<%@page import="edu.web.Member.MemberVO"%>
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
</head>
<body>
	<%
	// TODO : userid님, 환영합니다. 페이지에 출력

	MemberVO vo = (MemberVO) session.getAttribute("vo");
	

	if (vo == null) {
		
		out.print("<script>alert('세션이 만료 되었습니다.'); location.href='login.jsp';</script>");
		out.flush();
		return;
		//return으로 막아줘야 여기서 끝나고 밑에까지 영향을 미치지 않음!!!!!
		//if문 쓸때 꼭 return해서 조건이 세나가지 않게 할것!
		//이거 공부!!
	}

	// TODO : 회원 정보 이동 버튼 생성

	// TODO : 로그아웃 버튼 생성
	%>

	<h2><%=vo.getUserid()%>님, 환영합니다.
	</h2>


	<!-- GET 방식으로 userId 전송  -->
	<button onclick="location.href='select.do?userid=<%=vo.getUserid()%>'">회원정보</button>
	<!--select.do?userid -> 쿼리 스트링 사용! / 작은따옴표, 큰따옴표 구분 잘하기!  -->
	<!--select.do?userid  ->이부분도 이름 동일하게 할것! -->

	<button onclick="location.href='logout.do?userid=<%=vo.getUserid()%>'">로그아웃</button>

</body>
</html>