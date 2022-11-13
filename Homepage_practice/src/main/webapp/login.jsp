<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<%
		//TODO : <a>태그를 이용하여 member-register.jsp 이동 링크 생성
		//TODO : 회원가입 form생성, action =login_auth.do" method="post"
	%>
	<div class="header">Login</div>

	<%@ include file="header_prac.jspf"%>

	<form action="login_auth.do" method="post">
		<br> <input type="text" name="userid" required="required"
			placeholder="아이디 입력"><br> <br> <input
			type="password" name="password" required="required"
			placeholder="비밀번호 입력"><br> <br> <input
			type="submit" value="로그인"><br>

		<!--
		required="required" -> 입력란을 입력하세요! 라는 알림이 뜨는 코드
		  -->
		<a href="member-register.jsp">회원가입</a>

	</form>

	<%@ include file="footer_prac.jspf"%>


</body>
</html>