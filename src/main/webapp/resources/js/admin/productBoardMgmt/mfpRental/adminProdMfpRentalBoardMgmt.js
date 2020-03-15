$(function() {
	$('.register-page').on('click', function(e) {
		location.href='adminProdMfpRentalBoardMgmtEnrollPage.do';
	});
	
	//initData('Y', 'adminInstallBoardMgmtDetailPage', '/install');
});

function adminInstallBoardMgmtDetailPage(postId) {
	window.location.href = 'adminInstallBoardMgmtDetailPage.do?postId=' + postId;
}