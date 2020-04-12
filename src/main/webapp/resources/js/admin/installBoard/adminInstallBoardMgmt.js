$(function() {
	$('.register-page').on('click', function(e) {
		var returnPath = window.location.href;
		location.href='ckEnrollPage.do?type=install&returnPath=' + returnPath + '&divsn=admin';
	});
	
	initData('Y', 'adminInstallBoardMgmtDetailPage', '/install');
});

function adminInstallBoardMgmtDetailPage(postId) {
	window.location.href = 'adminInstallBoardMgmtDetailPage.do?postId=' + postId;
}