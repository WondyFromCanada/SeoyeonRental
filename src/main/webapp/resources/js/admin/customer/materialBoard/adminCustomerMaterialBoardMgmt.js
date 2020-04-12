$(function() {
	initTable();
	$.ajax({
		url: '/rental/customer/material',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			var gridColInf = getGridColInf('SY_CUSTOMER_MATERIAL_BOARD');
			initTable(gridColInf, data.length);
			tableData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
	
	$('.register-page').on('click', function(e) {
		location.href='adminCustomerMaterialBoardMgmtEnrollPage.do';
	});
})
	
function setEventListener(table) {
	$('.board-table tbody').on('click', 'tr', function() {
		var postId = table.row(this).data()[0];
		window.location.href = 'adminCustomerMaterialBoardMgmtDetailPage.do?postId=' + postId;
	});
}	