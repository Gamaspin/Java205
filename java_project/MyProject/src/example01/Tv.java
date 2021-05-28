package example01;

public class Tv extends Product {

	Tv(int price) {
		super(price);
	}
	public String toString() {	// Object클래스의 toString()을 오버라이딩한다.
		return "Tv";
	}

}
