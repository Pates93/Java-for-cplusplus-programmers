/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex03_01 - FileConcatenator.java
 */

import java.io.*;
import java.util.*;

public class FileConcatenator
{
	// Instansvariabler
	private File[] files;

	// Konstruktor
	public FileConcatenator(File[] files)
	{
		this.files = files;
	}

	// Metod som slår ihop innehållet i filerna och spara
	// resultatet till en fil som ges av fileName
	public void concatenate(File file)
	{
		// Returnerar om arrayen inte innehåller några filer
		if (files == null || files.length == 0)
			return;

		// Skapar först en Vector för att hålla FileInputStream
		Vector<FileInputStream> v = new Vector<FileInputStream>();

		// Loopar igenom alla filer som ska slås ihop. Skapar
		// en FileInputStream och lägger in den i vektorn.
		for (File f : files)
		{
			try
			{
				v.add(new FileInputStream(f));
			}
			catch (FileNotFoundException fel)
			{
				System.out.println("Kan inte hitta filen " + f.getName());
			}
		}

		// Skapar SequenceInputStream
		Enumeration<FileInputStream> e = v.elements();
		SequenceInputStream in = new SequenceInputStream(e);

		// Skapar en FileOutputStream för att spara data
		try
		{
			FileOutputStream out = new FileOutputStream(file);

			int c;

			while ((c = in.read()) != -1)
			{
				//System.out.println(" "+c);
				out.write(c);
			}

			// Stänger strömmarna
			in.close();
			out.close();
		}
		catch (FileNotFoundException fel)
		{
			System.out.println("Kunda inte skapa filen " + file.getName());
		}
		catch (IOException fel)
		{
			System.out.println("Fel vid skrivning till filen " + file.getName());
		}
	}
}