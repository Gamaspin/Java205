package ch06;


public class Male extends Person {
	protected String girl;
	public String getGirl() {
		return this.girl;		}
	public void setGirl(String girl) {
		this.girl = girl;		}
	
	public Male (String name, int age, String id, String girl) {
		super(name, age, id);
		this.girl = girl;
	}
	
	void hello() {
		super.hello();
		System.out.println("좋아하는 여자아이돌은 " + this.girl + "입니다.");
	}
}

