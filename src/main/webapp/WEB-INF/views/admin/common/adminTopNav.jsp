<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- bootpag paging plugin -->
<script type="text/javascript"
	src="resources/js/plugin/jquery.bootpag.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="adminMemberMgmtPage.do">회원관리</a></li>
				<li><a href="adminEstimateMgmtPage.do">견적문의</a></li>
				<li><a href="adminProdMfpMgmtPage.do">제품관리</a></li>
				<li><a href="adminProdMfpRentalBoardMgmtPage.do">제품게시판</a></li>
				<li><a href="adminInstallBoardMgmtPage.do">설치소식</a></li>
				<li><a href="adminCustomerQuestionBoardMgmtPage.do">고객센터</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>
