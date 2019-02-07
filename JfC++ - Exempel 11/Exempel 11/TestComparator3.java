import java.util.*;

public class TestComparator3 {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("C++", "Java", "JSP", "Python", "Pascal", "C#", "Cobol");
		
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names.toString());
		
		Collections.sort(names, (a, b) -> Integer.compare(a.length(), b.length()));
		System.out.println(names.toString());
	}
}