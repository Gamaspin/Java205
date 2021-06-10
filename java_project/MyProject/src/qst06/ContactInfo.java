package qst06;


public class ContactInfo {

	protected String name;
	protected String phoneNo;
	protected String email;
	protected String address;
	protected String birthday;
	protected String group;
	
	
	public ContactInfo() {}
	public ContactInfo(String name, String phoneNo, String email, 
					String address, String birthday, String group) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	public String getName() {
		return this.name;	}
	public void setName(String name) {
		this.name = name;	}
	public String getPhoneNo() {
		return this.phoneNo;	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;	}
	public String getEmail() {
		return this.email;	}
	public void setEmail(String email) {
		this.email = email;	}
	public String getAddress() {
		return this.address;	}
	public void setAddress(String address) {
		this.address = address;	}
	public String getBirthday() {
		return this.birthday;	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;	}
	public String getGroup() {
		return this.group;	}
	public void setGroup(String group) {
		this.group = group;	}


	@Override
	public String toString() {
		return "ContactInfo [name=" + this.name + ", phoneNo=" + this.phoneNo 
				+ ", email=" + this.email + ", address=" + this.address
				+ ", birthday=" + this.birthday + ", group=" + this.group + "]";
	}
	
	
	
}
