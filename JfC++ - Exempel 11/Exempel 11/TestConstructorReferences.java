import java.util.*;
import java.util.function.*;

public class TestConstructorReferences {	
	public static void main(String[] args) {
		// User user = User::new; //  error: incompatible types: User is not a functional interface
		
		Consumer<User> printNameAndRole = u -> System.out.println(u.getName() + " [" + u.getRole() + "]");
				
		Supplier<User> f1 = User::new;
		//Supplier<User> f1 = () -> new User();		
		User u1 = f1.get();
		printNameAndRole.accept(u1);
		
		Function<String, User> f2 = User::new;
		//Function<String, User> f2 = name -> new User(name);		
		User u2 = f2.apply("Robert");
		printNameAndRole.accept(u2);
		
		BiFunction<String, String, User> f3 = User::new;
		//BiFunction<String, String, User> f3 = (name, role) -> new User(name, role);
		User u3 = f3.apply("Robert", "admin");
		printNameAndRole.accept(u3);
	}
}