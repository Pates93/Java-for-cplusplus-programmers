/**
 * @author Robert Jonsson, ITM �stersund
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

	// Metod som sl�r ihop inneh�llet i filerna och spara
	// resultatet till en fil som ges av fileName
	public void concatenate(File file)
	{
		// Returnerar om arrayen inte inneh�ller n�gra filer
		if (files == null || files.length == 0)
			return;

		// Skapar f�rst en Vector f�r att h�lla FileInputStream
		Vector<FileInputStream> v = new Vector<FileInputStream>();

		// Loopar igenom alla filer som ska sl�s ihop. Skapar
		// en FileInputStream och l�gger in den i vektorn.
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

		// Skapar en FileOutputStream f�r att spara data
		try
		{
			FileOutputStream out = new FileOutputStream(file);

			int c;

			while ((c = in.read()) != -1)
			{
				//System.out.println(" "+c);
				out.write(c);
			}

			// St�nger str�mmarna
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