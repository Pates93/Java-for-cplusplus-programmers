/**
 * Ex04_06 - Person.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med namn
 * och personnummer. Metoder finns f�r att
 * s�tta namn och personnummer samt att skriva
 * ut information om personen.
 */
public class Person1
{
  // F�lt
  private String namn;    // Personens namn
  private String persnr;  // Personens pnr

  // Metod f�r att s�tta namn p� personen
  // Tar som parameter en String
  public void setNamn(String n)
  {
    namn = n;
  }

  // Metod f�r att s�tta personnummret
  public void setPersnr(String p)
  {
    persnr = p;
  }

  // Denna metod skriver ut information om personen
  public void print()
  {
    System.out.println("Namn\t" + namn);
    System.out.println("Persnr\t" + persnr);
  }
}