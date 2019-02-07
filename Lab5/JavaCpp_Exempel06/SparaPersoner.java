/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex02_04 - SparaPersoner.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SparaPersoner extends JFrame implements ActionListener
{
	// Deklarerar de komponenter som ska användas
	private JLabel labelFörnamn;
	private JLabel labelEfternamn;
	private JLabel labelÅlder;
	private JScrollPane scrollPane;
	private JTextField textFörnamn;
	private JTextField textEfternamn;
	private JTextField textÅlder;
	private JTextArea textUtskrift;
	private JButton knappSpara;
	private JPanel panelKomponenter;
	private JPanel panelNorr;

	// Konstruktorn i vilken vi skapar komponenterna
	public SparaPersoner()
	{
		// Sätter titel på fönstret
		setTitle("Spara personer till fil");

		// Anger vad som ska hända när vi stänger
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sätter storlek och placering av fönstret
		setSize(400, 300);
		setLocation(200, 200);

		// Skapar komponenterna och placerar ut dem
		panelNorr = new JPanel();
		panelKomponenter = new JPanel();
		labelFörnamn = new JLabel();
		textFörnamn = new JTextField();
		labelEfternamn = new JLabel();
		textEfternamn = new JTextField();
		labelÅlder = new JLabel();
		textÅlder = new JTextField();
		knappSpara = new JButton();
		scrollPane = new JScrollPane();
		textUtskrift = new JTextArea();

		panelNorr.setLayout(new BorderLayout());
		panelKomponenter.setLayout(new GridLayout(6, 1));

		labelFörnamn.setText("Förnamn:");
		panelKomponenter.add(labelFörnamn);
		panelKomponenter.add(textFörnamn);

		labelEfternamn.setText("Efternamn:");
		panelKomponenter.add(labelEfternamn);
		panelKomponenter.add(textEfternamn);

		labelÅlder.setText("Ålder");
		panelKomponenter.add(labelÅlder);
		panelKomponenter.add(textÅlder);

		panelNorr.add(panelKomponenter, BorderLayout.CENTER);

		knappSpara.setText("Spara");
		knappSpara.addActionListener(this);
		panelNorr.add(knappSpara, BorderLayout.SOUTH);

		add(panelNorr, BorderLayout.NORTH);

		scrollPane.setViewportView(textUtskrift);

		add(scrollPane, BorderLayout.CENTER);

		// Gör fönstret synligt
		setVisible(true);
	}

	// Metod som skapar ett Person-objekt och sparar till fil
	private void sparaTillFil(Person p)
	{
		// Sparar ner namn och ålder till filen personer.dat. Lägger till data sist i filen.
		try
		{
			DataOutputStream ut = new DataOutputStream(new FileOutputStream("personer.dat", true));
			ut.writeUTF(p.hämtaFörnamn());
			ut.writeUTF(p.hämtaEfternamn());
			ut.writeInt(p.hämtaÅlder());
			int antalBytes = ut.size();  // Antal skrivna byte
			ut.close();

			textUtskrift.append("Sparade " + p + " till fil ("+ antalBytes + " byte)\n");
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

	// Metod som slumpar fram olika personer
	// Används bara för att fylla filen med några personer
	private Person slumpaPerson()
	{
		String[] förnamn = {"Robert", "Stina", "Kalle", "Bertil", "Anna", "Lisa", "Sara", "Max", "Alexander", "Mats", "Jenny", "Olle"};
		String[] efternamn = {"Jonsson", "Andersson", "Ek", "Abrahamsson", "Wangby", "Eriksson", "Hansson", "Svensson", "Sundin", "Larsson"};

		int f = (int)(Math.random() * förnamn.length);
		int e = (int)(Math.random() * efternamn.length);
		int å = (int)(Math.random() * 100);

		return new Person(förnamn[f], efternamn[e], å);
	}


	public void actionPerformed(ActionEvent ae)
	{
		// Har användaren tryckt på knappen för att spara
		if (ae.getSource() == knappSpara)
		{
			// Skapar ett person-objekt från data i textfälten
			// Kan kännas onödigt att först skapa ett Person-objekt och
			// därefter anropa metoder för att hämta och sen spara objektets
			// data. Görs mest för att demonstrera.
			String f = textFörnamn.getText();
			String e = textEfternamn.getText();
			int å = -1;

			try {å = Integer.parseInt(textÅlder.getText());}
			catch (NumberFormatException fel) {}

			Person p = new Person(f, e, å);
			sparaTillFil(p);

			// Rensar textfälten
			textFörnamn.setText("");
			textEfternamn.setText("");
			textÅlder.setText("");
			textFörnamn.requestFocus();

			/*for (int i = 0; i < 250; i++)
			{
				sparaTillFil(slumpaPerson());
			}*/
		}
	}

	public static void main(String[] args)
	{
		// Skapar ett objekt av den egna klassen
		new SparaPersoner();
	}
}