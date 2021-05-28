package ex.infomanager;

public class UnivFriend extends Friend {

	String major;
	
	public UnivFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전공 :\t" + this.major);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 :\t" + this.getName());
		System.out.println("주소 :\t" + this.getAddress());
		System.out.println("전공 :\t" + this.getAddress());
	}

	
	
}
