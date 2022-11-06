<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 내용 수정 페이지</title>
</head>
<body>
	<h2>이벤트 내용 수정 페이지</h2>
	<form action="eventupdate" method="POST" enctype="multipart/form-data">
	
		<div>
			<p>이벤트 번호: ${vo.eventId }</p>
			<input type= "hidden" name="eventId" value="${vo.eventId }" required>
			
			<!--hidden을 사용하면 디자인적으로 textfield 를 감출수 있으면서 데이터는 얻어서 보낼 수 있다!  -->
			
		</div>
			
		<div>
			<p>이벤트명: </p>
			<input type= "text" name="eventName" value="${vo.eventName }" required>
		</div>
		<div>
			<p>할인 가격</p>
			<input type= "text" name="eventPrice" value="${vo.eventPrice }" required>					
		</div>
		
		<div>
			<p>이벤트 내용: </p>
			<textarea rows="20" cols="120" name="eventDesc" placeholder="이벤트 내용 입력" required></textarea>
			
		</div>
		
		<h2>이벤트 이미지 파일 업로드</h2>		
		<!--enctype="multipart/form-data" // 파일 넣을시 encording 타입을 의미함! 이게 있어야 업로드가 가능!  -->
		<input type="file" name ="files">
		
		<br>
		<div>	
			<input type="submit" value="수정">		
		</div>
		
	</form>
	
	
</body>
</html>