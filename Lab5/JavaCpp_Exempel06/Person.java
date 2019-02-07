/**
 * @author Robert Jonsson, ITM Östersund
 * @version 1.0
 * @file Ex02_03 - Person.java
 */

public class Person implements java.io.Serializable
{
	// Instansvariabler
	private String förnamn;
	private String efternamn;
	private int ålder;

	// Konstruktor
	public Person(String förnamn, String efternamn, int ålder)
	{
		this.förnamn = förnamn;
		this.efternamn = efternamn;
		this.ålder = ålder;
	}

	// Returnerar förnamnet
	public String hämtaFörnamn()
	{
		return förnamn;
	}

	// Returnerar efternamnet
	public String hämtaEfternamn()
	{
		return efternamn;
	}

	// Returnerar åldern
	public int hämtaÅlder()
	{
		return ålder;
	}

	public String toString()
	{
		return förnamn + " " + efternamn + " (" + ålder + " år)";
	}
}