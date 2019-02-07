/**
 * @author Robert Jonsson, ITM �stersund
 * @version 1.0
 * @file Ex02_03 - Person.java
 */

public class Person implements java.io.Serializable
{
	// Instansvariabler
	private String f�rnamn;
	private String efternamn;
	private int �lder;

	// Konstruktor
	public Person(String f�rnamn, String efternamn, int �lder)
	{
		this.f�rnamn = f�rnamn;
		this.efternamn = efternamn;
		this.�lder = �lder;
	}

	// Returnerar f�rnamnet
	public String h�mtaF�rnamn()
	{
		return f�rnamn;
	}

	// Returnerar efternamnet
	public String h�mtaEfternamn()
	{
		return efternamn;
	}

	// Returnerar �ldern
	public int h�mta�lder()
	{
		return �lder;
	}

	public String toString()
	{
		return f�rnamn + " " + efternamn + " (" + �lder + " �r)";
	}
}