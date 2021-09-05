<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
	<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
	<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "${path}/review/write.do";
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
	<h2>게시글 목록</h2>
	<button type="button" id="btnWrite">글쓰기</button>
	<table border="1" width="600px">
	    <tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.ridx}</td>
			<td><a href="${path}/review/view.do?ridx=${row.ridx}">${row.rtitle}</a></td>
			<td>${row.pidx}</td>
			<td>
	            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
	            <fmt:formatDate value="${row.rdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
	        </td>
	        <td>${row.viewcnt}</td>
	    </tr>    
	    </c:forEach>
</table>
</body>
</html>

</body>
</html>