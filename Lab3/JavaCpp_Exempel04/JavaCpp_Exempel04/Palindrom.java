import java.util.StringTokenizer;
import java.io.*;

/**
 * En klass som visar hur vi kan anv�nda StringTokenizer
 * f�r att dela upp en str�ng i olika delar. I detta fall
 * anv�nder vi StringTokenizer f�r att ta bort mellanslag
 * m.m. fr�n en str�ng s� att vi kan avg�ra om str�ngen
 * �r ett palindrom.
 *
 * @author Robert Jonsson
 * Ex06_06 - Palindrom.java
 */
public class Palindrom
{
	// En metod som avg�r om str�ngen som skickas som argument till
	// metoden �r ett palindrom eller inte. Returnerar sant om s�
	// �r fallet, falskt annara.
	public boolean isPalindrom(String mening)
	{
		// Anv�nder StringTokenizer f�r att ta bort alla mellanslag,
		// kommatecken och punkter m.m fr�n str�ngen.
		StringTokenizer st = new StringTokenizer(mening, ",.!? ");

		// Skapar en StringBuffer med en kapacitet lika stor som 'mening' eftersom
		// det tar tid att hela tiden �ka StringBuffer n�r kapaciteten �r slut
		StringBuffer sb = new StringBuffer(mening.length());

		// Loopar igenom alla tokens och l�gger till dem sist i sb
		while (st.hasMoreTokens())
		{
			sb.append(st.nextToken());
		}

		// Tilldelar v�ran mening inneh�llet i sb f�r senare j�mf�relse
		mening = sb.toString();

		// V�nder p� inneh�llet i sb
		// Observera hur enkelt det �r med en StringBuffer j�mf�rt med
		// exemplet StringReverser.java
		sb.reverse();

		// Ta bort kommentarerna nedan om du vill skriva ut inneh�llet
		//System.out.println(mening);
		//System.out.println(sb.toString());

		// J�mf�r nu om mening och inneh�llet i v�ran StringBuffer �r lika
		return mening.equalsIgnoreCase(sb.toString());
	}

	// Main
	public static void main(String[] args)
	{
		// Skapar ett objekt av klassen
		Palindrom p = new Palindrom();

		String s = "Ni talar bra latin";

		// Kollar om str�ngen �r ett palindrom
		boolean palindrom = p.isPalindrom(s);

		System.out.print("'" + s + "' ");

		if (palindrom)
			System.out.println(" �r ett palindrom");
		else
			System.out.println(" �r inte ett palindrom");
	}
}