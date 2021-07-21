<%@page import="java.sql.SQLException"%>
<%@page import="ncs.MemberManager.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//1.드라이버 로드
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	try{
	conn = ConnectionProvider.getConnection();
	
	request.setAttribute("result", dao.getMemberList(conn));
	
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
			JdbcUtil.close(conn);
	}
%>
<jsp:forward page="list_view.jsp" /> <!-- view 역활만 -->
