/**
 * Ex03_09 - Punkt.java
 * @author Robert Jonsson
 *
 * Denna klass representerar en punkt med en x- och y-koordinat.
 * Klassens innehåller information om punktens x-
 * och y-koordinat, detta är klassens data (instansvariabler).
 *
 * Vidare har vi metoder för att sätta värden på
 * koordinaterna samt för att skriva ut information
 * om punkten på skärmen. Det finns en konstruktor för att
 * direkt i samband med skapandet av ett objekt ange punkten
 * koordinater.
 */
public class Punkt
{
  // Instansvariabler
  private int xkord;  // För att lagra punktens x-koordinat
  private int ykord;  // För att lagra punktens y-koordinat


  // Konstruktor
  // Har två parametrar med vilka vi tilldelar
  // ett skapat objekt x- och y-koordinat
  public Punkt(int x, int y)
  {
	  xkord = x;
	  ykord = y;

	  // Vi hade även kunnat göra följande metodanrop
	  // i konstruktorn för att sätta värden på
	  // xkord och ykord:
	  //
	  // setX(x);
	  // setY(y);
  }
  // Metoder

  // Denna metod sätter nytt värde på x-koordinaten
  public void setX(int x)
  {
    // Lagrar det värde som skickas in i metoden via parametern x
    // i våran instansvariabel xkord. Vi gör här en tilldelning där fältet
    // xkord tilldeles värdet som finns lagrat i x
    xkord = x;
  }

  // Denna metod sätter nytt värde på y-koordinaten
  public void setY(int y)
  {
    ykord = y;
  }

  // Denna metod skriver ut punkten på skärmen enligt t.ex. (4, 5)
  public void print()
  {
    System.out.println("(" + xkord + ", " + ykord + ")");
  }
}