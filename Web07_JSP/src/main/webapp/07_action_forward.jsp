<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	* JSP : forward
	- 현재 페이지를 forward 페이지로 덮어씀 
	 --%>
	 
	 <h2>현재 페이지는 07_action_forward.jsp 입니다.</h2>
	 <jsp:forward page="04_error.jsp"></jsp:forward>
	 <!-- 실제 페이지의 경로를 숨기고 싶을 때 많이 사용! / 07_action_forward의 url로 나타나기 때문  -->
</body>
</html>