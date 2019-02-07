/**
 * Ex03_08 - PersonTest3.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Person3 genom att skapa
 * ett objekt av klassen samt anropar de metoder som finns.
 */
public class PersonTest3
{
  public static void main(String[] args)
  {
    // Skapar tv� olika objekt av klassen Person2
    Person3 kalle = new Person3();
    Person3 ok�nd = new Person3();

    // S�tter namn, persnr
    kalle.setFornamn("Kalle");
    kalle.setEfternamn("Karlsson");
    kalle.setAlder(30);
    kalle.setPersnr("721111-1111");

    // Anropar den �verlagrade setNamn()-metoden
    // s� att vi sj�lva f�r angen namnet
    ok�nd.setNamn();


    // Anropar metoden print() f�r att skriva ut information om objekten
    kalle.print();
    System.out.println(); // Skriver ut en tom rad
    ok�nd.print();

    // Avslutar med System.exit eftersom vi anv�nt oss av dialogrutor i applikationen
    System.exit(0);

    // OBS!! Notera vad utskriften av objekten ok�nd ger. F�r objektet kalle har vi
    // anv�nt alla set()-metoder s� att alla instansvariabler har f�tt ett v�rde.
    // D�remot har vi enbart satt f�r- och efternamn p� objektet ok�nd. De �vriga
    // instansvariablerna tilldeles default-v�rden.
  }
}