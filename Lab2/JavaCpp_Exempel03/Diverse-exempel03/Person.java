/**
 * En klass som representerar en person med namn, personnummer
 * och �lder. Namnet representeras av klassen <code>Namn</code>
 * som inneh�ller information om b�de f�r- och efternamnet.
 * <p>
 * Metoder finns f�r att b�de s�tta och h�mta v�rden samt
 * f�r att skriva ut information om personen.
 *
 * @author Robert Jonsson
 * @version 2.0
 * @file Ex03_18 - Person.java
 */
public class Person
{
  private Namn namn;                 // Personens namn
  private int alder;                 // Personens �lder
  private String persnr;             // Personens pnr
  private static int antalPersoner;  // Antal skapade objekt

  /**
   * Skapar en ny <code>Person</code> med ett namn, en �lder och ett personnummer.
   * Alla olika s�tt att skapa person objekt resulterar i att denna konstruktor
   * k�rs. Detta eftersom vi h�r r�knar upp antalet skapade objekt av klassen.
   * @param namn    personens namn som ett <code>Namn</code> objekt
   * @param alder   personens �lder
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
   * Skapar en ny <code>Person</code> med ett namn, en �lder och ett personnummer.
   * Denna variant att skapa objekt tar f�r- och efternamn som separata str�ngar. D�refter
   * skapas ett nytt <code>Namn</code> objekt som skickas till r�tt konstruktor.
   * @param fornamn   personens f�rnamn
   * @param efternamn personens efternamn
   * @param alder     personens �lder
   * @param persnr    personens personnummer
   * @see #Person(Namn, int, String)
   */
  public Person(String fornamn, String efternamn, int alder, String persnr)
  {
	  // hej
	this(new Namn(fornamn, efternamn), alder, persnr);
  }

  /**
   * Skapar en ny <code>Person</code> med ett namn och en �lder, men inget personnummer.
   * H�r skapas ett objekt som har ett namn och en �lder. Personnummret s�tts default
   * till <code>"xxxxxx-xxxx" och b�r senare �ndras med {@link #setPersnr(String) setPersNr()}
   * metoden.
   * @param namn      personens namn
   * @param alder     personens �lder
   * @see #Person(Namn, int, String)
   */
  public Person(Namn namn, int alder)
  {
    this(namn, alder, "xxxxxx-xxxx");
  }

  /**
   * Default konstruktorn. Skapar en person med default v�rden satta p� namn, �lder
   * personnummer. Detta s�tt att skapa ett objekt b�r undvikas. Anv�nd ist�llet
   * n�gon av de �vriga konstruktorerna.
   * @see #Person(Namn, int, String)
   * @see #Person(String, String, int, String)
   * @see #Person(Namn, int)
   */
  public Person()
  {
      this(new Namn("---", "---"), -1, "xxxxxx-xxxx");
  }


  /**
   * S�tter namnet p� personen.
   * @param namn personens namn
   * @see #setNamn(String, String)
   */
  public void setNamn(Namn namn)
  {
    this.namn = namn;
  }

  /**
   * S�tter namnet p� personen. Utifr�n de b�da str�ngarna som skickas som
   * argument skapas ett nytt tillf�lligt <code>Namn</code> objekt.
   * @param fornamn   personens f�rnamn
   * @param efternamn personens efternamn
   * @see #setNamn(Namn)
   */
  public void setNamn(String fornamn, String efternamn)
  {
    this.namn = new Namn(fornamn, efternamn);
  }

  /**
   * S�tter f�rnamnet p� personen.
   * @param fornamn personens f�rnamn
   * @see #setEfternamn(String)
   */
  public void setFornamn(String fornamn)
  {
    namn.setFornamn(fornamn);
  }

  /**
   * S�tter efternamnet p� personen.
   * @param efternamn personens efternamn
   * @see #setFornamn(String)
   */
  public void setEfternamn(String efternamn)
  {
    namn.setEfternamn(efternamn);
  }

  /**
   * S�tter �ldern p� personen.
   * @param alder personens �lder
   */
  public void setAlder(int alder)
  {
    this.alder = alder;
  }

  /**
   * S�tter personnummret p� personen.
   * @param persnr personens personnummer
   */
  public void setPersnr(String persnr)
  {
    this.persnr = persnr;
  }

  /**
   * Returnerar personens namn.
   * @return namnet p� personen
   * @see #getNamnAsString()
   */
  public Namn getNamn()
  {
    return namn;
  }

  /**
   * Returnerar personens namn som en str�ng.
   * Str�ngen som returneras har formen <i>f�rnamn efternamn</i>.
   * @return namnet p� personen som en str�ng
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
   * Returnerar personens f�rnamn.
   * @return f�rnamnet p� personen
   */
  public String getFornamn()
  {
    return namn.getFornamn();
  }

  /**
   * Returnerar personens efternamn.
   * @return efternamnet p� personen
   */
  public String getEfternamn()
  {
    return namn.getEfternamn();
  }

  /**
   * Returnerar personens �lder.
   * @return �ldern p� personen
   */
  public int getAlder()
  {
    return alder;
  }

  /**
   * Returnerar personens personnummer.
   * @return personnummret p� personen
   */
  public String getPersnr()
  {
    return persnr;
  }

  /**
   * Returnerar antalet skapade objekt av denna klass. Metoden �r en s.k.
   * klass-metod, vilket inneb�r att den �r deklarerad som <code>static</code>.
   * F�r att anropa metoden beh�vs inget <code>Person</code> objekt utan vi
   * anropar metoden direkt p� klassen enligt f�ljande:
   * <p>
   * <code>Person.getAntalPersoner()</code>
   * @return totala antalet skapade objekt av klassen
   */
  public static int getAntalPersoner()
  {
    return antalPersoner;
  }

  /**
   * Sriver ut information om personen p� sk�rmen. Utskriften sker
   * enligt f�ljande modell:<p>
   * <ul>Namn     Kalle Karlsson</ul>
   * <ul>�lder    33</ul>
   * <ul>Persnr   771111-1111</ul>
   */
  public void print()
  {
    System.out.println("Namn\t" + getNamnAsString());
    System.out.println("�lder\t" + alder);
    System.out.println("Persnr\t" + persnr);
  }

  /**
   * Returnerar en str�ngrepresentation av objektet. Str�ngen som returneras
   * inneh�ller personens f�r- och efternamn. Kan vara smidigt om vi
   * vill anv�nda objektet i t.ex. <code>System.out.println()</code>.
   * <p> Exempel:<code>
   * <ul>Person p = new Person("Kalle", "Karlsson", 33, "711111-1111");</ul>
   * <ul><code>System.out.println(p);</ul></code>
   * @return f�r- och efternamn p� personen
   */
  public String toString()
  {
    return getNamnAsString();
  }
}