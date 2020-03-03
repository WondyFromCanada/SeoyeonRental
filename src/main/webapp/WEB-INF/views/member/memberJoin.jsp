<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
<jsp:include page="../common/topNav.jsp" />
<h1 align="center">회원가입</h1>
      <table align="center">
         <tr>
            <td> * 아이디 </td>
            <td><input type="text" name="userId" id="userId"></td>
            <td><button onclick="return duplicationCheck()">중복확인</button></td>
         </tr>
         <tr>
            <td> * 비밀번호 </td>
            <td><input type="password" name="userPwd" id="userPwd"></td>
         </tr>
         <tr>
            <td> * 비밀번호확인 </td>
            <td><input type="password" name="userPwd2"></td>
         </tr>
         <tr>
            <td> * 이름 </td>
            <td><input type="text" name="userName" id="userNm"></td>
         </tr>
         <tr>
            <td> 이메일 </td>
            <td><input type="email" name="email" id="email"></td>
         </tr>
         <tr>
            <td> 주민등록번호 </td>
            <td>
               <input type="text" name="birthDay" id="birth">-
               <input type="text" name="gender" size="1" maxlength="1">******
            </td>
         </tr>
         <tr>
            <td> 전화번호 </td>
            <td><input type="tel" name="phone" id="phone"></td>
         </tr>
         <tr>
            <td> 주소 </td>
            <td><input type="text" name="address" id="addr"></td>
         </tr>
      </table>
      <br>
      <div align="center">
         <button type="reset">작성취소</button>
         <button onclick="memberJoin();">가입하기</button>
      </div>
<script type="text/javascript">
	
	function memberJoin() {
		
		var sendData = {
				userId: $('#userId').val(),
				userPwd: $('#userPwd').val(),
				userNm: $('#userNm').val(),
				email: $('#email').val(),
				birth: $('#birth').val(),
				addr: $('#addr').val(),
				phone: $('#phone').val()
		};
		
		$.ajax({
			url: '/rental/member',
			type: 'POST',
			data: JSON.stringify(sendData),
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
			},
			error: function(data) {
				console.log(data);
			}
		});
		
	}
	

	/* function duplicationCheck(){
		var userId = $("#userId").val();
		
		$.ajax({
			url:"duplicationCheck.me",
			type:"post",
			data:{userId:userId},
			success:function(data){
				console.log(data.member.userId);
			},
			error:function(status){
				alert(status);
			}
		});
		return false;
	} */
</script>
</body>
</html>
