<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<form id="formData" name="formData" method="post"
		action="adminProdMfpMgmtUpdate.do" enctype="multipart/form-data">
		<div>
			<div class="col-md-4">
				<div class="thumbnail caption">
					<img class="prodImg" id="prodMfpImgDiv" style="height: 600px;">
				</div>
				<button type="button" class="btn btn-default btn-block change-img">사진 변경</button>
				<input type="file" id="prodMfpImgDetail" name="prodMfpImgDetail" accept="image/*" onchange="handleImgFileSelect(this)"/>
			</div>
			<div class="col-md-8">
				<div class="">
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpBrandInfDetail">브랜드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpBrandInfDetail" name="mfpBrandInfDetail" style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpProdNmDetail">모델명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdNmDetail" name="mfpProdNmDetail" style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpProdInfDetail">핵심
							기능</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdInfDetail" name="mfpProdInfDetail" style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="outputSpdDetail">출력
							속도 (분당)</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="outputSpdDetail"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								required> <span style="float: left; padding-top: 10px;">매</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="scanSpdDetail">스캔 속도
							(분당)</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="scanSpdDetail"
								placeholder="" name="scanSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								required> <span style="float: left; padding-top: 10px;">매</span>
						</div>
					</div>
					<div class="form-group">
						<label for="networkDivsnDetail" class="col-sm-2">네트워크 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="networkDivsnDetail" name="networkDivsnDetail" style="margin-bottom: 20px;">
								<option value="유무선" selected="selected">유무선</option>
								<option value="유선">유선</option>
								<option value="무선">무선</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="paperDivsnDetail" class="col-sm-2">용지 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="paperDivsnDetail" name="paperDivsnDetail" style="margin-bottom: 20px;">
								<option value="A3" selected="selected">A3</option>
								<option value="A4">A4</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="colorYnDetail" class="col-sm-2">컬러 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="colorYnDetail" name="colorYnDetail" style="margin-bottom: 50px;">
								<option value="흑백" selected="selected">흑백</option>
								<option value="컬러">컬러</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdId" name="mfpProdId" style="display: none;">
						</div>
					</div>
				</div>
				<div style="float: right;">
					<button type="button" id="prodMfpDelete" class="btn btn-danger">삭제</button>
					<button type="button" id="prodMfpModify" class="btn btn-primary">수정</button>
					<button type="submit" id="prodMfpUpdate" class="btn btn-primary">저장</button>
					<button type="button" class="btn btn-default" onclick="location.href='adminProdMfpMgmtPage.do'">목록</button>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="resources/js/admin/productMgmt/common.js"></script>
	<script type="text/javascript" src="resources/js/admin/productMgmt/mfp/adminProdMfpMgmtDetail.js"></script>
</body>
</html>
