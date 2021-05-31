package ch08;

public class Calculator_Main extends Calculator_Impl{

	public static void main(String[] args) {
		Calculator calc = new Calculator_Impl();
		
		System.out.println(calc.add(10, 20));
		
	}
}

//class Calculator {
//	Calculator() {}
//	
//}



