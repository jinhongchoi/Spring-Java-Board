<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>HW2_practice</title>
</head>
<body>
	
			<h1>당신의 정보를 입력해주세요.</h1>
	<form action="HW2_result_practice.jsp" method ="get"><!--form action 에 jsp파일도 가능!(기존에는 servlet파일만 사용)  -->
		이름: <input type ="text" name ="name" placeholder="이름"><br>
		번호: <input type ="text" name ="phone" placeholder="전화번호"><br>
		이메일: <input type ="text" name ="email" placeholder="이메일"><br>
		
		<input type ="submit" value ="제출">
	</form>
	
</body>
</html>