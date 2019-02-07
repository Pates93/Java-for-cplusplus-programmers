import java.io.*;

/**
 * En klass som visar att String inte �r s� effektiv
 * att anv�nda om man ska tilldela str�ngen nya v�rden
 * m�nga g�nger, t.ex. i en loop. Programet k�r en loop
 * fr�n 0 till 10000 och bygger p� en str�ng med v�rdet
 * i loopvariabeln. Str�ngen kommer allts� att se ut s�:
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
			// Adderar v�rdet i loopvariabeln till v�ran str�ng s1
			// Kom ih�g fr�n lektionen hur skapandet av str�ngar g�r till
			s += i;
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