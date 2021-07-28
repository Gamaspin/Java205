<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h3>메시지를 삭제하려면 비밀번호를 입력하세요.</h3>
	<form action="messageDelete.jsp" method="post">
		비밀번호  <input type="password" name="password"> 
		
		<!-- 삭제하고자 하는 mid의 파라미터값을 가져와야 비교가 가능. 
			 그리고 이걸 hidden으로 설정 -->
		<input type="hidden" name="mid" value="${param.mid}"> <br>
		<input type="submit" value="삭제">
	</form>

</body>
</html>