/*
	Vectortest.java
	Topic: iteration
*/

import java.util.*;


public class Vectortest {


	public Vectortest() {

		Vector<Integer> vec = new Vector<Integer>();

		vec.add(3 );
		vec.add(5);

		Iterator<Integer> it =  vec.iterator();

		// Usage of iterators
		while(it.hasNext()) {
			Integer value = it.next();
			System.out.println(value+" ");
		}

		// Usage of vector index
		for(int i=0; i<vec.size(); ++i)
			System.out.println(vec.elementAt(i)+" ");


		// Usage of simplified for-loop
		for(Integer i:vec)
			System.out.println(i+" ");


	}



	public static void main(String args[]) {

		new Vectortest();

	}

}