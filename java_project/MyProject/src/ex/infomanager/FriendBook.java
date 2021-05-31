package ex.infomanager;
import java.util.Scanner;

public class FriendBook {
	public static void main(String[] args) {

		//Friend friend = new Friend("", "", "");
		//Friend가 추상클래스로 선언되어서 에러
		
		FriendInfoHandler handler = new FriendInfoHandler(100);
		Scanner sc = new Scanner(System.in);

		//아래 초기 메뉴 안내부터 계속적으로 반복시키고 싶음
		while(true) {
			System.out.println("친구 정보 관리 프로그램");
			System.out.println("*** 메뉴 선택 *****");
			System.out.println(Menu.HIGH_FRIEND + ". 고교 친구 정보 입력");
			System.out.println(Menu.UNIV_FRIEND + ". 대학 친구 정보 입력");
			System.out.println(Menu.SHOW_ALL + ". 전체 정보 출력");
			System.out.println(Menu.SHOW_BASIC + ". 기본 정보 출력");
			System.out.println(Menu.EXIT + ". 프로그램 종료");
			System.out.println("*****************");
			System.out.println("");
			System.out.println("메뉴를 선택해주세요.");
			int choice = Integer.parseInt(sc.nextLine()) ;

			switch(choice) {
			//case 1 : case 2 :	//숫자 대신 인터페이스 상수 이륾으로 대체
			case Menu.HIGH_FRIEND : case Menu.UNIV_FRIEND :
				handler.addFriend(choice);
				break;		//각 케이스마다 break; 가 없으면 그 바로 밑의 case도 같이 실행됨
			case Menu.SHOW_ALL :
				handler.showAllData();
				break;
			case Menu.SHOW_BASIC :
				handler.showAllBasicData();
				break;
			case Menu.EXIT :
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}

interface Menu {
	public static final int HIGH_FRIEND = 1;	//public static final 생략가능
						int UNIV_FRIEND = 2;
						int SHOW_ALL = 3;
						int SHOW_BASIC = 4;
						int EXIT = 5;
}