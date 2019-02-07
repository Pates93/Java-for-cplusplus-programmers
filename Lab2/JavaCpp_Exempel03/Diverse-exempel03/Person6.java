/**
 * Ex05_15 - Person6.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med för-
 * och efternamn, ålder och personnummer. Metoder
 * finns för att sätta och hämta information om
 * personen. Har överlagrat setNamn() så att användaren
 * själv får mata in för- och efternamn. Konstruktorer
 * finns för att enkelt kunna skapa objekt av klassen.
 * Har lagt till ett statiskt fält för att räkna antalet
 * skapade objekt. Har skrivit till en toString().
 */

// import av JOptionPane
import javax.swing.JOptionPane;

public class Person6
{
  // Fält
  private String fornamn;     // Personens förnamn
  private String efternamn;   // Personens efternamn
  private int alder;          // Personens ålder
  private String persnr;      // Personens pnr
  private static int antalPersoner;  // Antal skapade personer

  // Konstruktor som sätter värden på alla fält
  public Person6(String fornamn, String efternamn, int alder, String persnr)
  {
    this.fornamn = fornamn;
    this.efternamn = efternamn;
    this.alder = alder;
    this.persnr = persnr;

    // Ökar antalet skapade personer med ett
    antalPersoner++;
  }

  // Konstruktor som sätter namn och ålder, men inget persnr
  public Person6(String fornamn, String efternamn, int alder)
  {
    // Anropar konstruktorn ovan och sätter persnr till "xxxxxx-xxxx"
    this(fornamn, efternamn, alder, "xxxxxx-xxxx");
  }

  // Konstruktor som skapar ett "tomt" objekt
  public Person6()
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

  // Metod som returnerar antalet skapade objekt
  // Denna metod är statisk vilket innebär att den
  // tillhör klassen snarare än ett visst objekt
  public static int getAntalPersoner()
  {
    return antalPersoner;
  }

  // Metod som returnerar en strängrepresentation av objektet
  // Jag har valt att returnera för- och efternamn på personen
  // och utnyttjar metoden getNamn() som redan formaterar namnet
  // som jag vill ha det. Jag hade kunnat välja en annan representation
  // av ett Person-objekt.
  public String toString()
  {
    return getNamn();
  }
}