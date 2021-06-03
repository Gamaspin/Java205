package qst05;
import java.util.Random;
//import java.util.Scanner;
import javax.swing.*;

public class HighLowGame {
	
	public static boolean reTry = false;
	
	public static void main(String[] args) {

//		랜덤 숫자 부여
		Random random = new Random();
		int comPick = random.nextInt(100)+1;
//정답		System.out.println(comPick);

//		정답 맞출 때 까지 계속 숫자 입력 시도 -> 텍스트 창 팝업으로 대체
//		Scanner sc = new Scanner(System.in);
		
		
//		제한시간 부여
		CountDownThread ct = new CountDownThread();
		ct.start();
		System.out.println("=================================");
		System.out.println("1에서 100까지의 숫자 중 한 개를 입력해주세요.");
		while(!reTry) {
			String inputUserAnswer = JOptionPane.showInputDialog("정답을 입력해주세요 : ");
			int userPick = Integer.parseInt(inputUserAnswer);
			//int userPick = Integer.parseInt(sc.nextLine());
			if(comPick > userPick) {
				System.out.println("정답보다 작습니다.");
			} else if(comPick < userPick) {
				System.out.println("정답보다 큽니다.");
			} else {
				System.out.println("정답!! 숫자가 일치합니다.");
				reTry = true;
			}
		}
		try {
			ct.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class CountDownThread extends Thread {
	@Override
	public void run() {
		for(int i=20; i>0; i--) {
			if(HighLowGame.reTry) {
				return;
			}
			System.out.println(i);
			try {
				sleep(1000);	//1초 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(0);
	}
}
