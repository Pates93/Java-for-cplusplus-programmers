/**
 * @author Robert Jonsson, ITM �stersund
 * @version 2.0
 * @file Ex03_11 - ZIP.java
 */

import java.io.*;
import java.util.zip.*;
import java.util.*;

public class ZIP
{
	// ******************************************************
	// METODER F�R ATT PACKA FILER
	// ******************************************************

	// Statisk metod f�r att packa en fil till angiven zip-fil
	public static void compress(String file, String zipFile)
	{
		String[] tmp = {file};
		compress(tmp, zipFile);
	}

	// Statisk metod f�r att packa flera filer till angiven zip-fil
	public static void compress(String[] files, String zipFile)
	{
		try
		{
			// Skapar eventuella kataloger som beh�vs
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

			// St�nger zip-filen n�r vi �r klar
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
		// Kontrollerar f�rst om det �r en katalog som ska packas
		if (file.isDirectory())
		{
			// H�mtar i s� fall de filer som finns i katalogen
			File[] files = file.listFiles();

			// Loopar igenom alla filer
			for (int i = 0; i < files.length; i++)
			{
				// Anropar metod f�r att packa filen (rekursivt)
				compress(files[i], out);
			}
		}
		else
		{
			// Det var ingen katalog utan en fil som ska packas
			// Skapar en buffer f�r att slippa kopiera tecken f�r tecken
			byte[] buffer = new byte[4096];
			int bytesRead;

			System.out.print("Adding: " + file.getPath() + "... ");
			try
			{
				// F�r att l�sa fr�n filen
				FileInputStream in = new FileInputStream(file);

				// Skapa en ZipEntry f�r filen och l�gg till den i ZIP-filen
				ZipEntry entry = new ZipEntry(file.getPath());
				out.putNextEntry(entry);

				// �verf�r data
				while ((bytesRead = in.read(buffer)) != -1)
				{
					out.write(buffer, 0, bytesRead);
				}

				// St�ng str�mmar
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
	// METOD F�R ATT PACKA UPP FILER
	// ******************************************************

	// Statisk metod f�r att packa upp en zip-fil till angiven katalog
	public static void decompress(String source, String destination)
	{
		try
		{
			// �ppnar ZIP-filen f�r l�sning
			ZipFile zipFile = new ZipFile(source);

			// H�mtar alla filer i ZIP-filen
			Enumeration e = zipFile.entries();

			// Loopa igenom alla filer
			while (e.hasMoreElements())
			{
				// H�mta n�sta fil i ZIP-filen
				ZipEntry entry = (ZipEntry) e.nextElement();

				File destFile =	new File(destination, entry.getName());
				//System.out.print("Extracting: " + entry.getName() + " to " + destFile + "... ");
				System.out.print("Extracting: " + entry.getName() + "... ");

				// Skapar eventuella kataloger som beh�vs
				File destinationParent = destFile.getParentFile();
				if (destinationParent != null)
					destinationParent.mkdirs();

				// Packa upp filen om det inte �r en katalog
				if (!entry.isDirectory())
				{
					// Skapa en BufferedInputStream f�r att l�sa filen
					BufferedInputStream in = new BufferedInputStream(zipFile.getInputStream(entry));

					// Skapar en BufferedOutputStream f�r att spara filen
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));

					// Skapar en byte-buffer f�r att slippa kopiera tecken f�r tecken
					byte[] buffer = new byte[4096];
					int bytesWrite;

					// Kopiera data fr�n zip-fil till destination
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