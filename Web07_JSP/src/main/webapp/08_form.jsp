<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Request</title>
</head>
<body>
	
	<%--
	* Request
	- 요청한 HTTP의 정보(ip 주소, 파라미터 등)을 갖고 있는 
	  객체(servlet의 HttpServletRequest와 동일)
	
	- 요청한 페이지에 대한 정보만 가지고 있음(다른 페이지에서는 request 정보가 사라짐)
	  
	 --%>
	 
	 <h2>GET/POST 방식</h2>
	 
	 <form action="08_request.jsp" method = "get">
	 성<br> <input type="text" name ="firstName"> <br>
	 이름<br> <input type="text" name ="lastName"> <br>
	 <br> <input type="submit" value ="전송">
	 </form>
	 
	 <form action="08_request.jsp" method = "post">
	 성<br> <input type="text" name ="firstName"> <br>
	 이름<br> <input type="text" name ="lastName"> <br>
	 <br> <input type="submit" value ="전송">
	 </form>
		
	
</body>
</html>