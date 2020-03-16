$(function() {
	
	$('#prodMfpUpdate').hide();
	$('#prodMfpImgDetail').hide();
	$('.change-img').hide();
	$('.form-control').attr('readonly', true);
	
	var prodId = new URLSearchParams(location.search).get('prodId');
	$.ajax({
		url: '/rental/product/mfp/' + prodId,
		type: 'GET',
		contentType: 'application/json',
		success: function(data) {
			console.log(data);
			var data = data;
			
			console.log(data.CHANGE_NM + data.EXT);
			
			$('#prodMfpImgDiv').attr('src', '/rental/resources/uploadFiles/product/mfp/' + data.CHANGE_NM + data.EXT);
			$('#mfpBrandInfDetail').val(data.BRAND_INF);
			$('#mfpProdNmDetail').val(data.PROD_NM);
			$('#mfpProdInfDetail').val(data.PROD_INF);
			$('#outputSpdDetail').val(parseInt(data.OUTPUT_SPD));
			$('#scanSpdDetail').val(parseInt(data.SCAN_SPD));
			$('#networkDivsnDetail').val(data.NETWORK_DIVSN);
			$('#paperDivsnDetail').val(data.PAPER_DIVSN);
			$('#colorYnDetail').val(data.COLOR_YN);
			$('#mfpProdId').val(data.PROD_ID);
			$('#whole').data(data);

		},
		error: function(data) {
			console.log(data);
		}
	});
	
});

$('#prodMfpModify').click(function(e) {
	$('#prodMfpModify').hide();
	$('#prodMfpUpdate').show();
	$('.change-img').show();
	$('.form-control').removeAttr('readonly');
	
	$('.change-img').click(function(e) {
		$('#prodMfpImgDetail').click();
	});
});

$('#prodMfpDelete').click(function(e) {
	var confirm = window.confirm('삭제하시겠습니까?');
	if(confirm) {
		var prodId = window.location.href.split('prodId=')[1];
		$.ajax({
			url: '/rental/product/mfp/'+ prodId,
			type: 'DELETE',
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				if(data.result == 'success'){
					alert('삭제되었습니다.');
					window.location.href = 'adminProdMfpMgmtPage.do';					
				}
			},
			error: function(data) {
				console.log(data);
			}
		})
	}
});