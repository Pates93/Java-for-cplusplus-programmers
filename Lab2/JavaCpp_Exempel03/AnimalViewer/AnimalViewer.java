/**
 * View and listen to animals from a collection
 *
 * @author Örjan Sterner
 * @version 1.1 based on version 1.0 by Åke Malmberg
 */

import java.util.Vector;


public class AnimalViewer {

	private Vector<Animal> iAnimalVec;

	public AnimalViewer()  {
		// Create collection of animals
    	iAnimalVec = new Vector<Animal>();
    	iAnimalVec.add(new Dog());
    	iAnimalVec.add(new Lion());
    	iAnimalVec.add(new Coyote());
    	iAnimalVec.add(new Lemur());
	}

	public void viewAnimals() {
		// View collection of animals
		for(Animal animal:iAnimalVec) {

			animal.lookAtMe();
			animal.listenToMe();
			try {
				Thread.sleep(animal.getSoundDuration());
			}
			catch(Exception e) {

			}
		}
    }

    public static void main(String[] args)
    {
		System.out.println("--- Welcome to the animal show!! ---");
		new AnimalViewer().viewAnimals();
		System.exit(0);
    }

}
