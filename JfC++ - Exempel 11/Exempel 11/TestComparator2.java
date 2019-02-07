import java.util.*;

public class TestComparator2 {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("C++", "Java", "JSP", "Python", "Pascal", "C#", "Cobol");
		
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		
		System.out.println(names.toString());
	}
}