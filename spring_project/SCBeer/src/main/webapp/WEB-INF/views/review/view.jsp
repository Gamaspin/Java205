<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
	<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
	<script>
	 $(document).ready(function(){
	        $("#btnDelete").click(function(){
	            if(confirm("삭제하시겠습니까?")){
	                document.form1.action = "${path}/review/delete.do";
	                document.form1.submit();
	            }
	        });
	        
	        $("#btnUpdete").click(function(){
	            //var rtitle = document.form1.title.value; ==> name속성으로 처리할 경우
	            //var rtext = document.form1.content.value;
	            //var pidx = document.form1.writer.value;
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
	            document.form1.action="${path}/review/update.do"
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
	<h2>게시글 보기</h2>
	<form name="form1" method="post">
    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
      	  작성일자 : <fmt:formatDate value="${dto.rdate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
    </div>
    <div>
       	 조회수 : ${dto.viewcnt}
    </div>
    <div>
       	 제목
        <input name="rtitle" id="rtitle" size="80" value="${dto.rtitle}" placeholder="제목을 입력해주세요">
    </div>
    <div>
       	 내용
        <textarea name="rtext" id="rtext" rows="4" cols="80" placeholder="내용을 입력해주세요">${dto.rtext}</textarea>
    </div>
    <div>
       	 이름
        <input name="pidx" id="pidx" value="${dto.pidx}" placeholder="이름을 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="ridx" value="${dto.ridx}">
        <button type="button" id="btnUpdete">수정</button>
        <button type="button" id="btnDelete">삭제</button>
    </div>
</form>
</body>
</html>
