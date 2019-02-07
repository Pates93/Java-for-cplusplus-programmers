/**
 * @author Robert Jonsson, ITM �stersund
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

		// Fr�gar anv�ndaren efter vilken fil eller katalog som ska skapas
		System.out.print("Ange namnet p� filen som ska skapas: ");
		String filnamn = in.nextLine();
		File fil = new File(filnamn);

		// Unders�ker om det �r en fil eller katalog som ska skapas
		// Antar att om filnamnet saknar . (punkt) s� �r det katalog
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
				System.err.println("Ett fel intr�ffade n�r filen skulle skapas.\n");
				return false;
			}
		}

		return true;
	}
}