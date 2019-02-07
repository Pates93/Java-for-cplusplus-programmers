/*
	TreeSetTest.java
	Topic: a sorted set,  TreeSet
*/

import java.util.*;
import java.util.SortedSet.*;


public class TreeSetTest
{
	private TreeSet<Student> theSet;

	public TreeSetTest() {
		theSet = new TreeSet<Student>();

		Student s1 = new Student("Pelle Plugg","890413-8213");
		Student s2 = new Student("Nisse Nörd","900313-8117");
		Student s3 =new Student("Sandra Skarp","870202-8243");
		Student s4 =new Student("Lars Luring" , "850101-9239");
		Student s5 =new Student("Nisse Nörd","900313-8117");

		theSet.add(s1);
		theSet.add(s2);
		theSet.add(s3);
		theSet.add(s4);
		theSet.add(s5);

		Iterator<Student> it = theSet.iterator();

		System.out.println("All students:");
		while(it.hasNext()) {  // All students
			System.out.println(it.next()); // Sorted
		}

		System.out.println("\nStudents >= "+s3+":");
		SortedSet<Student> smallSet = theSet.tailSet(s3);
		it = smallSet.iterator();
		while(it.hasNext()) {  // All students
					System.out.println(it.next()); // Sorted
		}


	}

	public static void main(String[] args)
	{
		new TreeSetTest();
	}
}

/*
Utskrifter:

All students:
[Lars Luring, 850101-9239]
[Sandra Skarp, 870202-8243]
[Pelle Plugg, 890413-8213]
[Nisse Nörd, 900313-8117]

Students >= [Sandra Skarp, 870202-8243]:
[Sandra Skarp, 870202-8243]
[Pelle Plugg, 890413-8213]
[Nisse Nörd, 900313-8117]

*/
