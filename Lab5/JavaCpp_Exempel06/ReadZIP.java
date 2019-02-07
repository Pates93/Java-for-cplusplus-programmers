import java.io.*;
import java.util.zip.*;
import java.util.*;
import java.text.*;

public class ReadZIP
{
	public static void main(String[] args) throws IOException
	{
		// Namnet på den ZIP-fil som ska listas
		String file = "källkod.zip";
		read(file);
	}

	public static void read(String file)
	{
		// För att formatera datum
		DateFormat df = DateFormat.getInstance();

		try
		{
			// Öppnar ZIP-filen för läsning
			ZipFile zip = new ZipFile(file);

			// Hämta alla filer
			Enumeration e = zip.entries();

			// Skriver ut en rubrik
			System.out.format("%-30s %-7s %-7s %-5s %s\n", "Name", "Size", "Packed", "Ratio", "Modified");

			// Loopa igenom alla filer
			while(e.hasMoreElements())
			{
				// Hämta nästa fil i ZIP-filen
				ZipEntry entry = (ZipEntry)e.nextElement();

				// Plockar ut diverse data om filen
				String filename = entry.getName();
				long size = entry.getSize();
				long compressedSize = entry.getCompressedSize();
				long modified = entry.getTime();
				String comment = entry.getComment();
				int ratio = (int)(((size - compressedSize) / ((double)size)) * 100);

				// Skriver ut data om filen på skärmen
				System.out.format("%-30s %7s %7s %5s %16s \n", filename, size, compressedSize, ratio+"%", df.format(modified));

			}

			// Stänger ZIP-filen
			zip.close();
		}
		catch(ZipException ze)
		{
			System.out.println(file + " är ingen giltig ZIP-fil");
		}
		catch (IOException ioe)
		{
			System.out.println("Fel vid läsning.");
			ioe.printStackTrace();
		}
	}
}