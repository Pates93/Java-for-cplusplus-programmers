/**
 * Ex03_04 - Person2.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med för-
 * och efternamn, ålder och personnummer. Metoder
 * finns för att sätta och hämta information om
 * personen.
 */
public class Person2
{
  // Instansvariabler
  private String fornamn;     // Personens förnamn
  private String efternamn;   // Personens efternamn
  private int alder;          // Personens ålder
  private String persnr;      // Personens personnummer

  // Metod för att sätta förnamnet
  public void setFornamn(String f)
  {
    fornamn = f;
  }

  // Metod för att sätta efternamnet
  public void setEfternamn(String e)
  {
    efternamn = e;
  }

  // Metod för att sätta både för- och efternamn. Denna metod
  // har två parametrar, båda av typen String. Ena parametern
  // används för att sätta förnamn och den andra för efternamn.
  public void setNamn(String f, String e)
  {
    fornamn = f;
    efternamn = e;
  }

  // Metod för att sätta åldern
  public void setAlder(int a)
  {
    alder = a;
  }

  // Metod för att säätta personnummer
  public void setPersnr(String p)
  {
    persnr = p;
  }

  // Metod som returnerar förnamnet
  public String getFornamn()
  {
    return fornamn;
  }

  // Metod som returnerar efternamnet
  public String getEfternamn()
  {
    return efternamn;
  }

  // Metod som returnerar åldern
  public int getAlder()
  {
    return alder;
  }

  // Metod som returnerar personnumret
  public String getPersnr()
  {
    return persnr;
  }

  // Metod som returnerar både för- och efternamn samtidigt.
  // Observera att det är endast ett värde som returneras
  public String getNamn()
  {
    return fornamn + " " + efternamn;
  }

  // Metod som skriver ut information om personen
  public void print()
  {
	// Anropar metoden getNamn() för att smidigt skriva ut både för- och efternamn
	// Vi hade kunnat skriva System.out.println("Namn\t" + fornamn + " " + efternamn");
	// Men när vi redan har en metod som formaterar namnet så som vi vill utnyttjar vi den.
	// Vi ska undvika att upprepa samma kod på flera olika ställen (framför allt längre kodstycken)
    System.out.println("Namn\t" + getNamn());
    System.out.println("†lder\t" + alder);
    System.out.println("Persnr\t" + persnr);
  }
}