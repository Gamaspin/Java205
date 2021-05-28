package ex.infomanager;


//상속을 목적으로 하는 클래스
public class Friend {

	//이름, 전화번호, 주소
	protected String name;
	protected String phoneNumber;
	protected String address;
	
	//생성자
	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	//게터 & 세터
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public void showData() {
		System.out.println("이름 :\t" + this.name);
		System.out.println("전화번호 :\t" + this.phoneNumber);
		System.out.println("주소 :\t" + this.address);
	}
	
	public void showBasicInfo() {}		//상속을 통해 오버라이딩하기 위함
}
