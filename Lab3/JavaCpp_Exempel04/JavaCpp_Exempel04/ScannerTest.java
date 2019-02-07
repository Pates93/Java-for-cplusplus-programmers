import java.util.*;	// Scanner
import java.io.*;	// File, FileNotFoundException

/**
 * En klass som använder Scanner för att läsa data från
 * både tangentbordet och från en fil. Programmet frågar
 * användaren vilken fil som ska läsas in och listar sen
 * filens innehåll på skärmen. Använder även metoden
 * format för att formatera utskriften.
 *
 * @author Robert Jonsson
 * Ex06_07 - StringBuffer.java
 */
public class ScannerTest
{
	// Eftersom vi ska läsa från en fil måste main kasta vidare eventuella
	// FileNotFoundException. Ett sådant fel sker om vi försöker öppna en
	// fil som inte finns. Normalt använder vi try-catch för att hantera
	// denna typ av fel, men inte i denna kurs.
	public static void main(String[] args) throws FileNotFoundException
	{
		// För att läsa från tangentbordet
		Scanner tangentbordet = new Scanner(System.in);

		// Frågar användaren hur många gånger innehållet i filen ska listas
		System.out.print("Hur många gånger ska innehållet i filen listas: ");
		int antal = tangentbordet.nextInt();

		// Eftersom vi nu ska läsa in en sträng (efter ett tal)
		//måste vi "rensa" radbryts-tecknet
		tangentbordet.nextLine();

		// Frågar användaren efter vilken fil som ska läsas in (t.ex: MinFil.txt)
		System.out.print("Vilken fil ska läsas in: ");
		String filnamn = tangentbordet.nextLine();

		// Skapar en variabel för att skriva ut radnummer
		int radnummer = 0;

		// En for-loop som körs lika många gånger som användaren angav
		for (int i = 0; i < antal; i++)
		{
			// För att läsa från filen
			Scanner fil = new Scanner(new File(filnamn));

			// En while-loop som läser alla rader från filen
			// Metoden hasNext() returnerar true så länge som det finns mer
			// data att läsa (spelar ingen roll om det är tal eller text)
			while (fil.hasNext())
			{
				// Börjar med att öka på radnumret med 1
				radnummer++;

				// Läser nästa rad från filen till en temporär sträng
				String tmp = fil.nextLine();

				// Skriver ut radnummer + raden från filen.
				// Använder System.out.format() för att formatera utskriften
				// så att radnummer alltid skrivs ut med minst 4 positioner
				System.out.format("%4d - %s\n", radnummer, tmp);
			}
		}
	}
}