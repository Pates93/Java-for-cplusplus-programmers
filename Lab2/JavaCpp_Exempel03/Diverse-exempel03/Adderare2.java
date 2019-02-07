/**
 * Ex03_06 - Adderare2.java
 * @author Robert Jonsson
 *
 * Ett klass för att demonstrera överlagrade metoder.
 * Varje metod tar två parametrar, men av olika typ,
 * och adderar dessa. Resultatet skrivs ut.
 */
public class Adderare2
{
  // Metod som adderar två heltal med varandra
  public void addera(int tal1, int tal2)
  {
    System.out.println("Adderar tv† heltal: " + tal1 + " och " + tal2);
    int summa = tal1 + tal2;

    System.out.println("Summan „r " + summa +"\n");
  }

  // En överlagrad metod som också tar två parametrar, men
  // denna gång två parametrar av typen double.
  public void addera(double tal1, double tal2)
  {
    System.out.println("Adderar tv† decimaltal: " + tal1 + " och " + tal2);
    double summa = tal1 + tal2;

    System.out.println("Summan „r " + summa +"\n");
  }

  // Ytterligare en överlagrad metod som adderar ett hel- och ett decimaltal
  public void addera(int tal1, double tal2)
  {
    System.out.println("Adderar ett heltal " + tal1 +
      " och ett deciamltal " + tal2);
    double summa = tal1 + tal2;

    System.out.println("Summan „r " + summa +"\n");
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett nytt objekt av klassen Adderare2
    Adderare2 add = new Adderare2();

    // Beroende vilken ordning och typ av data vi skickar
    // våra argument till metoden addera() så anropas
    // olika varianter av metoden.

    // Beräknar summan av heltalen 10 och 20
    add.addera(10, 20);

    // Beräknar summan av deciamltalen 5.5 och 14.9
    add.addera(5.5, 14.9);

    // Beräknar summan av heltalen 99 och 0.99
    add.addera(99, 0.99);

    // Prova att kommentera bort hela metoden som tar
    // två heltal (int) som parameter. Kompilera och
    // testkör. Vad tror du händer när anropet till
    // addera sker med två heltal (när det inte finns
    // någon sådan metod)?
  }
}