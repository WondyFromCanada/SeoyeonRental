<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<form method="post" action="adminProdExpdMgmtEnroll.do"
		enctype="multipart/form-data">
		<div>
			<div class="col-md-4">
				<div class="thumbnail caption">
					<img class="prodImg"
						src="/rental/resources/images/common/noImg.png"
						style="width: 600px; height: 400px;">
				</div>
				<input type="file" id="prodExpdImg" name="prodExpdImg"
					accept="image/*" onchange="handleImgFileSelect(this)" required />
			</div>
			<div class="col-md-8">
				<div class="">
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdBrandInf">브랜드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdBrandInf"
								placeholder="" name="expdBrandInf" style="margin-bottom: 20px;"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdProdNm">모델명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdProdNm"
								placeholder="" name="expdProdNm" style="margin-bottom: 20px;"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdModelAvail">사용
							가능 기종</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdModelAvail"
								placeholder="" name="expdModelAvail"
								style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdProdInf">사용
							매수</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdProdInf"
								placeholder="" name="expdProdInf" style="margin-bottom: 20px;"
								required>
						</div>
					</div>
					<div class="form-group">
						<label for="sellYn" class="col-sm-2">판매 가능 여부</label>
						<div class="col-sm-10">
							<select class="form-control" id="sellYn" name="sellYn"
								style="margin-bottom: 20px;">
								<option value="가능" selected="selected">가능</option>
								<option value="불가">불가</option>
							</select>
						</div>
					</div>
				</div>
				<div style="float: right;">
					<button class="btn btn-default" onclick="location.href='adminProdExpdMgmtPage.do'">취소</button>
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="resources/js/admin/productMgmt/common.js"></script>
</body>
</html>
