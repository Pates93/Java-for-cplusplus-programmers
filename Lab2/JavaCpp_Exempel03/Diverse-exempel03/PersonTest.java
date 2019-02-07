/**
 * Ex03_19 - PersonTest.java
 * @author Robert Jonsson
 *
 * Ett klass som testar klassen Person genom att skapa
 * objekt av klassen samt anropar de metoder som finns.
 */
public class PersonTest
{
  public static void main(String[] args)
  {
    // Börjar med att skriva ut antal skapade objekt
    System.out.print("Antal skapade objekt: ");
    System.out.println(Person.getAntalPersoner() + "\n");


    // Provar olika sätt att skapa objekt av klassen Person och namn
    Person p1 = new Person("Kalle", "Karlsson", 33, "711111-1111");
    System.out.println("Nu har vi skapat: " + p1);

    Namn n1 = new Namn("Stina", "Svensson");
    Person p2 = new Person(n1, 14);
    System.out.println("Nu har vi skapat: " + p2.getNamnAsString());

    Person p3 = new Person();
    System.out.println("Nu har vi skapat: " + p3.getFornamn() + " " + p3.getEfternamn());

    Namn n2 = new Namn("Pelle", "Persson");
    Person p4 = new Person(n2, 25, "800101-0101");
    System.out.println("Nu har vi skapat: " + n2);

    // Skriver ut antal skapade objekt
	System.out.print("\n" + "Antal skapade objekt: ");
    System.out.println(Person.getAntalPersoner());

    // Anropar metoden print() på objekteten
    System.out.println("\nSkriver ut information:");
    p1.print();
    p2.print();
    p3.print();
    p4.print();

    // Ändrar värden på en del objekt
    p1.setAlder(103);
    p2.setFornamn("Anders");
    p2.setPersnr("750505-0505");
    p3.setNamn(p1.getNamn());  // Sätter namnet på p3 till samma som p1

    // Skriver ut info om dessa objekt igen
    System.out.println("\nSkriver ut information igen:");
	p1.print();
    p2.print();
    p3.print();
  }
}