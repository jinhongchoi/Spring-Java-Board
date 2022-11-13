<%@page import="edu.web.MemberPr.MemberVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// TODO : 회원 정보 출력
				
		MemberVO vo= (MemberVO)request.getAttribute("vo");
		// TODO : 회원 수정 버튼 생성, jsp 페이지에 userid 전송
		// TODO : 회원 탈퇴 버튼 생성
		
		
	%>
	
	<h2>회원 정보 출력</h2>
	<p>아이디는 <%=vo.getUserid() %> 입니다.</p>
	<p>비밀번호는 <%=vo.getPassword() %> 입니다.</p>
	<p>이메일은 <%=vo.getEmail() %> 입니다.</p>
	<p>이메일 수신여부는 <%=vo.getEmailAgree() %> 입니다.</p>
	<p>관신분야는 <%=vo.getInterestJoin() %> 입니다.</p>
	<p>연락처는 <%=vo.getPhone() %> 입니다.</p>
	<p>자기소개는 <%=vo.getIntroduce() %> 입니다.</p>
	
	<a href="member-update.jsp?userid=<%=vo.getUserid()%>"><input type="button" value= "정보 수정"> </a>
	<a href="delete.do?userid=<%=vo.getUserid()%>"><input type="button" value= "회원 탈퇴"> </a>

</body>
</html>