package qst03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


//class FootballPlayer /*implements Comparable<FootballPlayer>*/ {

public class CollectionFrameWork {

	public static void main(String[] args) {
		List<FootballPlayer> list = new ArrayList<FootballPlayer>();

		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String inputName = "";
		int inputNumber = 0;
		String inputTeam = "";
		int inputAge = 0;
		int stop = 1;
		
		for(int i=0; i == stop; i++) {
			
		
		System.out.println("선수정보를 입력합니다.");
		System.out.print("선수 이름을 입력해주세요.");
		inputName = sc1.nextLine();
		System.out.print("선수 등번호를 입력해주세요.");
		inputNumber = sc2.nextInt();
		System.out.println("선수 소속팀을 입력해주세요.");
		inputTeam = sc1.nextLine();
		System.out.println("선수 나이를 입력해주세요.");
		inputAge = sc2.nextInt();
		
		//요소 저장 : add(T t)
		list.add(new FootballPlayer(inputName+"\t",inputNumber, inputTeam+"\t", inputAge));
		
		System.out.println("계속 입력하시려면 1, 그만 입력하시려면 0을 써주세요.");
		stop= sc2.nextInt();
		}
		list.add(new FootballPlayer("이강인", 20, "Valencia CF", 21));
		list.add(new FootballPlayer("황희찬", 11, "RB Leipzig", 26));
		list.add(new FootballPlayer("황의조", 18, "Bordeaux", 30));
		list.add(new FootballPlayer("손흥민", 7, "Tottenham", 30));
		
		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
		}
		System.out.println("=============================");
		System.out.println("=======  이름\t등번호\t소속팀\t\t나이");

		//for-each 구문
		for(FootballPlayer str : list) {
			System.out.println(str);
		}
		System.out.println("=============================");

		//Iterator
		Iterator<FootballPlayer> itr = list.iterator();

		while(itr.hasNext()) {
			FootballPlayer currentStr = itr.next();
//			System.out.println(currentStr);
//			itr.next().showData();
		}
		
		
		
		
		
	}
}





