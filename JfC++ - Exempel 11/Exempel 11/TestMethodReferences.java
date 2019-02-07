import java.util.*;
import java.util.function.*;

public class TestMethodReferences {	
	public static void main(String[] args) {
		Function<String, Integer> test1 = String::length;
		Function<String, Integer> test2 = s -> s.length();
		String s = "Lamdas are fun!";
		
		System.out.println(test1.apply(s)); // 15
		System.out.println(test2.apply(s)); // 15
		
		List<String> names = Arrays.asList("C++", "Java", "JSP", "Python", "Pascal", "C#", "Cobol");
		
		Comparator<String> c1 = (a, b) -> a.compareTo(b);
		Comparator<String> c2 = String::compareTo;
		
		System.out.println(names.toString());
		
		Collections.sort(names, c1);
		System.out.println(names.toString());
		
		Collections.sort(names, c2);
		System.out.println(names.toString());
		
		Supplier<User> s1 = User::new;
		User u = s1.get();
		
	}
}