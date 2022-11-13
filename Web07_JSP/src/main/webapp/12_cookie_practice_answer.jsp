<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>
	
	<%
	String isSaveAgreed = request.getParameter("isSaveAgreed");
	
	if(isSaveAgreed !=null){
		Cookie idCookie = new Cookie("ID", request.getParameter("id"));
		Cookie pwCookie = new Cookie("PW", request.getParameter("pw"));
		
		idCookie.setMaxAge(60*60);
		pwCookie.setMaxAge(60*60);
		
		response.addCookie(idCookie);
		response.addCookie(pwCookie);
		Cookie[] cookies = request.getCookies();
		
	}
	
	// 12_cookie_practice_result.jsp 와 비교해보기!
	
	%>
	
	<h1>로그인 결과 화면</h1>
	<p><%=request.getParameter("id") %>님 환영합니다.</p>

	
</body>
</html>