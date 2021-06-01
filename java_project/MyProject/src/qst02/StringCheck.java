package qst02;
import java.util.Scanner;

public class StringCheck {
// 사용자에게 이름을 입력받아
// 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고, 
// 공백으로 입력되었는지 판별하는 프로그램
	public static boolean checkName(String name) {
		boolean result = true;
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);			
			if(!(c>='a'&&c<='z' || c>='A'&&c<='Z')) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("영문이름을 입력해주세요 >>"); //  __    abc
		String name = sc.nextLine();

		if(name != null && !name.trim().isEmpty()) {
						 //name.trim().length() != 0
			if(checkName(name)) {
				System.out.println("입력하신 이름은 : " + name);
			} else {
				System.out.println("이름을 표현할 수 없는 문자가 포함되어 있습니다.");
			}
		} else {
			System.out.println("공백문자열이 입력되었습니다.");
		}
	}
}

