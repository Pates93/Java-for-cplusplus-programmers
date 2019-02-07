/**
 * Abstract base class for viewable och audiable animals
 *
 * @author �rjan Sterner
 * @version 1.1 based on version 1.0 by �ke Malmberg
 */

public abstract class Animal implements IViewable, IAudiable {

	private String iAnimalName;


	protected Animal(String aName) {
		iAnimalName = aName;
	}

	public abstract void lookAtMe();
    public abstract void listenToMe();
    public abstract int getSoundDuration();  // Length of sound clip in millisec

    public String toString() {
		return iAnimalName;
	}

}
