package ex06_Network;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//MessageServer 클래스 : 다형성 이용
public class Util {
	public static void close(ServerSocket ss) {

		if(ss != null) {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Socket s) {

		if(s != null) {
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(FilterInputStream fin) {
		//DataInputStream의 상위. 필터스트림이 데이터스트림을 상속해줌
		try {
			if(fin != null) {
				fin.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(FilterOutputStream fout) {
		try {
			if(fout != null) {
				fout.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
