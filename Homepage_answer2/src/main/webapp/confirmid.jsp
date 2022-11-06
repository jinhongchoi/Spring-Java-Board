<%@page import="edu.web.Member_answer2.MemberDAOImple"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirmid</title>
</head>
<body>
	<%
	String userid=request.getParameter("userid");
	MemberDAOImple dao;
	dao=MemberDAOImple.getInstance();
	int result=dao.idCheck(userid);
		
	if (result == 1) {
	%>
		
	<% out.println("이미 존재하는 ID입니다.");
	} else {
	%>
	
	<% out.println("사용가능한 ID입니다.");
	}
	%>

</body>
</html>