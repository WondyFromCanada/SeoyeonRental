$(function() {
		$('#save').hide();
		var postId = window.location.href.split('postId=')[1];
		$.ajax({
			url: '/rental/install/' + postId,
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				var data = data;
				
				$('#title').val(data.TITLE);
				$('#writer').val(data.USER_NM);
				$('#p_content').html(data.CONTENT);
			},
			error: function(data) {
				console.log(data);
			}
		});
	})
	
	$('#updateMode').on('click', function(e) {
		$('#updateMode').hide();
		$('#save').show();
		$('#p_content').html('');
		CKEDITOR.replace('updateContent', {filebrowserImageUploadUrl: '/rental/install/imgUpload'});
	 	CKEDITOR.on('dialogDefinition', function( ev ){
	        var dialogName = ev.data.name;
	        var dialogDefinition = ev.data.definition;
	     
	        switch (dialogName) {
	            case 'image': //Image Properties dialog
	                //dialogDefinition.removeContents('info');
	                dialogDefinition.removeContents('Link');
	                dialogDefinition.removeContents('advanced');
	                break;
	        }
	    });
		var postId = window.location.href.split('postId=')[1];
		$.ajax({
			url: '/rental/install/' + postId,
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				
				$('#title').val(data.TITLE);
				$('#writer').val(data.USER_NM);
				CKEDITOR.instances.updateContent.setData();
				setTimeout(function() {
			        CKEDITOR.instances.updateContent.document.getBody().setHtml(data.CONTENT);
			    }, 200);
			},
			error: function(data) {
				console.log(data);
			}
		});
	});
	
	$('#save').on('click', function(e) {
		var confirm = window.confirm('수정하시겠습니까?');
		if(confirm) {
			var postId = window.location.href.split('postId=')[1];
			var sendData = {
					postId: postId,
	 				title: $('#title').val(),
	 				content: CKEDITOR.instances.updateContent.getData()
	 		};
			
			$.ajax({
				url: '/rental/install/'+ postId,
				type: 'PUT',			
				data: JSON.stringify(sendData),
				contentType: 'application/json',
				success: function(data) {
					console.log(data);
					if(data.result == 'success')
						window.location.href = 'adminInstallBoardMgmtPage.do';
				}, 
				error: function(data) {
					console.log(data);
				}
			});
		}
	});
	
	$('#delete').on('click', function(e) {
		var confirm = window.confirm('삭제하시겠습니까?');
		if(confirm) {
			var postId = window.location.href.split('postId=')[1];
			$.ajax({
				url: '/rental/install/'+postId,
				type: 'DELETE',
				contentType: 'application/json',
				success: function(data) {
					console.log(data);
					if(data.result == 'success')
						window.location.href = 'adminInstallBoardMgmtPage.do';
				},
				error: function(data) {
					console.log(data);
				}
			})
		}
	});
	
	