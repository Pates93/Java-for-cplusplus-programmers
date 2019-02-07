import java.util.*;
import java.util.function.*;

public class TestFunction {
	
	public static void main(String[] args) {
		Function<String, Integer> stringLength = s -> s.length();
		System.out.println(stringLength.apply("Lamdas are fun!")); // 15
		
		Function<Integer, Double> half = i -> i / 2d;
		System.out.println(stringLength.andThen(half).apply("Lamdas are fun!")); // 7.5
		
		List<User> users = new ArrayList<>();
		users.add(new User("Robert", "admin"));
		users.add(new User("Sara", "member"));
		users.add(new User("Kalle", "member"));
		users.add(new User("Fia", "admin"));
		
		List<String> userStrings = getUsersAsString(users, user -> user.getName() + "|" + user.getRole());
		System.out.println(userStrings.toString());
		// [Robert|admin, Sara|member, Kalle|member, Fia|admin]
		
		userStrings = getUsersAsString(users, user -> user.getRole().toUpperCase() + ";" + user.getName());
		System.out.println(userStrings.toString());
		// [ADMIN;Robert, MEMBER;Sara, MEMBER;Kalle, ADMIN;Fia]
	}
	
	public static List<String> getUsersAsString(List<User> users, Function<User, String> function) {
		List<String> result = new ArrayList<>();
		
		for (User user : users) {
			String s = function.apply(user);
			result.add(s);
		}
		
		return result;
	}
}