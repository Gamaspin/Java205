package ex.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderStream {
	public static void main(String[] args) {
		
		
		// 문자 단위로 읽어올 스트림 생성
		// Reader -> FileReader
		try {
			Reader in = new FileReader("hyper.txt");
			
			char[] cbuf = new char[10];
			int readLength = 0;
			
			readLength = in.read(cbuf, 0, cbuf.length);
							//여기에 담아줘, 어디부터, 어디까지
			
//			for(int i=0; i<readLength; i++) {	//파일안의 텍스트들을 하나씩 하나씩 가져오기
//				System.out.println(cbuf[i]);
//			}
			System.out.println(new String(cbuf));	// toString()	
			System.out.println(cbuf);
			
			in.close();
			System.out.println("읽기 완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
