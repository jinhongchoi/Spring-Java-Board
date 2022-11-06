<%@page import="edu.web.Member_answer2.MemberVO"%>
<%@page import="edu.web.Member_answer2.MemberDAOImple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body {
	background: #dfdfdf;
}

.form-login {
	width: 60%;
	background: white;
	padding: 20px;
	margin: auto;
}

/* Attribute Selector(속성 선택자) : [속성이름="속성값"] */
input[type="text"], input[type="password"], select {
	display: inline-block;
	width: 100%;
	padding: 8px 0px;
	margin: 8px 8px;
	box-sizing: border-box;
	border: none;
	border-bottom: 2px solid grey;
}

input[type="text"]:focus, input[type="password"]:focus, select:focus {
	outline: none;
	border-bottom: 2px solid rgb(253, 0, 6);
}

input[type="submit"] {
	width: 100%;
	margin: 8px 8px;
	background: lightpink;
	color: white;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background: hotpink;
}
</style>

<meta charset="UTF-8">
<title>Login-Result</title>
<script type="text/javascript">
	function check() {
		var check = confirm("로그아웃 하시겠습니까?");
		//confirm으로 확인 알림 띄울 수 있다!
		if(check) {			
			location.href="logout.do"
		}
	}
</script>
</head>
<%@ include file ="header_prac.jspf" %>
<body>
	<%
	// TODO : userid님, 환영합니다. 페이지에 출력

	MemberVO vo = (MemberVO) session.getAttribute("vo");
	//강사님은 session 대신 request로 했기때문에 request.getAttribute 로 사용! -> 세션을 남발하지말기!
	
	if(session.getAttribute("vo")==null){
		response.setContentType("text/html; charset=UTF-8");		
		out.print("<script>alert('세션이 만료 되었습니다.'); location.href='login.jsp';</script>");
		//지금은 jsp-> jsp로 이동하지만 나중에는 무조건 jsp->servlet -> jsp로 가게끔한다!
		out.flush();
		return;
	}
	
	
	// TODO : 회원 정보 이동 버튼 생성

	// TODO : 로그아웃 버튼 생성	
	%>

	<h2><%=vo.getUserid()%>님, 환영합니다.
	</h2>

	<!-- GET 방식으로 userId 전송  -->
	<button onclick="location.href='select.do?userid=<%=vo.getUserid()%>'">회원정보</button><br>
	<!--select.do?userid -> 쿼리 스트링 사용! / 작은따옴표, 큰따옴표 구분 잘하기!  -->
	<!--select.do?userid  ->이부분도 이름 동일하게 할것! -->

	<button onclick="location.href='logout.do?userid=<%=vo.getUserid()%>'">로그아웃</button><br>
	<button onclick=check()>로그아웃 알람</button>
	
</body>
</html>