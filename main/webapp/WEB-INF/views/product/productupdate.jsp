<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>
</head>
<body>
	<h2>글 수정 페이지</h2>
	<form action="productupdate" method="POST" enctype="multipart/form-data">
	
		<div>
			<p>글 번호: ${vo.productId }</p>
			<input type= "hidden" name="productId" value="${vo.productId }" required>
			
			<!--hidden을 사용하면 디자인적으로 textfield 를 감출수 있으면서 데이터는 얻어서 보낼 수 있다!  -->
			
		</div>
		<div>
			<p>상품 카테고리</p>
			<input type="radio" name="productCate" value="팝콘">팝콘
			<input type="radio" name="productCate" value="음료">음료
			<input type="radio" name="productCate" value="스낵">스낵
		</div>
		
		<div>
			<p>상품명: </p>
			<input type= "text" name="productName" value="${vo.productName }" required>
		</div>
		<div>
			<p>상품 가격</p>
			<input type= "text" name="productPrice" value="${vo.productPrice }" required>					
		</div>
		
		<div>
			<p>상품 내용: </p>
			<textarea rows="20" cols="120" name="productDesc" placeholder="상품 내용 입력" required></textarea>
			
		</div>
		
		<h2>상품 이미지 파일 업로드</h2>		
		<!--enctype="multipart/form-data" // 파일 넣을시 encording 타입을 의미함! 이게 있어야 업로드가 가능!  -->
		<input type="file" name ="files">
		
		<br>
		<div>	
			<input type="submit" value="수정">		
		</div>
		
	</form>
	
	
</body>
</html>