/**
 * En klass som representerar ett namn. Detta namn best�r
 * utav b�de f�r- och efternamnet.
 * <p>
 * Metoder finns f�r att b�de s�tta och h�mta b�de f�r-
 * och efternamn, samt f�r hela namet.
 *
 * @author Robert Jonsson
 * @version 1.0
 * @file Ex03_17 - Namn.java
 */
public class Namn
{
  // Instansvariabler
  private String fornamn;     // F�rnamn
  private String efternamn;   // Efternamn

  /**
   * Skapar ett nytt <code>Namn</code> med ett f�r- och efternamn angivet.
   * @param fornamn    personens f�rnamn
   * @param efternamn  personens efternamn
   */
  public Namn(String fornamn, String efternamn)
  {
    this.fornamn   = fornamn;
    this.efternamn = efternamn;
  }

  /**
   * Default konstruktorn. Skapar ett namn med default v�rden satta p� f�r-
   * och efternamn. Detta s�tt att skapa ett objekt b�r undvikas.
   * @see #Namn(String, String)
   */
  public Namn()
  {
      this("unknown", "unknown");
  }

  /**
   * S�tter nytt f�r- och efternamn.
   * @param fornamn   f�rnamnet
   * @param efternamn efternamnet
   * @see #setFornamn(String)
   * @see #setEfternamn(String)
   */
  public void setNamn(String fornamn, String efternamn)
  {
    this.fornamn   = fornamn;
    this.efternamn = efternamn;
  }

  /**
   * S�tter nytt f�rnamn.
   * @param fornamn f�rnamnet
   * @see #setEfternamn(String)
   */
  public void setFornamn(String fornamn)
  {
    this.fornamn = fornamn;
  }

  /**
   * S�tter nytt efternamnet.
   * @param efternamn efternamnet
   * @see #setFornamn(String)
   */
  public void setEfternamn(String efternamn)
  {
    this.efternamn = efternamn;
  }

  /**
   * Returnerar b�de f�r- och efternamn.
   * Str�ngen som returneras har formen <i>f�rnamn efternamn</i>.
   * @return f�r- och efternamn som en str�ng
   * @see #toString()
   */
  public String getNamn()
  {
    return fornamn + " " + efternamn;
  }

  /**
   * Returnerar f�rnamnet.
   * @return f�rnamnet
   */
  public String getFornamn()
  {
    return fornamn;
  }

  /**
   * Returnerar efternamnet.
   * @return efternamnet
   */
  public String getEfternamn()
  {
    return efternamn;
  }

  /**
   * Returnerar en str�ngrepresentation av objektet. Str�ngen som returneras
   * inneh�ller f�r- och efternamn. Kan vara smidigt om vi
   * vill anv�nda objektet i t.ex. <code>System.out.println()</code>.
   * <p> Exempel:<code>
   * <ul>Namn n = new Namn("Kalle", "Karlsson");</ul>
   * <ul><code>System.out.println(n);</ul></code>
   * @return f�r- och efternamn p� personen
   */
  public String toString()
  {
    return getNamn();
  }
}