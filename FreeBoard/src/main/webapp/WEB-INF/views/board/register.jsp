<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/* ========기본 설정==============  */

body{
margin: 0;
font-family: NanumSquareNeo;
}

table{
	text-align: center;
	margin-left: 550px; 
    margin-right:auto;	
    border-collapse: collapse;
    border-radius: 16px;
}

input{
	margin-right: 10px;
}
.drink{
  display: inline-flex;
  justify-content: right;
  margin-left: 50px;
  margin-right: 40px;
  padding-right: 100px;
  
}
.shop{
  margin-left: 450px;
  margin-right: 250px;
}


@font-face {
    font-family: 'NanumSquareNeo';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2') format('woff2');
    
}

a {
  text-decoration: none;
  active-color { color:#000; }  
}

ul{
	list-style-type: none;
}

li{
	display: inline-block;	
} 

/*===========타이틀 설정==================  */

.Title{
  margin: 0;
  padding: 0;
  font-size:20px;  
  margin-left: 550px;
  margin-right: 350px;
  text-decoration: none;/*a href 밑줄 등 글자 꾸밈 없음*/
  padding-top: 50px; 
}

/* ==============class=".btn-3d.red" 버튼 효과 ============== */
.btn-3d {
  position: relative;
  display: inline-block;
  font-size: 10px;
  padding: 5px 18px;
  color: white;
  border-radius: 30px;
  text-align: center;
  transition: top .01s linear;
  text-shadow: 0 1px 0 rgba(0,0,0,0.15);
}
.btn-3d.red:hover    {background-color: #A52A2A;}
.btn-3d:active {
  top: 9px;
}
.btn-3d.red {
  background-color: #e74c3c;
  box-shadow: 0 0 0 1px #c63702 inset,
        0 0 0 2px rgba(255,255,255,0.15) inset,
        0 8px 0 0 #C24032,
        0 8px 0 1px rgba(0,0,0,0.4),
        0 8px 8px 1px rgba(0,0,0,0.5);
}
.btn-3d.red:active {
  box-shadow: 0 0 0 1px #c63702 inset,
        0 0 0 2px rgba(255,255,255,0.15) inset,
        0 0 0 1px rgba(0,0,0,0.4);
}

</style>

<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>

	
	<div class="Title">
	<h2>글 작성 페이지</h2>
	</div>
	
	<br>
	<br>
	
	<div style="margin-left:550px; ">
	<form action="register" method="POST">
		<div>
			<p>제목: </p>
			<input type= "text" name="boardTitle" placeholder= "제목 입력" required>
		</div>
		<div>
			<p>작성자: </p>
			<input type="text" name="memberId" value="test"readonly>
		</div>
		
		<div>
			<p>내용: </p>
			<textarea rows="20" cols="120" name="boardContent" placeholder="내용 입력" required></textarea>
			
		</div>
		
		<br>
		<br>
		
		<div>	
			<input type="submit" value="등록" class="btn-3d red">		
		</div>
		
	</form>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	

	
</body>
</html>