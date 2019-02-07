/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex02_01 - SkapaFil.java
 */

import java.io.*;
import java.util.*;

public class SkapaFil
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		// Frågar användaren efter vilken fil eller katalog som ska skapas
		System.out.print("Ange namnet på filen som ska skapas: ");
		String filnamn = in.nextLine();
		File fil = new File(filnamn);

		// Undersöker om det är en fil eller katalog som ska skapas
		// Antar att om filnamnet saknar . (punkt) så är det katalog
		if (filnamn.indexOf(".") == -1)
		{
			skapaKatalog(fil);
		}
		else
		{
			skapaFil(fil);
		}
	}

	private static boolean skapaKatalog(File fil)
	{
		// Testar om katalogen redan finns
		if (fil.exists())
		{
			System.out.println("Katalogen existerar redan.");
			return false;
		}
		else
		{
			fil.mkdirs();
		}

		return true;
	}

	private static boolean skapaFil(File fil)
	{
		// Testar om filen redan finns
		if (fil.exists())
		{
			System.out.println("Filen existerar redan.");
			return false;
		}
		else
		{
			try
			{
				fil.createNewFile();
			}
			catch (IOException ioe)
			{
				System.err.println("Ett fel inträffade när filen skulle skapas.\n");
				return false;
			}
		}

		return true;
	}
}