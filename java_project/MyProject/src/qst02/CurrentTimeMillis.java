package qst02;

public class CurrentTimeMillis {
	public static void main(String[] args) {
		
		long startTime = 0; 
		long endTime = 0;
		long resultTime = 0;
		
		startTime = System.currentTimeMillis();
		
		for(int n = 1; n <= 1000000; n++) {
			System.out.println(n);
		}
		
		endTime = System.currentTimeMillis();
		
		resultTime = endTime - startTime;
		
		System.out.println("연산 시작시간 : " + startTime/1000);
		System.out.println("연산 종료시간 : " + endTime/1000);
		System.out.println("연산 소요시간 : " + resultTime/1000);
	}
}
