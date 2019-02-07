/**
 * Ex03_11 - Person4.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med för-
 * och efternamn, ålder och personnummer. Metoder
 * finns för att sätta och hämta information om
 * personen. Har överlagrat setNamn() så att användaren
 * själv får mata in för- och efternamn. Konstruktorer
 * finns för att enkelt kunna skapa objekt av klassen.
 */

// import av JOptionPane
import javax.swing.JOptionPane;

public class Person4
{
  // Instansvariabler
  private String fornamn;     // Personens förnamn
  private String efternamn;   // Personens efternamn
  private int alder;          // Personens ålder
  private String persnr;      // Personens pnr

  // Konstruktor som sätter värden på alla instansvariabler
  public Person4(String fornamn, String efternamn, int alder, String persnr)
  {
    // Eftersom både instansvariablerna och parametrarna har samma namn så skiljer
    // vi dem åt genom att använda this. this.fornamn refererar till
    // instansvariablerna fornamn, medan bara fornamn refererar till parametern.
    this.fornamn = fornamn;
    this.efternamn = efternamn;
    this.alder = alder;
    this.persnr = persnr;
  }

  // Konstruktor som sätter namn och ålder, men inget persnr
  public Person4(String fornamn, String efternamn, int alder)
  {
    // Anropar konstruktorn ovan och sätter persnr till "xxxxxx-xxxx"
    // På så sätt initierar vi alla instansvariabler även om vi valde
    // att skapa ett objekt utan att ange ett personnummer.
    this(fornamn, efternamn, alder, "xxxxxx-xxxx");
  }

  // Konstruktor som skapar ett "tomt" objekt med endast våra egna
  // "default"-värden.
  public Person4()
  {
    this("ok„nt", "ok„nt", -1, "xxxxxx-xxxx");
  }

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

  // Metod för att sätta både för- och efternamn
  public void setNamn(String f, String e)
  {
    fornamn = f;
    efternamn = e;
  }

  // Överlagrad metod så att användaren får ange
  // för- och efternamn
  public void setNamn()
  {
    fornamn = JOptionPane.showInputDialog("Ange förnamn:");
    efternamn = JOptionPane.showInputDialog("Ange efternamn:");
  }

  // Metod för att sätta åldern
  public void setAlder(int a)
  {
    alder = a;
  }

  // Metod för att sätta personnummer
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
    return  efternamn;
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

  // Metod som returnerar hela namnet
  public String getNamn()
  {
    return fornamn + " " + efternamn;
  }

  // Metod som skriver ut information om personen
  public void print()
  {
    System.out.println("Namn\t" + getNamn());
    System.out.println("†lder\t" + alder);
    System.out.println("Persnr\t" + persnr);
  }
}