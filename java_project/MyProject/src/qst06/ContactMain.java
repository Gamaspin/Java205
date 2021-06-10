package qst06;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ContactMain implements Serializable {
	public static void main(String[] args) {
		
		
		ArrayList<ContactInfo> info = new ArrayList(10);
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
		System.out.println("생일을 입력해주세요.");
		birthday = sc.nextLine();
		System.out.println("그룹을 입력해주세요.");
		group = sc.nextLine();
		
		info.add(new ContactInfo(name, phoneNo, email, address
					,birthday, group));
		
//		Iterator<ContactInfo> itr = info.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		System.out.println(info.toString());
		
		
		
	}

	

	


}
