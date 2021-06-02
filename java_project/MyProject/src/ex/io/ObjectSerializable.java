package ex.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializable {
	public static void main(String[] args) {
		
		//오브젝트를 저장
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		out.writeObject(new Circle(1,2,3.4));	//괄호안에는 Serializable를 상속받는 특정 클래스만 가능
		out.writeObject(new Circle(3,5,7.9));
		out.writeObject("Hello");
		out.writeObject(new String("HEHEH"));
		
		
		ArrayList<Circle> list = new ArrayList<>();
		list.add(new Circle(1,2,3.4));
		list.add(new Circle(5,6,7.8));
		list.add(new Circle(9,12,13.14));
		list.add(new Circle(21,22,23.24));
		list.add(new Circle(31,32,33.34));
		out.writeObject(list);
		
		
		
		
		out.close();
		System.out.println("인스턴스 저장 완료");
		
		
		//인스턴스 복원
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
		
		//복원 순서는 저장 순서에 맞게 복원됨
		Circle c1 = (Circle) in.readObject();
		Circle c2 = (Circle) in.readObject();
		String str1 = (String) in.readObject();
		String str2 = (String) in.readObject();
		
		
		ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject();
		
		for (Circle circle : list2) {
			//circle.showData();
			System.out.println(circle);
		}
		
		
		System.out.println("======================");
		System.out.println("복원된 인스턴스의 데이터를 출력");
		
		c1.showData();
		c2.showData();
		System.out.println(str1);
		System.out.println(str2);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
	//ex.io.Circle 클래스
class Circle implements Serializable {
			//직렬화 대상임을 의미
	int x, y;
	transient double r;

	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void showData() {
		System.out.println("원점 [" + x + ", " + y + "]");
		System.out.println("반지름 : " + r);
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
	
	
}