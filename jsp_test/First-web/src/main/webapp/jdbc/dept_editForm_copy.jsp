<!--


	//사용자가 전달하는 부서번호 받기
	String deptno = request.getParameter("deptno");
	//out.println(deptno);
	
	
	// 전달받은 부서 번호로 부서정보를 가져온다	
		// 1. 드라이버 로드 : 서블릿클래스 Loader에서 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
		// 2. DB 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	conn = ConnectionProvider.getConnection();

	Dept dept = null;
	
	String sqlSelect = "select * from dept where deptno=?";
	pstmt = conn.prepareStatement(sqlSelect);
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	rs = pstmt.executeQuery();
	
	
	//while을 안쓰는 이유 = pk라서 반복할 필요가 없음
	if(rs.next()){
		dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
	}
	
		//out.println(dept);


	// 부서정보를 form_view.jsp로 전달(공유)
	request.setAttribute("dept", dept);


%>

<jsp:forward page="form_view.jsp" /> 

 -->