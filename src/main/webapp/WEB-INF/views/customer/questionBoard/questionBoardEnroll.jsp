<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<textarea class="form-control" id="p_content"></textarea>

<button onclick="showData()">data show</button>

</body>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
 CKEDITOR.replace('p_content'
                , {filebrowserUploadUrl: '/rental/customer/question/image'
                 });
 function showData() {
	 console.log(CKEDITOR.instances.p_content.getData());
 }
</script>
</html>
