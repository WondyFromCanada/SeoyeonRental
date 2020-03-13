<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>설치 소식 메인</title>
</head>
<body>
	<jsp:include page="../common/topNav.jsp" />
	<div id="content">
		<table id="boardTable" class="table table-striped table-bordered"></table>
	</div>
	<div id="main"></div>
</body>
<script src="resources/js/installBoard/installBoardMain.js"></script>
</html>
