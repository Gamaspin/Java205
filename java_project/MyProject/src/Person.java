import java.lang.*;
import java.util.Scanner;

public class Person {
	
	double circumference (double radius) { 
		return 2 * Math.PI * radius;
		}
	
	double circleArea (double radius) {
		return Math.PI * radius * radius;
	}

	
	public static void main(String[] args) {
//		String name;
//		String phoneNo;
//		int socialId;
		
		Scanner scn = new Scanner(System.in);
		Person p = new Person();
		
		double circumference, circleArea;
		System.out.println("원 둘레값을 위한 원의 반지름을 입력해주세요.");
		circumference = scn.nextDouble();
		System.out.println("원의 둘레는 " + p.circumference(circumference));
		System.out.println("==========");
		System.out.println("원 넓이값을 위한 원의 반지름을 입력해주세요.");
		circleArea = scn.nextDouble();
		System.out.println("원의 넓이는 " + p.circleArea(circleArea));
		System.out.println("종료합니다.");
		
		
	}
}
