$(function() {
		$('#save').hide();
		var postId = window.location.href.split('postId=')[1];
		$.ajax({
			url: '/rental/install/' + postId,
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				
				$('#title').val(data.TITLE);
				$('#p_content').html(data.CONTENT);
			},
			error: function(data) {
				console.log(data);
			}
		});
	})
	
	
	