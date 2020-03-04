<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>1:1문의 상세보기</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<br><br><br><br>
<br><br><br><br>
<div id="main">
	<input type="text" id="title">
	<input type="text" id="writer">
	<div id="p_content"></div>
</div>

</body>

<script>
	$(function() {
		
		var postId = window.location.href.split('postId=')[1];
		$.ajax({
			url: '/rental/customer/question/' + postId,
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				var data = data;
				
				$('#title').val(data.TITLE);
				$('#writer').val(data.USER_NM);
				$('#p_content').html(data.CONTENT);
			},
			error: function(data) {
				console.log(data);
			}
		});
	})
	
	
	
</script>
</html>