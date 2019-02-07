abstract class AbstractClass {

	public String toString() {
		return "AbstractClass";
	}

	public abstract void myMethod();

}


class ConcreteClass extends AbstractClass {


	public void myMethod() {
		System.out.println("This is myMethod in ConcreteClass.");
	}

	public String toString() {
		return "ConcreteClass, derived from " + super.toString();
	}

}

public class Client {

	public static void main(String args[]) {

		AbstractClass ac = new ConcreteClass();
		ac.myMethod();
		System.out.println(ac); // calls ac.toString();
	}
}

