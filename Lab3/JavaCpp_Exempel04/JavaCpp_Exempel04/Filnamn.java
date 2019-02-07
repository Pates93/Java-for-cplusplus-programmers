import java.io.*;

/**
 * En klass f�r att testa enkla operationer p� en str�ng.
 * Anv�ndaren f�r mata in ett filnamn som programmet sen
 * delar upp i filnamn och fil�ndelse. Anv�nder metoderna
 * lastIndexOf() och substring() till detta.
 *
 * @author Robert Jonsson
 * Ex06_02 - Filnamn.java
 */
public class Filnamn
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader input = new BufferedReader(new
			InputStreamReader(System.in));

		System.out.print("Ange ett filnamn> ");
		String inmatning = input.readLine();

		// Anv�nder en while-loop f�r att g�ra flera inmatningar
		while (!inmatning.equals(""))
		{
			// Vi b�rjar med att kolla om en punkt finns f�r annars �r det
			// inte ett gilltigt filnamn. Anv�nder lastIndexof() s� att vi
			// �r s�ker p� att vi f�r index f�r sista punkten i namnet (ett
			// filnamn kan inneh�lla punkter i sj�lva namnet).
			int punkt = inmatning.lastIndexOf('.');

			// Kollar om -1 returnerades vilket i s� fall inneb�r att
			// det inte finns n�gon punkt i inmatningen.
			if (punkt == -1)
			{
				System.out.println("Felaktigt filnamn (inneh�ller ingen punkt)!\n");
			}
			else
			{
				// Med hj�lp av index f�r sista punkten anv�nder vi metoden
				// substring f�r att ta reda p� filnamnet och fil�ndelsen
				String suffix = inmatning.substring(punkt + 1);
				String filnamn = inmatning.substring(0, punkt);

				System.out.println("\nFilnamn:    " + filnamn);
				System.out.println("Fil�ndelse: " + suffix + "\n");
			}

			// Ny inmatning, bara 'enter' f�r att sluta
			System.out.print("Ange ett nytt filnamn (endast enter avslutar)> ");
			inmatning = input.readLine();
		}
	}
}