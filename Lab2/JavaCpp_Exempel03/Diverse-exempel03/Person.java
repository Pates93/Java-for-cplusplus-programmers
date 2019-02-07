/**
 * En klass som representerar en person med namn, personnummer
 * och ålder. Namnet representeras av klassen <code>Namn</code>
 * som innehåller information om både för- och efternamnet.
 * <p>
 * Metoder finns för att både sätta och hämta värden samt
 * för att skriva ut information om personen.
 *
 * @author Robert Jonsson
 * @version 2.0
 * @file Ex03_18 - Person.java
 */
public class Person
{
  private Namn namn;                 // Personens namn
  private int alder;                 // Personens ålder
  private String persnr;             // Personens pnr
  private static int antalPersoner;  // Antal skapade objekt

  /**
   * Skapar en ny <code>Person</code> med ett namn, en ålder och ett personnummer.
   * Alla olika sätt att skapa person objekt resulterar i att denna konstruktor
   * körs. Detta eftersom vi här räknar upp antalet skapade objekt av klassen.
   * @param namn    personens namn som ett <code>Namn</code> objekt
   * @param alder   personens ålder
   * @param persnr  personens personnummer
   * @see #getAntalPersoner()
   */
  public Person(Namn namn, int alder, String persnr)
  {
    this.namn   = namn;
    this.alder  = alder;
    this.persnr = persnr;
    antalPersoner = antalPersoner + 1;
  }

  /**
   * Skapar en ny <code>Person</code> med ett namn, en ålder och ett personnummer.
   * Denna variant att skapa objekt tar för- och efternamn som separata strängar. Därefter
   * skapas ett nytt <code>Namn</code> objekt som skickas till rätt konstruktor.
   * @param fornamn   personens förnamn
   * @param efternamn personens efternamn
   * @param alder     personens ålder
   * @param persnr    personens personnummer
   * @see #Person(Namn, int, String)
   */
  public Person(String fornamn, String efternamn, int alder, String persnr)
  {
	  // hej
	this(new Namn(fornamn, efternamn), alder, persnr);
  }

  /**
   * Skapar en ny <code>Person</code> med ett namn och en ålder, men inget personnummer.
   * Här skapas ett objekt som har ett namn och en ålder. Personnummret sätts default
   * till <code>"xxxxxx-xxxx" och bör senare ändras med {@link #setPersnr(String) setPersNr()}
   * metoden.
   * @param namn      personens namn
   * @param alder     personens ålder
   * @see #Person(Namn, int, String)
   */
  public Person(Namn namn, int alder)
  {
    this(namn, alder, "xxxxxx-xxxx");
  }

  /**
   * Default konstruktorn. Skapar en person med default värden satta på namn, ålder
   * personnummer. Detta sätt att skapa ett objekt bör undvikas. Använd istället
   * någon av de övriga konstruktorerna.
   * @see #Person(Namn, int, String)
   * @see #Person(String, String, int, String)
   * @see #Person(Namn, int)
   */
  public Person()
  {
      this(new Namn("---", "---"), -1, "xxxxxx-xxxx");
  }


  /**
   * Sätter namnet på personen.
   * @param namn personens namn
   * @see #setNamn(String, String)
   */
  public void setNamn(Namn namn)
  {
    this.namn = namn;
  }

  /**
   * Sätter namnet på personen. Utifrån de båda strängarna som skickas som
   * argument skapas ett nytt tillfälligt <code>Namn</code> objekt.
   * @param fornamn   personens förnamn
   * @param efternamn personens efternamn
   * @see #setNamn(Namn)
   */
  public void setNamn(String fornamn, String efternamn)
  {
    this.namn = new Namn(fornamn, efternamn);
  }

  /**
   * Sätter förnamnet på personen.
   * @param fornamn personens förnamn
   * @see #setEfternamn(String)
   */
  public void setFornamn(String fornamn)
  {
    namn.setFornamn(fornamn);
  }

  /**
   * Sätter efternamnet på personen.
   * @param efternamn personens efternamn
   * @see #setFornamn(String)
   */
  public void setEfternamn(String efternamn)
  {
    namn.setEfternamn(efternamn);
  }

  /**
   * Sätter åldern på personen.
   * @param alder personens ålder
   */
  public void setAlder(int alder)
  {
    this.alder = alder;
  }

  /**
   * Sätter personnummret på personen.
   * @param persnr personens personnummer
   */
  public void setPersnr(String persnr)
  {
    this.persnr = persnr;
  }

  /**
   * Returnerar personens namn.
   * @return namnet på personen
   * @see #getNamnAsString()
   */
  public Namn getNamn()
  {
    return namn;
  }

  /**
   * Returnerar personens namn som en sträng.
   * Strängen som returneras har formen <i>förnamn efternamn</i>.
   * @return namnet på personen som en sträng
   * @see #getNamn()
   * @see #toString()
   */
  public String getNamnAsString()
  {
	String f = namn.getFornamn();
	String e = namn.getEfternamn();
    return f + " " + e;
  }

  /**
   * Returnerar personens förnamn.
   * @return förnamnet på personen
   */
  public String getFornamn()
  {
    return namn.getFornamn();
  }

  /**
   * Returnerar personens efternamn.
   * @return efternamnet på personen
   */
  public String getEfternamn()
  {
    return namn.getEfternamn();
  }

  /**
   * Returnerar personens ålder.
   * @return åldern på personen
   */
  public int getAlder()
  {
    return alder;
  }

  /**
   * Returnerar personens personnummer.
   * @return personnummret på personen
   */
  public String getPersnr()
  {
    return persnr;
  }

  /**
   * Returnerar antalet skapade objekt av denna klass. Metoden är en s.k.
   * klass-metod, vilket innebär att den är deklarerad som <code>static</code>.
   * För att anropa metoden behövs inget <code>Person</code> objekt utan vi
   * anropar metoden direkt på klassen enligt följande:
   * <p>
   * <code>Person.getAntalPersoner()</code>
   * @return totala antalet skapade objekt av klassen
   */
  public static int getAntalPersoner()
  {
    return antalPersoner;
  }

  /**
   * Sriver ut information om personen på skärmen. Utskriften sker
   * enligt följande modell:<p>
   * <ul>Namn     Kalle Karlsson</ul>
   * <ul>Ålder    33</ul>
   * <ul>Persnr   771111-1111</ul>
   */
  public void print()
  {
    System.out.println("Namn\t" + getNamnAsString());
    System.out.println("†lder\t" + alder);
    System.out.println("Persnr\t" + persnr);
  }

  /**
   * Returnerar en strängrepresentation av objektet. Strängen som returneras
   * innehåller personens för- och efternamn. Kan vara smidigt om vi
   * vill använda objektet i t.ex. <code>System.out.println()</code>.
   * <p> Exempel:<code>
   * <ul>Person p = new Person("Kalle", "Karlsson", 33, "711111-1111");</ul>
   * <ul><code>System.out.println(p);</ul></code>
   * @return för- och efternamn på personen
   */
  public String toString()
  {
    return getNamnAsString();
  }
}