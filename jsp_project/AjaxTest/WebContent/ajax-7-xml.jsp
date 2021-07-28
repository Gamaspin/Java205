<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<style>
</style>
<script>

	$(document).ready(function() {
		//alert("dd");

		$.ajax({
			url : 'data.xml',
			success : function(data) {
				$(data).find('product').each(function() {
					// 변수를 선언합니다. 
					var pname = $(this).find('name').text();
					var price = $(this).find('price').text();
					var html = '<h3>이름 : '+pname+', 가격 : '+price+'</h3>';
					// 출력합니다. 
					//$('<h1></h1>').text(name + ':' + price).appendTo('body');
					$('body').append(html);
				});
			}
		});
	});
	
</script>
<body>



</body>
</html>