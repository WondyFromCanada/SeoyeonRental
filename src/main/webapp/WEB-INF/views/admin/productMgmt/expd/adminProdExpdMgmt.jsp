<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="../../common/adminTopNav.jsp" />
<jsp:include page="../../common/adminProdSubNav.jsp" />
<button type="button" class="btn btn-default" onclick="window.location.href='adminProdExpdMgmtEnrollPage.do'">제품등록</button>
</body>
</html>