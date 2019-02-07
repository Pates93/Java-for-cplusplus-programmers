/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex03_06 - RomanReader.java
 */

import java.io.*;

public class RomanReader extends FilterReader
{
	// Konstruktor
	public RomanReader(Reader in)
	{
		// Anrop till super så att inströmmen in initieras på ett korrekt sätt
		super(in);
	}

	// OMDEFINIERA METODEN READ
	// Läser ett tecken från inströmmen
	public int read() throws IOException
	{
		return in.read();
	}

	// OMDEFINIERA METODEN READ
	// Läser tecken till en char-array
	public int read(char cbuf[], int off, int len) throws IOException
	{
		return in.read(cbuf, off, len);
	}

	// EGEN METOD NEXTROMAN
	// Läser nästa romerska tal från inströmmen
	public RomanNumeral nextRoman() throws IOException
	{
		// Skapar en liten buffer för att läsa tecken till
		char buf[] = new char[64];

		// Hur mycket plats det finns kvar i bufferten
		int room = buf.length;

		int offset = 0;
		int c;

loop:	while (true)
		{
			// Läser nästa tecken från inströmmen
			switch (c = in.read())
			{
				// Har vi kommit till slutet av filen eller radbrytning så avbryt
				case -1:
				case '\n':
					break loop;

				// På vissa system består radbrytning av \r eller \r\n
				case '\r':
					int c2 = in.read();
					if ((c2 != '\n') && (c2 != -1))
					{
						// Om nästa tecken efter \r inte var \n eller slutet av filen
						// så måste vi läsa tillbaka tecknet till strömmen. Detta
						// görs med en PushbackReader som vi eventuell måste skapa.
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
						// Nu finns det inte mer plats i bufferten så måste vi utöka den
						char[] tmp = buf;
						buf = new char[offset + 64];
						room = buf.length - offset - 1;
						System.arraycopy(tmp, 0, buf, 0, offset);
					}

					buf[offset++] = (char) c;
					break;
			}
		}

		// Har vi kommit till slutet av filen och offset är lika med noll
		// så innebär det att inget fanns att läsa. Vi returnerar null
		if ((c == -1) && (offset == 0))
		{
			return null;
		}

		// Skapar en sträng av char-arrayen
		String s = new String(buf, 0, offset);

		return new RomanNumeral(s);
	}

	// EGEN METOD NEXTROMANASINT
	// Läser nästa romerska tal från inströmmen pch returnerar som int
	public int nextRomanAsInt() throws IOException
	{
		RomanNumeral roman = nextRoman();

		if (roman == null)
			return -1;

		return roman.intValue();
	}
}