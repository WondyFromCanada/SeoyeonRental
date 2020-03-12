/**
 * 
 */
$(function() {
	$.ajax({
		url: '/rental/product/mfp',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			divData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
})

function divData(data) {
	
	var div = $('#prodMfpDiv');
	$(div).html('');
	
	var dataList = data;
	
	var innerHTML = "";
	$.each(dataList, function(i, v) {
		innerHTML += 
			"<div class='col-sm-4'>" +
				"<div class='thumbnail'>" +
					"<img class='prodMfpImg' src='/rental/resources/uploadFiles/product/mfp/" + v.CHANGE_NM + v.EXT + "'>" +
					"<p class='prodMfpId'>" + v.PROD_ID + "</p>" + 
					"<p class='prodMfpP'>" + v.PROD_NM + "</p>" + 
				"</div>" +
			"</div>";
	});
	
	$(div).append(innerHTML);
}