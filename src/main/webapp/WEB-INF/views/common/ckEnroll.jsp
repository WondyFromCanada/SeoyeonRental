<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>ck 공통 등록페이지</title>
</head>
<body>
<c:if test="${divsn eq 'admin'}">
	<jsp:include page="../admin/common/adminTopNav.jsp" />
</c:if>
<c:if test="${divsn eq 'customer'}">
	<jsp:include page="topNav.jsp" />
</c:if>

<div class="container-fluid">
	<div class="form-inline">
		<label class="control-label" for="title">제목 : </label>
		<input class="form-control" type="text" name="title" id="title">
		
		<select class="form-control" id="publicYn">
			<option value="N">비공개</option>
			<option value="Y">공개</option>
		</select>
		
		<label class="control-label" for="boardType">구분 : </label>
		<input class="form-control" type="text" id="boardType" readonly>

	</div>	
		<textarea class="form-control" id="p_content"></textarea>
		
		<button class="btn btn-default" id="register">등록</button>
		<button class="btn btn-default" id="goBack">목록으로</button>

</div>
</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/ckCommon/enroll.js"></script>
</html>
