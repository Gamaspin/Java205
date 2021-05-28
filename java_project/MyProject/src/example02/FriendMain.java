package example02;

public class FriendMain {
	public static void main(String[] args) {

		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		Friend f3 = new Friend("손흥민");

		System.out.println(f1);	//f1.toString();
		System.out.println(f2);
		System.out.println(f3);

		System.out.println(f1 == f3);	//각 인스턴스의 주소값이 다르므로 false
		System.out.println(f1.equals(f3));


	}
}



class Friend {
	String myName;

	Friend(String name) {
		myName = name;
	}

	@Override
	public String toString() {
		return "제 이름은 " + myName + "입니다.";  
	}

	public boolean equals(Object o) {	//Object타입에 이렇게 메소드가 정의되어있음. 그냥 외울것

		boolean result = false;

		if(o != null && o instanceof Friend) {
			Friend f = (Friend) o;
			if(myName.equals(f.myName)) {		//상황에 맞게 조건 추가 가능
				result = true;
			}
		} 
		return result;

	}
}