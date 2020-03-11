<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<form  id="formData" name="formData" method="post" action="adminProdMfpMgmtEnroll.do" enctype="multipart/form-data">
		<div>
			<div class="col-md-4">
				<div class="thumbnail caption">
					<img class="prodImg" src="/rental/resources/images/common/noImg.png"
						style="width: 100%; height: 600px;">
				</div>
				<input type="file" id="prodMfpImg" name="prodMfpImg" accept="image/*" onchange="handleImgFileSelect(this)" required/>
			</div>
			<div class="col-md-8">
				<div class="">
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpBrandInf">브랜드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpBrandInf"
								placeholder="" name="mfpBrandInf" style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpProdNm">모델명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdNm"
								placeholder="" name="mfpProdNm" style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpProdInf">핵심 기능</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdInf"
								placeholder="" name="mfpProdInf" style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="outputSpd">출력
							속도 (분당)</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="outputSpd"
								placeholder="" name="outputSpd"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;" required>
							<span style="float: left; padding-top: 10px;">매</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="scanSpd">스캔 속도
							(분당)</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="scanSpd"
								placeholder="" name="scanSpd"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;" required>
							<span style="float: left; padding-top: 10px;">매</span>
						</div>
					</div>
					<div class="form-group">
						<label for="networkDivsn" class="col-sm-2">네트워크 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="networkDivsn"
								name="networkDivsn" style="margin-bottom: 20px;">
								<option value="유무선" selected="selected">유무선</option>
								<option value="유선">유선</option>
								<option value="무선">무선</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="paperDivsn" class="col-sm-2">용지 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="paperDivsn" name="paperDivsn"
								style="margin-bottom: 20px;">
								<option value="A3" selected="selected">A3</option>
								<option value="A4">A4</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="colorYn" class="col-sm-2">컬러 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="colorYn" name="colorYn" style="margin-bottom: 50px;">
								<option value="흑백" selected="selected">흑백</option>
								<option value="컬러">컬러</option>
							</select>
						</div>
					</div>
				</div>
				<div style="float: right;">
					<button type="button" class="btn btn-default" onclick="location.href='adminProdMfpMgmtPage.do'">취소</button>
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="resources/js/admin/productMgmt/common.js"></script>
</body>
</html>
