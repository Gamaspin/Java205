
<%@page import="ncs.MemberManager.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object loginObj = session.getAttribute("loginInfo");
%>

<nav>
	<ul>
		<% if(loginObj == null) { %>
		<li><a href="<%= request.getContextPath() %>/ncs.jdbc/member_regForm.jsp">회원가입</a></li>
		<li><a href="<%= request.getContextPath() %>/new/loginForm.jsp">로그인</a></li>
		<%}  else {%>
		<li><a href="<%= request.getContextPath() %>/new/logout.jsp">로그아웃</a></li>
		<li><a href="<%= request.getContextPath()%>/ncs.jdbc/member_list.jsp">회원리스트 보기</a></li>
		<%} %>
		<li><a href="<%= request.getContextPath()%>/new/mypage.jsp">My Page</a></li>
		
	</ul>
</nav>