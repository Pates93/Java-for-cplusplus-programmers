import java.io.*;
import java.util.zip.*;
import java.util.*;
import java.text.*;

public class ReadZIP
{
	public static void main(String[] args) throws IOException
	{
		// Namnet p� den ZIP-fil som ska listas
		String file = "k�llkod.zip";
		read(file);
	}

	public static void read(String file)
	{
		// F�r att formatera datum
		DateFormat df = DateFormat.getInstance();

		try
		{
			// �ppnar ZIP-filen f�r l�sning
			ZipFile zip = new ZipFile(file);

			// H�mta alla filer
			Enumeration e = zip.entries();

			// Skriver ut en rubrik
			System.out.format("%-30s %-7s %-7s %-5s %s\n", "Name", "Size", "Packed", "Ratio", "Modified");

			// Loopa igenom alla filer
			while(e.hasMoreElements())
			{
				// H�mta n�sta fil i ZIP-filen
				ZipEntry entry = (ZipEntry)e.nextElement();

				// Plockar ut diverse data om filen
				String filename = entry.getName();
				long size = entry.getSize();
				long compressedSize = entry.getCompressedSize();
				long modified = entry.getTime();
				String comment = entry.getComment();
				int ratio = (int)(((size - compressedSize) / ((double)size)) * 100);

				// Skriver ut data om filen p� sk�rmen
				System.out.format("%-30s %7s %7s %5s %16s \n", filename, size, compressedSize, ratio+"%", df.format(modified));

			}

			// St�nger ZIP-filen
			zip.close();
		}
		catch(ZipException ze)
		{
			System.out.println(file + " �r ingen giltig ZIP-fil");
		}
		catch (IOException ioe)
		{
			System.out.println("Fel vid l�sning.");
			ioe.printStackTrace();
		}
	}
}