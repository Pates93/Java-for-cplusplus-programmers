public class TestFormula2 {
	
	public static void main(String[] args) {
		Formula additionFormula = (a, b) -> a + b;		
		Formula subtractionFormula = (a, b) -> a - b;		
		Formula multiplicationFormula = (a, b) -> a * b;		
		Formula divisionFormula = (a, b) -> a / b;
		
		double a = 4;
		double b = 5;
		
		System.out.println(a + " + " + b + " = " + additionFormula.calculate(a, b));
		System.out.println(a + " - " + b + " = " + subtractionFormula.calculate(a, b));
		System.out.println(a + " * " + b + " = " + multiplicationFormula.calculate(a, b));
		System.out.println(a + " / " + b + " = " + divisionFormula.calculate(a, b));
	}
}