public class Calculator {

	//메소드 -> 기능 (재료 -> 처리 -> 반환)
	//반환타입 메소드이름(매개변수들) {	처리 구문	}
		void plus(int num1, int num2) {
			System.out.println(num1 + num2);	}
		void minus(int num1, int num2) {
			System.out.println(num1 - num2);	}
		void multi(int num1, int num2) {
			System.out.println(num1 * num2);	}
		void div(int num1, int num2) {
			System.out.println(num1 / num2);	}
						
		int add (int a, int b) { 
			return a + b;	}
		int subtract (int a, int b) {
			return a - b;	}
		int multiply (int a, int b) {
			return a * b;	}
		int divide (int a, int b) { 
			return a / b;	}
	

	public static void main(String[] args) {
		System.out.println("류한성");
		
		//인스턴스 생성 -> 클래스의 정의가 필요 ( 필요한 변수, 필요한 메소드)
		//클래스이름 참조변수 = new 클래스이름
		
		Calculator cal = new Calculator();
		
	}
}
