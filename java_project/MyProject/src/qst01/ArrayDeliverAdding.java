package qst01;

public class ArrayDeliverAdding {
	public static void addOneDArr(int[][] arr, int add) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(i + 1 + "번째의 배열");
			System.out.println("=======");
			
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] += add;
				System.out.println(arr[i][j]);
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4,5},
				{10,12,14,16},
				{11,22,33,44,55,66,77,88}
		};
		ArrayDeliverAdding.addOneDArr(arr,10);

	}

}

