import java.util.*;
import java.util.function.*;

public class TestPredicateUserGood {
	
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("Robert", "admin"));
		users.add(new User("Sara", "member"));
		users.add(new User("Kalle", "member"));
		users.add(new User("Fia", "admin"));
		
		List<User> admins = getUserList(users, user -> user.getRole().equals("admin"));
		List<User> members = getUserList(users, user -> user.getRole().equals("member"));
	}
	
	public static List<User> getUserList(List<User> users, Predicate<User> predicate) {
		List<User> result = new ArrayList<>();
		
		for (User user : users) {
			if (predicate.test(user)) {
				result.add(user);
			}
		}
		
		return result;
	}
}