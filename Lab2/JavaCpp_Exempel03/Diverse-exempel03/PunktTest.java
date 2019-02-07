/**
 * Ex03_10 - PunktTest.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Punkt genom att skapa
 * ett objekt av klassen samt anropar de metoder som finns.
 * Använder konstruktorn för att skapa objekt.
 */
public class PunktTest
{
  public static void main(String[] args)
  {
    // Skapar ett objekt av klassen Punkt. Objektet p1
    // innehåller en referens till själva objektet.
    Punkt p1 = new Punkt(100, 150);

    // Observera att vi nu inte längre kan använda
    // new Punkt() utan enda sättet att skapa Punkt-objekt
    // är att använda konstruktorn med två parametrar.

    // Skriver ut information om objektet
    p1.print();

    // Sätter nya värden och skriver ut igen
    p1.setX(200);
    p1.setY(50);
    p1.print();
  }
}