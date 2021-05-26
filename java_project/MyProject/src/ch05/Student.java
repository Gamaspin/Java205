package ch05;

public class Student {

	private String name;
	private int korean;
	private int english;
	private int math;
	double average;
	int sum;

	Student() {}
	Student (String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return this.name;	}
	public void setName(String name) {
		this.name = name;	}
	public int getKorean() {
		return this.korean;	}
	public void setKorean(int korean) {
		this.korean = korean;	}
	public int getEnglish() {
		return this.english;	}
	public void setEnglish(int english) {
		this.english = english;	}
	public int getMath() {
		return this.math;	}
	public void setMath(int math) {
		this.math = math;	}

	public void sum() {
		sum = this.korean + this.english + this.math;
	}
	public double avg() {
		average = (double) sum / 3;
		return average;
	}
	public void show() {
		System.out.println(this.name + "의 평균점수는 " + average + "점 입니다.");
	}
	public String toString() {
		String str = this.name + ": " + this.korean + ", " + this.english + ", " + this.math;
		return str;
	}

	public static void main(String[] args) {

		Student[] student = new Student[10];
		student[0] = new Student("가", 90, 95, 100);
		student[1] = new Student("나", 86, 92, 85);
		student[2] = new Student("다", 100, 82, 98);
		student[3] = new Student("라", 97, 76, 90);
		student[4] = new Student("마", 85, 79, 94);

		student[5] = new Student("바", 76, 97, 100);
		student[6] = new Student("사", 88, 88, 92);
		student[7] = new Student("아", 100, 100, 100);
		student[8] = new Student("자", 45, 82, 76);
		student[9] = new Student("차", 83, 82, 88);

		for(int i=0; i < student.length; i++) {
			student[i].sum();
			student[i].avg();
			student[i].show();
			//student[0].toString();
			System.out.println(student[i].toString());
			System.out.println("");

		}
	}
}
