<%@page import="ncs.MemberManager.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//request.setAttribute("name", "손흥민");
	session.setAttribute("name", "이강인");
	application.setAttribute("name", "황의조");
	
	
	Member member = new Member();
	member.setId("cool");
	member.setName("COOL");
	member.setPw("1234");
	session.setAttribute("member", member);
	
%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	표현식 : <span><%= request.getAttribute("name") %></span>	<br><br>
	<br>
	표현언어1 : <span>${requestScope.name}</span><br><br>
	
	내장객체의 표현식이 생략되었을 때 규칙 <br>
	1. pageScope의 속성을 찾는다 -> 2. requestScope -> 3. sessionScope -> 4. applicationScope 순으로 찾는다. <br><br>
	
	표현언어2 : <span>${name}</span> <br>
	표현언어3 : <span>${sessionScope.name}</span> <br>
	표현언어4 : <span>${applicationScope.name}</span> <br>
	
	
	<hr>
	값이 없을 경우 표현식으로는 null값이 뜨고, 표현언어로는 아무것도 출력하지 않는다.	<br>
	param.code : <%= request.getParameter("code") %>	<br>
	param.code : ${param.code}	<br>
	
<%-- 	<hr>
	pageContext : <br>
	<%= pageContext.getRequest().getServletContext().getContextPath()%> 	<br>
	${pageContext.request.requestURL}	<br>
	${pageContext.request.requestURI}	<br>
	${pageContext.request.contextPath}	<br>
	<%= request.getContextPath() %>	<br>

	
	<hr>
	<br>
	${true} / ${false } / ${100 } / ${'손흥민'} / ${null } / ${' \' \\ '}
	<br> 
--%>

	<hr>
	<hr>	toString처럼 표현됨	<br>
	${member}	<br>	
	
	<%= session.getAttribute("member") %>	<br>
	<br>
	Id값만 가져오고 싶을 때	<br>
	${member.id}	 <- \$ {member.id} 는 member.getId() 메소드를 호출하는 것임	<br>
	<%= ((Member) session.getAttribute("member")).getId() %>	<br>


</body>
</html>