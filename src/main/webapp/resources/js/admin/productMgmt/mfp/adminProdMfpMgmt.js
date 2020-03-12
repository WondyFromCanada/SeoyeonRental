/**
 * 
 */
$(function() {

	/*var page_count = Math.ceil(14/5);
	var page_data = $('#prodMfpUl').data();

	if(typeof(page_data.twbsPagination) != 'undefined'){
		if(page_data.twbsPagination.options.totalPages != page_count){
			$('#prodMfpUl').twbsPagination('destroy');
		}
	}*/

	$('#prodMfpUl').twbsPagination({
		totalPages: 10,	// 총 페이지 번호 수
		visiblePages: 5,	// 하단에서 한번에 보여지는 페이지 번호 수
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
			//클릭 이벤트
			console.log("클릭");
			prodListCnt(page);

		}
	});

	/*$.ajax({
		url: '/rental/product/mfp',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {

			ulData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});

	$.ajax({
		url: '/rental/product/mfpCnt',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			console.log(data);
		},
		error: function(data) {
			console.log(data);
		}
	});*/

});

var flag = true;

function prodListCnt(page) {
	console.log("page : " + page);
	if(flag){
		flag = false;
		$.ajax({
			url: '/rental/product/mfpCnt',
			type: 'GET',
			contenType: 'application/json',
			success: function(data) {
				console.log(data);
				$("#prodMfpUl").twbsPagination("changeTotalPages", data , page);

				prodList();
			},
			complete: function(){
				flag = true;	//호출 완료되면 flag 값을 사용가능하게 변경
			},
			error: function(data) {
				console.log(data);
			}
		});
	}
}

function prodList() {
	$.ajax({
		url: '/rental/product/mfp',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {

			ulData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
}

function ulData(data) {

	var ul = $('#prodMfpUl');
	$(ul).html('');

	var dataList = data;

	var innerHTML = "";
	$.each(dataList, function(i, v) {
		innerHTML +=
			//"<li>" +
			"<div class='col-sm-4'>" +
			"<div class='thumbnail'>" +
			"<img class='prodMfpImg' src='/rental/resources/uploadFiles/product/mfp/" + v.CHANGE_NM + v.EXT + "' onclick='prodMfpDetail(\"" + v.PROD_ID + "\")'>" +
			"<p class='prodMfpP' onclick='prodMfpDetail(\"" + v.PROD_ID + "\")'>" + v.PROD_NM + "</p>" + 
			"</div>" +
			"</div>";
		//"</li>";
	});

	$(ul).append(innerHTML);
}

function prodMfpDetail(prodId) {
	window.location.href = 'adminProdMfpMgmtDetailPage.do?prodId=' + prodId;
}