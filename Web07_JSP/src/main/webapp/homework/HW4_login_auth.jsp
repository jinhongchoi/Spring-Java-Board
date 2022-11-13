<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW4_login_auth.jsp</title>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	%>
	
	<%
	if (id.equals("test") && pw.equals("1234")) {
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setMaxInactiveInterval(60 * 60);
		
		out.print("<script>location.href='HW4_login_result.jsp'</script>");
		// 페이지 이동시키는 코드!
	}else{
		
		out.print("<script>alert('로그인 실패!')</script>");
		// 알람띄우는 코드!
		out.print("<script>location.href='HW4.jsp'</script>");
	}
	%>

</head>
<body>


	
		

</body>
</html>