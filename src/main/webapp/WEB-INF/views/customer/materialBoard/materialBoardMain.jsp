<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>고객센터 자료실 메인페이지</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<jsp:include page="../../common/customer/customerSubNav.jsp" />
<div id="content">
	<table class="display table board-table"></table>
</div>
<div id="main"></div>
</body>
<script src="resources/js/util/dataTable.js"></script>
<script src="resources/js/customer/materialBoard/materialBoardMain.js"></script>
</html>