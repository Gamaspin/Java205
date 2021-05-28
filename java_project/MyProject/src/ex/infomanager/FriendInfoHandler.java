package ex.infomanager;
import java.util.Scanner;

public class FriendInfoHandler {

	
	// 저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가지는 클래스
	
	Friend[] friendsInfo;
	int numOfFriend;	//배열의 입력 index역할, 정보의 개수 파악용
	
	//생성자
	public FriendInfoHandler(int num) {	//배열의 사이즈 -> 배열 인스턴스 생성
		this.friendsInfo = new Friend[num];
		this.numOfFriend = 0;
	}
	
	//데이터의 입력 처리
	//사용자로부터 친구의 정보를 입력 받아서 -> 배열에 저장
	public void addFriend(int choice) {		//choice -> 1(고교) or 2(대학)
		System.out.println("=== 친구 목록 관리 매니저 프로그램입니다. ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		String phoneNumber = sc.nextLine();
		System.out.println("주소를 입력해주세요.");
		String address = sc.nextLine();
		
		//기본정보를 받았으니 이제 분기
		if(choice == 1) {	//고교 친구(highFriend)
			System.out.println("고등학교 친구의 직업을 입력해주세요.");
			String work = sc.nextLine();
			
			//인스턴스 생성
			HighFriend hf = new HighFriend(name, phoneNumber, address, work);
			
//			//배열에 요소 추가
//			friendsInfo[numOfFriend] = hf;
//			numOfFriend++;
			//밑의 공통코드를 사용하기 때문에 윗 2줄은 대체 가능
			addFriendInfo(hf);
			
			//인스턴스 생성은 아래 한줄로 대체 가능함
			//addFriendInfo(new HighFriend(name, phoneNumber, address, work);
			
			
		} else if (choice == 2) {	//대학 친구(UnivFriend)
			System.out.println("대학교 친구의 전공을 입력해주세요.");
			String major = sc.nextLine();
			
			//인스턴스 생성
//			UnivFriend uf = new UnivFriend(name, phoneNumber, address, major);
//			
//			addFriendInfo(uf);
			
			addFriendInfo(new UnivFriend(name, phoneNumber, address, major));
			
//			//배열에 요소 추가
//			friendsInfo[numOfFriend] = uf;
//			numOfFriend++;
		} else {
			System.out.println("잘못 입력하셨습니다. 1(고교친구) 혹은 2(대학친구) 중에 숫자를 다시 입력해주세요.");
		}
		
	}
	
	//Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장해줌 (공통코드 생성)
	public void addFriendInfo(Friend f) {
		friendsInfo[numOfFriend++] = f;
	}
	
	//모든 데이터를 출력하는 메소드
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		if(numOfFriend>0) {	//친구 입력값이 1개라도 있어야지 정상 출력되게끔
			for(int i=0; i<numOfFriend; i++) {
				friendsInfo[i].showData();
				System.out.println("=========================");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("=========================");
	}
	
	//기본 데이터를 출력하는 메소드
	public void showAllBasicData() {
		System.out.println("친구의 모든 기본 정보를 출력합니다.");
		if(numOfFriend>0) {	//친구 입력값이 1개라도 있어야지 정상 출력되게끔
			for(int i=0; i<numOfFriend; i++) {
				friendsInfo[i].showBasicInfo();
				System.out.println("=========================");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("=========================");
	}
	
}
