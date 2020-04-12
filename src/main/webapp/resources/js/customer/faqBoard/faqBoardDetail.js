$(function() {
	var postId = window.location.href.split('postId=')[1];
	$.ajax({
		url: '/rental/customer/faq/' + postId,
		type: 'GET',
		contentType: 'application/json',
		success: function(data) {
			console.log(data);
			if(data.result == 'unAuthorized') {
				alert('비공개 글입니다!');
				window.location.href='customerFaqBoardPage.do';
			}
			var data = data;
			
			$('#title').val(data.TITLE);
			$('#writer').val(data.USER_NM);
			$('#p_content').html(data.CONTENT);
			$('#answer').val(data.ANSWER);
		},
		error: function(data) {
			console.log(data);
		}
	});
})
	
	
	