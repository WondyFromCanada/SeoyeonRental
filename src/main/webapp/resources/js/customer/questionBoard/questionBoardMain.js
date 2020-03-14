$(function() {
	initTable();
	$.ajax({
		url: '/rental/customer/question',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			tableData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
	
	$('#registerPage').on('click', function(e) {
		var returnPath = window.location.href;
		location.href='ckEnrollPage.do?type=question&returnPath=' + returnPath + '&divsn=customer';
	});
})
	
function initTable() {
	var table = $('#boardTable');
	table.html('');
	
	var thead = "";
	thead += 
		"<th>번호</th>" + 
		"<th>제목</th>" + 
		"<th>작성자</th>" + 
		"<th>작성일자</th>" + 
		"<th>공개여부</th>"; 
	
	var innerHTML = "";
	
	innerHTML += 
		"<thead>" + 
			"<tr>" + 
				thead +
			"</tr>" +
		"</thead>";

	var tbody = "";
	
	innerHTML +=
		"<tbody>" +
			tbody +
		"</tbody>";
	
	table.append(innerHTML);
}

function setEventListener(table) {
	
	$('#boardTable tbody').on('click', 'tr', function() {
		var postId = table.row(this).data()[0];
		window.location.href = 'customerQuestionDetailPage.do?postId=' + postId;
	});
}

function tableData(data) {
	
	var tbody = $('#boardTable tbody');
	$(tbody).html('');
	
	var dataList = data;
	
	var innerHTML = "";
	$.each(dataList, function(i, v) {
		innerHTML += 
			"<tr>" +
				"<td name='postId'>" + v.POST_ID + "</td>"+ 
				"<td name='title'>" + v.TITLE + "</td>"+ 
				"<td name='userNm'>" + v.USER_NM + "</td>"+ 
				"<td name='createDate'>" + v.CREATE_DATE + "</td>"+ 
				"<td name='publicYn'>" + v.PUBLIC_YN + "</td>"+ 
			'</tr>';
	});
	
	$(tbody).append(innerHTML);
	var table = $('#boardTable').DataTable();
	setEventListener(table);
}

	