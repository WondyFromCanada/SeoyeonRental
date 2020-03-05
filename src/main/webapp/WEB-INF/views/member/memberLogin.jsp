<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
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

<button onclick="login();">로그인</button>
</body>
<script>
	function login() {
		
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
						window.location.href = 'mainPage.do';
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
