import java.io.*;

/**
 * En klass för att testa enkla operationer på en sträng.
 * Användaren får mata in ett ord/mening och programet
 * skriver ut strängen fast bakvänt. Använder metoderna
 * charAt() och length() till detta.
 *
 * @author Robert Jonsson
 * Ex06_01 - StringReverser.java
 */
public class StringReverser
{
	public static void main(String[] args) throws IOException
	{
		// Skapar objekt för att läsa från tangentbord
		BufferedReader input = new BufferedReader(new
			InputStreamReader(System.in));

		System.out.print("Skriv n†got> ");
		String inmatning = input.readLine();

		// Skriver ut strängen bakvänt
		System.out.print("             ");  // Bara för att få utskriften rätt ställe

		// Tar reda på den inmatade strängens längd
		int längd = inmatning.length();

		// En for-loop vars initieringsvariabel börjar på högsta index
		// i strängen och minskar med ett efter varje varv i loopen
		for (int i = längd - 1; i >=0; i--)
		{
			// Skriver ut tecknet på index i
			System.out.print(inmatning.charAt(i));
		}

		// Radbrytning
		System.out.println();
	}
}