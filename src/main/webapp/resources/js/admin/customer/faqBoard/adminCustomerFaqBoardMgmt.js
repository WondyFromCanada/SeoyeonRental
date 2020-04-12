$(function() {
	initTable();
	$.ajax({
		url: '/rental/customer/faq',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			var gridColInf = getGridColInf('SY_CUSTOMER_FAQ_BOARD');
			initTable(gridColInf, data.length);
			tableData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
	
	$('.register-page').on('click', function(e) {
		var returnPath = window.location.href;
		location.href='ckEnrollPage.do?type=faq&returnPath=' + returnPath + '&divsn=admin';
	});
})
	
function setEventListener(table) {
	$('.board-table tbody').on('click', 'tr', function() {
		var postId = table.row(this).data()[0];
		window.location.href = 'adminCustomerFaqBoardMgmtDetailPage.do?postId=' + postId;
	});
}