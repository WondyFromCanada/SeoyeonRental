<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<input type="text" id="writer" readonly>
	<div id="p_content"></div>
	<textarea id="updateContent" style="display: none;"></textarea>
	<button id="updateMode">수정하기</button>
	<button id="save">저장</button>
	<button id="delete">삭제</button>
	<button id="goBack" onclick="location.href='customerQuestionBoardPage.do'">목록으로</button>
</div>

</body>

<script>
	$(function() {
		$('#save').hide();
		var postId = window.location.href.split('postId=')[1];
		$.ajax({
			url: '/rental/customer/question/' + postId,
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				if(data.result == 'unAuthorized') {
					alert('비공개 글입니다!');
					window.location.href='customerQuestionBoardPage.do';
				}
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
	
	$('#updateMode').on('click', function(e) {
		$('#updateMode').hide();
		$('#save').show();
		$('#p_content').html('');
		CKEDITOR.replace('updateContent', {filebrowserImageUploadUrl: '/rental/customer/question/imgUpload'});
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
		var postId = window.location.href.split('postId=')[1];
		$.ajax({
			url: '/rental/customer/question/' + postId,
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				
				$('#title').val(data.TITLE);
				$('#writer').val(data.USER_NM);
				CKEDITOR.instances.updateContent.setData();
				setTimeout(function() {
			        CKEDITOR.instances.updateContent.document.getBody().setHtml(data.CONTENT);
			    }, 200);
			},
			error: function(data) {
				console.log(data);
			}
		});
	});
	
	$('#save').on('click', function(e) {
		var confirm = window.confirm('수정하시겠습니까?');
		if(confirm) {
			var postId = window.location.href.split('postId=')[1];
			var sendData = {
					postId: postId,
	 				title: $('#title').val(),
	 				content: CKEDITOR.instances.updateContent.getData()
	 		};
			
			$.ajax({
				url: '/rental/customer/question/'+ postId,
				type: 'PUT',			
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
			});
		}
	});
	
	$('#delete').on('click', function(e) {
		var confirm = window.confirm('삭제하시겠습니까?');
		if(confirm) {
			var postId = window.location.href.split('postId=')[1];
			$.ajax({
				url: '/rental/customer/question/'+postId,
				type: 'DELETE',
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
	});
	
	
</script>
</html>