/**
 * Interface for audiable animals
 *
 * @author �rjan Sterner
 * @version 1.1 based on version 1.0 by �ke Malmberg
 */

public interface IAudiable
{
	public void listenToMe();  		// Produce a sound
	public int getSoundDuration();  // Length of sound in millisec
}