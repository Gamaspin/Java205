


public class Person {
	
	String memberName;
	String phoneNo = "000-0000-0000";
	String socialId = "701225-0000000";
	long socialId2 = 7012250000000L;
	
	//클래스의 구성 - > 인스턴스 변수, 메소드
	void showData() {
		System.out.println("회원 이름 : " + this.memberName);
		System.out.println("회원 전화 번호 : " + this.phoneNo);
	}
	
	
	public static void main(String[] args) {
		//Person 인스턴스 생성
		Person person = new Person();
		System.out.println("이름 : " + person.memberName);
//		person.showData(memberName, phoneNo);
		person.memberName = "손흥민";
		person.showData();
		
	
	
}
}