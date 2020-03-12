<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="resources/css/admin/productMgmt/expd/prodExpd.css">
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<jsp:include page="../../common/adminProdSubNav.jsp" />
	<div class="container-fluid" style="margin-top: 20px;">
		<div class="row text-center slideanim" id="prodExpdDiv"></div>
		<div>
			<button type="button" class="btn btn-default"
				onclick="window.location.href='adminProdExpdMgmtEnrollPage.do'">제품등록</button>
		</div>
	</div>
	<script src="resources/js/admin/productMgmt/expd/adminProdExpdMgmt.js"></script>
</body>
</html>