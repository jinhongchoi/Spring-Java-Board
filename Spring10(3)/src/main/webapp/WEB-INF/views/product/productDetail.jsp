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
<title>상품 상세정보</title>
</head>
<body>
	
	<!--앞에서 setattribute 였으니 getattribute 가져오는 것도 생각!   -->
	
	<h2>상품 상세정보</h2>
	<a href="productupdate?productId=${vo.productId }"><input type="button" value="상품 수정"></a>
	<form action="productdelete" method="POST">
			<input type="hidden" name="productId" value= "${vo.productId }">
			<input type= "submit" value ="상품 삭제">
	</form>	
	
	<br>
	<br>	
	<table border="1">
		<tr>
			<td>
				<img src="display?fileName=/${vo.productUrl }" width="340px" height="300px">
			</td>
			<td>
				
				<table border="1" style="height: 300px; width: 400px">
					<tr align="center">				
						<td>상품명</td>						
						<td>
						<input type="hidden" name ="productName" value="${vo.productName }">
						${vo.productName }
						</td>
					</tr>
					<tr align="center">
						<td>가격</td>
						<td><fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/></td>
					</tr>
					<tr align="center">
						<td>상품소개</td>
						<td>${vo.productDesc }</td>
					</tr>
					<tr align="center">
						<td colspan="2">	
						<form name="form1" method="post" action = "/carts">
								<input type="hidden" id ="money" value="${vo.productPrice}">		
								<input type="hidden" id ="productPrice" value="${vo.productPrice}">
						        <input type="hidden" id ="productName" value="${vo.productName }">				
								<input type="hidden" id ="productId" value="${vo.productId }">
								<select id  ="amount">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>&nbsp;개
								<button id="btn_cart" value="장바구니에 담기">장바구니에 담기</button>						
						</form>
						<a type="button" href="carts/cartlist">장바구니 목록</a>
						<a href="productlist">상품목록</a>
						</td>
					</tr>
				</table>
			</td>
		
		</tr>
	</table>
	
	<script type="text/javascript">
		
	$(document).ready(function () {
				
		$('#btn_cart').click(function () {
			var userId = 1; 
			var userName = 100;
			var productId = $('#productId').val();
			var productName = $('#productName').val();
			var productPrice = $('#productPrice').val();
			var amount = $('#amount').val();
			var money = $('#productPrice').val();
			
			var obj = {
					'userId' : userId,
					'userName' : userName,
					'productId' : productId,
					'productName' : productName,
					'productPrice' : productPrice,
					'amount' : amount,
					'money' : money
			};				
			console.log(obj);
			
			// $.ajax로 송수신
			$.ajax({
				type: 'POST',
				url: '../carts',
				headers : {
					'Content-Type' : 'application/json',
					'X-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify(obj), // JSON 으로 변환
				success : function (result, status) {
					console.log(result);
					console.log(status);
					if(result == 1){
						alert('장바구니에 담기 성공');
						
					}
				}
			}); //end ajax
		}); //end btn_add.click() 
	});//end document
		
	</script>
		
		

</body>
</html>







