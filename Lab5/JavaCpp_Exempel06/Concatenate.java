/**
 * @author Robert Jonsson, ITM �stersund
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

		// S�tter att filv�ljaren endast ska visa textfiler
		fc.setFileFilter(new TextFileFilter());

		// Anv�ndaren ska kunna v�lja m�nga filer
		fc.setMultiSelectionEnabled(true);

		// Visar filv�ljaren
		int val = fc.showOpenDialog(null);

		// Har anv�ndaren tryckt p� knappen �ppna
		if (val == JFileChooser.APPROVE_OPTION)
		{
			// H�mtar valda filer
            File[] files = fc.getSelectedFiles();

            // Skapar ett objekt av v�r klass FileConcatenator
            FileConcatenator filecon = new FileConcatenator(files);

            // L�ter anv�ndaren v�lja var inneh�llet ska sparas
            fc.setMultiSelectionEnabled(false);
            val = fc.showSaveDialog(null);

            // Har anv�ndaren tryckt p� knappen Spara
			if (val == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();

				// Dags att spara ner inneh�llet i filerna till den nya filen
				filecon.concatenate(file);
			}
		}
	}
}