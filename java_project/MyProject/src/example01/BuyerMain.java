package example01;

public class BuyerMain {
	public static void main(String[] args) {
		
		//구매자 객체 생성
		Buyer buyer = new Buyer();
		
		//제품 객체 생성
		Tv tv = new Tv(1000);
		Computer com = new Computer(300);
		
		
		//구매
		buyer.buy(tv);
		buyer.buy(com);
		
//		//결과 지표
//		System.out.println("현재 남은 돈은 " + buyer.money + "만원입니다.");
//		System.out.println("현재 보너스점수는 " + buyer.bonusPoint + "점입니다.");
	
		//구매 지표 출력
		buyer.summary();
	}
}
