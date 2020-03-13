$(document).ready(function() {
	
	$('#prodMfpUpdate').hide();
	$('#prodMfpImgDetail').hide();
	
	var prodId = window.location.href.split('prodId=')[1];
	$.ajax({
		url: '/rental/product/mfp/' + prodId,
		type: 'GET',
		dataType : "text",
		contentType: 'application/json',
		success: function(data) {
			console.log(data);
			var data = data;
			
			console.log(data.CHANGE_NM + data.EXT);
			
			/*$('#prodMfpImgDiv').attr('src', '/rental/resources/uploadFiles/product/mfp/"' + data.CHANGE_NM + data.EXT + "'");
			$('#mfpBrandInfDetail').val(data.BRAND_INF);
			$('#mfpProdNmDetail').val(data.PROD_NM);
			$('#mfpProdInfDetail').val(data.PROD_INF);
			$('#outputSpdDetail').val(parseInt(data.OUTPUT_SPD));
			$('#scanSpdDetail').val(parseInt(data.SCAN_SPD));
			$('#networkDivsnDetail').html(data.NETWORK_DIVSN);
			$('#paperDivsnDetail').val(data.PAPER_DIVSN);
			$('#colorYnDetail').val(data.COLOR_YN);*/
		},
		error: function(data) {
			console.log(data);
		}
	});
	
});
