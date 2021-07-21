<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// dept_list.jsp 요청을 받고 처리를 해줌 <-의 프로세스에서 요청받음과 처리 부분을 나누게 될 것임



	// 1. 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. DB 연결
	Connection conn = null;
	//Statement stmt = null;
	//ResultSet rs = null;
	DeptDao dao = new DeptDao();
	
	
		// jdbcUrl
	conn = ConnectionProvider.getConnection();
		
		
	//String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimeZone=UTC";
	//String user = "bit";
	//String pw = "bit";
	
	//conn = DriverManager.getConnection(jdbcUrl, user, pw);

	
	
	


	// 6. 결과데이터를 request의 속성에 저장	-> 데이터의 공유(전달)
	request.setAttribute("result", dao.getDeptList(conn));
	
%>


<jsp:forward page="list_view.jsp" /> 
<!-- list_view.jsp : view의 역할만 함 -->


