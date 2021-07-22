<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 : 문자열 데이터를 사용자의 브라우저에 저장
	// 쿠키 생성 -> response.add(c);
	// Cookie 클래스
		//Cookie cookie = new Cookie("cname", "test");
	
	// 쿠키를 브라우저로 응답
		//response.addCookie(cookie);
		//response.addCookie(new Cookie("number", "7"));

	response.addCookie(CookieBox.makeCookie("name", "손흥민", "/"));
	response.addCookie(CookieBox.makeCookie("backNumber", "7"));
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>

<body>

	<h1>쿠키 저장</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>




</body>
</html>