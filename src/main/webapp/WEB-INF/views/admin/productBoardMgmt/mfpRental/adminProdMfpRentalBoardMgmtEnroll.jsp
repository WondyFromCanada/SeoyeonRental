<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리자 복합기 렌탈 게시판 등록페이지</title>
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
						<label class="control-label col-sm-2" for="mfpProdInfDetail">핵심
							기능</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mfpProdInfDetail" name="mfpProdInfDetail" style="margin-bottom: 20px;" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="outputSpdDetail">출력
							속도 (분당)</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="outputSpdDetail"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								readonly> <span style="float: left; padding-top: 10px;">매</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="scanSpdDetail">스캔 속도
							(분당)</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="scanSpdDetail"
								placeholder="" name="scanSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								readonly> <span style="float: left; padding-top: 10px;">매</span>
						</div>
					</div>
					<div class="form-group">
						<label for="networkDivsnDetail" class="col-sm-2">네트워크 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="networkDivsnDetail" name="networkDivsnDetail" style="margin-bottom: 20px;" disabled>
								<option value="유무선" selected="selected">유무선</option>
								<option value="유선">유선</option>
								<option value="무선">무선</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="paperDivsnDetail" class="col-sm-2">용지 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="paperDivsnDetail" name="paperDivsnDetail" style="margin-bottom: 20px;" disabled>
								<option value="A3" selected="selected">A3</option>
								<option value="A4">A4</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="colorYnDetail" class="col-sm-2">컬러 구분</label>
						<div class="col-sm-10">
							<select class="form-control" id="colorYnDetail" name="colorYnDetail" style="margin-bottom: 50px;" disabled>
								<option value="흑백" selected="selected">흑백</option>
								<option value="컬러">컬러</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="agreement">약정</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="agreement"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								> <span style="float: left; padding-top: 10px;">년</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="registerPrice">등록비</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="registerPrice"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								> <span style="float: left; padding-top: 10px;">원(\)</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="price">가격</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="price"
								placeholder="" name="outputSpdDetail"
								style="margin-bottom: 20px; width: 90%; float: left; margin-right: 20px;"
								> <span style="float: left; padding-top: 10px;">원(\)</span>
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
			<label for='content'>상세내용 : </label>
			<textarea id="p_content"></textarea>
		</div>
		
		<div class="btn-area">
			<button class="btn btn-default register">등록</button>
		</div>
	</div>
	
	
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content" style="padding: 15px 0;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">제품선택</h4>
				</div>
				<div class="modal-body" style='padding: 15px 0px !important'></div>
				<div class="modal-footer">
				</div>
			</div>

		</div>
	</div>
</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script src="resources/js/admin/productBoardMgmt/mfpRental/adminProdMfpRentalBoardMgmtEnroll.js"></script>
</html>

