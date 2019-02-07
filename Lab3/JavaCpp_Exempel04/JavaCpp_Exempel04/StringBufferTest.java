import java.io.*;

/**
 * En klass som visar att StringBuffer �r mer effektiv
 * att anv�nda, �n en String, om man ska tilldela str�ngen
 * nya v�rden m�nga g�nger. Programet k�r en loop
 * fr�n 0 till 10000 och bygger p� en str�ngbuffer med v�rdet
 * i loopvariabeln. Str�ngen kommer allts� att se ut s�:
 *
 * 012345678910111213141516....99989999
 *
 * @author Robert Jonsson
 * Ex06_05 - StringBufferTest.java
 */
public class StringBufferTest
{
	public static void main(String[] args) throws IOException
	{
		// Skapar v�ran stringbuffer
		StringBuffer s = new StringBuffer("");

		// Tar tiden innan vi startar loopen..
		System.out.print("Startar... ");
		long startTid = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++)
		{
			s.append(i);
		}

		// ..och tiden efter att loopen �r klar
		long slutTid = System.currentTimeMillis();
		System.out.println("klar");

		// Skriver ut skillnaden ==> tiden det tog i ms
		System.out.println("Operationen tog " + (slutTid - startTid) + " ms.");

		// Ber anv�ndaren trycka enter innan str�ngen skrivs ut.
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\nTryck enter f�r att skriva ut den skapade str�ngen");
		input.readLine();

		System.out.println(s);
	}
}