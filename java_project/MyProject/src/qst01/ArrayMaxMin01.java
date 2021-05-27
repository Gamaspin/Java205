package qst01;
import java.util.*;

public class ArrayMaxMin01 {
	public static int miniValue(int[] arr) {
		int min = arr[0];
		for (int i=1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int maxValue(int[] arr) {
		int max = arr[0];
		for (int i=1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int inputLength=0;

		System.out.println("배열 길이를 입력해주세요.");
		inputLength = sc.nextInt();
		int[] arr = new int[inputLength];
		System.out.print("배열에 들어갈 숫자를 입력해 주세요 : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("최소값 : " + miniValue(arr));
		System.out.println("최대값 : " + maxValue(arr));
	}
}
