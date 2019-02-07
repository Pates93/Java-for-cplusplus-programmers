public class TestFormula1 {
	
	public static void main(String[] args) {
		Formula additionFormula = new Formula() {
			public double calculate(double a, double b) {
				return a + b;
			}
		};
		
		Formula subtractionFormula = new Formula() {
			public double calculate(double a, double b) {
				return a - b;
			}
		};
		
		Formula multiplicationFormula = new Formula() {
			public double calculate(double a, double b) {
				return a * b;
			}
		};
		
		Formula divisionFormula = new Formula() {
			public double calculate(double a, double b) {
				return a / b;
			}
		};
		
		double a = 4;
		double b = 5;
		
		System.out.println(a + " + " + b + " = " + additionFormula.calculate(a, b));
		System.out.println(a + " - " + b + " = " + subtractionFormula.calculate(a, b));
		System.out.println(a + " * " + b + " = " + multiplicationFormula.calculate(a, b));
		System.out.println(a + " / " + b + " = " + divisionFormula.calculate(a, b));
	}
}