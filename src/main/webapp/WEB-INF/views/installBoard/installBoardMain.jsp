<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet"
	href="resources/css/admin/productMgmt/mfp/prodMfp.css">
	<title>설치 소식 메인</title>
<style>
	.thumbnail img {
		height: 300px !important;
	}
</style>
</head>
<body>
	<jsp:include page="../common/topNav.jsp" />
	<div class="container-fluid" style="margin-top: 20px;">
		<div class="pagination-sm text-center slideanim main-content">
			<div class="row content-body">
			</div>
		</div>
	</div>
	<div class="img-chk"></div>
</body>
<script src="resources/js/util/pagination.js"></script>
<script src="resources/js/installBoard/installBoardMain.js"></script>
</html>
