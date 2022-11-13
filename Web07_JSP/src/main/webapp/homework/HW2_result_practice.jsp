<%@page import="edu.web.homework.ContactDAOImple"%>
<%@page import="edu.web.homework.ContactVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%
 ContactDAOImple dao;

%>
<meta charset="EUC-KR">
<title>HW2_practice_result</title>
</head>
<body>

	<%
	dao= ContactDAOImple.getinstance();
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	ContactVO vo= new ContactVO(name, phone, email);
	
	int result = dao.insert(vo);
	
	%>
	
	<h1>정보</h1>
	<h2>입력받은 정보</h2>
	<p>name<%=name %></p>
	<p>phone<%=phone %></p>
	<p>email<%=email %></p>


</body>
</html>