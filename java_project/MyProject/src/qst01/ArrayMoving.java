package qst01;

public class ArrayMoving {
	public static void change(int[][] arr) {
		int[] temp;
		for(int i=arr.length-1; i>0; i--) {
			temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
		}
	}

	public static void show(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		
		System.out.println("변경 전");
		ArrayMoving.show(arr);
		ArrayMoving.change(arr);
		System.out.println("변경 후");
		ArrayMoving.show(arr);
	}	

}
