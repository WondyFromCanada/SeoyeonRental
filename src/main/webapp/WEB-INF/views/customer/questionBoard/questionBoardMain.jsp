<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>고객센터 | 1:1문의</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<div class="btn-group btn-group-justified">
	<a class="btn btn-primary" href="customerQuestionBoardPage.do">1:1 문의</a>
	<a class="btn btn-primary" href="customerQuestionBoardPage.do">자주묻는질문</a>
	<a class="btn btn-primary" href="customerMaterialPage.do">자료실</a>
</div>

<div id="content">
	<table id="boardTable" class="display table"></table>
</div>
<div id="main"></div>
<button class="btn btn-warning" onclick="window.location.href='customerQuestionEnrollPage.do'">게시글등록페이지</button>
</body>
<script src="resources/js/customer/questionBoard/questionBoardMain.js"></script>
</html>