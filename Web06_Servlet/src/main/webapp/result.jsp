<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	

	<%
	 //request : forward에서 넘겨받은 request 객체 
	 
	 String name = request.getParameter("name");
	 int age = Integer.parseInt(request.getParameter("age"));
	 String email = request.getParameter("email");
	 int money = Integer.parseInt(request.getParameter("money"));
	%>
	
	<h1>결과 페이지</h1>
	<p>제 이름은 <%=name %>입니다.</p>
	<p>제 나이은 <%=age %>입니다.</p>
	<p>제 이메일은 <%=email %>입니다.</p>
	<p>제 재산은 <%=money %>억원 입니다.</p>
</body>
</html>