import java.util.function.*;

public class TestPredicate {
	
	public static void main(String[] args) {
		Predicate<Integer> greaterThanTen = i -> i > 10;
		System.out.println(greaterThanTen.test(14)); // true
		System.out.println(greaterThanTen.test(7));  // false
		
		Predicate<Integer> lowerThanTwenty = i -> i < 20;
		System.out.println(greaterThanTen.and(lowerThanTwenty).test(15));  // true
		System.out.println(greaterThanTen.and(lowerThanTwenty).negate().test(15)); // false
		
		// Skriver ut Number 10 passed the test!
		process(10, i -> i > 7);
	}
	
	public static void process(int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("Number " + number + " passed the test!");
		}
	}
}