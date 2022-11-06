<%@page import="edu.web.Member_answer2.MemberVO"%>
<%@page import="edu.web.Member_answer2.MemberDAOImple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member-result</title>
<script type="text/javascript">
function check1() {
	var check1 = confirm("회원 탈퇴 하시겠습니까?");
	//confirm으로 확인 알림 띄울 수 있다!
	if(check1) {			
		location.href="delete.do"
	}
}
</script>
</head>
<%@ include file ="header_prac.jspf" %>
<body>

	<%
		// TODO : 회원 정보 출력
		MemberVO vo= (MemberVO)request.getAttribute("vo");
		
		if(session.getAttribute("vo")==null){
		response.setContentType("text/html; charset=UTF-8");		
		out.print("<script>alert('세션이 만료 되었습니다.'); location.href='login.jsp';</script>");
		out.flush();
		return;
		}
	
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
	
	<a href="member-update.jsp?userid=<%=vo.getUserid()%>"><input type="button" value= "정보 수정"> </a><br>
	<a href="delete.do?userid=<%=vo.getUserid()%>"><input type="button" value= "회원 탈퇴"> </a><br>
	<button onclick=check1()>회원탈퇴 알람</button></a><br>
	<input type="button" value= "회원 탈퇴 알람 2" onclick=check1()></a>

</body>
</html>








