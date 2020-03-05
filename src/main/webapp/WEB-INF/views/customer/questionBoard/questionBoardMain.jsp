<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>고객센터 | 1:1문의</title>
</head>
<body>
<jsp:include page="../../common/topNav.jsp" />
<br><br><br><br>
<br><br><br><br>
<button onclick="location.href='customerQuestionBoardPage.do">1:1 문의</button>
<button onclick="location.href='customerQuestionBoardPage.do">자주묻는질문</button>
<button onclick="location.href='customerMaterialPage.do">자료실</button>

<div id="content"></div>
<div id="page-selection"></div>
<div id="main"></div>
<button onclick="window.location.href='customerQuestionEnrollPage.do'">게시글등록페이지</button>

</body>

<script>
	$(function() {
		$.ajax({
			url: '/rental/customer/question',
			type: 'GET',
			contenType: 'application/json',
			success: function(data) {
				var innerHTML = "";
				$.each(data, function(i, v) {
					innerHTML += 
						"<div postId='" + v.POST_ID + "' style='border: 1px solid black; width: 40%;'>" + v.TITLE + 
							"<button onclick='detail(this);'>상세보기</button>" + 
							"<p>공개여부 : " + ((v.PUBLIC_YN == 'N')?'비공개':'공개') +
						"</div>";
				});
				
				$('#main').append(innerHTML);
				
				/* $('#page-selection').bootpag({
					total: data.length,
					maxVisible: 10
				}).on('page', function(e, num) {
					
					var innerHTML = "<div postId='" + data[num - 1].POST_ID + "' style='border: 1px solid black; width: 40%;'>" + data[num - 1].TITLE + "<button onclick='detail(this);'>상세보기</button>" + "</div>";
					$('#content').html(innerHTML);
					
					//$(this).bootpag({total: 10, maxVisible: 10});
				}); */
				
			},
			error: function(data) {
				console.log(data);
			}
		});
	})
	
	
	function detail(el) {
		var postId = $(el).parent().attr('postId');
		console.log(postId);
		
		window.location.href = 'customerQuestionDetailPage.do?postId=' + postId;
	}
	
</script>
</html>