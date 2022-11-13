<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//맴버 변수, 전역 변수
int fontSize;
int day =3;
%>
<!--
	public class{
	int fontSize;
	int day =3;	
	}
	위에랑 같은 거! -> 맴버변수를 위와 같이 생성한 것!
  -->
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구문</title>
</head>
<body>
	<%		
		int test =1; //지역 변수-> <% 이 안에서만 사용이 가능! 다른<% 는 다른 class라고 생각!
	%>
	
	<%	//자바공간
		if(day ==1||day ==7){
	%>
		<!--html 공간  -->
		
		<p>오늘은 주말입니다.</p>
			
	<%	// 자바공간	 -> 이런식으로 if문 사이에 html공간을 추가할 수있고, 이렇게 많이 씀!
		// 이렇게 짜더라도 웹에서는 html 부분만 보임!
		}else{
	%>
		<p>오늘은 평일입니다.</p>	
	<%
		}	
	%>
	
	<%--
		JSP 태그는 HTML 내 어느 위치에서든 사용 가능
	 --%>
	 <%
	 	for(fontSize=1 ; fontSize<=3 ; fontSize++){
	 %>
	 	<font color="green" size="<%=fontSize%>">JSP 구문 연습 중</font><br>
	 <%		
	 	}
	 %>
	
</body>
</html>