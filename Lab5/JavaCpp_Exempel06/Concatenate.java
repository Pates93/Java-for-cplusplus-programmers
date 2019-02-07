/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex03_03 - Concatenate.java
 */

import java.io.*;
import javax.swing.*;

public class Concatenate
{
	public static void main(String[] args)
	{
		// Skapar en filechooser
		JFileChooser fc = new JFileChooser();

		// Sätter att filväljaren endast ska visa textfiler
		fc.setFileFilter(new TextFileFilter());

		// Användaren ska kunna välja många filer
		fc.setMultiSelectionEnabled(true);

		// Visar filväljaren
		int val = fc.showOpenDialog(null);

		// Har användaren tryckt på knappen Öppna
		if (val == JFileChooser.APPROVE_OPTION)
		{
			// Hämtar valda filer
            File[] files = fc.getSelectedFiles();

            // Skapar ett objekt av vår klass FileConcatenator
            FileConcatenator filecon = new FileConcatenator(files);

            // Låter användaren välja var innehållet ska sparas
            fc.setMultiSelectionEnabled(false);
            val = fc.showSaveDialog(null);

            // Har användaren tryckt på knappen Spara
			if (val == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();

				// Dags att spara ner innehållet i filerna till den nya filen
				filecon.concatenate(file);
			}
		}
	}
}