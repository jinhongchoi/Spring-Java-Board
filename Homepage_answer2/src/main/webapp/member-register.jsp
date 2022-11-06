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

button:hover {
  background: hotpink;
  
}

button {
	margin: 5px;
       
    background-color: #03C75B;
    border: 1px solid #0CBF57;
    position: relative;
    width: 450px;
    height: 55px;
    font-weight: bold;
    color: white;
    font-size: 18px;
    margin-bottom: 20px;
}


</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
<script type="text/javascript">
function idcheck(){
	 var userid = document.getElementById("userid").value;
	 if(userid.length==0 && userid==""){
		 alert("ID를 입력해주세요!")
		 return;
	 }
	 console.log(userid);

	 var url = "confirmid.jsp?userid=" + userid;
	 window.open(url,"","height = 200, width = 300");
	}
</script>


<body>
	
	<%
		//TODO : 회원가입 form action= "register.do"
	%>
	
	
	<h1>회원 가입 페이지</h1>
	
	 <form action="register.do" method="post">	 
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