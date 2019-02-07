/**
 * Ex03_02 - VardeAnrop.java
 * @author Robert Jonsson
 *
 * Ett klass för att visa vad som sker med primitiva
 * datatyper som skickas som argument till en metod.
 */
public class VardeAnrop
{
  // Metod som tar ett heltal som parameter och
  // tilldelar denna värdet 0
  public void nollStall(int tal)
  {
    tal = 0;
  }

  // Main metoden
  public static void main(String[] args)
  {
    // Skapar ett objekt av klassen VardeAnrop
    VardeAnrop va = new VardeAnrop();

    // Initierar variabeln tal att innehålla värdet 10 och skriver ut värdet
    int tal = 10;
    System.out.println("tal f”re anrop:  " + tal);

    // Anropar metoden nollStall för att sätta tal till 0
    // Skriver därefter ut värdet igen
    va.nollStall(tal);

    System.out.println("tal efter anrop: " + tal);
  }
}