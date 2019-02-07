/**
 * Ex03_03 - ReferensAnrop.java
 * @author Robert Jonsson
 *
 * Ett klass för att visa vad som sker med objekt-
 * referenser som skickas som argument till en metod.
 */
public class ReferensAnrop
{
  // Metod som tar ett personobjekt och en sträng som parameter.
  // På objektet p anropar vi metoden setNamn för att sätta nytt
  // namn på personen.
  public void bytNamn(Person1 p, String n)
  {
    p.setNamn(n);
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett objekt av klassen ReferensAnrop
    ReferensAnrop ra = new ReferensAnrop();

    // Skapar ett person objekt och sätter namn och persnr
    // Observera att jag använder klassen Person1 för att skapa objektet
    // Anledningen är att jag i lektion 3 har många olika versioner av klassen Person
    // för att demonstrera olika saker.
    Person1 p1 = new Person1();
    p1.setNamn("Kalle");
    p1.setPersnr("711111-1111");

    // Skriver ut information om objektet
    p1.print();

    // Anropar metoden bytNamn() för att byta namn till Stina
    // Vi skickar vårat objekt p1 (objektreferens) samt strängen-
    // konstanten Stina till metoden. Eftersom det är objekt så
    // skickas en kopia på referensen via värdeanrop.
    ra.bytNamn(p1, "Stina");

    // Tillskillnad från exemplet VardeAnrop.java påverkas objekt av förändringar
    // som görs i objektet när det skickas som argument.
    p1.print();
  }
}