$(function() {
	initData('N', 'adminProdMfpMgmtDetailPage', '/product/mfp');
});

function adminProdMfpMgmtDetailPage(prodId) {
	window.location.href = 'adminProdMfpMgmtDetailPage.do?prodId=' + prodId;
}