import java.io.*;

/**
 * En klass som visar att String inte är så effektiv
 * att använda om man ska tilldela strängen nya värden
 * många gånger, t.ex. i en loop. Programet kör en loop
 * från 0 till 10000 och bygger på en sträng med värdet
 * i loopvariabeln. Strängen kommer alltså att se ut så:
 *
 * 012345678910111213141516....99989999
 *
 * @author Robert Jonsson
 * Ex06_04 - StringTest.java
 */
public class StringTest
{
	public static void main(String[] args) throws IOException
	{
		String s = "";

		// Tar tiden innan vi startar loopen..
		System.out.print("Startar... ");
		long startTid = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++)
		{
			// Adderar värdet i loopvariabeln till våran sträng s1
			// Kom ihåg från lektionen hur skapandet av strängar går till
			s += i;
		}

		// ..och tiden efter att loopen är klar
		long slutTid = System.currentTimeMillis();
		System.out.println("klar");

		// Skriver ut skillnaden ==> tiden det tog i ms
		System.out.println("Operationen tog " + (slutTid - startTid) + " ms.");

		// Ber användaren trycka enter innan strängen skrivs ut.
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\nTryck enter för att skriva ut den skapade strängen");
		input.readLine();

		System.out.println(s);
	}
}