<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 faq 메인페이지</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<jsp:include page="../../common/adminCustomerSubNav.jsp" />
	<div class="container-fluid" id="content">
		<table class="display table board-table"></table>
		<div class="row">
			<button class="btn btn-warning register-page">등록페이지</button>
		</div>
	</div>
</body>
<script src="resources/js/util/dataTable.js"></script>
<script src="resources/js/admin/customer/faqBoard/adminCustomerFaqBoardMgmt.js"></script>
</html>
