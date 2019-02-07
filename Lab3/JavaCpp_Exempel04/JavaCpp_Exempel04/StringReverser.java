import java.io.*;

/**
 * En klass f�r att testa enkla operationer p� en str�ng.
 * Anv�ndaren f�r mata in ett ord/mening och programet
 * skriver ut str�ngen fast bakv�nt. Anv�nder metoderna
 * charAt() och length() till detta.
 *
 * @author Robert Jonsson
 * Ex06_01 - StringReverser.java
 */
public class StringReverser
{
	public static void main(String[] args) throws IOException
	{
		// Skapar objekt f�r att l�sa fr�n tangentbord
		BufferedReader input = new BufferedReader(new
			InputStreamReader(System.in));

		System.out.print("Skriv n�got> ");
		String inmatning = input.readLine();

		// Skriver ut str�ngen bakv�nt
		System.out.print("             ");  // Bara f�r att f� utskriften r�tt st�lle

		// Tar reda p� den inmatade str�ngens l�ngd
		int l�ngd = inmatning.length();

		// En for-loop vars initieringsvariabel b�rjar p� h�gsta index
		// i str�ngen och minskar med ett efter varje varv i loopen
		for (int i = l�ngd - 1; i >=0; i--)
		{
			// Skriver ut tecknet p� index i
			System.out.print(inmatning.charAt(i));
		}

		// Radbrytning
		System.out.println();
	}
}