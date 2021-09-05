<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
	<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
	<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			//var rtitle = document.form1.rtitle.value; ==> name속성으로 처리할 경우
			//var rtext = document.form1.rtext.value;
			//var pidx = document.form1.pidx.value;
			var rtitle = $("#rtitle").val();
			var rtext = $("#rtext").val();
			var pidx = $("#pidx").val();
			if(rtitle == ""){
				alert("제목을 입력하세요");
				document.form1.rtitle.focus();
				return;
			}
			if(rtext == ""){
				alert("내용을 입력하세요");
				document.form1.rtext.focus();
				return;
			}
			if(pidx == ""){
				alert("이름을 입력하세요");
				document.form1.pidx.focus();
				return;
			}
			// 폼에 입력한 데이터를 서버로 전송
			document.form1.submit();
		});
	});

</script>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp" %>
	
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	<hr>
	<ul>		
	</ul>
	<%-- <%@ include file="../review/menu.jsp" %> --%>
	<h2>게시글 작성</h2>
	<form name="form1" method="post" action="${path}/review/insert.do">
	<div>
		 제목
        <input name="rtitle" id="rtitle" size="80" placeholder="제목을 입력해주세요">
	</div>
	<div>
		내용
        <textarea name="rtext" id="rtext" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
	</div>
	<div>
		이름
        <input name="pidx" id="pidx" placeholder="이름을 입력해주세요">
	</div>
	<div style="width:650px; text-align: center;">
		<button type="button" id="btnSave">확인</button>
		<button type="reset">취소</button>
	</div>
</form>
</body>
</html>
