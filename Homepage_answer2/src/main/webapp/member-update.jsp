<%@page import="edu.web.Member_answer2.MemberVO"%>
<%@page import="edu.web.Member_answer2.MemberDAOImple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

html{
    height: 300%;
    text-align: center;
    
}

body {
    background-color:#F5F6F7;
    margin: 0;
    height: 300%;
}

.form-login {
  width: 60%;
  background: white;
  padding: 20px;
  margin: auto;
}

/* Attribute Selector(속성 선택자) : [속성이름="속성값"] */
input[type="text"], input[type="password"], input[type="email"], select {
   
    font-weight: bold;
    font-size: 14px;
    margin-bottom: 30px;
    text-align: center;
    
    background-color: white;
    border: 1px solid #DBDADA;
    
    width: 450px;
    height: 50px;
    top: 40px;
}

textarea, select {
   
    font-weight: bold;
    font-size: 14px;
    
    text-align: center;
    
    background-color: white;
    border: 1px solid #DBDADA;
    
    width: 450px;
}

input[type="text"]:focus, input[type="password"]:focus, input[type="email"]:focus, select:focus{
  outline: none;
  border-bottom: 2px solid rgb(253, 0, 6);
}

input[type="submit"] {

    margin: 5px;
    top: 40px;   
    
    background-color: #03C75B;
    border: 1px solid #0CBF57;
    position: relative;
    width: 450px;
    height: 55px;
    font-weight: bold;
    color: white;
    font-size: 18px;
    margin-bottom: 50px;
}

input[type="submit"]:hover {
  background: hotpink;
  
}


</style>
<meta charset="UTF-8">
<title>member-update</title>

</head>



<body>
	
	<%
		// TODO : 회원 가입 form과 비슷.
		// 		userid는 변경하지 못하도록 input 태그 설정
		//		action="update.do" 입력된 회원 전체 수정 정보 전송
		MemberVO vo= (MemberVO)session.getAttribute("vo");
		
		if(session.getAttribute("vo")==null){
		response.setContentType("text/html; charset=UTF-8");		
		out.print("<script>alert('세션이 만료 되었습니다.'); location.href='login.jsp';</script>");
		out.flush();
		return;
		}
		
	%>
		
	
			
	<h1>회원 정보 수정</h1>
	 
	 <form action="update.do" method="post">
	 
	 <b>이름</b><br> <input type="text" name ="userid" value="<%=vo.getUserid() %>" readonly> <br>
	 <!-- name 부분은 다 똑같이 작성해야 하므로 작성시 항상 꼼꼼히 신경쓸것!(대소문자 주의!) -->
	 <b>비밀번호</b><br> <input type="password" name ="password" required> <br>
	 <b>이메일</b><br> <input type="email" name ="email" required> <br>
	 
	 <br><b>이메일 수신여부</b><br> 
	 <input type="radio" name ="emailAgree" value="yes"required>예
	 <input type="radio" name ="emailAgree" value="no"required> 아니오<br>
	 
	 <br><b>관심사항</b><br>
	 <input type="checkbox" name="interest" value="영화"required>영화
	 <input type="checkbox" name="interest" value="music"required>음악
	 <input type="checkbox" name="interest" value="webtoon"required>웹툰<br>
	 <input type="checkbox" name="interest" value="game"required>게임
	 <input type="checkbox" name="interest" value="sport"required>운동<br>
	 
	 <br><b>핸드폰</b><br> <input type="text" name ="phone"required> <br>
	 <b>자기소개</b><br> <textarea rows="10" cols="60" name="introduce"></textarea> <br>
	 <br><input type="submit" value="전송">
	 
	 </form>
	 
	
	 
</body>


</html>






