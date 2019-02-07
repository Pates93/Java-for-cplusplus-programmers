import java.util.*;
import java.util.function.*;

public class TestConsumer {
	
	public static void main(String[] args) {
		User user = new User("Robert", "admin");
		
		Consumer<User> printName = u -> System.out.println("Name: " + u.getName());
		printName.accept(user);
		
		Consumer<User> printRole = u -> System.out.println("Role: " + u.getRole());
		printName.andThen(printRole).accept(user);
	}
}