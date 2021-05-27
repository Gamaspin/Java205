package ch07;

public class ArrayQ {
	public static void main(String[] args) {


		String src = "ABCDEFGXZ";
		int a = 0;
		for(int j=src.length()-1; j>=0; j--) {
			System.out.println("src.charAt("+ a++ +"):"+ src.charAt(j));
		}
	}
}
