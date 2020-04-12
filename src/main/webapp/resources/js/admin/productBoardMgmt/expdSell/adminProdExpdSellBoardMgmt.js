$(function() {
	$('.register-page').on('click', function(e) {
		location.href='adminProdExpdSellBoardMgmtEnrollPage.do';
	});
	
	initData('N', 'adminProductBoardMgmtDetail', '/productBoard/sell/expd', '/product/expd');
});

function adminInstallBoardMgmtDetailPage(postId) {
	window.location.href = 'adminInstallBoardMgmtDetailPage.do?postId=' + postId;
}