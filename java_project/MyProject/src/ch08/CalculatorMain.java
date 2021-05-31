package ch08;

public class CalculatorMain extends CalculatorImpl{

	public static void main(String[] args) {
		Calculator calc = new CalculatorImpl();
		
		System.out.println(calc.add(38, 17));
		System.out.println(calc.substract(38, 17));
		System.out.println(calc.multiply(38, 17));
		System.out.println(calc.divide(38, 17));
		
	}
}



