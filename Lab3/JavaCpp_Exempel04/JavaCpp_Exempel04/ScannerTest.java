import java.util.*;	// Scanner
import java.io.*;	// File, FileNotFoundException

/**
 * En klass som anv�nder Scanner f�r att l�sa data fr�n
 * b�de tangentbordet och fr�n en fil. Programmet fr�gar
 * anv�ndaren vilken fil som ska l�sas in och listar sen
 * filens inneh�ll p� sk�rmen. Anv�nder �ven metoden
 * format f�r att formatera utskriften.
 *
 * @author Robert Jonsson
 * Ex06_07 - StringBuffer.java
 */
public class ScannerTest
{
	// Eftersom vi ska l�sa fr�n en fil m�ste main kasta vidare eventuella
	// FileNotFoundException. Ett s�dant fel sker om vi f�rs�ker �ppna en
	// fil som inte finns. Normalt anv�nder vi try-catch f�r att hantera
	// denna typ av fel, men inte i denna kurs.
	public static void main(String[] args) throws FileNotFoundException
	{
		// F�r att l�sa fr�n tangentbordet
		Scanner tangentbordet = new Scanner(System.in);

		// Fr�gar anv�ndaren hur m�nga g�nger inneh�llet i filen ska listas
		System.out.print("Hur m�nga g�nger ska inneh�llet i filen listas: ");
		int antal = tangentbordet.nextInt();

		// Eftersom vi nu ska l�sa in en str�ng (efter ett tal)
		//m�ste vi "rensa" radbryts-tecknet
		tangentbordet.nextLine();

		// Fr�gar anv�ndaren efter vilken fil som ska l�sas in (t.ex: MinFil.txt)
		System.out.print("Vilken fil ska l�sas in: ");
		String filnamn = tangentbordet.nextLine();

		// Skapar en variabel f�r att skriva ut radnummer
		int radnummer = 0;

		// En for-loop som k�rs lika m�nga g�nger som anv�ndaren angav
		for (int i = 0; i < antal; i++)
		{
			// F�r att l�sa fr�n filen
			Scanner fil = new Scanner(new File(filnamn));

			// En while-loop som l�ser alla rader fr�n filen
			// Metoden hasNext() returnerar true s� l�nge som det finns mer
			// data att l�sa (spelar ingen roll om det �r tal eller text)
			while (fil.hasNext())
			{
				// B�rjar med att �ka p� radnumret med 1
				radnummer++;

				// L�ser n�sta rad fr�n filen till en tempor�r str�ng
				String tmp = fil.nextLine();

				// Skriver ut radnummer + raden fr�n filen.
				// Anv�nder System.out.format() f�r att formatera utskriften
				// s� att radnummer alltid skrivs ut med minst 4 positioner
				System.out.format("%4d - %s\n", radnummer, tmp);
			}
		}
	}
}