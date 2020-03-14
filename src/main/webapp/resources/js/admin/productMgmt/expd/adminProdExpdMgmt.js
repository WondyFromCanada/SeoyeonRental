/**
 * 
 */
$(function() {
	initData();
});

function initData() {
	$.ajax({
		url: '/rental/product/expd',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			//data Null 처리
			if(data.length > 1) {
				
				//보여지길 원하는 갯수
				var pageSize = 9;
				
				//전체 데이터 갯수를 9로 나눈후 반올림하여 총 페이지 수 설정
				var totalPages = Math.ceil(data.length / pageSize);
				
				//페이징 영역에 번호 몇개까지 보일건지
				var visibleBlock = 5;
				
				$('#prodExpdDiv').twbsPagination({
					totalPages: totalPages,	// 총 페이지 번호 수
					visiblePages: visibleBlock,	// 하단에서 한번에 보여지는 페이지 번호 수
					startPage : 1, // 시작시 표시되는 현재 페이지
					initiateStartPageClick: true,	// 플러그인이 시작시 페이지 버튼 클릭 여부 (default : true)
					first : "<<",	// 페이지네이션 버튼중 처음으로 돌아가는 버튼에 쓰여 있는 텍스트
					prev : "<",	// 이전 페이지 버튼에 쓰여있는 텍스트
					next : ">",	// 다음 페이지 버튼에 쓰여있는 텍스트
					last : ">>",	// 페이지네이션 버튼중 마지막으로 가는 버튼에 쓰여있는 텍스트
					nextClass : "page-item next",	// 이전 페이지 CSS class
					prevClass : "page-item prev",	// 다음 페이지 CSS class
					lastClass : "page-item last",	// 마지막 페이지 CSS calss
					firstClass : "page-item first",	// 첫 페이지 CSS class
					pageClass : "page-item",	// 페이지 버튼의 CSS class
					activeClass : "active",	// 클릭된 페이지 버튼의 CSS class
					disabledClass : "disabled",	// 클릭 안된 페이지 버튼의 CSS class
					anchorClass : "page-link",	//버튼 안의 앵커에 대한 CSS class
					onPageClick: function (event, page) {
						//twbs입힌 prodMfpUi 하위에 컨텐츠 넣을 영역을 하나 더 추가해야 함
						//새로운 페이지 갈때마다 초기화 하고 다시 컨텐츠 넣음
						$("#prodExpdlistBody").empty();
						
						//데이터 총 갯수
						var totalCnt = data.length;
						
						//긁어온 페이징 공식
						var startRow = (page - 1) * pageSize;
						var endRow = page * pageSize;
						if(endRow > totalCnt) {
							endRow = totalCnt;
						}
						var startPage = ((page - 1)/visibleBlock) * visibleBlock + 1;
						var endPage = startPage + visibleBlock - 1;
						if(endPage > totalPages) {    
							endPage = totalPages;
						}
						//공식을 통해 긁어온 시작번호와 끝번호를 가지고 dataList에서 화면에 뿌려줄 애들만 추출
						var innerHTML = "";
						for(var i = startRow; i < endRow; i ++) {
							innerHTML +=
								"<div class='col-sm-4'>" +
									"<div class='thumbnail'>" +
										"<img src='/rental/resources/uploadFiles/product/expd/" + data[i].CHANGE_NM + data[i].EXT + "' onclick='prodExpdDetail(\"" + data[i].PROD_ID + "\")'>" +
										"<p onclick='prodExpdDetail(\"" + data[i].PROD_ID + "\")'>" + data[i].PROD_NM + "</p>" + 
									"</div>" +
								"</div>";
						}
						
						$("#prodExpdlistBody").append(innerHTML);
						
					}
				});
			} else {
				//null 일때
			}
		},
		error: function(data) {
			console.log(data);
		}
	});
}

function prodExpdDetail(prodId) {
		window.location.href = 'adminProdExpdMgmtDetailPage.do?prodId=' + prodId;
}