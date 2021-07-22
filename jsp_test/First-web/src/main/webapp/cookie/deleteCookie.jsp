<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%
	// 쿠키의 삭제는 쿠키유지시간을 0으로 설정해준다
	
		//Cookie c = new Cookie("cname", "");
	
		//c.setMaxAge(0);	// 초단위임. (60*60*24) : 하루 24시간
	
	// 삭제 이후 응답을 줘야함
		//response.addCookie(c);
		
	response.addCookie(CookieBox.makeCookie("name", "", "/", 0));
	
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


	<h1>쿠키가 삭제되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>




</body>
</html>