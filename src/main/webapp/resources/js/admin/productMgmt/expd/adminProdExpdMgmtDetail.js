/**
 * 
 */
$(function() {
	$('#prodExpdUpdate').hide();
	$('#prodExpdImgDetail').hide();
	$('.change-img').hide();
	$('.form-control').attr('readonly', true);
	
	var prodId = new URLSearchParams(location.search).get('prodId');
	$.ajax({
		url: '/rental/product/expd/' + prodId,
		type: 'GET',
		contentType: 'application/json',
		success: function(data) {
			console.log(data);
			var data = data;
			
			$('#prodExpdImgDiv').attr('src', '/rental/resources/uploadFiles/product/expd/' + data.CHANGE_NM + data.EXT);
			$('#expdBrandInfDetail').val(data.BRAND_INF);
			$('#expdProdNmDetail').val(data.PROD_NM);
			$('#expdModelAvailDetail').val(data.MODEL_AVAIL);
			$('#expdProdInfDetail').val(data.PROD_INF);
			$('#sellYnDetail').val(data.SELL_YN);
			$('#expdProdId').val(data.PROD_ID);
		},
		error: function(data) {
			console.log(data);
		}
	});
});

$('#prodExpdModify').click(function(e) {
	$('#prodExpdModify').hide();
	$('#prodExpdUpdate').show();
	$('.change-img').show();
	$('.form-control').removeAttr('readonly');
	
	$('.change-img').click(function(e) {
		$('#prodExpdImgDetail').click();
	});
});

$('#prodExpdDelete').click(function(e) {
	var confirm = window.confirm('삭제하시겠습니까?');
	if(confirm) {
		var prodId = window.location.href.split('prodId=')[1];
		$.ajax({
			url: '/rental/product/expd/'+ prodId,
			type: 'DELETE',
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				if(data.result == 'success'){
					alert('삭제되었습니다.');
					window.location.href = 'adminProdExpdMgmtPage.do';					
				}
			},
			error: function(data) {
				console.log(data);
			}
		})
	}
});