<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 제품 게시판 복합기 렌탈 상세페이지</title>
</head>
<body>
<jsp:include page="../../common/adminTopNav.jsp" />
<div class="container-fluid">
	<div class="row prod-inf-area">
			<div class="col-md-4">
				<div class="thumbnail caption">
					<img class="prodImg" id="prodMfpImgDiv" style="height: 600px;">
				</div>
			</div>
			<div class="col-md-8">
				<div class="">
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpTitleDetail">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpTitleDetail" name="mfpBrandInfDetail" style="margin-bottom: 20px;" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpProdInfDetail">제품정보</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdInfDetail" name="mfpBrandInfDetail" style="margin-bottom: 20px;" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpBrandInfDetail">브랜드</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpBrandInfDetail" name="mfpBrandInfDetail" style="margin-bottom: 20px;" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="mfpProdNmDetail">모델명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdNmDetail" name="mfpProdNmDetail" style="margin-bottom: 20px;" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="agreement">약정</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="agreement"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								readonly> <span style="float: left; padding-top: 10px;">년</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="registerPrice">보증금</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="registerPrice"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								readonly> <span style="float: left; padding-top: 10px;">원(\)</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="price">가격</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="price"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								readonly> <span style="float: left; padding-top: 10px;">원(\)</span>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdId" name="mfpProdId" style="display: none;">
						</div>
					</div>
				</div>
			</div>
		</div>
		<button class="btn btn-default open-modal" type="button"
				data-toggle="modal" data-target="#myModal">제품추가</button>
		<div class="content-area">
			<label for='content'>상품정보 : </label>
			<textarea id="p_content"></textarea>
			<div id="mfpContent" align="center"></div>
		</div>
		
		<div class="btn-area">
			<button class="btn btn-default update-mode">수정하기</button>
			<button class="btn btn-default update">저장</button>
			<button class="btn btn-default delete">삭제</button>
			<button class="btn btn-default go-back">목록으로</button>
		</div>
	</div>
</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/admin/productBoardMgmt/mfpRental/adminProdMfpRentalBoardMgmtDetail.js"></script>
</html>
