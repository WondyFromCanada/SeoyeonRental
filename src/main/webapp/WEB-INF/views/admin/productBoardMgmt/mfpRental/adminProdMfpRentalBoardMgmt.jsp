<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 제품 게시판 복합기 렌탈 메인페이지</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<jsp:include page="../../common/adminProdBoardSubNav.jsp" />
	<div class="container-fluid" style="margin-top: 20px;">
		<div class="pagination-sm text-center slideanim main-content">
			<div class="row content-body">
			</div>
		</div>
		<button class="btn btn-warning register-page">등록</button>
	</div>	
</body>
<script src="resources/js/util/pagination.js"></script>
<script src="resources/js/admin/productBoardMgmt/mfpRental/adminProdMfpRentalBoardMgmt.js"></script>
</html>
