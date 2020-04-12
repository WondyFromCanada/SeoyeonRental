<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<title>Home</title>
<link rel="stylesheet"
	href="resources/css/admin/productMgmt/mfp/prodMfp.css">
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<jsp:include page="../../common/adminProdSubNav.jsp" />
	<div class="container-fluid" style="margin-top: 20px;">
		<div class="pagination-sm text-center slideanim main-content">
			<div class="row content-body">
			</div>
		</div>
	</div>
	<div>
		<button type="button" class="btn btn-default"
			onclick="window.location.href='adminProdMfpMgmtEnrollPage.do'">제품등록</button>
	</div>
</body>
<script src="resources/js/util/pagination.js"></script>
<script src="resources/js/admin/productMgmt/mfp/adminProdMfpMgmt.js"></script>
</html>