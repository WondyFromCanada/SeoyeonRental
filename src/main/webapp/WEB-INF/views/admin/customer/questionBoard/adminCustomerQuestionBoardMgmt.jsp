<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 1:1문의 메인페이지</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<jsp:include page="../../common/adminCustomerSubNav.jsp" />
	<div class="container-fluid" id="content">
		<table class="display table board-table"></table>
		<div class="row">
		</div>
	</div>
</body>
<script src="resources/js/util/dataTable.js"></script>
<script src="resources/js/admin/customer/questionBoard/adminCustomerQuestionBoardMgmt.js"></script>
</html>
