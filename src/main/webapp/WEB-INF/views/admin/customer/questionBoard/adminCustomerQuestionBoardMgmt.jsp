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
			<table id="boardTable" class="display table"></table>
			<div class="row">
				<button class="btn btn-warning" onclick="location.href='adminCustomerFaqBoardEnrollPage.do'">등록페이지</button>
			</div>
		</div>
</body>
<script 
	type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
<script src="resources/js/admin/customer/questionBoard/adminCustomerQuestionBoardMgmt.js"></script>
</html>
