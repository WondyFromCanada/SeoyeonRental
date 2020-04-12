<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="../common/topNav.jsp" />
<br><br><br><br>
<br><br><br><br>
<label for="userId">아이디: </label><input type="text" name="userId" id="userId">
<label for="userPwd">비밀번호: </label><input type="password" name="userPwd" id="userPwd">

<button id="login" onclick="login();">로그인</button>
</body>
<script>

$(function() {
	$('#userId').focus();
	$(window).on('keyup', function(e) {
		if(e.keyCode == '13') {
			if($("#login")) {
				$('#login').click();
			}
		}
	})
});
	function login() {
		
		var prevPage = document.referrer;
		
		if($('#userId').val() != null && $('#userPwd').val() != null) {
			var sendData = {
					userId: $('#userId').val(),
					userPwd: $('#userPwd').val()
			};
			
			$.ajax({
				url: '/rental/member/login',
				type: 'POST',
				data: JSON.stringify(sendData),
				contentType: 'application/json',
				success: function(data) {
					if(data.result == 'success') {
						if(prevPage.indexOf('mainPage.do') == -1 ) {
							window.location.href = prevPage;
						} else {
							window.location.href = 'mainPage.do';
						}
					} else {
						alert('아이디 혹은 비밀번호 오류입니다');
					}
					console.log(data);
				},
				error: function(data) {
					console.log(data);
				}
			});
		
		}
	}
</script>
</html>
