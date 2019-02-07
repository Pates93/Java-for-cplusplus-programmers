/**
 * Ex03_01 - Adderare.java
 * @author Robert Jonsson
 *
 * Ett klass f�r att demonstrera metoder som tar mer
 * �n en parameter. Denna klass har en metod som
 * tar tv� heltal som parametrar.
 */
public class Adderare
{
  // Metod som adderar tv� heltal med varandra och
  // skriver ut resultatet p� sk�rmen
  public void addera(int tal1, int tal2)
  {
    // Ber�knar summan av tal1 och tal2. Resultatet
    // lagrar vi i variabeln summa.
    int summa = tal1 + tal2;

	// G�r en utskrift av additionen enligt formen:
	// v�rde_p�_tal1 + v�rde_p�_tal2 = v�rde_p�_summa
    System.out.println(tal1 + " + " + tal2 + " = " + summa);
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett nytt objekt av klassen Adderare. Vi anv�nder inte
    // en testklass som �vriga exempel gjort.
    Adderare add = new Adderare();

    // Ber�knar summan av heltalskonstanterna 10 och 20
    add.addera(10, 20);

    // Ber�knar summan av variablerna i1 och i2;
    int i1 = 25;
    int i2 = 5;
    add.addera(i1, i2);

    // Prova att �ndra i koden f�r ett av metodanropen s� att endast ett
    // argument anv�ds (eller fler �n tv�). Kompilera och notera vilket
    // felmeddelande som ges. Prova �ven att ange fel datatyp som argument.
    // T.ex add.addera(10, "20"); eller add.addera(10, 23.43);
  }
}