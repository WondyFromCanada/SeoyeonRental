<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 1:1 문의 상세페이지</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<jsp:include page="../../common/adminCustomerSubNav.jsp" />
</body>
<div class="container-fluid" id="main">
	<div class="row form-inline" >
		<label class="control-label" for="title">제목 : </label>
		<input class="form-control" type="text" id="title">
		<label class="control-label" for="title">작성자 : </label>
		<input class="form-control" type="text" id="writer" readonly>
	</div>
	<div id="p_content"></div>
	<textarea id="updateContent" style="display: none;"></textarea>
	
	<div class="answer_area">
		<label for="answer" class="control-label">답변 : </label>
		<textarea id="answer" class="form-control" readonly></textarea>
	</div>
	<button id="updateMode">수정하기</button>
	<button id="save">저장</button>
	<button id="delete">삭제</button>
	<button id="goBack" onclick="location.href='adminCustomerQuestionBoardMgmtPage.do'">목록으로</button>
</div>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/admin/customer/questionBoard/adminCustomerQuestionBoardMgmtDetail.js"></script>
</html>
