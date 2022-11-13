<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 속성(attribute)값 제거/invalidate(무효화)</h1>
	
	<%
	
		// 세션 attribute에 데이터 저장
		session.setAttribute("password", 123);
		
		// 세션 attribute 출력
		Enumeration<String>attrNames =session.getAttributeNames();
		while(attrNames.hasMoreElements()){
			String name= attrNames.nextElement();
			out.println(name+"<br>");
		}		
		
		out.println("<p>userid 속성제거</p><br>");
		session.removeAttribute("userid"); // 세션 속성 제거하는 코드
		// session.removeAttribute(name); ->이렇게 하면 다 지워진다!(session의 key 값이 name이기 때문에!)
		attrNames =session.getAttributeNames();
		while(attrNames.hasMoreElements()){
			String name= attrNames.nextElement();
			out.println(name+"<br>");
		}	
		
		session.invalidate(); // 세션 무효화 : 모든 세션 속성을 제거
		// 유효하지 않은 세션 : 세션 속성이 아무것도 없거나 세션이 invalidate 된 경우
		
		// 현재 세션이 유효(valid)한 지 체크(유효하면 세션이 생성된거! / 무효하면 세션이 없는거!)
		if(request.isRequestedSessionIdValid()){
			out.println("유효한 세션<br>");
		}else{
			out.println("유효하지 않은 세션<br>");
		}
		
		
	%>
	
</body>
</html>







