/**
 *
 * @author Örjan Sterner
 * @version 1.1 based on version 1.0 by Åke Malmberg
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.io.IOException;
import java.util.Scanner;

public class AnimalSoundPlayer {

	private AudioClip iAudioClip;

	public AnimalSoundPlayer(String aPathToSoundFile) throws IOException {

		URL url = getClass().getResource(aPathToSoundFile);
		if (url != null)
			iAudioClip = Applet.newAudioClip(url);
		else
			throw new IOException("Sound file  "+aPathToSoundFile+" not available");

	}



	public void playAnimalSound(boolean aLoop) {

		if(aLoop) {
			for(int i=0;i<3;++i)
				iAudioClip.loop();
		}
		else
			iAudioClip.play();

	}


	public void stopPlayingSound() {
		iAudioClip.stop();
	}
//--- main function for testing ---
/*
	public static void main(String args[]) throws IOException {
		AnimalSoundPlayer asp = new AnimalSoundPlayer("dog.wav");
		for(int i=0;i<3;++i)
			asp.playAnimalSound();

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
	}
*/

}