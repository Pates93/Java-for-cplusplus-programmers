import java.io.*;

/**
 * En klass för att testa enkla operationer på en sträng.
 * Användaren får mata in ett filnamn som programmet sen
 * delar upp i filnamn och filändelse. Använder metoderna
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

		// Använder en while-loop för att göra flera inmatningar
		while (!inmatning.equals(""))
		{
			// Vi börjar med att kolla om en punkt finns för annars är det
			// inte ett gilltigt filnamn. Använder lastIndexof() så att vi
			// är säker på att vi får index för sista punkten i namnet (ett
			// filnamn kan innehålla punkter i själva namnet).
			int punkt = inmatning.lastIndexOf('.');

			// Kollar om -1 returnerades vilket i så fall innebär att
			// det inte finns någon punkt i inmatningen.
			if (punkt == -1)
			{
				System.out.println("Felaktigt filnamn (inneh†ller ingen punkt)!\n");
			}
			else
			{
				// Med hjälp av index för sista punkten använder vi metoden
				// substring för att ta reda på filnamnet och filändelsen
				String suffix = inmatning.substring(punkt + 1);
				String filnamn = inmatning.substring(0, punkt);

				System.out.println("\nFilnamn:    " + filnamn);
				System.out.println("Fil„ndelse: " + suffix + "\n");
			}

			// Ny inmatning, bara 'enter' för att sluta
			System.out.print("Ange ett nytt filnamn (endast enter avslutar)> ");
			inmatning = input.readLine();
		}
	}
}