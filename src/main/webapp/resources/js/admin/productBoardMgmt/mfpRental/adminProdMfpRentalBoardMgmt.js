$(function() {
	$('.register-page').on('click', function(e) {
		location.href='adminProdMfpRentalBoardMgmtEnrollPage.do';
	});
	
	initData('N', 'adminProdMfpRentalBoardMgmtDetailPage', '/productBoard/rental/mfp', '/product/mfp');
});

function adminProdMfpRentalBoardMgmtDetailPage(postId) {
	window.location.href = 'adminProdMfpRentalBoardMgmtDetailPage.do?postId=' + postId;
}