package explanation;
import java.util.Calendar;
import java.util.Scanner;



public class VaccineCheck {



	void vaccineCheck(int birthYear) {
		//int age = 2021 - birthYear - 1;
		int age = ageCal(birthYear);

		boolean check1 = age < 15 || age >= 65;
		boolean check2 = !(age >= 15 && age < 65);

		if(check1) {
			System.out.println("무료 예방 접종이 가능합니다.");
		} else {
			System.out.println("무료 접종 대상자가 아닙니다.");
		}
	}

	void checkUp(int birthYear) {
		int age = 2021 - birthYear - 1;
		boolean check3 = (birthYear%2 == 0 && 2021%2 == 0) 
					|| (birthYear%2 == 1 && 2021%2 == 1);
		boolean check4 = birthYear%2 == 2021%2;
		if(age >= 20 && check3) {
			System.out.println("검진 대상");
			if(age >= 40) {
				System.out.println("암검진 대상자");
			}
		} else {
			System.out.println("검진 대상이 아닙니다.");
		}
	}

	int ageCal(int year) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		return Calendar.getInstance().get(Calendar.YEAR) - year - 1;
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("태어난 해를 입력해주세요.");
		int birthYear = s.nextInt();

		VaccineCheck vc = new VaccineCheck();
		vc.vaccineCheck(birthYear);
		vc.checkUp(birthYear);
		
		
	}
}
