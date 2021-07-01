package oneBitClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login2 {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Scanner inputIdPw = new Scanner(System.in);
				
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");

			// 2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!!!");


			String sqlSelect2 = "SELECT * FROM ClassMember WHERE mid = ? and mpw = ?";
			pstmt = conn.prepareStatement(sqlSelect2);
			
			
			
			System.out.println("ID를 입력해주세요. (대소문자에 유의)");
			pstmt.setString(1, inputIdPw.nextLine());
			System.out.println("PW를 입력해주세요. (대소문자에 유의)");
			pstmt.setString(2, inputIdPw.nextLine());
			
//			pstmt.setString(1, "jongwon");
//			pstmt.setString(2, "123456");

			rs = pstmt.executeQuery();
//			int result = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("로그인 완료! 환영합니다.");	
				
					int mno = rs.getInt("mno");
					System.out.print(mno + "\t");
					String mname = rs.getString("mname");
					System.out.print(mname + "\t");
					String mloc = rs.getString("mloc");
					System.out.println(mloc + "\t");
				
			} else {
				System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
			}
			
			
			
				



		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾지못함!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!!!");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

