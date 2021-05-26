package ch03;

//변수의 기능 1. 데이터를 메모리에 저장 2. 주소의 기능
public class Member {
	
//	 Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 
//	 단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다. 
		//*생성자 -> 초기화 메소드, 인스턴스를 생성할 때 단 한번, 인스턴스 변수를 초기화한다.
//	 ① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
		//*데이터 저장 -> 변수를 이용해서 메모리에 저장
//	 ② 위에서 정의한 정보를 출력하는 메소드 정의
		//*기능 -> 메소드
//	 ③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
		//*생성자의 요구사항 -> 생성자 오버로딩
		//*오버로딩 -> 이름이 같은 메소드 정의
			//생성자의 이름 (매개변수) { 초기화 코드 ...}
			//생성자의 이름 -> 클래스 이름
			//생성자는 반드시 하나 이상이 있어야 한다!!!
			//조건
			//1. 메소드의 이름은 같다
			//2. 매개변수의 개수가 다르거나, 매개변수의 타입이 달라야 오버로딩 성립
			//3. 
//	 ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
		
	
	//① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	private String name;
	private String phoneNo;
	private String major;
	private int grade;
	private String email;
	private String birthday;
	private String address;
	
	//접근 제어 지시자 private을 쓰는 이유
	//클래스 내부의 멤버들만 참조가 가능 : 정보 은닉, 변수의 데이터를 보호
	//getter, setter 사용
	public String getName() {
		return this.name;	}
	public void setName(String name) {
		this.name = name;	}

	public String getPhoneNo() {
		return this.phoneNo;	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;	}

	public String getMajor() {
		return this.major;	}
	public void setMajor(String major) {
		this.major = major;	}

	public int getGrade() {
		return this.grade;	}
	public void setGrade(int grade) {
		this.grade = grade;	}

	public String getEmail() {
		return this.email;	}
	public void setEmail(String email) {
		this.email = email;	}

	public String getBirthday() {
		return this.birthday;	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;	}

	public String getAddress() {
		return this.address;	}
	public void setAddress(String address) {
		this.address = address;	}

	
	Member(String name, String phoneNo, String major, int grade, String email, String birthday, String address) {
		this(name, phoneNo, major, grade, email);
		this.birthday = birthday; 
		this.address = address;
	}
	Member(String name, String phoneNo, String major, int grade, String email) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.major = major;
		this.grade = grade;
		this.email = email;
	}
	Member(String name, String phoneNo, String major) {
		this(name, phoneNo, major, 0, null, null, null);
	}
	Member() {}
	
	//② 위에서 정의한 정보를 출력하는 메소드 정의
			void printInfo() {
				System.out.println("이름 : " + this.name); //this -> 자기 자신의 참조값을 가지는 참조변수
				System.out.println("휴대전화 : " + phoneNo);
				System.out.println("전공 : " + major);
				System.out.println("학년 : " + grade);
				System.out.println("이메일 : " + email);
				if(this.birthday == null) {
					System.out.println("생일 : 입력된 데이터 없음");
				} else {
					System.out.println("생일 : " + birthday);
				}
				if(this.address != null) {
					System.out.println("주소 : " + address);
				} else {
					System.out.println("주소 : 입력된 데이터 없음");
				}
			}

	public static void main(String[] args) {
		Member m1 = new Member("손흥민", "010-3333-8888", "양발감아차기", 4, "hmson7@", "7월 7일", "Tottenham, England");
		Member m2 = new Member("이강인", "010-1111-7777", "탈압박메커니즘", 1, "kanginlee@");
		//m1.name = "안정환";
		m1.setName("홍명보");
		m1.printInfo();
		System.out.println(m1.name);
		System.out.println();
		
		m2.printInfo();
	}
}

