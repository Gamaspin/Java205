<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>

<%@page import="ncs.MemberManager.Member"%>
<%@page import="ncs.MemberManager.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	Timestamp date = new Timestamp(new Date().getTime());
	
	int result = 0;
	
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	try{
		conn = ConnectionProvider.getConnection();
		
		result = dao.joinMember(conn,new Member(0,id,pw,name,date));
	}catch(Exception e){
		e.printStackTrace();
	}
	
	if(result>0){
%>
		<script>
			alert('등록되었습니다.');
			location.href='member_list.jsp';
		</script>
<% 
	} else { 
%>
		<script>
			alert('오류 발생으로 등록 x \n 입력페이지로 다시 이동합니다.');
			window.history.go(-1);
		</script>
<%
		}		
%>
