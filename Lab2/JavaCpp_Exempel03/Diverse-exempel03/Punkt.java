/**
 * Ex03_09 - Punkt.java
 * @author Robert Jonsson
 *
 * Denna klass representerar en punkt med en x- och y-koordinat.
 * Klassens inneh�ller information om punktens x-
 * och y-koordinat, detta �r klassens data (instansvariabler).
 *
 * Vidare har vi metoder f�r att s�tta v�rden p�
 * koordinaterna samt f�r att skriva ut information
 * om punkten p� sk�rmen. Det finns en konstruktor f�r att
 * direkt i samband med skapandet av ett objekt ange punkten
 * koordinater.
 */
public class Punkt
{
  // Instansvariabler
  private int xkord;  // F�r att lagra punktens x-koordinat
  private int ykord;  // F�r att lagra punktens y-koordinat


  // Konstruktor
  // Har tv� parametrar med vilka vi tilldelar
  // ett skapat objekt x- och y-koordinat
  public Punkt(int x, int y)
  {
	  xkord = x;
	  ykord = y;

	  // Vi hade �ven kunnat g�ra f�ljande metodanrop
	  // i konstruktorn f�r att s�tta v�rden p�
	  // xkord och ykord:
	  //
	  // setX(x);
	  // setY(y);
  }
  // Metoder

  // Denna metod s�tter nytt v�rde p� x-koordinaten
  public void setX(int x)
  {
    // Lagrar det v�rde som skickas in i metoden via parametern x
    // i v�ran instansvariabel xkord. Vi g�r h�r en tilldelning d�r f�ltet
    // xkord tilldeles v�rdet som finns lagrat i x
    xkord = x;
  }

  // Denna metod s�tter nytt v�rde p� y-koordinaten
  public void setY(int y)
  {
    ykord = y;
  }

  // Denna metod skriver ut punkten p� sk�rmen enligt t.ex. (4, 5)
  public void print()
  {
    System.out.println("(" + xkord + ", " + ykord + ")");
  }
}