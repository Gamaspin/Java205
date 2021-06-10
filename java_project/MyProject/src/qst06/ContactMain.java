package qst06;

import java.util.Scanner;

public class ContactMain {
	public static void main(String[] args) {
		
		
		ContactInfo info = new ContactInfo();
		
		
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		String phoneNo;
		String email;
		String address;
		String birthday;
		String group;
		
		System.out.println("이름을 입력해주세요.");
		name = sc.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		phoneNo = sc.nextLine();
		System.out.println("이메일 주소를 입력해주세요.");
		email = sc.nextLine();
		System.out.println("주소를 입력해주세요.");
		address = sc.nextLine();
		
		System.out.println(info.toString());
		
	}

	public ContactMain() {
		super();
		// TODO Auto-generated constructor stub
	}


}
