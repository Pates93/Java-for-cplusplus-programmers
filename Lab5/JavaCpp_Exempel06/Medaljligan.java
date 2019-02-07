/**
 * @author Robert Jonsson, ITM Östersund
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

			// Loopar så länge som det finns mer rader att läsa i filen
			while (infil.hasNextLine())
			{
				// Läser en rad och använder den i en ny Scanner
				String s = infil.nextLine();
				Scanner rad = new Scanner(s);
				rad.useDelimiter(";");

				// Varje rad är uppdelad i int;String;int;int;int
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
			// Fångar eventuella FileNotFoundException
			System.out.println("Filen finns inte");
		}
		catch (IOException e)
		{
			// Fångar eventuella andra IO-fel som kan uppstå
			e.printStackTrace();
		}

	}
}