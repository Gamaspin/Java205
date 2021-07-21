package dept.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao {

	public List<Dept> getDeptList(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;

		List<Dept> deptList = new ArrayList()<Dept>();
		
		try {
			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// sql
			String sqlSelect = "select * from dept";


			// 4. ResultSet
			rs = stmt.executeQuery(sqlSelect);


			// 5. List<Dept>	<- 결과
			

			while(rs.next()) {
				// List에 객체 추가
				deptList.add(
						new Dept(
								rs.getInt("deptno"), 
								rs.getString("dname"), 
								rs.getString("loc")
								)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(stmt);
		}

		return list;
		

	}






}
