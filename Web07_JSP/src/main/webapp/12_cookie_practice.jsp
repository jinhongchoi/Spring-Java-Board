<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 Practice</title>

<%
Cookie[]cookies = request.getCookies();

String id = "";
String pw = "";

if(cookies != null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("ID")){
			id= cookie.getValue();
		}else if(cookie.getName().equals("PW")){
			pw= cookie.getValue();
		}
	}
	
}
%>

</head>
<body>

	<form action="12_cookie_practice_answer.jsp" method="post">
		 아이디 <br>  <input type="text" name="id" placeholder="아이디 입력" value="<%=id%>"><br>
		 비밀번호 <br> <input type="password"name="pw" placeholder="비밀번호 입력" value="<%=pw%>"><br> 
		 			<input	type="checkbox" name="isSaveAgreed" value="agreed"> 아이디 저장<br>
		<br> <input type="submit" value="로그인">
	</form>

</body>
</html>