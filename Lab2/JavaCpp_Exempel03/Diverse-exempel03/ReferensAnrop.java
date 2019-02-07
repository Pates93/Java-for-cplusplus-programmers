/**
 * Ex03_03 - ReferensAnrop.java
 * @author Robert Jonsson
 *
 * Ett klass f�r att visa vad som sker med objekt-
 * referenser som skickas som argument till en metod.
 */
public class ReferensAnrop
{
  // Metod som tar ett personobjekt och en str�ng som parameter.
  // P� objektet p anropar vi metoden setNamn f�r att s�tta nytt
  // namn p� personen.
  public void bytNamn(Person1 p, String n)
  {
    p.setNamn(n);
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett objekt av klassen ReferensAnrop
    ReferensAnrop ra = new ReferensAnrop();

    // Skapar ett person objekt och s�tter namn och persnr
    // Observera att jag anv�nder klassen Person1 f�r att skapa objektet
    // Anledningen �r att jag i lektion 3 har m�nga olika versioner av klassen Person
    // f�r att demonstrera olika saker.
    Person1 p1 = new Person1();
    p1.setNamn("Kalle");
    p1.setPersnr("711111-1111");

    // Skriver ut information om objektet
    p1.print();

    // Anropar metoden bytNamn() f�r att byta namn till Stina
    // Vi skickar v�rat objekt p1 (objektreferens) samt str�ngen-
    // konstanten Stina till metoden. Eftersom det �r objekt s�
    // skickas en kopia p� referensen via v�rdeanrop.
    ra.bytNamn(p1, "Stina");

    // Tillskillnad fr�n exemplet VardeAnrop.java p�verkas objekt av f�r�ndringar
    // som g�rs i objektet n�r det skickas som argument.
    p1.print();
  }
}