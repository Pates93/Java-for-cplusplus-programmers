import java.util.StringTokenizer;
import java.io.*;

/**
 * En klass som visar hur vi kan använda StringTokenizer
 * för att dela upp en sträng i olika delar. I detta fall
 * använder vi StringTokenizer för att ta bort mellanslag
 * m.m. från en sträng så att vi kan avgöra om strängen
 * är ett palindrom.
 *
 * @author Robert Jonsson
 * Ex06_06 - Palindrom.java
 */
public class Palindrom
{
	// En metod som avgör om strängen som skickas som argument till
	// metoden är ett palindrom eller inte. Returnerar sant om så
	// är fallet, falskt annara.
	public boolean isPalindrom(String mening)
	{
		// Använder StringTokenizer för att ta bort alla mellanslag,
		// kommatecken och punkter m.m från strängen.
		StringTokenizer st = new StringTokenizer(mening, ",.!? ");

		// Skapar en StringBuffer med en kapacitet lika stor som 'mening' eftersom
		// det tar tid att hela tiden öka StringBuffer när kapaciteten är slut
		StringBuffer sb = new StringBuffer(mening.length());

		// Loopar igenom alla tokens och lägger till dem sist i sb
		while (st.hasMoreTokens())
		{
			sb.append(st.nextToken());
		}

		// Tilldelar våran mening innehållet i sb för senare jämförelse
		mening = sb.toString();

		// Vänder på innehållet i sb
		// Observera hur enkelt det är med en StringBuffer jämfört med
		// exemplet StringReverser.java
		sb.reverse();

		// Ta bort kommentarerna nedan om du vill skriva ut innehållet
		//System.out.println(mening);
		//System.out.println(sb.toString());

		// Jämför nu om mening och innehållet i våran StringBuffer är lika
		return mening.equalsIgnoreCase(sb.toString());
	}

	// Main
	public static void main(String[] args)
	{
		// Skapar ett objekt av klassen
		Palindrom p = new Palindrom();

		String s = "Ni talar bra latin";

		// Kollar om strängen är ett palindrom
		boolean palindrom = p.isPalindrom(s);

		System.out.print("'" + s + "' ");

		if (palindrom)
			System.out.println(" „r ett palindrom");
		else
			System.out.println(" „r inte ett palindrom");
	}
}