<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW4_login_result.jsp</title>
</head>
<body>
	
	
	<%
		String id=(String)session.getAttribute("id");
		//앞에서 세션이 생성되기 때문에 흐름 잘 파악할 것!
		if(id !=null && id.equals("test")){
		// .equals()는 null을 못잡는다
	%>
		<h2><%=id %>님 환영합니다.</h2>		
	<%
		}else {
		out.print("<script>alert('로그인 해주세요!');</script>");
		out.print("<script>location.href='HW4.jsp'</script>");	
		
		}
	%>
	
	
</body>
</html>