/**
 * Ex03_05 - PersonTest2.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Person2 genom att skapa
 * ett objekt av klassen samt anropar de metoder som finns.
 */
public class PersonTest2
{
  public static void main(String[] args)
  {
    // Skapar tv�  olika objekt av klassen Person2
    Person2 p1 = new Person2();
    Person2 p2 = new Person2();

    // S�tter namn, �lder och persnr p� p1
    p1.setFornamn("Kalle");
    p1.setEfternamn("Karlsson");
    p1.setAlder(30);
    p1.setPersnr("721111-1111");

    // S�tter namn, �lder och persnr p� p2.
    // H�r anv�nder vi setNamn() f�r att s�tta b�de
    // f�r- och efternamn samtidigt.
    p2.setNamn("Stina", "Svensson");
    p2.setAlder(15);
    p2.setPersnr("900101-0101");

    // Anropar metoden print() p� objektet p1
    // f�r att skriva ut personen p� sk�rmen
    p1.print();

    // Anropar olika get()-metoder p� objektet p2 f�r att
    // skriva ut informationen om personen. P� s� s�tt kan vi
    // anpassa utseendet p� utskriften om vi vill.
    System.out.println();
    System.out.print(p2.getNamn());
    int alder = p2.getAlder(); // Variabeln alder tilldelas v�rdet av metodanropet
    System.out.println(" �r " + alder + " �r gamal.");
    System.out.println("Hennes personnummer �r " + p2.getPersnr());
  }
}