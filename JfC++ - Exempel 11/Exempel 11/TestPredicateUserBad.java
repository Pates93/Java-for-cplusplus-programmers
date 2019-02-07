import java.util.*;
import java.util.function.*;

public class TestPredicateUserBad {
	
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("Robert", "admin"));
		users.add(new User("Sara", "member"));
		users.add(new User("Kalle", "member"));
		users.add(new User("Fia", "admin"));
		
		List<User> admins = getAdminList(users);
		List<User> members = getMemberList(users);
	}
	
	public static List<User> getAdminList(List<User> users) {
		List<User> result = new ArrayList<>();
		
		for (User user : users) {
			if (user.getRole().equals("admin")) {
				result.add(user);
			}
		}
		
		return result;
	}

	public static List<User> getMemberList(List<User> users) {
		List<User> result = new ArrayList<>();
		
		for (User user : users) {
			if (user.getRole().equals("member")) {
				result.add(user);
			}
		}
		
		return result;
	}
}