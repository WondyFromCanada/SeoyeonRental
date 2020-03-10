<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>SeoyoeonRental</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- data tables CSS -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!--data table JS  -->
<script 
	type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
<style>
	body {
		margin-top: 101px;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img src="https://via.placeholder.com/50" alt="Chania"> <a
					class="navbar-brand" href="mainPage.do">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty sessionScope.loginUser}">
					<li><a href="joinPage.do"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="loginPage.do"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
				<c:if test="${!empty sessionScope.loginUser}">
					<c:if test="${sessionScope.loginUser.DIVSN eq 'ADMIN' }">
						<li><a href="adminEstimateMgmtPage.do" target="_blank"><span
								class="glyphicon glyphicon-user"></span> Admin</a></li>
					</c:if>
					<li><a href="myPage.do"><span
							class="glyphicon glyphicon-log-in"></span> MyPage</a></li>
					<li><a href="logout.do"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</c:if>
			</ul>
		</div>
		<div class="container">
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="mfpRentalPage.do">복합기렌탈</a></li>
					<li><a href="mfpSellPage.do">복합기판매</a></li>
					<li><a href="expdSellPage.do">소모품판매</a></li>
					<li><a href="installBoardPage.do">설치소식</a></li>
					<li><a href="customerQuestionBoardPage.do">고객센터</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
</html>
