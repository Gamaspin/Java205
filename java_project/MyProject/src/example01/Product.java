package example01;

public class Product {
	
	final int price; // 제품의 가격 (특별한 경우가 아니라면 변동되면 안되니 final)
	int bonusPoint; // 제품구매 시 제공하는 보너스점수
	
	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0); // 보너스점수는 제품가격의 10%
		}
	
}
