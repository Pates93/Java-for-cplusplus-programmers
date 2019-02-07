/**
 * Ex03_01 - Adderare.java
 * @author Robert Jonsson
 *
 * Ett klass för att demonstrera metoder som tar mer
 * än en parameter. Denna klass har en metod som
 * tar två heltal som parametrar.
 */
public class Adderare
{
  // Metod som adderar två heltal med varandra och
  // skriver ut resultatet på skärmen
  public void addera(int tal1, int tal2)
  {
    // Beräknar summan av tal1 och tal2. Resultatet
    // lagrar vi i variabeln summa.
    int summa = tal1 + tal2;

	// Gör en utskrift av additionen enligt formen:
	// värde_på_tal1 + värde_på_tal2 = värde_på_summa
    System.out.println(tal1 + " + " + tal2 + " = " + summa);
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett nytt objekt av klassen Adderare. Vi använder inte
    // en testklass som övriga exempel gjort.
    Adderare add = new Adderare();

    // Beräknar summan av heltalskonstanterna 10 och 20
    add.addera(10, 20);

    // Beräknar summan av variablerna i1 och i2;
    int i1 = 25;
    int i2 = 5;
    add.addera(i1, i2);

    // Prova att ändra i koden för ett av metodanropen så att endast ett
    // argument anväds (eller fler än två). Kompilera och notera vilket
    // felmeddelande som ges. Prova även att ange fel datatyp som argument.
    // T.ex add.addera(10, "20"); eller add.addera(10, 23.43);
  }
}