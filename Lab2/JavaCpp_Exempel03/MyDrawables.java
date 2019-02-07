interface IEatable {
	boolean isAnimal();
	boolean hasTail();
	float getWeight();
}

interface IHuntableAndEatable extends IEatable {
	boolean canFly();
	float getEscapeSpeed();
}


interface IDrawable
{	void drawMe(int x, int y);
}


class Rat implements IHuntableAndEatable, IDrawable {
	// IHuntableAndEatable
	public boolean isAnimal() { return true; }
	public boolean hasTail() { return true; }
	public float getWeight() { return 0.025f; }
	public boolean canFly() { return false;}
	public float getEscapeSpeed() { return 10.0f; }
	// IDrawable
	public void drawMe(int x, int y) {
		System.out.println("I am a rat.");
	}

	public String toString() { return "rat"; }
}



abstract class Feline
{	boolean hungry=true;
	abstract void speak();
	abstract boolean canEat(IEatable aFood);
	abstract boolean canCatch(IHuntableAndEatable aVictim);

}


class HouseCat extends Feline implements IDrawable {
	public void drawMe(int x, int y) {
		System.out.println("I am a housecat");
	}

	public void speak() {
		System.out.println("mjau");
	}

	boolean canEat(IEatable aFood) {
		if(aFood.isAnimal() && aFood.hasTail() &&
		   aFood.getWeight() < 0.25)
		   return true;
		return false;
	}

	boolean canCatch(IHuntableAndEatable aVictim) {
		if(!aVictim.canFly() && aVictim.getEscapeSpeed() < 12.0)
			return true;
		return false;
	}
}


class SpaceAlien extends Feline implements IDrawable{
	public void drawMe(int x, int y) {
		System.out.println("But I am a space-alien");
	}

	public void speak() {
		System.out.println("uhuh");
	}

	boolean canEat(IEatable aFood) {
		return true;	// Eats anything
	}

	boolean canCatch(IHuntableAndEatable aVictim) {
		return true;  // Catches anything
	}
}

public class MyDrawables
{
	private IDrawable[] drawables = new IDrawable[3];

	public MyDrawables()	// Create and "draw" the IDrawables
	{	drawables[0]=new HouseCat();
		drawables[1]=new SpaceAlien();
		drawables[2]=new Rat();

		for (int i=0;i<drawables.length;i++)
			drawables[i].drawMe(i*5,i*5);
	}

	public IDrawable getDrawable(int idx) {
		return drawables[idx];
	}

	public static void main(String[] args){

		MyDrawables theDrawables = new MyDrawables();

		// Can a HouseCat eat a rat??
		IHuntableAndEatable food = new Rat();
		Feline cat = new HouseCat();

		if(cat.canEat(food))
			System.out.println("A cat can eat a " + food);
		else
			System.out.println("No, a cat cannot eat a " + food);

		// Well then, can a cat catch a rat??
		if(cat.canCatch(food))
			System.out.println("A cat can catch a " + food);
		else
			System.out.println("No, a cat cannot catch a " + food);


		if(food instanceof IEatable) System.out.println("IEatable");
		if(food instanceof IHuntableAndEatable) System.out.println("IHuntableAndEatable");
		if(food instanceof IDrawable) System.out.println("IDrawable");
		if(food instanceof Rat) System.out.println("Rat");



	}
}
