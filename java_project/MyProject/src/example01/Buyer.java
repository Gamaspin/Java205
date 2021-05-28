package example01;

public class Buyer	/* extends Object (생략됨) */ {
	int money;
	int bonusPoint;
	
	//구매 목록을 저장할 배열을 만들어줌
	Product[] item;
	
	//구매한 제품의 개수 -> 배열의 입력 index값
	int cnt;

	public Buyer() {
		this.money = 10000;
		this.bonusPoint = 0;
		this.item = new Product[10];
		this.cnt = 0;
	}


	//제품들을 구매
	void buy(Product p) {

		//보유 금액을 확인하고 구매여부 체크
		if(this.money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;	//메소드의 종료, 값의 반환
		}
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;
		
		
		//구매 내역에 제품을 추가
//		item[cnt] = p;
//		cnt++;
		item[cnt++] = p;
		
		System.out.println(p + " 구매");
//		System.out.println(p.toString());
	}

	//출력 -> 구매 상품 리스트, 구매 금액의 총합 출력
	void summary() {
		int sum = 0;	//구매 총액
		String itemList = "";	//초기화는 null말고 그냥 빈칸으로 -> 뒤에 문자를 붙여나갈 것이기 때문
		int bonusPoint = 0;
		
		
	//배열을 반복문을 이용해서 구매 내역을 완성
		
		for(int i=0; i<cnt; i++) {
			//금액의 합
			sum += item[i].price;
			//적립될 보너스 포인트
			bonusPoint += item[i].bonusPoint;
			//구매 상품 이름
			itemList += item[i] + ", ";
							//참조변수만 쓰면 toString 하는거와 같음
		}
		System.out.println("구매하신 제품은 " + itemList + "입니다.");
		System.out.println("구매 금액은 총 " + sum + "만원 입니다.");
		System.out.println("적립된 포인트는 " + bonusPoint + "점 입니다.");
	}
}
