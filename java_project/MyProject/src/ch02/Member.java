package ch02;
import java.util.Calendar;
import java.util.Scanner;

// ch02.Member 이 클래스의 진짜이름
public class Member {
	Calendar calendar = Calendar.getInstance();
	int thisYear = calendar.get(Calendar.YEAR);
	int birthYear;
	int age;

	void fluCheck(int birthYear) {
		age = (thisYear-birthYear-1);
		if(age < 15 || age >= 65) {
			System.out.println("무료 예방 접종이 가능합니다.");
		} else {
			System.out.println("무료 접종 대상이 아닙니다.");
		} System.out.println("==============");
	}

	void medicalCheck(int birthYear) {
		age = (thisYear-birthYear-1);
		if(age >= 19) {
			System.out.println("만 19세 이상이셔서 무료 건강검진 대상자 입니다.");
			if(age%2 == 0) {
				System.out.println("짝수 해에 무료 건강 검진을 받을 수 있습니다.");
			} else if(age%2 == 1) {
				System.out.println("홀수 해에 무료 건강 검진을 받을 수 있습니다.");
			} 
			if(age >= 39) {
				System.out.println("또한 만 39세 이상이셔서 암 무료 검진 대상자 입니다.");
			}
		} 
		else {
			System.out.println("만 19세 이하는 무료 건강 검진 대상자가 아닙니다.");
		}
	}

	public static void main(String[] args) {

		//변수 선언
		//데이터의 타입 식별 이름
		//데이터 타입 -> 내가 다루어야 하는 데이터의 특징에 의해서 결정
		//기본형 8가지 -> 정수형, 실수형, boolean, 문자

		Scanner sc = new Scanner(System.in);
		Member member = new Member();

		System.out.println("독감예방 접종 대상자 여부를 확인합니다.");
		System.out.println("만 15세 미만, 만 65세 이상의 경우 무료예방접종이 가능합니다.");
		System.out.println("태어난 해를 입력해주세요.");
		int birthYear = sc.nextInt();
		member.fluCheck(birthYear);

		System.out.println("건강검진 대상자 여부를 확인합니다.");
		System.out.println("대한민국 성인(만 19세 이상)의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.");
		System.out.println("태어난 해를 입력해주세요.");
		birthYear = sc.nextInt();
		member.medicalCheck(birthYear);
	}
}
