$(function() {
	$('.register-page').on('click', function(e) {
		var returnPath = window.location.href;
		location.href='ckEnrollPage.do?type=install&returnPath=' + returnPath + '&divsn=customer';
	});
	
	initData('Y', 'installBoardDetailPage', '/install');
});

function installBoardDetailPage(postId) {
	window.location.href = 'installBoardDetailPage.do?postId=' + postId;
}