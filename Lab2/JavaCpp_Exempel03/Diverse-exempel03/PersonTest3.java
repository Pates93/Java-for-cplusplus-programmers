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
    // Skapar två olika objekt av klassen Person2
    Person3 kalle = new Person3();
    Person3 okänd = new Person3();

    // Sätter namn, persnr
    kalle.setFornamn("Kalle");
    kalle.setEfternamn("Karlsson");
    kalle.setAlder(30);
    kalle.setPersnr("721111-1111");

    // Anropar den överlagrade setNamn()-metoden
    // så att vi själva får angen namnet
    okänd.setNamn();


    // Anropar metoden print() för att skriva ut information om objekten
    kalle.print();
    System.out.println(); // Skriver ut en tom rad
    okänd.print();

    // Avslutar med System.exit eftersom vi använt oss av dialogrutor i applikationen
    System.exit(0);

    // OBS!! Notera vad utskriften av objekten okänd ger. För objektet kalle har vi
    // använt alla set()-metoder så att alla instansvariabler har fått ett värde.
    // Däremot har vi enbart satt för- och efternamn på objektet okänd. De övriga
    // instansvariablerna tilldeles default-värden.
  }
}