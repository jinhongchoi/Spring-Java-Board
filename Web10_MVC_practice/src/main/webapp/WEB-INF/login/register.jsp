<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

		<h1>회원 가입 페이지</h1>
	
	 <form action="register.go" method="post">	 
	 <b>ID</b><br> <input type="text" name ="userid" id="userid" required> <br>
	 <button onclick="idcheck()">중복확인</button><br>
	 
	 <!-- name 부분은 다 똑같이 작성해야 하므로 작성시 항상 꼼꼼히 신경쓸것!(대소문자 주의!) -->
	 <b>비밀번호</b><br> <input type="password" name ="password"required> <br>
	 <b>이메일</b><br> <input type="email" name ="email"required> <br>
	 
	 <br><b>이메일 수신여부</b><br> 
	 <input type="radio" name ="emailAgree" value="yes"required>예
	 <input type="radio" name ="emailAgree" value="no"required> 아니오<br>
	 
	 <br><b>관심사항</b><br>
	 <input type="checkbox" name="interest" value="영화">영화
	 <input type="checkbox" name="interest" value="music">음악
	 <input type="checkbox" name="interest" value="webtoon">웹툰<br>
	 <input type="checkbox" name="interest" value="game">게임
	 <input type="checkbox" name="interest" value="sport">운동<br>
	 
	 <br><b>핸드폰</b><br> <input type="text" name ="phone"required> <br>
	 <b>자기소개</b><br> <textarea rows="10" cols="60" name="introduce"required></textarea> <br>
	 <br><input type="submit" value="전송">
	 

	 </form>

</body>
</html>