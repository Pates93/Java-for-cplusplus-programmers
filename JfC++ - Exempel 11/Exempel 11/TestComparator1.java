import java.util.*;

public class TestComparator1 {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("C++", "Java", "JSP", "Python", "Pascal", "C#", "Cobol");
		Collections.sort(names, new DescendingAlphabeticalComparator());
		System.out.println(names.toString());
	}
}