/**
 *
 * @author Örjan Sterner
 * @version 1.1 based on version 1.0 by Åke Malmberg
 */

import java.io.IOException;
import java.util.Scanner;

public class Dog extends Animal  // implements IViewable and IAudiable
{
	private static String iImageFile = "golden.jpg";
    private static String iSoundFile = "dog.wav";
	private AnimalSoundPlayer iSoundPlayer;
	private AnimalImageViewer iImageViewer;

	public Dog() {
		super("Dog");
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
		iImageViewer.viewAnimal(400,400);

    }

    public void listenToMe()
    {
		boolean doSoundLoop = false;
		iSoundPlayer.playAnimalSound(doSoundLoop);
    }

	public int getSoundDuration() {
		return 1000;
	}

    //--- main function for testing ---

		public static void main(String args[]) throws IOException {
			Animal animal = new Dog();

			animal.lookAtMe();
			animal.listenToMe();

			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
		}


}
