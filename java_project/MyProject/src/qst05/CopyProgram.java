package qst05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyProgram extends Thread {

	File originFile;
	File copyFile;
	public CopyProgram(File originFile, File copyFile) {
		this.originFile = originFile;
		this.copyFile = copyFile;
	}

	@Override
	public void run() {
		try {
			// 1. 파일의 바이너리 데이터를 읽어올 스트림 생성 : FileInputStream
			//FileInputStream in = new FileInputStream("origin.pdf");
			InputStream in = new FileInputStream(originFile);

			// 2. 파일을 쓰기위한 스트림 생성 : FileOutputStream
			FileOutputStream out = new FileOutputStream(copyFile);

			// 필터 스크림 생성 -> 기본 스트림이 필요
			BufferedInputStream fin = new BufferedInputStream(in);
			BufferedOutputStream fout = new BufferedOutputStream(out);

			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어올 바이트 데이터 배열
			int bData = -1; //-1이 초기화임

			while(true) {
				bData = fin.read();

				// 탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(bData == -1) {
					break;
				}

				// 출력 : 파일에 데이터를 쓴다
				fout.write(bData);
				copyByte++;
			} 

			// 스트림 닫기
			fin.close();
			fout.close();

			System.out.println("복사 완료! 복사된 바이트 사이즈 : " + copyByte + "byte");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

