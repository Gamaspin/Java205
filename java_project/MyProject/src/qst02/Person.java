package qst02;

public class Person {
	String name;
	String personNumber;

	Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if((obj != null) && obj instanceof Person) {
			String personCheck = ((Person) obj).personNumber;
			return personCheck.equals(personNumber);
		} else {
			return false;
		}
	}

	
	
	public static void main(String[] args) {
		Person p1 = new Person("손흥민", "1992-07-08");
		Person p2 = new Person("이강인", "2001-02-19");
		Person p3 = new Person("손흥민", "1992-07-08");
		
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println(p2.equals(p3));
		
	}
}
