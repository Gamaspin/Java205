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
		Person p1 = new Person("손흥민", "920708-1234567");
		Person p2 = new Person("이강인", "010219-3456789");
		Person p3 = new Person("손흥민", "920708-1234567");

		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람입니다.");
		}
		if(p1.equals(p3)) {
			System.out.println("p1과 p3은 같은 사람입니다.");
		}
		if(p2.equals(p3)) {
			System.out.println("p2과 p3은 같은 사람입니다.");
		}
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.equals(p3));
//		System.out.println(p2.equals(p3));
	}
}
