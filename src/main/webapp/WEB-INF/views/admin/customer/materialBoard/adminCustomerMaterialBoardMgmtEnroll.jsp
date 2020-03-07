<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 자료실 등록</title>
</head>
<body>
<jsp:include page="../../common/adminTopNav.jsp" />
<br><br><br>
<br><br><br>

<!-- 파일 전송은 post 방식으로 해야 컨트롤러에서 파일을 받을 수 있음 -->
<form id="formData" method="post" name="formData" action="/rental/customer/material" enctype="multipart/form-data">
	제목 : <input type="text" id="title" name="title">
	내용 : <input type="text" id="content" name="content">
	파일 : <input type="file" id="file" name="file">
	<button type="submit">등록</button>
</form>
<textarea class="form-control" id="p_content"></textarea>
<button id="goBack" onclick="location.href='adminCustomerMaterialBoardMgmtPage.do'">목록으로</button>

</body>
</html>
