<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<!--c 태그는 JSTL 이므로 사용하려면 taglib 라이브러리가 필요! 위에 코드 갖다 쓴다!-->
  
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
	
/* ========기본 설정==============  */
body{

font-family: NanumSquareNeo;
}

table{
	text-align: center;
	margin-left:auto; 
    margin-right:auto;	
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

/*===========수정 삭제 설정==================  */

.UD{
	text-align: center;
	margin-left: 650px;
}

/* ==============class=".btn-3d.red" 장바구니 담기 버튼 효과 ============== */
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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>이벤트 상세정보</title>
</head>
<body>
	
	
	<%@ include file ="../header.jspf" %>
	
	
	<div class="Title">
	<h2>이벤트 상세정보</h2>
	</div>
	
	<hr width="45%" style="margin-left: 550px">
	
	<form action="eventdelete" method="POST" class="UD">
			<input type="hidden" name="eventId" value= "${vo.eventId }">
			<input type= "submit" value ="이벤트 삭제">
	</form>	
	
	<br>
	<br>	
	<table>
		<tr>
			<td>
				<img src="display?fileName=/${vo.eventUrl }" width="340px" height="300px" style="margin-right: 50px;">
			</td>
			<td>				
				<table style="height: 300px; width: 400px">
					<tr align="left">				
						<td>이벤트 명</td>						
						<td>
						<input type="hidden" name ="eventName" value="${vo.eventName }">
						${vo.eventName }
						</td>
					</tr>
					<tr align="left">
						<td>할인 가격</td>
						<td><fmt:formatNumber value="${vo.eventPrice}" pattern="###,###,###"/></td>
					</tr>
					<tr align="left">
						<td>이벤트 내용</td>
						<td>${vo.eventDesc }</td>
					</tr>
					 <tr align="left">
						<td colspan="2">	
						<form name="form1" method="post" >									
								<input type="hidden" id ="eventPrice" value="${vo.eventPrice}">
						        <input type="hidden" id ="eventName" value="${vo.eventName }">				
								<input type="hidden" id ="eventId" value="${vo.eventId }">
		
								<button id="btn_ecart" class="btn-3d red" value="쿠폰함에 담기" type="button">쿠폰함에 담기</button>
								<!--type="button" 을 넣지 않으면  
								Request method 'POST' not supported
								이런 에러가 뜬다!
								 -->						
						</form>

						</td>
					</tr> 
				</table>
			</td>		
		</tr>
	</table>
	<br>
	<br>
	<ul style="text-align: center;">
	<li>
	<a type="button" href="../ecart/ecartlist" class="btn-3d red">쿠폰함 목록</a>
	</li>
	<li>
	<a href="eventlist" class="btn-3d red" style="margin-left: 50px;">이벤트 목록</a>
	</li>
	</ul>
	
	
	<script type="text/javascript">
		
	$(document).ready(function () {
				
		$('#btn_ecart').click(function () {
			var userId = 1; 
			var userName = 100;
			var eventId = $('#eventId').val();
			var eventName = $('#eventName').val();
			var eventPrice = $('#eventPrice').val();
				
			var obj = {
					'userId' : userId,
					'userName' : userName,
					'eventId' : eventId,
					'eventName' : eventName,
					'eventPrice' : eventPrice
			};				
			console.log(obj);
			
			// $.ajax로 송수신
			$.ajax({
				type: 'POST',
				url: '../ecarts',
				headers : {
					'Content-Type' : 'application/json',
					'X-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify(obj), // JSON 으로 변환
				success : function (result, status) {
					console.log(result);
					console.log(status);
					if(result == 1){
						alert('쿠폰함에 담기 성공');						
					}else{
						alert('이미 존재하는 쿠폰입니다.');
					}
				}
			}); //end ajax
		}); //end btn_ecart() 
	});//end document
		
	</script>
	
	<br>
	<br>
	<br>
	<br>
	<br>	
	<%@ include file ="../footer.jspf" %>	

</body>
</html>







