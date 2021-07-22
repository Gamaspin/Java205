<%@page import="ncs.MemberManager.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- member_list.jsp에서 request에 저장한 데이터 불러오기 -->
<% List<Member> list = (List<Member>)request.getAttribute("result"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 보기</title>
<style>
	button{
		margin: 5px;
		background-color: darkgrey;
	}
</style>
<script>
</script>
</head>
<body>
	<h1>회원 리스트</h1>
	<hr>
	
	<!-- <button onclick="location.href='member_regForm.jsp'">회원 등록</button> -->
	<a href="<%= request.getContextPath() %>/new/index.jsp"><button>홈으로 돌아가기</button></a>
	<table border=1>
		<tr>
			<th>회원 아이디</th>
			<th>회원 비밀번호</th>
			<th>회원 이름</th>
			<th>회원 가입일</th>
		</tr>		
		<%
			if(list != null){
				for(int i=0; i<list.size(); i++){
					%>
		<tr>
			<td><%=list.get(i).getId() %></td>
			<td><%=list.get(i).getPw() %></td>
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getRegDate() %></td>			
		</tr>						
					<%
				}
			}
		%>
	</table>	
</body>
</html>
