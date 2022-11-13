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
	 
		String str=request.getParameter("str");
		
	if(str.equals("a")){
		out.print("apple");
	}else if(str.equals("b")){
		out.print("banana");
	}else if(str.equals("c")){
		out.print("coconut");
	}else{
		out.print("not fruits");
	} 
	
	%>
	

</body>
</html>