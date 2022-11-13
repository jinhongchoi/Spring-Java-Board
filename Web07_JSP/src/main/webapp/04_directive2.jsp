<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="04_error.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 처리</title>
</head>
<body>
	<h1>Directive를 사용한 에러 페이지 처리</h1>
	<p>나눗셈결과 : <%=123/0 %></p>
	<%
		String[]str = new String[2]	;
		str[25]= "hello";
	
	%>
</body>
</html>