package ch06;

public class Person_Main {
	public static void main(String[] args) {
		Male male = new Male("손흥민", 30 , "921234-1122334","아이유");
		Female female = new Female("아이유", 27, "961234-2045678","BTS");

		male.hello();
		System.out.println("");
		female.hello();
	}
}
