/**
 * En klass som representerar ett namn. Detta namn består
 * utav både för- och efternamnet.
 * <p>
 * Metoder finns för att både sätta och hämta både för-
 * och efternamn, samt för hela namet.
 *
 * @author Robert Jonsson
 * @version 1.0
 * @file Ex03_17 - Namn.java
 */
public class Namn
{
  // Instansvariabler
  private String fornamn;     // Förnamn
  private String efternamn;   // Efternamn

  /**
   * Skapar ett nytt <code>Namn</code> med ett för- och efternamn angivet.
   * @param fornamn    personens förnamn
   * @param efternamn  personens efternamn
   */
  public Namn(String fornamn, String efternamn)
  {
    this.fornamn   = fornamn;
    this.efternamn = efternamn;
  }

  /**
   * Default konstruktorn. Skapar ett namn med default värden satta på för-
   * och efternamn. Detta sätt att skapa ett objekt bör undvikas.
   * @see #Namn(String, String)
   */
  public Namn()
  {
      this("unknown", "unknown");
  }

  /**
   * Sätter nytt för- och efternamn.
   * @param fornamn   förnamnet
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
   * Sätter nytt förnamn.
   * @param fornamn förnamnet
   * @see #setEfternamn(String)
   */
  public void setFornamn(String fornamn)
  {
    this.fornamn = fornamn;
  }

  /**
   * Sätter nytt efternamnet.
   * @param efternamn efternamnet
   * @see #setFornamn(String)
   */
  public void setEfternamn(String efternamn)
  {
    this.efternamn = efternamn;
  }

  /**
   * Returnerar både för- och efternamn.
   * Strängen som returneras har formen <i>förnamn efternamn</i>.
   * @return för- och efternamn som en sträng
   * @see #toString()
   */
  public String getNamn()
  {
    return fornamn + " " + efternamn;
  }

  /**
   * Returnerar förnamnet.
   * @return förnamnet
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
   * Returnerar en strängrepresentation av objektet. Strängen som returneras
   * innehåller för- och efternamn. Kan vara smidigt om vi
   * vill använda objektet i t.ex. <code>System.out.println()</code>.
   * <p> Exempel:<code>
   * <ul>Namn n = new Namn("Kalle", "Karlsson");</ul>
   * <ul><code>System.out.println(n);</ul></code>
   * @return för- och efternamn på personen
   */
  public String toString()
  {
    return getNamn();
  }
}