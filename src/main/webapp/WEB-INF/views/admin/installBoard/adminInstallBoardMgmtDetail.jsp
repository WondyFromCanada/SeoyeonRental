<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 설치소식 상세페이지</title>
</head>
<body>
	<jsp:include page="../common/adminTopNav.jsp" />
	<div class="container-fluid" id="main">
		<div class="row form-inline" >
			<label class="control-label" for="title">제목 : </label>
			<input class="form-control" type="text" id="title">
			<label class="control-label" for="writer">작성자: </label>
			<input class="form-control" type="text" id="writer" readonly>
		</div>
		<div id="p_content"></div>
		<textarea id="updateContent" style="display: none;"></textarea>
		
		<button class="btn btn-default" id="updateMode">수정하기</button>
		<button class="btn btn-default" id="save">저장</button>
		<button class="btn btn-default" id="delete">삭제</button>
		<button class="btn btn-default" id="goBack" onclick="location.href='adminInstallBoardMgmtPage.do'">목록으로</button>
	</div>
</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/admin/installBoard/adminInstallBoardMgmtDetail.js"></script>
</html>
