/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex03_06 - RomanReader.java
 */

import java.io.*;

public class RomanReader extends FilterReader
{
	// Konstruktor
	public RomanReader(Reader in)
	{
		// Anrop till super s� att instr�mmen in initieras p� ett korrekt s�tt
		super(in);
	}

	// OMDEFINIERA METODEN READ
	// L�ser ett tecken fr�n instr�mmen
	public int read() throws IOException
	{
		return in.read();
	}

	// OMDEFINIERA METODEN READ
	// L�ser tecken till en char-array
	public int read(char cbuf[], int off, int len) throws IOException
	{
		return in.read(cbuf, off, len);
	}

	// EGEN METOD NEXTROMAN
	// L�ser n�sta romerska tal fr�n instr�mmen
	public RomanNumeral nextRoman() throws IOException
	{
		// Skapar en liten buffer f�r att l�sa tecken till
		char buf[] = new char[64];

		// Hur mycket plats det finns kvar i bufferten
		int room = buf.length;

		int offset = 0;
		int c;

loop:	while (true)
		{
			// L�ser n�sta tecken fr�n instr�mmen
			switch (c = in.read())
			{
				// Har vi kommit till slutet av filen eller radbrytning s� avbryt
				case -1:
				case '\n':
					break loop;

				// P� vissa system best�r radbrytning av \r eller \r\n
				case '\r':
					int c2 = in.read();
					if ((c2 != '\n') && (c2 != -1))
					{
						// Om n�sta tecken efter \r inte var \n eller slutet av filen
						// s� m�ste vi l�sa tillbaka tecknet till str�mmen. Detta
						// g�rs med en PushbackReader som vi eventuell m�ste skapa.
						if (!(in instanceof PushbackReader))
						{
							this.in = new PushbackReader(in);
						}
						((PushbackReader)in).unread(c2);
					}
					break loop;

				default:
					if (--room < 0)
					{
						// Nu finns det inte mer plats i bufferten s� m�ste vi ut�ka den
						char[] tmp = buf;
						buf = new char[offset + 64];
						room = buf.length - offset - 1;
						System.arraycopy(tmp, 0, buf, 0, offset);
					}

					buf[offset++] = (char) c;
					break;
			}
		}

		// Har vi kommit till slutet av filen och offset �r lika med noll
		// s� inneb�r det att inget fanns att l�sa. Vi returnerar null
		if ((c == -1) && (offset == 0))
		{
			return null;
		}

		// Skapar en str�ng av char-arrayen
		String s = new String(buf, 0, offset);

		return new RomanNumeral(s);
	}

	// EGEN METOD NEXTROMANASINT
	// L�ser n�sta romerska tal fr�n instr�mmen pch returnerar som int
	public int nextRomanAsInt() throws IOException
	{
		RomanNumeral roman = nextRoman();

		if (roman == null)
			return -1;

		return roman.intValue();
	}
}