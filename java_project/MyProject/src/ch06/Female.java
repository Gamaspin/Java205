package ch06;


public class Female extends Person {
	protected String boy;
	public String getBoy() {
		return this.boy;		}
	public void setBoy(String boy) {
		this.boy = boy;		}
	
	public Female(String name, int age, String id, String boy) {
		super(name, age, id);
		this.boy = boy;
	}
	
	void hello() {
		super.hello();
		System.out.println("좋아하는 남자아이돌은 " + this.boy + "입니다.");
	}
}

