$(function() {
	//카테고리
	var boardType = new URLSearchParams(location.search).get('type');
	
	//이전 페이지
	var prevPage = new URLSearchParams(location.search).get('returnPath');
	
	$('#boardType').val(boardType);
	if( boardType != 'question' ) {
		$('#publicYn').hide();
	}
	
	//imgUplaod, ajax url
	var url = "";
	
	if(boardType == 'question') {
		url = '/rental/customer/question'
	} else if(boardType == 'faq') {
		url = '/rental/customer/faq';
	} else if(boardType == 'install') {
		url = '/rental/install';
	}
	
	//ckEditor를 매핑할 textarea를 지정, img 파일을 저장할 servlet 경로 매핑
	CKEDITOR.replace('p_content', {filebrowserImageUploadUrl: url + '/imgUpload'});
	
	//ckEditor Config => img저장 탭에서 link 와 acvanced 탭을 없앰
	CKEDITOR.on('dialogDefinition', function( ev ) {
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
	
	$('#register').on('click', function(e) {
		register(boardType, prevPage, url);
	});
	
	$('#goback').on('click', function(e) {
		location.href = prevPage;
	});
	
	function register(boardType, prevPage, url) {
		var sendData = {
				title: $('#title').val(),
				content: CKEDITOR.instances.p_content.getData()
		};
		
		if(boardType == 'question') {
			sendData.publicYn = $('#publicYn').val();
		} else if(boardType == 'faq') {
		} else if(boardType == 'install') {
		} else if(boardType == '')
		
		console.log('sendData: ', sendData);
		
		$.ajax({
			url: url,
			type: 'POST',
			data: JSON.stringify(sendData),
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				
				//session이 비어있다면 was에서 loginRequired 상태를 내려줌
				if(data.length == 0) {
					alert('로그인이 필요한 서비스입니다');
					window.location.href = 'loginPage.do';
				}
				
				//성공시 이전페이지로 이동
				if(data.result == 'success') {
					alert('등록했습니다!');
					window.location.href = prevPage;
				}
			},
			error: function(data) {
				console.log(data);
			}
		})
	}
})
 	
 	