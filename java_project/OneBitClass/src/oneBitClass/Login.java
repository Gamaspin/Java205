//package oneBitClass;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class Login {
//	
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	
//	public Login() {
//	}
//	public int login(String mid, String mpw) { 
//		String SQL = "SELECT mpw FROM ClassMember WHERE mid = ?"; 
//		try {
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1,  mid);
//			rs = pstmt.executeQuery(); 
//			if (rs.next()) {
//				if (rs.getString(1).contentEquals(mpw)) {
//					return 1; // 로그인 성공
//				}
//				else {
//					return 0; // 비밀번호 불일치
//				}
//			}
//			return -1; // 아이디가 없음
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -2; // DB 오류 
//	}
//	
//	
//	
//	
//
//}
//
