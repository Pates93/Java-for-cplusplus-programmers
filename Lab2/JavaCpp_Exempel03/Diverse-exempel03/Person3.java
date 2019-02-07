/**
 * Ex03_07 - Person3.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med f�r-
 * och efternamn, �lder och personnummer. Metoder
 * finns f�r att s�tta och h�mta information om
 * personen. Har �verlagrat setNamn() s� att anv�ndaren
 * sj�lv f�r mata in f�r- och efternamn.
 */

// import av JOptionPane eftersom dialogrutor anv�nds
import javax.swing.JOptionPane;

public class Person3
{
  // Instansvariabler
  private String fornamn;     // Personens f�rnamn
  private String efternamn;   // Personens efternamn
  private int alder;          // Personens �lder
  private String persnr;      // Personens pnr

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
  // f�r- och efternamn
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
}