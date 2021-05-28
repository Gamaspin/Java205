package example01;

public class CastingTest01 {

	static class Car {
		String color;
		int door;


		void drive() {
			System.out.println("drive~");
		}
	}
	static class FireEngine extends Car {
		void drive() {
			System.out.println("drive water");
		}
		void water() {
			System.out.println("water!");
		}
	}

	static class Ambulance extends Car {
		void siren() {
			System.out.println("siren~");
		}
	}

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		Car fe2 = new FireEngine();
		fe.water();
		car = fe;	//car = (car)fe; 에서 형변환이 생략된 형태이다.
		//car.water();	//에러!!! Car타입의 참조변수로는 water()를 호출할 수 없다.
		//fe2 = (FireEngine) car;	//자손타입 <- 조상타입
		fe2.drive();
	}
}
