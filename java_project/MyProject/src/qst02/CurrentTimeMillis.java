package qst02;

public class CurrentTimeMillis {
	public static void main(String[] args) {
		
		long sTime = System.nanoTime();
		System.out.println(sTime);
		
		long startTime = System.currentTimeMillis();
		
		long sum = 0;
		for(int n = 1; n <= 100000000; n++) {
//			System.out.println(n);
			sum += n;
		}
		long endTime = System.currentTimeMillis();
		
		long resultTime = endTime - startTime;
		
		System.out.println("연산 소요시간 : " + resultTime + " ms");
	}
}
