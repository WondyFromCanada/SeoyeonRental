/**
 * 
 */
$(function() {
	$('#prodExpdUpdate').hide();
	$('#prodExpdImgDetail').hide();
	
	var prodId = window.location.href.split('prodId=')[1];
	$.ajax({
		url: '/rental/product/expd/' + prodId,
		type: 'GET',
		contentType: 'application/json',
		success: function(data) {
			console.log(data);
			var data = data;
			
			$('#prodExpdImgDiv').attr('src', '/rental/resources/uploadFiles/product/expd/"' + data.CHANGE_NM + data.EXT + "'");
			$('#expdBrandInfDetail').val(data.BRAND_INF);
			$('#expdProdNmDetail').val(data.PROD_NM);
			$('#expdModelAvailDetail').val(data.MODEL_AVAIL);
			$('#expdProdInfDetail').val(parseInt(data.PROD_INF));
			$('#sellYnDetail').val(parseInt(data.SELL_YN));
		},
		error: function(data) {
			console.log(data);
		}
	});
});