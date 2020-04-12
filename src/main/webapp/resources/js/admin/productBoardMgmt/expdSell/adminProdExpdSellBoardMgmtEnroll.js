$(function() {
	$('.register').hide();
	$('.content-area').hide();
	$('.prod-inf-area').hide();
	
	$('.open-modal').on('click', function(e) {
		$.ajax({
			url: '/rental/product/expd',
			type: 'GET',
			contentType: 'application/json',
			success: function(data) {
				var innerHTML = "";
				
				$.each(data, function(i, v) {
					var src = "resources/uploadFiles/product/expd/" + 
						v.CHANGE_NM + v.EXT;
					
					innerHTML += 
						"<div class='col-xs-4' align='center' onclick='getProdInf(" + v.PROD_ID + ")'>" + 
							"<img style='width: 100%;' src=" + src + ">" + 
							"<p>" + v.PROD_NM + "</p>" + 
						"</div>";
				});
				$('.modal-body').append(innerHTML);
			},
			error: function(data) {
				console.log(data);
			}
		});
	});
	
	$('.register').on('click', function(e) {
		var sendData = {
				title: $('#mfpTitleDetail').val(),
				prodId: $('#mfpProdId').val(),
				content: CKEDITOR.instances.p_content.getData(),
				agreement: $('#agreement').val(),
				price: $('#price').val(),
				registerPrice: $('#registerPrice').val()
		};
		
		if(
				sendData.title.length > 0 && sendData.price.length > 0 && 
				sendData.content.length > 0 && sendData.agreement.length > 0 && 
				sendData.registerPrice.length > 0
			) {
			
			var confirm = window.confirm('등록하시겠습니까?');
			if(confirm) {
				$.ajax({
					url: '/rental/productBoard/rental/expd',
					data: JSON.stringify(sendData),
					contentType: 'application/json',
					type: 'POST',
					success: function(data) {
						if(data.result == 'success')
							location.href = 'adminProdExpdRentalBoardMgmtPage.do';
					},
					error: function(data) {
						console.log(data);
					}
				});
				
			}
		}
		
	});
	
});

function getProdInf(prodId) {
	$.ajax({
		url: '/rental/product/expd/'+prodId,
		type: 'GET',
		contentType: 'application/json',
		success: function(data) {
			$('.open-modal').text('제품변경');
			$('.close').click();
			$('.register').show();
			$('.content-area').show();
			$('.prod-inf-area').show();
			
			$('#prodMfpImgDiv').attr('src', '/rental/resources/uploadFiles/product/expd/' + data.CHANGE_NM + data.EXT);
			$('#mfpBrandInfDetail').val(data.BRAND_INF);
			$('#mfpProdNmDetail').val(data.PROD_NM);
			
			var prodInf = 
				data.PROD_INF + ', ' + data.OUTPUT_SPD +
				data.SCAN_SPD + ', ' + data.NETWORK_DIVSN + 
				data.PAPER_DIVSN;
				
			$('#mfpProdInfDetail').val(prodInf);
			$('#mfpProdId').val(data.PROD_ID);
			
			CKEDITOR.replace('p_content', {
					filebrowserImageUploadUrl: '/rental/productBoard/rental/expd/imgUpload',
					height: 450
				}
			);
			
			//ckEditor Config => img저장 탭에서 link 와 acvanced 탭을 없앰
			CKEDITOR.on('dialogDefinition', function( ev ) {
				var dialogName = ev.data.name;
				var dialogDefinition = ev.data.definition;
				
				switch (dialogName) {
				case 'image': 
					dialogDefinition.removeContents('Link');
					dialogDefinition.removeContents('advanced');
					break;
				}
			});
			
		},
		error: function(data) {
			console.log(data);
		}
	});
}


