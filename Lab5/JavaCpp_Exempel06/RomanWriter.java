/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex03_05 - RomanWriter.java
 */

import java.io.*;

public class RomanWriter extends FilterWriter
{
	// Konstruktor
	public RomanWriter(Writer out)
	{
		// Anrop till super så att utströmmen out initieras på ett korrekt sätt
		super(out);
	}

	// OMDEFINIERA METODEN WRITE
	// Skriver en sträng innehållandes ett romerskt tal
	public void write(String str, int off, int len) throws IOException
	{
		// Skapar ett RomanNumeral-objekt för att vara säker på att strängen
		// verkligen innehåller ett romerskt tal
		RomanNumeral r = new RomanNumeral(str);
		str = r.toString();

		// Skriver strängen till utströmmen
		out.write(str, off, len);

		// Skriver en radbrytning
		out.write(System.getProperty("line.separator"));
	}

	// OMDEFINIERA METODEN WRITE
	// Skriver en char-array innehållandes ett romerskt tal
	public void write(char[] cbuf, int off, int len) throws IOException
	{
		// Skapar en sträng av char-fältet
		String s = new String(cbuf);

		// Skickar vidare för att skrivas till utströmmen
		write(s, off, len);
	}

	// OMDEFINIERA METODEN WRITE
	// Skriver ett enskilt tecken (romerskt) till utströmmen
	public void write(int c) throws IOException
	{
		// Observera att denna metod i FilterWriter säger att
		// det är ett tecken (char) som ska skrivas till strömmen.
		// Vi får inte tro att heltalet c ska konverteras till
		// sitt romerska värde för att skrivas till strömmen.
		// För detta skriver vi en egen writeInt-metod.

		// Skapar en temporär char-array, konverterar heltalet
		// till ett tecken och skickar vidare.
		char[] tmp = new char[1];
		tmp[0] = (char) c;
	    write(new String(tmp), 0, 1);
	}

	// EGEN METOD WRITEINT
	// Konverterar ett heltal till dess romerska värde och skriver till utströmmen
	public void writeInt(int num) throws IOException
	{
		// Konverterar talet till dess romerska värde
		String s = new RomanNumeral(num).toString();

		// Skickar vidare för att skrivas till utströmmen
		write (s, 0, s.length());
	}

	// EGEN METOD WRITE
	// Skriver en sträng innehållandes ett romerskt tal
	public void write(String str) throws IOException
	{
		// Skickar vidare för att skrivas till utströmmen
		write (str, 0, str.length());
	}
}