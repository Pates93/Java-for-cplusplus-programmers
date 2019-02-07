import java.util.*;

public class DescendingAlphabeticalComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return b.compareTo(a);
	}
}