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
		<div class="pagination-sm text-center slideanim" id="content">
			<div class="row" id="contentBody">
			</div>
		</div>
		<div>
			<button type="button" class="btn btn-default" id="registerPage">등록</button>
		</div>
	</div>
	<div id="imgChk"></div>
</body>
<script src="resources/js/installBoard/installBoardCommon.js"></script>
<script src="resources/js/installBoard/installBoardMain.js"></script>
</html>
