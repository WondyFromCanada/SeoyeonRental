$(function() {
	var postId = new URLSearchParams(location.search).get('postId');
	initData(postId);
	
	$('.update').hide();
	
	$('.update-mode').on('click', function(e) {
		updateMode();
	});
	
	$('.update').on('click', function(e) {
		updateProdBoard(postId);
	});
	
	$('.delete').on('click', function(e) {
		deleteProdBoard(postId);
	});
	
	$('.go-back').on('click', function(e) {
		location.href = 'adminProdMfpRentalBoardMgmtPage.do';
	});
});

function initData(postId) {
	$.ajax({
		url: '/rental/productBoard/rental/mfp/'+ postId,
		contentType: 'application/json',
		success: function(data) {
			console.log(data);
			
			$('.open-modal').hide();
			$('#p_content').hide();
			
			$('#prodMfpImgDiv').attr('src', '/rental/resources/uploadFiles/product/mfp/' + data.CHANGE_NM + data.EXT);
			$('#mfpBrandInfDetail').val(data.BRAND_INF);
			$('#mfpProdNmDetail').val(data.PROD_NM);
			
			var prodInf = 
				data.PROD_INF + ', ' + data.OUTPUT_SPD +
				data.SCAN_SPD + ', ' + data.NETWORK_DIVSN + 
				data.PAPER_DIVSN;
			
			
			$('#mfpTitleDetail').val(data.TITLE);
			$('#mfpProdInfDetail').val(prodInf);
			$('#mfpProdId').val(data.PROD_ID);
			$('#mfpContent').html(data.CONTENT);
			$('#agreement').val(data.AGREEMENT);
			$('#registerPrice').val(data.REGISTER_PRICE);
			$('#price').val(data.PRICE);
			
			
			
		},
		error: function(data) {
			console.log(data);
		}
	})
}

function updateMode() {
	$('.update-mode').hide();
	$('.update').show();
	$('#mfpContent').hide();
	
	document.getElementById('mfpTitleDetail').readOnly = false;
	document.getElementById('agreement').readOnly = false;
	document.getElementById('registerPrice').readOnly = false;
	document.getElementById('price').readOnly = false;
	
	CKEDITOR.replace('p_content', {
		filebrowserImageUploadUrl: '/rental/productBoard/rental/mfp/imgUpload',
		height: 450
		}
	);
	
	//ckEditor Config => img저장 탭에서 link 와 acvanced 탭을 없앰
	CKEDITOR.on('dialogDefinition', function( ev ) {
		var dialogName = ev.data.name;
		var dialogDefinition = ev.data.definition;
		
		switch (dialogName) {
		case 'image': 
			dialogDefinition.removeContents('Link');
			dialogDefinition.removeContents('advanced');
			break;
		}
	});
	
	var content = $('#mfpContent').html();
	
	CKEDITOR.instances.p_content.setData();
	setTimeout(function() {
        CKEDITOR.instances.p_content.document.getBody().setHtml(content);
    }, 200);
}

function updateProdBoard(postId) {
	var sendData = {
		postId: postId,
		title: $('#mfpTitleDetail').val(),
		content: CKEDITOR.instances.p_content.getData(),
		agreement: $('#agreement').val(),
		registerPrice: $('#registerPrice').val(),
		price: $('#price').val()
	};
	
	if(
			sendData.title.length > 0 &&
			sendData.content.length > 0 &&
			sendData.agreement.length > 0 &&
			sendData.registerPrice.length > 0 &&
			sendData.price.length > 0
			) {
		var confirm = window.confirm('수정하시겠습니까?');
		if(confirm) {
			$.ajax({
				url: '/rental/productBoard/rental/mfp/'+ postId,
				data: JSON.stringify(sendData),
				type: 'PUT',
				contentType: 'application/json',
				success: function(data) {
					console.log(data);
					if(data.result == 'success') {
						window.location.href = 'adminProdMfpRentalBoardMgmtPage.do';
					} else if(data.result.length == 0) {
						window.location.href = 'memberLogin.do';
					} else {
						alert('오류발생!');
					}
				},
				error: function(data) {
					console.log(data);
				}
			});
		}
	}
	
}

function deleteProdBoard(postId) {
	
	var srcList = [];
	$.each($('#mfpContent').find('img'), function(i, v) {
		srcList.push( $(v).attr('src').substr(7, $(v).attr('src').length));
	});
	
	$.ajax({
		url: '/rental/productBoard/rental/mfp/' + postId,
		type: 'DELETE',
		data: JSON.stringify({srcList: srcList}),
		contentType: 'application/json',
		success: function(data) {
			if(data.result == 'success') {
				window.location.href = 'adminProdMfpRentalBoardMgmtPage.do';
			} else if(data.result.length == 0) {
				window.location.href = 'memberLogin.do';
			} else {
				alert('오류발생!');
			}
		},
		error: function(data) {
			console.log(data);
		}
	});
}



