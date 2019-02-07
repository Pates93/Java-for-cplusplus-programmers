/**
 * @author Robert Jonsson, ITM Östersund
 * @version 2.0
 * @file Ex03_11 - ZIP.java
 */

import java.io.*;
import java.util.zip.*;
import java.util.*;

public class ZIP
{
	// ******************************************************
	// METODER FÖR ATT PACKA FILER
	// ******************************************************

	// Statisk metod för att packa en fil till angiven zip-fil
	public static void compress(String file, String zipFile)
	{
		String[] tmp = {file};
		compress(tmp, zipFile);
	}

	// Statisk metod för att packa flera filer till angiven zip-fil
	public static void compress(String[] files, String zipFile)
	{
		try
		{
			// Skapar eventuella kataloger som behövs
			File zipFileParent = new File(zipFile).getParentFile();
			if (zipFileParent != null)
				zipFileParent.mkdirs();

			// Skapar ZIP-filen
			ZipOutputStream out = new ZipOutputStream(
				new BufferedOutputStream(
				new FileOutputStream(zipFile)));

			// Loopa igenom de filer som ska packas
			for (int i = 0; i < files.length; i++)
			{
				// Anropar metod som packar filen
				compress(new File(files[i]), out);
			}

			// Stänger zip-filen när vi är klar
			out.close();
		}
		catch (IOException fel)
		{
			System.out.println("Kunde inte skapa ZIP-filen");
		}


	}

	// Packar en fil med angiven ZipOutpuStream
	private static void compress(File file, ZipOutputStream out)
	{
		// Kontrollerar först om det är en katalog som ska packas
		if (file.isDirectory())
		{
			// Hämtar i så fall de filer som finns i katalogen
			File[] files = file.listFiles();

			// Loopar igenom alla filer
			for (int i = 0; i < files.length; i++)
			{
				// Anropar metod för att packa filen (rekursivt)
				compress(files[i], out);
			}
		}
		else
		{
			// Det var ingen katalog utan en fil som ska packas
			// Skapar en buffer för att slippa kopiera tecken för tecken
			byte[] buffer = new byte[4096];
			int bytesRead;

			System.out.print("Adding: " + file.getPath() + "... ");
			try
			{
				// För att läsa från filen
				FileInputStream in = new FileInputStream(file);

				// Skapa en ZipEntry för filen och lägg till den i ZIP-filen
				ZipEntry entry = new ZipEntry(file.getPath());
				out.putNextEntry(entry);

				// Överför data
				while ((bytesRead = in.read(buffer)) != -1)
				{
					out.write(buffer, 0, bytesRead);
				}

				// Stäng strömmar
				out.closeEntry();
				in.close();
			}
			catch (IOException fel)
			{
				System.out.println("ERROR");
				return;
			}

			System.out.println("done");
		}
	}

	// ******************************************************
	// METOD FÖR ATT PACKA UPP FILER
	// ******************************************************

	// Statisk metod för att packa upp en zip-fil till angiven katalog
	public static void decompress(String source, String destination)
	{
		try
		{
			// Öppnar ZIP-filen för läsning
			ZipFile zipFile = new ZipFile(source);

			// Hämtar alla filer i ZIP-filen
			Enumeration e = zipFile.entries();

			// Loopa igenom alla filer
			while (e.hasMoreElements())
			{
				// Hämta nästa fil i ZIP-filen
				ZipEntry entry = (ZipEntry) e.nextElement();

				File destFile =	new File(destination, entry.getName());
				//System.out.print("Extracting: " + entry.getName() + " to " + destFile + "... ");
				System.out.print("Extracting: " + entry.getName() + "... ");

				// Skapar eventuella kataloger som behövs
				File destinationParent = destFile.getParentFile();
				if (destinationParent != null)
					destinationParent.mkdirs();

				// Packa upp filen om det inte är en katalog
				if (!entry.isDirectory())
				{
					// Skapa en BufferedInputStream för att läsa filen
					BufferedInputStream in = new BufferedInputStream(zipFile.getInputStream(entry));

					// Skapar en BufferedOutputStream för att spara filen
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));

					// Skapar en byte-buffer för att slippa kopiera tecken för tecken
					byte[] buffer = new byte[4096];
					int bytesWrite;

					// Kopiera data från zip-fil till destination
					while ((bytesWrite = in.read(buffer)) != -1)
					{
						out.write(buffer, 0, bytesWrite);
					}

					out.flush();
					out.close();
					in.close();
				}

				System.out.println("done");
			}

			zipFile.close();
		}
		catch (IOException ioe)
		{
			System.out.println("ERROR");
		}
	}
}