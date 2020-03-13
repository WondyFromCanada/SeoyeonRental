<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<jsp:include page="../../common/adminTopNav.jsp" />
	<form method="post" action="adminProdExpdMgmtUpdate.do"
		enctype="multipart/form-data">
		<div>
			<div class="col-md-4">
				<div class="thumbnail caption">
					<img class="prodImg" id="prodExpdImgDiv"
						src=""
						style="width: 600px; height: 400px;">
				</div>
				<input type="file" id="prodExpdImgDetail" name="prodExpdImgDetail"
					accept="image/*" onchange="handleImgFileSelect(this)" required />
			</div>
			<div class="col-md-8">
				<div class="">
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdBrandInfDetail">브랜드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdBrandInfDetail"
								placeholder="" name="expdBrandInfDetail" style="margin-bottom: 20px;"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdProdNmDetail">모델명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdProdNmDetail"
								placeholder="" name="expdProdNmDetail" style="margin-bottom: 20px;"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdModelAvailDetail">사용
							가능 기종</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdModelAvailDetail"
								placeholder="" name="expdModelAvailDetail"
								style="margin-bottom: 20px;" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="expdProdInfDetail">사용
							매수</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="expdProdInfDetail"
								placeholder="" name="expdProdInfDetail" style="margin-bottom: 20px;"
								required>
						</div>
					</div>
					<div class="form-group">
						<label for="sellYnDetail" class="col-sm-2">판매 가능 여부</label>
						<div class="col-sm-10">
							<select class="form-control" id="sellYnDetail" name="sellYnDetail"
								style="margin-bottom: 20px;">
								<option value="가능" selected="selected">가능</option>
								<option value="불가">불가</option>
							</select>
						</div>
					</div>
				</div>
				<div style="float: right;">
					<button id="prodExpdDelete" class="btn btn-danger">삭제</button>
					<button id="prodExpdModify" class="btn btn-primary">수정</button>
					<button id="prodExpdUpdate" class="btn btn-primary">저장</button>
					<button class="btn btn-default" onclick="location.href='adminProdExpdMgmtPage.do'">목록</button>
				</div>
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="resources/js/admin/productMgmt/common.js"></script>
	<script src="resources/js/admin/productMgmt/expd/adminProdExpdMgmtDetail.js"></script>
</body>
</html>
