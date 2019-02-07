/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex03_05 - RomanWriter.java
 */

import java.io.*;

public class RomanWriter extends FilterWriter
{
	// Konstruktor
	public RomanWriter(Writer out)
	{
		// Anrop till super s� att utstr�mmen out initieras p� ett korrekt s�tt
		super(out);
	}

	// OMDEFINIERA METODEN WRITE
	// Skriver en str�ng inneh�llandes ett romerskt tal
	public void write(String str, int off, int len) throws IOException
	{
		// Skapar ett RomanNumeral-objekt f�r att vara s�ker p� att str�ngen
		// verkligen inneh�ller ett romerskt tal
		RomanNumeral r = new RomanNumeral(str);
		str = r.toString();

		// Skriver str�ngen till utstr�mmen
		out.write(str, off, len);

		// Skriver en radbrytning
		out.write(System.getProperty("line.separator"));
	}

	// OMDEFINIERA METODEN WRITE
	// Skriver en char-array inneh�llandes ett romerskt tal
	public void write(char[] cbuf, int off, int len) throws IOException
	{
		// Skapar en str�ng av char-f�ltet
		String s = new String(cbuf);

		// Skickar vidare f�r att skrivas till utstr�mmen
		write(s, off, len);
	}

	// OMDEFINIERA METODEN WRITE
	// Skriver ett enskilt tecken (romerskt) till utstr�mmen
	public void write(int c) throws IOException
	{
		// Observera att denna metod i FilterWriter s�ger att
		// det �r ett tecken (char) som ska skrivas till str�mmen.
		// Vi f�r inte tro att heltalet c ska konverteras till
		// sitt romerska v�rde f�r att skrivas till str�mmen.
		// F�r detta skriver vi en egen writeInt-metod.

		// Skapar en tempor�r char-array, konverterar heltalet
		// till ett tecken och skickar vidare.
		char[] tmp = new char[1];
		tmp[0] = (char) c;
	    write(new String(tmp), 0, 1);
	}

	// EGEN METOD WRITEINT
	// Konverterar ett heltal till dess romerska v�rde och skriver till utstr�mmen
	public void writeInt(int num) throws IOException
	{
		// Konverterar talet till dess romerska v�rde
		String s = new RomanNumeral(num).toString();

		// Skickar vidare f�r att skrivas till utstr�mmen
		write (s, 0, s.length());
	}

	// EGEN METOD WRITE
	// Skriver en str�ng inneh�llandes ett romerskt tal
	public void write(String str) throws IOException
	{
		// Skickar vidare f�r att skrivas till utstr�mmen
		write (str, 0, str.length());
	}
}