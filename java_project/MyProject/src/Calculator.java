import java.util.Scanner;

public class Calculator {

	//메소드 -> 기능 (재료 -> 처리 -> 반환)
	//반환타입 메소드이름(매개변수들) {	처리 구문	}
	//		void plus(int num1, int num2) {
	//			System.out.println(num1 + num2);	}
	//		void minus(int num1, int num2) {
	//			System.out.println(num1 - num2);	}
	//		void multi(int num1, int num2) {
	//			System.out.println(num1 * num2);	}
	//		void div(int num1, int num2) {
	//			System.out.println(num1 / num2);	}

	int add (int a, int b) { 
		return a + b;	}
	int subtract (int a, int b) {
		return a - b;	}
	int multiply (int a, int b) {
		return a * b;	}
	int divide (int a, int b) { 
		return a / b;	}

	static int getValue() {
		Scanner sc = new Scanner(System.in);
		int inputString = sc.nextInt();
		return inputString;
	}
	double circumference (double radius) { 
		return 2 * Math.PI * radius;
	}

	double circleArea (double radius) {
		return Math.PI * radius * radius;
	}



	public static void main(String[] args) {
		//인스턴스 생성 -> 클래스의 정의가 필요 ( 필요한 변수, 필요한 메소드)
		//클래스이름 참조변수 = new 클래스이름
		Calculator cal = new Calculator();
		//				cal.plus(10, 20);
		//				cal.minus(20, 10);
		//				cal.multi(5, 6);
		//				cal.div(10, 3);

		Scanner scn = new Scanner(System.in);


		int a, b, result;
		char operator;
		System.out.print("첫 번째 숫자를 써주세요. : ");
		a = scn.nextInt();
		System.out.print("두 번째 숫자를 써주세요. : ");
		b = scn.nextInt();
		System.out.print("연산 기호를 써주세요. (+ - * /)");
		operator = scn.next().charAt(0);

		switch (operator) {
		case '+':
			result = cal.add(a, b);
			break;

		case '-':
			result = cal.subtract(a, b);	//result = first - second;
			break;

		case '*':
			result = a * b;
			break;

		case '/':
			result = a / b;
			break;

		default:
			System.out.printf("ERROR : +, -, *, / 중에서 연산자를 다시 입력해주세요. ");
			return;
		}

		System.out.println(a + " " + operator + " " + b + " = " + result);
		System.out.println("계산을 완료하였습니다.");
		System.out.println("");

		
		Scanner sc = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		double circumference, circleArea;
		System.out.println("원 둘레값을 위한 원의 반지름을 입력해주세요.");
		circumference = sc.nextDouble();
		System.out.println("원의 둘레는 " + calc.circumference(circumference));
		System.out.println("==========");
		System.out.println("원 넓이값을 위한 원의 반지름을 입력해주세요.");
		circleArea = sc.nextDouble();
		System.out.println("원의 넓이는 " + calc.circleArea(circleArea));
		System.out.println("종료합니다.");
	}
}
