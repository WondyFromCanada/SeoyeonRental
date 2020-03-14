$(function() {
	$('#registerPage').on('click', function(e) {
		var returnPath = window.location.href;
		location.href='ckEnrollPage.do?type=install&returnPath=' + returnPath + '&divsn=customer';
	});
});

function installBoardDetail(postId) {
	window.location.href = 'installBoardDetailPage.do?postId=' + postId;
}