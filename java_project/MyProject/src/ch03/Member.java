package ch03;

public class Member {
	//변수의 기능 1. 데이터를 메모리에 저장 2. 주소의 기능
	String name;
	String phoneNo;
	String major;
	int grade;
	String email;
	String birthday;
	String address;

	Member(String name, String phonNo,String major,int grade, String email) {
		this(name, phonNo, major, grade, email, "7월7일", "Tottenham, England");
	}
	
	Member(String name, String phonNo, String major, int grade, String email, String birthday, String address) {
		this.name = name;
		this.phoneNo = phonNo;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}

	void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("휴대전화 : " + phoneNo);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
		System.out.println("이메일 : " + email);
		System.out.println("생일 : " + birthday);
		System.out.println("주소 : " + address);
	}

	public static void main(String[] args) {
		Member m1 = new Member("손흥민", "010-3333-8888", "양발감아차기", 4, "hmson7@");
		Member m2 = new Member("이강인", "010-1111-7777", "탈압박메커니즘", 1, "kanginlee@", "5월 25일", "Valencia, Spain");
		m1.printInfo();
		System.out.println();
		m2.printInfo();
	}
}

