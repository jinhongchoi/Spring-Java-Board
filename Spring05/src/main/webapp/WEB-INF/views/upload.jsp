<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<h1>파일 업로드 폼</h1>
	<h2>단일 파일 업로드</h2>
	<form action="upload" method = "post" enctype="multipart/form-data">
	<!--enctype="multipart/form-data" // 파일 넣을시 encording 타입을 의미함! 이게 있어야 업로드가 가능!  -->
		<input type="file" name ="file">
		<input type="submit" name ="업로드">
	</form>
	
	<h2>다중 파일 업로드</h2>
	<form action="upload2" method = "post" enctype="multipart/form-data">	
		<input type="file" name ="files" multiple="multiple">
		<input type="submit" name ="업로드">
	</form>
	
</body>
</html>








