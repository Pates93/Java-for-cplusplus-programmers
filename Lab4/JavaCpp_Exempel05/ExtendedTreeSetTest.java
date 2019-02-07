/*
	ExtendedTreeSetTest.java
	Class TreeSet is extended to class ExtendedTreeSet
	which has some ststic set operations added.
*/

import java.util.*;
import java.util.SortedSet.*;


class ExtendedTreeSet<E> extends TreeSet<E> {

	/**
	@return	returns the union of and aSet1 and aSet2
	*/
	public static <E> TreeSet<E> union(TreeSet<E> aSet1, TreeSet<E> aSet2)
		 {
			TreeSet<E> newSet = new TreeSet<E>(aSet1);
			for(Iterator<E> it=aSet2.iterator();it.hasNext();)
		 	{
				E element=it.next(); // if possible, add elements
		 		newSet.add(element);
			}
			return newSet; // return the union set
	}

	/**
	@return	returns the intersection between and aSet1 and aSet2
	*/
	public static <E> TreeSet<E> intersection(TreeSet<E> aSet1, TreeSet<E> aSet2)
	 {
		TreeSet<E> newSet=new TreeSet<E>();
		for(Iterator<E> it=aSet1.iterator();it.hasNext();)
	 	{
			E element=it.next();
	 		if(aSet2.contains(element))
	 			newSet.add(element);
		}
		return newSet;
	}


	/**
	@return	set difference of aSet1 and aSet2
	*/
	public static <E> TreeSet<E> difference(TreeSet<E> aSet1, TreeSet<E> aSet2 )
	{
		TreeSet<E> newSet=new TreeSet<E>(aSet1);
		for(Iterator<E> it=aSet1.iterator();it.hasNext();)
		{
			E element=it.next();
	 		if(aSet2.contains(element))
				newSet.remove(element);
		}

		return newSet;
	}

}

public class ExtendedTreeSetTest
{
	private TreeSet<Student> setA = new TreeSet<Student>();
	private TreeSet<Student> setB = new TreeSet<Student>();


	public ExtendedTreeSetTest() {

		Student s1 = new Student("Pelle Plugg","890413-8213");
		Student s2 = new Student("Nisse Nörd","900313-8117");
		Student s3 =new Student("Sandra Skarp","870202-8243");
		Student s4 =new Student("Lars Luring" , "850101-9239");
		Student s5 =new Student("Hanna Havre","881231-8277");
		Student s6 =new Student("Kalle Kula","840314-8217");

		setA.add(s1);
		setA.add(s2);
		setA.add(s3);
		setA.add(s4);

		setB.add(s3);
		setB.add(s4);
		setB.add(s5);
		setB.add(s6);


		System.out.println("Set A:");
		Iterator<Student> it = setA.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}


		System.out.println("\nSet B:");
		it = setB.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}



		SortedSet<Student> tmpSet = ExtendedTreeSet.union(setA,setB);
		it = tmpSet.iterator();

		System.out.println("\nset A union set B:");
		while(it.hasNext()) {
			System.out.println(it.next()); // Sorted
		}

		tmpSet = ExtendedTreeSet.intersection(setA,setB);
		it = tmpSet.iterator();
		System.out.println("\nSet A intersection Set B:");
		while(it.hasNext()) {
			System.out.println(it.next());
		}


		tmpSet = ExtendedTreeSet.difference(setA,setB);
		it = tmpSet.iterator();
		System.out.println("\nSet A difference Set B:");
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public static void main(String[] args)
	{
		new ExtendedTreeSetTest();
	}
}

/*
Utskrifter:

Set A:
Lars Luring, 850101-9239
Sandra Skarp, 870202-8243
Pelle Plugg, 890413-8213
Nisse Nörd, 900313-8117

Set B:
Kalle Kula, 840314-8217
Lars Luring, 850101-9239
Sandra Skarp, 870202-8243
Hanna Havre, 881231-8277

set A union set B:
Kalle Kula, 840314-8217
Lars Luring, 850101-9239
Sandra Skarp, 870202-8243
Hanna Havre, 881231-8277
Pelle Plugg, 890413-8213
Nisse Nörd, 900313-8117

Set A intersection Set B:
Lars Luring, 850101-9239
Sandra Skarp, 870202-8243

Set A difference Set B:
Pelle Plugg, 890413-8213
Nisse Nörd, 900313-8117

*/
