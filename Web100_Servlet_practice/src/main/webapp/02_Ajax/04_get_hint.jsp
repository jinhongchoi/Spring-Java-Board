<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
	String str=request.getParameter("q");
	
	if(str.equals("a")){	
		out.println("apple");		
	}else if(str.equals("b")){
		out.print("banana");
	}else if(str.equals("c")){
		out.print("coconut");
	}else{
		out.print("not fruits");
	} 
		
	//내가 한거 -> 조금 더 범용적임
	%>
		
	<%
	String str1=request.getParameter("q1");
	String result;
	"".charAt(0);
	if(str1.charAt(0)=='a'){	
		result="apple";		
	}else if(str1.charAt(0)=='b'){
		result="banana";
	}else if(str1.charAt(0)=='c'){
		result="coconut";
	}else{
		result="not fruits";
	} 
	
	//강사님이 해준거! -> 둘중 하나만 해야한다
	%>
	
	<%=result %>

