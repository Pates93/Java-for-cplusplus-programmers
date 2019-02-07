/**
 * Ex05_16 - PersonTest6.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Person6 toString() metod.
 */
public class PersonTest6
{
  public static void main(String[] args)
  {
    // Skapar olika objekt av klassen Person6
    Person6 p1 = new Person6("Kalle", "Karlsson", 30, "721111-1111");
    Person6 p2 = new Person6("Stina", "Svensson", 12);
    Person6 p3 = new Person6();

    // Provar olika sätt att använda toString()
    System.out.println(p1.toString());
    System.out.println(p1); // Används enbart objektreferensen i en System.out är det toString() som anropas.

    String namn = p2.toString();
    System.out.println(namn);
    System.out.println(p3 + " " + p1);

    // Avslutar med System.exit
    System.exit(0);
  }
}