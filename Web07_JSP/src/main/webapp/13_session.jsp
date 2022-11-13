<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
<%
	// session 객체: session 범위에 존재하는 객체-> jsp 어느 범위에서나 존재함!
	
	// 세션 생성 시간 -> 생성할 때 그 시간!
	Date createTime = new Date(session.getCreationTime());
	
	// 이 웹페이지의 마지막 접속 시간 -> 같은 세션에서 접속한 시간! 새로고침하면 다시 접속하는거여서 시간이 바뀐다!
	Date lastAceessTime = new Date(session.getLastAccessedTime());
	
	// 세션 유지 시간 설정 방법1
	session.setMaxInactiveInterval(10); // 10초	
	// 유지시간이 지나면 세션 아이디가 새로 생성된다! -> 생성시간 마지막 접속시간도 같이 변하는거 확인됨!
	
	// 세션 유지 시간 설정 방법2
	// - web.xml 설정
	
	/*
	
	<seeeion-config>
	<seeeion-timeout>10</seeeion-timeout> // 분 단위
	</seeeion-config>
	
	*/
	
	// 세션에 키*값 저장하기
	session.setAttribute("userid", "운영자");
	
%>

</head>
<body>
	
	<%--
		* HTTP 특성
		- connectionless : 클라이언트가 요청을 한 후 응답을 받으면 연결을 끊는 특성
		- stateless : 통신이 긑나면 상태를 유지하지 않는 특성
		- 쿠키와 세션은 HTTP 특성이 아닌 연결 상태를 유지하기 위해 사용
		
		* 세션(session)
		- 쿠키를 기반으로 사용
		- 자바 측에서 데이터를 관리
		- 세션 ID를 부여하여 브라우저를 종료할 때까지 데이터를 유지
		- 세션 객체 : 사용자를 식별할 수 있는 방법을 제공
		   1) 특정 페이지의 요청
		   2) 웹 사이트 방문 카운트
		   3) 사용자에 대한 정보 저장
		  -주의 사항 : 세션은 원래 프로젝트(클라이언트)에 실행되는 모든 웹페이지에 적용됨
		  			따라서, 하나의 클라이언트에 세션을 많이 사용하면 충돌이 발생할 수 있음
		  			scope가 넓다
		  - session 객체는 session의 메소드를 사용하면 생성됨. (예, session.Attribute());
		
	 --%>
	 
	 <h2>세션 아이디: <%= session.getId() %></h2>
	 <h2>세션 생성 시간: <%= createTime %></h2> 
	 <h2>마지막 접속 시간 : <%=lastAceessTime %></h2>
	 <a href= "13_session_test.jsp">13_session_test.jsp 페이지 이동</a>
	
</body>
</html>













