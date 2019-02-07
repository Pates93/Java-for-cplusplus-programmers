/**
 * Ex03_04 - Person2.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med f�r-
 * och efternamn, �lder och personnummer. Metoder
 * finns f�r att s�tta och h�mta information om
 * personen.
 */
public class Person2
{
  // Instansvariabler
  private String fornamn;     // Personens f�rnamn
  private String efternamn;   // Personens efternamn
  private int alder;          // Personens �lder
  private String persnr;      // Personens personnummer

  // Metod f�r att s�tta f�rnamnet
  public void setFornamn(String f)
  {
    fornamn = f;
  }

  // Metod f�r att s�tta efternamnet
  public void setEfternamn(String e)
  {
    efternamn = e;
  }

  // Metod f�r att s�tta b�de f�r- och efternamn. Denna metod
  // har tv� parametrar, b�da av typen String. Ena parametern
  // anv�nds f�r att s�tta f�rnamn och den andra f�r efternamn.
  public void setNamn(String f, String e)
  {
    fornamn = f;
    efternamn = e;
  }

  // Metod f�r att s�tta �ldern
  public void setAlder(int a)
  {
    alder = a;
  }

  // Metod f�r att s��tta personnummer
  public void setPersnr(String p)
  {
    persnr = p;
  }

  // Metod som returnerar f�rnamnet
  public String getFornamn()
  {
    return fornamn;
  }

  // Metod som returnerar efternamnet
  public String getEfternamn()
  {
    return efternamn;
  }

  // Metod som returnerar �ldern
  public int getAlder()
  {
    return alder;
  }

  // Metod som returnerar personnumret
  public String getPersnr()
  {
    return persnr;
  }

  // Metod som returnerar b�de f�r- och efternamn samtidigt.
  // Observera att det �r endast ett v�rde som returneras
  public String getNamn()
  {
    return fornamn + " " + efternamn;
  }

  // Metod som skriver ut information om personen
  public void print()
  {
	// Anropar metoden getNamn() f�r att smidigt skriva ut b�de f�r- och efternamn
	// Vi hade kunnat skriva System.out.println("Namn\t" + fornamn + " " + efternamn");
	// Men n�r vi redan har en metod som formaterar namnet s� som vi vill utnyttjar vi den.
	// Vi ska undvika att upprepa samma kod p� flera olika st�llen (framf�r allt l�ngre kodstycken)
    System.out.println("Namn\t" + getNamn());
    System.out.println("�lder\t" + alder);
    System.out.println("Persnr\t" + persnr);
  }
}