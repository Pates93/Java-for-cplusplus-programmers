/**
 *
 * @author Örjan Sterner
 * @version 1.1 based on version 1.0 by Åke Malmberg
 */

import java.io.IOException;
import java.util.Scanner;

public class Lion extends Animal  // implements IViewable and IAudiable
{
	private static String iImageFile = "lion.jpg";
    private static String iSoundFile = "lion.wav";
	private AnimalSoundPlayer iSoundPlayer;
	private AnimalImageViewer iImageViewer;

	public Lion() {
		super("Lion");
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
		iImageViewer.viewAnimal(310,410);

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
			Animal lion = new Lion();

			lion.lookAtMe();
			lion.listenToMe();

			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
		}


}
