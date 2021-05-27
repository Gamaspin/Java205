package ch06;
import java.util.Calendar;

public class Person {
	protected String name;
	protected int age;
	protected String id;
	
//	Calendar calendar = Calendar.getInstance();
//	int thisYear = calendar.get(Calendar.YEAR);
//	String birthYear = id.substring(0,2);
//	char oldNew = id.charAt(7);
//	int ageData;
//	if(oldNew <3) {
//		age = thisYear -  
//	}
//	
	
	
	public Person() {}
	public Person (String name, int age, String id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public String getName()		{
		return this.name;		}
	public void setName(String name) {
		this.name = name;		}
	public int getAge() 		{
		return this.age;		}
	public void setAge(int age) {
		this.age = age;			}
	public String getSocialId() {
		return this.id;			}
	public void setSocialId(String socialId) {
		this.id = socialId;		}
	
	void hello() {
		System.out.println("안녕하세요. 저는" + this.name + "입니다. " +
				this.age + "살 입니다.");
	}
}

