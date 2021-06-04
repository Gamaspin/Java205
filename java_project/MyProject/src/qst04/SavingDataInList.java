package qst04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class FootballPlayer implements Serializable {
	private String name;
	private int number;
	private String team;
	private int age;

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
	public String toString() {
		return "FootballPlayer [name: " + name + ", number: " + number + ", team: " + team + ", age=" + age + "]";
	}
}

public class SavingDataInList {

	public static void main(String[] args) {
		// 앞 Chapter에서 만들어본 축구선수 정보 파일로 저장하는 프로그램을 만들어 봅시다.
		// 축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.
		ArrayList<FootballPlayer> fPSave = new ArrayList<>(); 
		fPSave.add(new FootballPlayer("HM Son", 10, "Tottenham", 30));
		fPSave.add(new FootballPlayer("BK Cha", 11, "Team Legend", 44));
		fPSave.add(new FootballPlayer("MB Hong", 4, "Team Legend", 38));
		
		// 이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
		try {
			// Serializable를 구현한 FootballPlayer클래스의 값을 파일을 생성해 저장
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FootballPlayer.txt"));
			out.writeObject(fPSave);
			out.close();
			
		// 저장된 파일을 객체로 만드는 기능을 만들어봅시다.
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("FootballPlayer.txt"));
			// 해당 파일의 값을 객체로 생성
			ArrayList<FootballPlayer> fpLoad = (ArrayList<FootballPlayer>) in.readObject(); 
			// 값 출력
			for(FootballPlayer fp : fpLoad) {
				System.out.println(fp);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

