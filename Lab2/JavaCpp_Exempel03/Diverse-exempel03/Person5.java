/**
 * Ex05_13 - Person5.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med f�r-
 * och efternamn, �lder och personnummer. Metoder
 * finns f�r att s�tta och h�mta information om
 * personen. Har �verlagrat setNamn() s� att anv�ndaren
 * sj�lv f�r mata in f�r- och efternamn. Konstruktorer
 * finns f�r att enkelt kunna skapa objekt av klassen.
 * Har lagt till en statiskt instansvariabel f�r att r�kna antalet
 * skapade objekt.
 */

// import av JOptionPane
import javax.swing.JOptionPane;

public class Person5
{
  // Instansvariabler
  private String fornamn;     // Personens f�rnamn
  private String efternamn;   // Personens efternamn
  private int alder;          // Personens �lder
  private String persnr;      // Personens pnr
  private static int antalPersoner;  // Antal skapade personer

  // Konstruktor som s�tter v�rden p� alla instansvariabler
  public Person5(String fornamn, String efternamn, int alder, String persnr)
  {
    this.fornamn = fornamn;
    this.efternamn = efternamn;
    this.alder = alder;
    this.persnr = persnr;

    // �kar antalet skapade personer med ett
    antalPersoner = antalPersoner + 1;
  }

  // Konstruktor som s�tter namn och �lder, men inget persnr
  public Person5(String fornamn, String efternamn, int alder)
  {
    // Anropar konstruktorn ovan och s�tter persnr till "xxxxxx-xxxx"
    this(fornamn, efternamn, alder, "xxxxxx-xxxx");
  }

  // Konstruktor som skapar ett "tomt" objekt
  public Person5()
  {
    this("ok�nt", "ok�nt", -1, "xxxxxx-xxxx");
  }

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

  // Metod f�r att s�tta b�de f�r- och efternamn
  public void setNamn(String f, String e)
  {
    fornamn = f;
    efternamn = e;
  }

  // �verlagrad metod s� att anv�ndaren f�r ange
  // f�r- och efternamn med hj�lp av dialogrutor
  public void setNamn()
  {
    fornamn = JOptionPane.showInputDialog("Ange f�rnamn:");
    efternamn = JOptionPane.showInputDialog("Ange efternamn:");
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
    return  efternamn;
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

  // Metod som returnerar hela namnet
  public String getNamn()
  {
    return fornamn + " " + efternamn;
  }

  // Metod som skriver ut information om personen
  public void print()
  {
    System.out.println("Namn\t" + getNamn());
    System.out.println("�lder\t" + alder);
    System.out.println("Persnr\t" + persnr);
  }

  // Metod som returnerar antalet skapade objekt
  // Denna metod �r statisk vilket inneb�r att den
  // tillh�r klassen snarare �n ett visst objekt
  // och att ett anrop av metoden inte g�rs med ett objekt
  // utan med namnet p� klassen. Person5.getAntalPersoner();
  public static int getAntalPersoner()
  {
    return antalPersoner;
  }
}