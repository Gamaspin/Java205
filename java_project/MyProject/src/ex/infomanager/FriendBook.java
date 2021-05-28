package ex.infomanager;
import java.util.Scanner;

public class FriendBook {
	public static void main(String[] args) {

		FriendInfoHandler handler = new FriendInfoHandler(100);

		Scanner sc = new Scanner(System.in);

		//아래 초기 메뉴 안내부터 계속적으로 반복시키고 싶음
		while(true) {

			System.out.println("친구 정보 관리 프로그램");
			System.out.println("*** 메뉴 선택 *****");
			System.out.println("1. 고교 친구 정보 입력");
			System.out.println("2. 대학 친구 정보 입력");
			System.out.println("3. 전체 정보 출력");
			System.out.println("4. 기본 정보 출력");
			System.out.println("5. 프로그램 종료");
			System.out.println("*****************");
			System.out.println("");
			System.out.println("메뉴를 선택해주세요.");

			
			int choice = Integer.parseInt(sc.nextLine()) ;

			switch(choice) {
			case 1 : case 2 : 
				handler.addFriend(choice);
				break;		//각 케이스마다 break; 가 없으면 그 바로 밑의 case도 같이 실행됨

			case 3:
				handler.showAllData();
				break;

			case 4:
				handler.showAllBasicData();
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
		
		
	}
}
