$(function() {
	initTable();
	$.ajax({
		url: '/rental/customer/material',
		type: 'GET',
		contenType: 'application/json',
		success: function(data) {
			tableData(data);
		},
		error: function(data) {
			console.log(data);
		}
	});
})
	
function initTable() {
	var table = $('#boardTable');
	table.html('');
	
	var thead = "";
	thead += 
		"<th>번호</th>" + 
		"<th>제목</th>" + 
		"<th>작성일자</th>"; 
	
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
		window.location.href = 'adminCustomerMaterialBoardMgmtDetailPage.do?postId=' + postId;
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
				"<td name='createDate'>" + v.CREATE_DATE + "</td>"+ 
			'</tr>';
	});
	
	$(tbody).append(innerHTML);
	var table = $('#boardTable').DataTable();
	setEventListener(table);
}
	