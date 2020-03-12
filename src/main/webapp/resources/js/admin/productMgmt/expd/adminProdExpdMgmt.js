/**
 * 
 */
$(function() {
	$.ajax({
		url: '/rental/product/expd',
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
	
	var div = $('#prodExpdDiv');
	$(div).html('');
	
	var dataList = data;
	
	var innerHTML = "";
	$.each(dataList, function(i, v) {
		innerHTML += 
			"<div class='col-sm-4'>" +
				"<div class='thumbnail'>" +
					"<img class='prodExpdImg' src='/rental/resources/uploadFiles/product/expd/" + v.CHANGE_NM + v.EXT + "'>" +
					"<p class='prodExpdId'>" + v.PROD_ID + "</p>" + 
					"<p class='prodExpdP'>" + v.PROD_NM + "</p>" + 
				"</div>" +
			"</div>";
	});
	
	$(div).append(innerHTML);
}