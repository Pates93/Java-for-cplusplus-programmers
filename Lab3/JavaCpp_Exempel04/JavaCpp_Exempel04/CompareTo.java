import java.io.*;

/**
 * En klass f�r att demonstrera metoden compareTo().
 * Anv�ndaren f�r mata in tv� ord och programet
 * skriver sen ut vilket ord som kommer f�re i
 * alfabetet. Fungerar inte med de svenska tecknen.
 *
 * @author Robert Jonsson
 * Ex06_03 - CompareTo.java
 */
public class CompareTo
{
	public static void main(String[] args) throws IOException
	{
		String ord1;  // F�rsta ordet
		String ord2;  // Andra ordet

		BufferedReader input = new BufferedReader(new
			InputStreamReader(System.in));

		System.out.print("\nAnge f�rsta ordet> ");
		ord1 = input.readLine();

		// Loopar s� l�nge som f�rsta ordet inte �r en tom str�ng (enbart tryckt p� enter)
		while (!ord1.equalsIgnoreCase(""))
		{
			System.out.print("Ange andra ordet> ");
			ord2 = input.readLine();

			// Kontrollerar vilket ord som kommer f�rst (alfabetisk ordning)
			// Observera att compareTo() inte tar h�nsyn till ���
			if (ord1.compareTo(ord2) < 0)
			{
				System.out.println(ord1 + " kommer innan " + ord2);
			}
			else if (ord1.compareTo(ord2) > 0)
			{
				System.out.println(ord2 + " kommer innan " + ord1);
			}
			else
			{
				System.out.println(ord1 + " och " + ord2 + " �r lika");
			}

			System.out.print("\nAnge f�rsta ordet> ");
			ord1 = input.readLine();
		}
	}
}