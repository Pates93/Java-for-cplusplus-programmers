/**
 * Ex03_10 - PunktTest.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Punkt genom att skapa
 * ett objekt av klassen samt anropar de metoder som finns.
 * Anv�nder konstruktorn f�r att skapa objekt.
 */
public class PunktTest
{
  public static void main(String[] args)
  {
    // Skapar ett objekt av klassen Punkt. Objektet p1
    // inneh�ller en referens till sj�lva objektet.
    Punkt p1 = new Punkt(100, 150);

    // Observera att vi nu inte l�ngre kan anv�nda
    // new Punkt() utan enda s�ttet att skapa Punkt-objekt
    // �r att anv�nda konstruktorn med tv� parametrar.

    // Skriver ut information om objektet
    p1.print();

    // S�tter nya v�rden och skriver ut igen
    p1.setX(200);
    p1.setY(50);
    p1.print();
  }
}