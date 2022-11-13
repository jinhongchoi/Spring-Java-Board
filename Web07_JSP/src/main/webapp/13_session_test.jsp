<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Test</title>
</head>
<body>
	<%
		String userid=(String)session.getAttribute("userid");
		//앞에서 세션이 생성되기 때문에 흐름 잘 파악할 것!
	%>
	
	<h2><%=userid %>님 환영합니다.</h2>

</body>
</html>