/**
 * Ex04_06 - Person.java
 * @author Robert Jonsson
 *
 * En klass som representerar en person med namn
 * och personnummer. Metoder finns för att
 * sätta namn och personnummer samt att skriva
 * ut information om personen.
 */
public class Person1
{
  // Fält
  private String namn;    // Personens namn
  private String persnr;  // Personens pnr

  // Metod för att sätta namn på personen
  // Tar som parameter en String
  public void setNamn(String n)
  {
    namn = n;
  }

  // Metod för att sätta personnummret
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