<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 FAQ 등록 페이지</title>
</head>
<body>
<jsp:include page="../../common/adminTopNav.jsp" />

<label for="title">제목 : </label><input type="text" name="title" id="title">
<select id="publicYn">
	<option value="N">비공개</option>
	<option value="Y">공개</option>
</select>
<textarea class="form-control" id="p_content"></textarea>

<button onclick="register()">등록</button>
<button id="goBack" onclick="location.href='adminCustomerFaqBoardMgmtPage.do'">목록으로</button>

</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/admin/customer/faqBoard/adminCustomerFaqBoardMgmtEnroll.js"></script>
</html>
