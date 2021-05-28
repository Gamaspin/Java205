package ex.infomanager;

public class HighFriend extends Friend {

	String work;
	
	public HighFriend(String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address);
		this.work = work;
	}

	@Override	//annotation
	public void showData() {
		super.showData();
		System.out.println("직업 :\t" + this.work);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 :\t" + this.getName());
		System.out.println("전화 :\t" + this.getPhoneNumber());
	}

	
	
}
