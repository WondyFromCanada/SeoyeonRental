$(function() {
	initTable();
	$.ajax({
		url: '/rental/customer/question',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			var gridColInf = getGridColInf('SY_CUSTOMER_QUESTION_BOARD');
			initTable(gridColInf, data.length);
			tableData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
})
	
function setEventListener(table) {
	
	$('.board-table tbody').on('click', 'tr', function() {
		var postId = table.row(this).data()[0];
		window.location.href = 'adminCustomerQuestionBoardMgmtDetailPage.do?postId=' + postId;
	});
}	