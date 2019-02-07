/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex02_07 - LaddaPersonObjekt.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class LaddaPersonObjekt extends JFrame implements ActionListener
{
	// Deklarerar de komponenter som ska anv�ndas
	private JLabel labelStatus;
	private JScrollPane scrollPane;
	private JTextArea textUtskrift;
	private JButton knappLadda;

	//
	private java.util.List<Person> personlista;

	// Konstruktorn i vilken vi skapar komponenterna
	public LaddaPersonObjekt()
	{
		// Lista f�r alla personer som laddas
		personlista = new java.util.ArrayList<Person>();

		// S�tter titel p� f�nstret
		setTitle("Ladda Person-objekt fr�n fil");

		// Anger vad som ska h�nda n�r vi st�nger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// S�tter storlek och placering av f�nstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenterna och placerar ut dem
		labelStatus = new JLabel("Antal personer: " + personlista.size());
		knappLadda = new JButton("L�s in personer fr�n fil");
		scrollPane = new JScrollPane();
		textUtskrift = new JTextArea();

		scrollPane.setViewportView(textUtskrift);
		knappLadda.addActionListener(this);

		add(knappLadda, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(labelStatus, BorderLayout.SOUTH);

		// G�r f�nstret synligt
		setVisible(true);
	}

	// Metod som skapar ett Person-objekt och sparar till fil
	private void laddaFr�nFil()
	{
		// L�ser alla personer fr�n filen personer.dat
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("personobjekt.dat"));
			while (true)
			{
				Person p = (Person)in.readObject();
				personlista.add(p);
				textUtskrift.append("Laddade " + p + " fr�n fil\n");
			}
		}
		catch(ClassNotFoundException fel)
		{
			textUtskrift.append(fel.toString());
		}
		catch(EOFException fel)
		{
			// H�r b�r vi st�nga filen
		}
		catch(IOException fel)
		{
			textUtskrift.append(fel.toString());
			fel.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		// Har anv�ndaren tryckt p� knappen f�r att spara
		if (ae.getSource() == knappLadda)
		{
			// B�rjar med att t�mma listan och rensa textf�ltet
			personlista.clear();
			textUtskrift.setText("");
			labelStatus.setText("Antal personer: " + personlista.size());

			// L�ser in alla personer fr�n filen
			laddaFr�nFil();
			labelStatus.setText("Antal personer: " + personlista.size());
		}
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		new LaddaPersonObjekt();
	}
}