/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex02_05 - LaddaPersoner.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class LaddaPersoner extends JFrame implements ActionListener
{
	// Deklarerar de komponenter som ska användas
	private JLabel labelStatus;
	private JScrollPane scrollPane;
	private JTextArea textUtskrift;
	private JButton knappLadda;

	//
	private java.util.List<Person> personlista;

	// Konstruktorn i vilken vi skapar komponenterna
	public LaddaPersoner()
	{
		// Lista för alla personer som laddas
		personlista = new java.util.ArrayList<Person>();

		// Sätter titel på fönstret
		setTitle("Ladda personer från fil");

		// Anger vad som ska hända när vi stänger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sätter storlek och placering av fönstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenterna och placerar ut dem
		labelStatus = new JLabel("Antal personer: " + personlista.size());
		knappLadda = new JButton("Läs in personer från fil");
		scrollPane = new JScrollPane();
		textUtskrift = new JTextArea();

		scrollPane.setViewportView(textUtskrift);
		knappLadda.addActionListener(this);

		add(knappLadda, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(labelStatus, BorderLayout.SOUTH);

		// Gör fönstret synligt
		setVisible(true);
	}

	// Metod som skapar ett Person-objekt och sparar till fil
	private void laddaFrånFil()
	{
		// Läser alla personer från filen personer.dat
		try
		{
			DataInputStream in = new DataInputStream(new FileInputStream("personer.dat"));
			while (in.available() > 0)
			{
				String f = in.readUTF();
				String e = in.readUTF();
				int å = in.readInt();
				Person p = new Person(f, e, å);
				personlista.add(p);
				textUtskrift.append("Laddade " + p + " från fil\n");
			}
			in.close();
		}
		catch(FileNotFoundException fel)
		{
			textUtskrift.append(fel.toString());
		}
		catch(IOException fel)
		{
			textUtskrift.append(fel.toString());
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		// Har användaren tryckt på knappen för att spara
		if (ae.getSource() == knappLadda)
		{
			// Börjar med att tömma listan och rensa textfältet
			personlista.clear();
			textUtskrift.setText("");
			labelStatus.setText("Antal personer: " + personlista.size());

			// Läser in alla personer från filen
			laddaFrånFil();
			labelStatus.setText("Antal personer: " + personlista.size());
		}
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		new LaddaPersoner();
	}
}