package ex06_Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class INetAddressTest {
	public static void main(String[] args) {
		
		String urlStr = "www.naver.com";
		
			
		try {
			InetAddress ip = InetAddress.getByName(urlStr);
			
			System.out.println("호스트 이름 : " + ip.getHostName());
			System.out.println("아이피 주소 : " + ip.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
