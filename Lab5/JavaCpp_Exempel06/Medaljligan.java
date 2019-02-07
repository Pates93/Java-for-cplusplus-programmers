/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex02_02 - Medaljligan.java
 */

import java.io.*;
import java.util.*;

public class Medaljligan
{
	public static void main(String[] args)
	{
		try
		{
			// Skapar ett fil-objekt och knyter den till filen Medaljligan.txt
			File f = new File("Medaljligan.txt");

			// Skapar ett Scanner-objekt och kopplar den till filen ovan
			Scanner infil = new Scanner(f);

			// Loopar s� l�nge som det finns mer rader att l�sa i filen
			while (infil.hasNextLine())
			{
				// L�ser en rad och anv�nder den i en ny Scanner
				String s = infil.nextLine();
				Scanner rad = new Scanner(s);
				rad.useDelimiter(";");

				// Varje rad �r uppdelad i int;String;int;int;int
				int placering = rad.nextInt();
				String land = rad.next();
				int guld = rad.nextInt();
				int silver = rad.nextInt();
				int brons = rad.nextInt();

				// Summerar antalet medaljer
				int antalMedaljer = guld + silver + brons;

				// Skriver ut resultatet
				System.out.format("%-10s %2d medaljer\n", land, antalMedaljer);
			}
		}
		catch (FileNotFoundException filFinnsInte)
		{
			// F�ngar eventuella FileNotFoundException
			System.out.println("Filen finns inte");
		}
		catch (IOException e)
		{
			// F�ngar eventuella andra IO-fel som kan uppst�
			e.printStackTrace();
		}

	}
}