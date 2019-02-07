import java.time.*;
import java.util.function.*;

public class TestSupplier {
	
	public static void main(String[] args) {
		Supplier<Integer> supply42s = () -> 42;
		System.out.println(supply42s.get()); // 42
		
		Supplier<User> newUserSupplier = () -> new User();
		User user = newUserSupplier.get();
		user.setName("Kalle");
		
		Supplier<LocalDate> todaysDateSupplier = () -> LocalDate.now();
		System.out.println(todaysDateSupplier.get()); // 2015-09-24
	}
}