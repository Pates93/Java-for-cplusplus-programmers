/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex03_02 - TextFileFilter.java
 */

import java.io.File;
import javax.swing.filechooser.*;

// Klass f�r att anv�ndas tillsammans med en JFileChooser
// Klassen sorterar ut s� att endast angivna textfiler visas
public class TextFileFilter extends FileFilter
{
	// Metod som returnerar true eller false beroende p�
	// om f �r en accepterad filtyp eller inte.
	public boolean accept(File f)
	{
		// Returnera true om det �r en katalog s� att anv�ndaren
		// har m�jlighet att navigera runt i katalogstrukturen
		if (f.isDirectory())
		{
			return true;
		}

		// Ta reda p� fil�ndelse
		String extension = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 &&  i < s.length() - 1)
		{
			extension = s.substring(i+1).toLowerCase();
		}

		if (extension != null)
		{
			// Returnera true om n�gon av f�ljande fil�ndelser
			if (extension.equals("txt") ||
				extension.equals("text") ||
				extension.equals("java") ||
				extension.equals("htm") ||
				extension.equals("html"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return false;
	}

	// Beskrivning av filtret
	public String getDescription()
	{
		return "Textfiler";
	}
}