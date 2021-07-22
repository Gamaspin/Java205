<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 session 객체를 소멸시킨다. (메모리를 날린다.)
	session.invalidate();
%>

<script>
	alert("로그아웃 되었습니다.");
	location.href = '<%= request.getContextPath()%>/new/index.jsp';
</script>