$(function() {
	initData('N', 'adminProdExpdMgmtDetailPage', '/product/expd');
});

function adminProdExpdMgmtDetailPage(prodId) {
		window.location.href = 'adminProdExpdMgmtDetailPage.do?prodId=' + prodId;
}