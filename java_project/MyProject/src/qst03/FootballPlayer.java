package qst03;
import java.util.*;

public class FootballPlayer implements Comparable<FootballPlayer> {
	private String name;
	private int number;
	private String team;
	private int age;

	// TreeSet<E>을 이용해서
	// 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
	// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
	@Override
	public int compareTo(FootballPlayer o) {			// * -1 은 내림차순을 뜻함
		int result = this.team.compareTo(o.getTeam()) * -1;	// 음수 / 양수 / 0
		if(result == 0) {	//위 조건인 팀 이름이 같을 경우의 if를 의미함
			result = this.name.compareTo(o.getName());
			if(result == 0) {
				result = this.number-o.getNumber();
			}
		}
		return result;
	}

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return this.name;	}
	public void setName(String name) {
		this.name = name;	}
	public int getNumber() {
		return this.number;	}
	public void setNumber(int number) {
		this.number = number;	}
	public String getTeam() {
		return this.team;	}
	public void setTeam(String team) {
		this.team = team;	}
	public int getAge() {
		return this.age;	}
	public void setAge(int age) {
		this.age = age;	}

	@Override
	public boolean equals(Object obj) {
		//팀과 이름 그리고 나이가 같으면 같은 선수라 판단
		boolean chk = false;
		if(obj != null && obj instanceof FootballPlayer) {
			FootballPlayer player = (FootballPlayer)obj;
			if(this.team.equals(player.team) && this.name.equals(player.name)
					&& this.age == player.age) {
				//System.out.println("소속팀과 선수명, 그리고 나이가 같으므로 동일 선수입니다.");
				chk = true;
			}
		}
		return chk;
	}

	@Override
	public int hashCode() {
		return age%10;
	}

	@Override
	public String toString() {
		//	return "이름 : " + name + ", 등번호 : " + number + ", 소속팀 : " + team + ", 나이 : " + age;
		return "선수 정보 : " + name +" " + number +" " + team+" " + age;
	}


	//	public void showData() {
	//		System.out.printf("%s, %d \n", this.name, this.age);
	//	}

	public static void main(String[] args) {
		//1번	List<FootballPlayer> players = new ArrayList<>();

		//2번	Set<FootballPlayer> players = new HashSet<FootballPlayer>();

		//3번	
		TreeSet<FootballPlayer> players = new TreeSet<>();

		Scanner sc1 = new Scanner(System.in);

		String inputName = "";
		int inputNumber = 0;
		String inputTeam = "";
		int inputAge = 0;
		boolean stop = false;

		while (!stop) {
			System.out.println("선수정보를 입력합니다.");
			System.out.print("선수 이름을 입력해주세요.");
			inputName = sc1.nextLine();
			
			System.out.print("선수 등번호를 입력해주세요.");
			inputNumber = Integer.parseInt(sc1.nextLine());
			
			System.out.println("선수 소속팀을 입력해주세요.");
			inputTeam = sc1.nextLine();
			
			System.out.println("선수 나이를 입력해주세요.");
			inputAge = Integer.parseInt(sc1.nextLine());
//			inputAge = sc1.nextInt();
//			sc1.nextLine();
			
			players.add(new FootballPlayer(inputName,inputNumber,inputTeam,inputAge));
			System.out.println("계속 입력하시려면 Y, 그만 입력하시려면 N을 써주세요.");
			String yn = sc1.nextLine();
			
			if (yn.equals("Y") || yn.equals("y")) { // Y 또는 y 입력시 반복
				System.out.println("---------------------");
				continue; // 보조제어문(반복 계속)
			}
			if (yn.equals("N") || yn.equals("n")) { // N 또는 n 입력시 종료
				break; // 보조제어문(반복 종료)
			}
		}

		//데이터 저장
//1번	list.add(new FootballPlayer("이강인", 20, "Valencia CF", 21));
//직접입력으로 바꾸었기 때문에 아래 데이터들은 필요 없음		
//		players.add(new FootballPlayer("Son1", 7, "Tot", 30));
//		players.add(new FootballPlayer("Park1", 13, "ManU", 37));
//		players.add(new FootballPlayer("Son1", 9, "Tot", 30));
//		players.add(new FootballPlayer("Lee1", 20, "Tot", 17));
//		players.add(new FootballPlayer("Park2", 20, "ManU", 31));
//		players.add(new FootballPlayer("Park2", 21, "ManU", 30));

		System.out.println("요소의 개수 : " + players.size());

		//정렬
		Iterator<FootballPlayer> itr = players.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 
		//	Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
		HashMap<Integer, FootballPlayer> players2 = new HashMap<>();

		players2.put(7, new FootballPlayer("Son", 7, "Tot", 30));
		players2.put(10, new FootballPlayer("Kane", 10, "Tot", 28));
		players2.put(20, new FootballPlayer("Alli", 20, "Tot", 24));
		//Key값을 Set객체로 변환해줌


		System.out.println("======================");
		Set<Integer> set = players2.keySet();

		Iterator<Integer> itr2 = set.iterator();
		while(itr2.hasNext()) {
			System.out.println(players2.get(itr2.next()));	//키값을 통해서 저장되어 있던 내용을 players.get을 통해 불러옴

		}

	}

}



