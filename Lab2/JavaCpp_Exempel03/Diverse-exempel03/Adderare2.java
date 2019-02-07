/**
 * Ex03_06 - Adderare2.java
 * @author Robert Jonsson
 *
 * Ett klass f�r att demonstrera �verlagrade metoder.
 * Varje metod tar tv� parametrar, men av olika typ,
 * och adderar dessa. Resultatet skrivs ut.
 */
public class Adderare2
{
  // Metod som adderar tv� heltal med varandra
  public void addera(int tal1, int tal2)
  {
    System.out.println("Adderar tv� heltal: " + tal1 + " och " + tal2);
    int summa = tal1 + tal2;

    System.out.println("Summan �r " + summa +"\n");
  }

  // En �verlagrad metod som ocks� tar tv� parametrar, men
  // denna g�ng tv� parametrar av typen double.
  public void addera(double tal1, double tal2)
  {
    System.out.println("Adderar tv� decimaltal: " + tal1 + " och " + tal2);
    double summa = tal1 + tal2;

    System.out.println("Summan �r " + summa +"\n");
  }

  // Ytterligare en �verlagrad metod som adderar ett hel- och ett decimaltal
  public void addera(int tal1, double tal2)
  {
    System.out.println("Adderar ett heltal " + tal1 +
      " och ett deciamltal " + tal2);
    double summa = tal1 + tal2;

    System.out.println("Summan �r " + summa +"\n");
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett nytt objekt av klassen Adderare2
    Adderare2 add = new Adderare2();

    // Beroende vilken ordning och typ av data vi skickar
    // v�ra argument till metoden addera() s� anropas
    // olika varianter av metoden.

    // Ber�knar summan av heltalen 10 och 20
    add.addera(10, 20);

    // Ber�knar summan av deciamltalen 5.5 och 14.9
    add.addera(5.5, 14.9);

    // Ber�knar summan av heltalen 99 och 0.99
    add.addera(99, 0.99);

    // Prova att kommentera bort hela metoden som tar
    // tv� heltal (int) som parameter. Kompilera och
    // testk�r. Vad tror du h�nder n�r anropet till
    // addera sker med tv� heltal (n�r det inte finns
    // n�gon s�dan metod)?
  }
}