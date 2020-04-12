<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>고객센터 faq 상세보기</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<jsp:include page="../../common/customer/customerSubNav.jsp" />
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
	<button id="goBack" onclick="location.href='customerFaqBoardPage.do'">목록으로</button>
</div>

</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/customer/faqBoard/faqBoardDetail.js"></script>
</html>