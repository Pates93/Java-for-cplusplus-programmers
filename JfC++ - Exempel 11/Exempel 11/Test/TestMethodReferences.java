import java.util.function.*;
public class TestMethodReferences {
	
	public static void main(String[] args) {
		Function<String, Integer> test1 = String::length;
		Function<String, Integer> test2 = s -> s.length();
		String s = "Lamdas are fun!";
		
		System.out.println(test1.apply(s)); // 15
		System.out.println(test2.apply(s)); // 15
	}
}