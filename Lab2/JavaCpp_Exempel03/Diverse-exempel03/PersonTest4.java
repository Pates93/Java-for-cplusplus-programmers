/**
 * Ex03_12 - PersonTest4.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Person4 genom att skapa
 * ett objekt av klassen genom konstruktorerna.
 */
public class PersonTest4
{
  public static void main(String[] args)
  {
    // Skapar olika objekt av klassen Person4 genom att
    // använda de tre olika konstruktorerna
    Person4 p1 = new Person4("Kalle", "Karlsson", 30, "721111-1111");
    Person4 p2 = new Person4("Stina", "Svensson", 12);
    Person4 p3 = new Person4();

    // Anropar metoden print() för varje objekt
    p1.print();
    System.out.println();  // Radbrytning
    p2.print();
    System.out.println();  // Radbrytning
    p3.print();

    // Avslutar med System.exit eftersom vi i Person4 använt dialogrutor
    // Är egentligen inte nödvändigt eftersom vi aldrig anropar metoden
    // som använder dialogrutor.
    System.exit(0);
  }
}