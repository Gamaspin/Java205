package qst05;

import java.io.File;
import java.util.Scanner;

public class CopyProgramMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("먼저, 복사하고자 하는 파일의 경로를 입력해주세요.");
		System.out.print("D:\\");
		String origDir = sc.nextLine();
		File fromDir = new File("D:\\" + origDir);
		if(!fromDir.exists()) {
			System.out.println(fromDir + " 폴더가 존재하지 않습니다.");
			return;
		} 

		System.out.println("그리고 복사하고자 하는 파일의 이름을 입력해주세요.");
		System.out.print("D:\\" + origDir + "\\");
		String origFile = sc.nextLine();
		File fromFile = new File("D:\\" + origDir + "\\" + origFile);
		if(!fromFile.exists()) {
			System.out.println(fromFile + " 파일이 존재하지 않습니다.");
			return;
		} 

		System.out.println("다음으로, 복사한 파일을 저장하기 위한 경로를 입력해주세요.");
		System.out.print("D:\\");
		String copyDir = sc.nextLine();
		File toDir = new File("D:\\" + copyDir);
		if(!toDir.exists()) {
			System.out.println(toDir + " 폴더를 생성하였습니다.");
			toDir.mkdir();
		} 

		System.out.println("복사한 파일을 저장합니다. 파일명을 입력해주세요.");
		String copyFile = sc.nextLine();
		File toFile = new File("D:\\" + copyDir + "\\" + copyFile);
		System.out.println("파일 복사 성공");


		CopyProgram copyProgram = new CopyProgram(fromFile, toFile);
		copyProgram.start();

	}
}
