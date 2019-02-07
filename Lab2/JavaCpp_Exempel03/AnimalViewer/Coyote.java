/**
 *
 * @author Örjan Sterner
 * @version 1.1 based on version 1.0 by Åke Malmberg
 */

import java.io.IOException;
import java.util.Scanner;

public class Coyote extends Animal  // implements IViewable and IAudiable
{
	private static String iImageFile = "coyote.jpg";
    private static String iSoundFile = "coyote.wav";
	private AnimalSoundPlayer iSoundPlayer;
	private AnimalImageViewer iImageViewer;

	public Coyote() {
		super("Coyote");
		try {
			iSoundPlayer = new AnimalSoundPlayer(iSoundFile);
		}
		catch(IOException e) {
			System.err.println(e);
			System.exit(1);
		}

		iImageViewer = new AnimalImageViewer(iImageFile,toString());
    }

    public void lookAtMe()
    {
		iImageViewer.viewAnimal(500,500);

    }

    public void listenToMe()
    {
		boolean doSoundLoop = false;
		iSoundPlayer.playAnimalSound(doSoundLoop);
    }


	public int getSoundDuration() {
		return 5500;
	}

    //--- main function for testing ---

		public static void main(String args[]) throws IOException {
			Animal animal = new Coyote();

			animal.lookAtMe();
			animal.listenToMe();

			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
		}


}
