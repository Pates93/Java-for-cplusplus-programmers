/**
 * Ex03_14 - PersonTest5.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Person5 genom att skapa
 * objekt av klassen och visar hur m�nga objekt som �r
 * skapade.
 */
public class PersonTest5
{
  public static void main(String[] args)
  {
    // Anropar den statiska metoden f�r att "h�mta"
    // antalet skapade objekt. Observera att inga objekt av
    // klassen �nnu skapats, men det g�r inget eftersom
    // statiska metoder anropas med namnet p� klassen.
    int antal = Person5.getAntalPersoner();
    System.out.println("Antal skapade objekt: " + antal);

    // Skapar olika objekt av klassen Person5
    Person5 p1 = new Person5("Kalle", "Karlsson", 30, "721111-1111");
    Person5 p2 = new Person5("Stina", "Svensson", 12);
    Person5 p3 = new Person5();

    // Skriver ut antalet skapade objekt
    // Kom ih�g att metodanropet tilldelas det v�rde som returneras.
    // D�rf�r kan vi t.ex. g�ra som nedan utan att "mellanlagra" i en lokal variabel.
    System.out.println("Antal skapade objekt: " + Person5.getAntalPersoner());

    // Nu n�r vi har objekt skapade av klassen Person5 kan vi �ven anv�nda dem f�r att
    // anropa statiska metoder. Dvs p2.getAntalPersoner() eller p1.getAntalPersoner()
    // fungerar lika bra och returnera samma v�rde som Person5.getAntalPersoner().

    // Avslutar med System.exit
    System.exit(0);
  }
}