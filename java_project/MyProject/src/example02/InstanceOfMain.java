package example02;

public class InstanceOfMain {
	public static void main(String[] args) {

		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();

		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}

	public static void wrapBox(Box box) {
		//어떤 클래스의 void가 들어오는지 알아야함
		//형변환 여부 먼저 확인
//		if(box instanceof GoldPaperBox) {
//			((GoldPaperBox)box).goldPaperWrap();
//		} else if(box instanceof PaperBox) {
//			((PaperBox)box).paperWrap();
//		} else {
//			box.simpleWrap();	
//		}
	

	box.wrap();

}

}





class Box {
	public void simpleWrap() {
		System.out.println("1간단 포장");
	}
	public void wrap() {
		System.out.println("1간단 포장");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("2종이 포장");
	}
	public void wrap() {
		System.out.println("2종이 포장");
	}
}

class GoldPaperBox extends Box {
	public void goldPaperWrap() {
		System.out.println("3금박종이 포장");
	}
	public void wrap() {
		System.out.println("3금박종이 포장");
	}
}



