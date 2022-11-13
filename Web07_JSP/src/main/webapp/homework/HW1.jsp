<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 계산기</title>
</head>
<body>
	<h1>적금 계산기</h1>
	<!--
		JSP 파일 생성(적금 계산 결과 페이지)
		1. 월 적금액, 기간, 이자율을 전송하는 form만들기(HW1.jsp)
		 - (form action="HW1_result.jsp" method = "get")
		2. 월 적금액, 기간, 이자율을 전송받아 계산하여 출력하는 jsp 파일 만들기(HW1_result.jsp) 
		
		// JSP -> JSP 로 가는 방법! -> servlet 을 거치지 않아도 가능! 
		(대신 서버를 거치지않는 차이점이 있다! -> servlet이 있어야 서버 거침(?))
		
	  -->
	<h1>당신의 정보를 입력해주세요.</h1>
	<form action="HW1_result.jsp" method ="get"><!--form action 에 jsp파일도 가능!(기존에는 servlet파일만 사용)  -->
		월 적금액: <input type ="number" name ="inputMoney" placeholder="월 적금액"><br>
		기간: <input type ="number" name ="period" placeholder="기간"><br>
		이자율: <input type ="number" name ="interest" placeholder="이자율"><br>
		
		<input type ="submit" value ="제출">
	</form>
	
	
</body>
</html>