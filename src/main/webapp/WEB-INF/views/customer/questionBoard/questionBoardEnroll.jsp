<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<br><br><br>
<br><br><br>
<label for="title">제목 : </label><input type="text" name="title" id="title">
<select id="publicYn">
	<option value="N">비공개</option>
	<option value="Y">공개</option>
</select>
<textarea class="form-control" id="p_content"></textarea>

<button onclick="register()">등록</button>
<button id="goBack" onclick="location.href='customerQuestionBoardPage.do'">목록으로</button>

</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript">

	//ckEditor를 매핑할 textarea를 지정, img 파일을 저장할 servlet 경로 매핑
 	CKEDITOR.replace('p_content', {filebrowserImageUploadUrl: '/rental/customer/question/imgUpload'});
	
	//ckEditor Config => img저장 탭에서 link 와 acvanced 탭을 없앰
 	CKEDITOR.on('dialogDefinition', function( ev ){
        var dialogName = ev.data.name;
        var dialogDefinition = ev.data.definition;
     
        switch (dialogName) {
            case 'image': //Image Properties dialog
                //dialogDefinition.removeContents('info');
                dialogDefinition.removeContents('Link');
                dialogDefinition.removeContents('advanced');
                break;
        }
    });
 	
 	
 	function register() {
 		var sendData = {
 				title: $('#title').val(),
 				//ckeditor 안의 내용을 html 태그로 변환해서 가져옴
 				content: CKEDITOR.instances.p_content.getData(),
 				publicYn: $('#publicYn').val()
 		};
 		
 		console.log('sendData: ', sendData);
 		
 		$.ajax({
 			url: '/rental/customer/question',
 			type: 'POST',
 			data: JSON.stringify(sendData),
 			contentType: 'application/json',
 			success: function(data) {
 				console.log(data);
 				
 				//session이 비어있다면 was에서 loginRequired 상태를 내려줌
 				if(data.result == 'loginRequired') {
					alert('로그인이 필요한 서비스입니다');
 					window.location.href = 'loginPage.do';
 				}
 				
 				//성공시 메인으로 이동
 				if(data.result == 'success') {
					alert('등록했습니다!');
 					window.location.href = 'customerQuestionBoardPage.do';
 				}
 			},
 			error: function(data) {
 				console.log(data);
 			}
 		})
 	}
</script>
<script type='text/javascript'>
/*    window.parent.CKEDITOR.tools.callFunction(" + 
      callback + 
      ",'" + fileUrl + "','이미지를 업로드 하였습니다.'" + ) */
</script>
</html>
