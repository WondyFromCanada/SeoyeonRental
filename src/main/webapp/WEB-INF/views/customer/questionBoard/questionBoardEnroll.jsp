<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<br><br><br>
<br><br><br>
<label for="title">제목 : </label><input type="text" name="title" id="title">
<textarea class="form-control" id="p_content"></textarea>

<button onclick="register()">등록</button>
<button onclick="showData()">취소</button>

</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
 	CKEDITOR.replace('p_content', {filebrowserImageUploadUrl: '/rental/customer/question/imgUpload'});
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
 				content: CKEDITOR.instances.p_content.getData()
 		};
 		
 		console.log('sendData: ', sendData);
 		
 		$.ajax({
 			url: '/rental/customer/question',
 			type: 'POST',
 			data: JSON.stringify(sendData),
 			contentType: 'application/json',
 			success: function(data) {
 				console.log(data);
 				
 				if(data.result == 'success') 
 					window.location.href = 'customerQuestionBoardPage.do';
 			},
 			error: function(data) {
 				console.log(data);
 			}
 		})
 	}
 	
 	$(function() {
 		
 		var tmpMap = {
 				key1: 'val1'
 		};
 		
 		$.ajax({
 			url: '/rental/customer/question/test',
 			type: 'POST',
 			data: JSON.stringify(tmpMap),
 			contentType: 'application/json',
 			success: function(data) {
 				console.log(data);
 			},
 			error: function(data) {
 				console.log(data);
 			}
 		});
 	});
</script>
<script type='text/javascript'>
   window.parent.CKEDITOR.tools.callFunction(" + 
      callback + 
      ",'" + fileUrl + "','이미지를 업로드 하였습니다.'" + )
</script>
</html>
