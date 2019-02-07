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
    // Skapar två  olika objekt av klassen Person2
    Person2 p1 = new Person2();
    Person2 p2 = new Person2();

    // Sätter namn, ålder och persnr på p1
    p1.setFornamn("Kalle");
    p1.setEfternamn("Karlsson");
    p1.setAlder(30);
    p1.setPersnr("721111-1111");

    // Sätter namn, ålder och persnr på p2.
    // Här använder vi setNamn() för att sätta både
    // för- och efternamn samtidigt.
    p2.setNamn("Stina", "Svensson");
    p2.setAlder(15);
    p2.setPersnr("900101-0101");

    // Anropar metoden print() på objektet p1
    // för att skriva ut personen på skärmen
    p1.print();

    // Anropar olika get()-metoder på objektet p2 för att
    // skriva ut informationen om personen. På så sätt kan vi
    // anpassa utseendet på utskriften om vi vill.
    System.out.println();
    System.out.print(p2.getNamn());
    int alder = p2.getAlder(); // Variabeln alder tilldelas värdet av metodanropet
    System.out.println(" „r " + alder + " †r gamal.");
    System.out.println("Hennes personnummer „r " + p2.getPersnr());
  }
}