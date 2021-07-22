package ncs.MemberManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.util.JdbcUtil;

public class MemberDao {
	//싱글톤 패턴
	//1.인스턴스 생성을 막는다.
	private MemberDao() {}
	//2.클래스 내부에서 인스턴스 생성
	private static MemberDao dao = new MemberDao();
	//3.외부에서 참조값을 반환 받을 수 있는 메서드
	public static MemberDao getInstance() {
		return dao ==null? new MemberDao() : dao;
	}
	
	//member 정보 조회
	public List<Member> getMemberList(Connection conn){
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = null;

		try {
			stmt = conn.createStatement();
			String sql = "select * from member";
			
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Member>();
			
			while(rs.next()) {
				list.add(
						new Member(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getTimestamp(5)
							));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}		
		return list;
	}	
	//member 등록
	public int joinMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(0,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getRegDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	
	
	public Member selectByIdPw(Connection conn, String id, String pw) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where id=? and pw=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			// id는 유니크라서 0아니면 1 이므로 while문 안돌려도 됨
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setRegDate(rs.getTimestamp("regDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return member;
	}
}
