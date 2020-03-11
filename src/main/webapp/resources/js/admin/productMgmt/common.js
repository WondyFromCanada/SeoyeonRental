/**
 * 
 */
/* 2020.03.09 김정언 - 사진 선택 시 img 영역에 띄우는 함수 */
var selectFile;

function handleImgFileSelect(e){
	var files = e.files;
	var filesArr = Array.prototype.slice.call(files);

	// 파일이 없을 때는 noImg 사진을 띄워줌
	if(e.files.length == 0){
		$(".prodImg").attr("src", "/rental/resources/images/common/noImg.png");
		return;
	}

	filesArr.forEach(function(f){			
		selectFile = f;

		var reader = new FileReader();
		reader.onload = function(e){
			$(".prodImg").attr("src", e.target.result);
		}
		reader.readAsDataURL(f);
	});
}
/* End */