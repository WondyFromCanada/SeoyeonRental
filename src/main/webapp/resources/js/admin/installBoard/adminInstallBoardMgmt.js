$(function() {
	
	$('#registerPage').on('click', function(e) {
		var returnPath = window.location.href;
		location.href='ckEnrollPage.do?type=install&returnPath=' + returnPath + '&divsn=admin';
	});
});

function installBoardDetail(postId) {
	window.location.href = 'adminInstallBoardMgmtDetailPage.do?postId=' + postId;
}