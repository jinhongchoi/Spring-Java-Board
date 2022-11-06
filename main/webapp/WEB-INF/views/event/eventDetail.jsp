<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<!--c 태그는 JSTL 이므로 사용하려면 taglib 라이브러리가 필요! 위에 코드 갖다 쓴다!-->
  
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>이벤트 상세정보</title>
</head>
<body>
	
	<!--앞에서 setattribute 였으니 getattribute 가져오는 것도 생각!   -->
	

	<br>	
	<form action="eventdelete" method="POST">
			<input type="hidden" name="eventId" value= "${vo.eventId }">
			<input type= "submit" value ="이벤트 삭제">
	</form>	
	
	<br>
	<br>	
	<table border="1">
		<tr>
			<td>
				<img src="display?fileName=/${vo.eventUrl }" width="340px" height="300px">
			</td>
			<td>
				
				<table border="1" style="height: 300px; width: 400px">
					<tr align="center">				
						<td>이벤트 명</td>						
						<td>
						<input type="hidden" name ="eventName" value="${vo.eventName }">
						${vo.eventName }
						</td>
					</tr>
					<tr align="center">
						<td>할인 가격</td>
						<td><fmt:formatNumber value="${vo.eventPrice}" pattern="###,###,###"/></td>
					</tr>
					<tr align="center">
						<td>이벤트 내용</td>
						<td>${vo.eventDesc }</td>
					</tr>
					 <tr align="center">
						<td colspan="2">	
						<form name="form1" method="post" >									
								<input type="hidden" id ="eventPrice" value="${vo.eventPrice}">
						        <input type="hidden" id ="eventName" value="${vo.eventName }">				
								<input type="hidden" id ="eventId" value="${vo.eventId }">
		
								<button id="btn_ecart" value="쿠폰함에 담기" type="button">쿠폰함에 담기</button>
								<!--type="button" 을 넣지 않으면  
								Request method 'POST' not supported
								이런 에러가 뜬다!
								 -->						
						</form>
						<a type="button" href="../ecart/ecartlist">쿠폰함 목록</a>
						<a href="eventlist">이벤트 목록</a>
						</td>
					</tr> 
				</table>
			</td>
		
		</tr>
	</table>
	
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
		
		

</body>
</html>







