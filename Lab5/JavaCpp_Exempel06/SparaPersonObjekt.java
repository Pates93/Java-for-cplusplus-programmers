/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex02_06 - SparaPersonObjekt.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SparaPersonObjekt extends JFrame implements ActionListener
{
	// Deklarerar de komponenter som ska anv�ndas
	private JLabel labelF�rnamn;
	private JLabel labelEfternamn;
	private JLabel label�lder;
	private JScrollPane scrollPane;
	private JTextField textF�rnamn;
	private JTextField textEfternamn;
	private JTextField text�lder;
	private JTextArea textUtskrift;
	private JButton knappSpara;
	private JPanel panelKomponenter;
	private JPanel panelNorr;
	private ObjectOutputStream ut;

	// Konstruktorn i vilken vi skapar komponenterna
	public SparaPersonObjekt()
	{
		// S�tter titel p� f�nstret
		setTitle("Spara Person-objekt till fil");

		// Anger vad som ska h�nda n�r vi st�nger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// S�tter storlek och placering av f�nstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenterna och placerar ut dem
		panelNorr = new JPanel();
		panelKomponenter = new JPanel();
		labelF�rnamn = new JLabel();
		textF�rnamn = new JTextField();
		labelEfternamn = new JLabel();
		textEfternamn = new JTextField();
		label�lder = new JLabel();
		text�lder = new JTextField();
		knappSpara = new JButton();
		scrollPane = new JScrollPane();
		textUtskrift = new JTextArea();

		panelNorr.setLayout(new BorderLayout());
		panelKomponenter.setLayout(new GridLayout(6, 1));

		labelF�rnamn.setText("F�rnamn:");
		panelKomponenter.add(labelF�rnamn);
		panelKomponenter.add(textF�rnamn);

		labelEfternamn.setText("Efternamn:");
		panelKomponenter.add(labelEfternamn);
		panelKomponenter.add(textEfternamn);

		label�lder.setText("�lder");
		panelKomponenter.add(label�lder);
		panelKomponenter.add(text�lder);

		panelNorr.add(panelKomponenter, BorderLayout.CENTER);

		knappSpara.setText("Spara");
		knappSpara.addActionListener(this);
		panelNorr.add(knappSpara, BorderLayout.SOUTH);

		add(panelNorr, BorderLayout.NORTH);

		scrollPane.setViewportView(textUtskrift);

		add(scrollPane, BorderLayout.CENTER);

		// G�r f�nstret synligt
		setVisible(true);

		// Skapar ObjectOutputStream
		try
		{
			ut = new ObjectOutputStream(new FileOutputStream("personobjekt.dat", true));
		}
		catch(IOException fel)
		{
			textUtskrift.append(fel.toString());
		}
	}

	// Metod som sparar ett helt Person-objekt fil
	private void sparaTillFil(Person p)
	{
		// Sparar ner namn och �lder till filen personer.dat. L�gger till data sist i filen.
		try
		{
			ut.writeObject(p);
			ut.flush();

			textUtskrift.append("Sparade " + p + " till fil\n");
		}
		catch(IOException fel)
		{
			textUtskrift.append(fel.toString());
		}
	}

	// Metod som slumpar fram olika personer
	// Anv�nds bara f�r att fylla filen med n�gra personer
	private Person slumpaPerson()
	{
		String[] f�rnamn = {"Robert", "Stina", "Kalle", "Bertil", "Anna", "Lisa", "Sara", "Max", "Alexander", "Mats", "Jenny", "Olle"};
		String[] efternamn = {"Jonsson", "Andersson", "Ek", "Abrahamsson", "Wangby", "Eriksson", "Hansson", "Svensson", "Sundin", "Larsson"};

		int f = (int)(Math.random() * f�rnamn.length);
		int e = (int)(Math.random() * efternamn.length);
		int � = (int)(Math.random() * 100);

		return new Person(f�rnamn[f], efternamn[e], �);
	}


	public void actionPerformed(ActionEvent ae)
	{
		// Har anv�ndaren tryckt p� knappen f�r att spara
		if (ae.getSource() == knappSpara)
		{
			// Skapar ett person-objekt fr�n data i textf�lten
			// Kan k�nnas on�digt att f�rst skapa ett Person-objekt och
			// d�refter anropa metoder f�r att h�mta och sen spara objektets
			// data. G�rs mest f�r att demonstrera.
			String f = textF�rnamn.getText();
			String e = textEfternamn.getText();
			int � = -1;

			try {� = Integer.parseInt(text�lder.getText());}
			catch (NumberFormatException fel) {}

			Person p = new Person(f, e, �);
			sparaTillFil(p);

			// Rensar textf�lten
			textF�rnamn.setText("");
			textEfternamn.setText("");
			text�lder.setText("");
			textF�rnamn.requestFocus();

			/*for (int i = 0; i < 250; i++)
			{
				sparaTillFil(slumpaPerson());
			}*/
		}
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		new SparaPersonObjekt();
	}
}