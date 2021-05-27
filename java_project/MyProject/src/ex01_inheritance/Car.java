package ex01_inheritance;

public class Car {
	int gasolineGauge;

	Car(int gas) {	//메소드 생성
		this.gasolineGauge = gas;	//생성자 생성
	}
	//	Car(){}
}
class HybridCar extends Car {	//오류메시지 = 디폴트생성자가 없어서 -> Car(){}
	int electronicGauge;

	//	public HybridCar() {
	//		super();
	//	}
	HybridCar(int gas, int eg) {
		super(gas);	//조상의 생성자는 반드시 첫 문장에서 호출해야함
		electronicGauge = eg;
	}
	HybridCar(int gas) {
		super(gas);
	}
}
class HybridWaterCar extends HybridCar {
	int waterGauge;

	HybridWaterCar(int gg, int eg, int wg) {
		super(gg, eg);
		waterGauge = wg;
	}
	HybridWaterCar(int gg, int eg) {
		super(gg, eg);
	}
	HybridWaterCar(int gg) {
		super(gg);
	}

	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolineGauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
	}
}
