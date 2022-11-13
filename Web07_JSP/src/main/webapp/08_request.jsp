<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Request</title>
</head>
<body>
	<%
		out.println("당신의 IP 주소: "+ request.getRemoteAddr()+ "<br>");
		out.println("당신의 Host Name : "+ request.getHeader("host")+"<br>");
		out.println("당신의 쿠키 : "+ request.getHeader("cookie")+"<br>");
		out.println("당신의 servlet 경로 : "+ request.getServletPath()+"<br>");
		
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		
	%>
	
	<h1>결과 페이지</h1>
	<p>이름: <%=firstName + lastName %></p>
	
	
</body>
</html>