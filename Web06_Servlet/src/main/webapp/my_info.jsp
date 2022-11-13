<%@page import="edu.web.servlet05.infoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My_info</title>
</head>
<body>
	
	<%	//여기는 꺼내는 페이지! -> 꺼낸다(get!), request 에서(request.)
		String name = (String)request.getAttribute("name");
		//넣었을 때 object형식으로 담았기 때문에 꺼낼때는 원하는 방식으로 형변환 필요!
		String lived =(String)request.getAttribute("lived");
		int age = (Integer)request.getAttribute("age");
		//이름 짓는 것을 변수명과 똑같이 한다! -> 실수하지 않기 위해서
		
		infoVO vo = (infoVO)request.getAttribute("vo");
		// vo로 가져올때는 형변환을 (infoVO)로 해주면 안에 내용은 알아서 변환된다!
	%>
	
	<p>이름 : <%=name %></p>
	<p>사는곳 : <%=lived %></p>
	<p>나이 : <%=age %></p>
	<p><%=vo %></p>
	
</body>
</html>