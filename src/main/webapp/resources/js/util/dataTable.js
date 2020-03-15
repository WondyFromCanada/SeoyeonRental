var columnTitle = {};
columnTitle['POST_ID'] = '게시글번호';
columnTitle['TITLE'] = '제목';
columnTitle['CONTENT'] = '내용';
columnTitle['ANSWER'] = '답변';
columnTitle['CREATE_DATE'] = '작성일자';

columnTitle['USER_NM'] = '작성자';

function getGridColInf(tblGrpNm) {
	var gridColInf = [];
	var sendData = {
			tblGrpNm: tblGrpNm
	};
	
	$.ajax({
		url: '/rental/getGridColInf.do',
		data: JSON.stringify(sendData),
		type: 'POST',
		async: false,
		contentType: 'application/json',  
		success: function(data) {
			gridColInf = data;
		}
	});
	
	return gridColInf;
}

function initTable(gridColInf, length) {
	var table = $('.board-table');
	table.html('');
	
	var thead = "";
	var tbody = "";
	
	$.each(gridColInf, function(i, v) {
		thead += 
			"<th name='" + v.TBL_COL_NM + "'>" + columnTitle[v.TBL_COL_NM] + "</th>";
		tbody += 
			"<td name='" + v.TBL_COL_NM + "'>" + columnTitle[v.TBL_COL_NM] + "</td>";
	});
	
	var tbodyHTML = "";
	for(var i = 0; i < length; i++) {
		tbodyHTML +=
			"<tr>" + tbody + "</tr>";
	}
	
	var innerHTML = "";
	
	innerHTML += 
		"<thead>" + 
			"<tr>" + 
				thead +
			"</tr>" +
		"</thead>";
	
	
	innerHTML +=
		"<tbody>" +
			tbodyHTML +
		"</tbody>";
	
	table.append(innerHTML);
}

function tableData(data) {
	var tbody = $('.board-table tbody');
	var dataList = data;
	
	var trList = $('.board-table tbody tr');
	$.each(trList, function(i, tr){
	    var tdList = $(tr).children();
	    $.each(tdList, function(i2, td){
	        $(td).text( data[i][ $(td).attr('name') ] );
	    });
	});
	
	var table = $('.board-table').DataTable();
	setEventListener(table);
}
