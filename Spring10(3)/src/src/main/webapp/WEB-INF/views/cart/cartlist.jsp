<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->    
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>상품장바구니 목록</title>
<script type="text/javascript">
	$(document).ready(function () {
		//리스트 페이지로 이동
		$('#btn_list').click(function () {
			location.href="../product/productlist";
		});// end btnList
			
	});//end document
	
	$(document).ready(function () {
		//리스트 페이지로 이동
		$('#btn_pay').click(function () {
			location.href="../pay/paylist";
		});// end btnList
			
	});//end document
	
</script>

</head>

<style type="text/css">
table, th, td{
	border-style: solid;
	border-width: 1px;
	text-align: center;
	
}
input{
	margin-right: 10px;
}
.drink{
  display: inline-flex;
  justify-content: right;
  margin-left: 40px;
  margin-right: 40px;
  padding: 100px 100px 100px 100px; 
}
.shop{
  margin-left: 150px;
  margin-right: 150px;
}
.Title{
  font-size:40px;
  margin-left: 250px;
  margin-right: 150px;	
}

ul{
	list-style-type: none;
	text-align: center;
} /* 페이징 처리시 디자인  */

li{
	display: inline-block;
} /* 페이징 처리시 디자인  */


</style>



<body>
	<h1>장바구니 확인</h1>
	
	<div style="text-align: center;">
		<div id ="carts"></div>	
	</div>
		
	
	<c:choose>
		<c:when test="${map.count ==0 }">
			장바구니가 비었습니다.
		</c:when>
		<c:otherwise>
		<form name="form1" id="form1" method="post" action="../cart/update">
			<table border="1">
				<tr>
					<th>상품명</th>
					<th>상품 이미지</th>
					<th>단가</th>
					<th>수량</th>
					<th>금액</th>
					<th>취소</th>
				</tr>
				<c:forEach var="vo" items="${map.list }" varStatus="i">
				<tr>
					<td>
						${vo.productName }
					</td>
					<td>
						<img src="display?fileName=/${vo.productUrl }" width="200px" height="150px">
					</td>
					<td style="width: 80px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${vo.productPrice}"/>
					</td>
					<td>
						<input type="number" style="width: 40px" name="amount" value="${vo.amount}" min="1">
						<input type="hidden" name ="productId" value="${vo.productId }">
					</td>
					<td style="width: 100px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${vo.money}"/>
					</td>
					<td>						
						<input type="submit" value="삭제" formaction="../cart/delete?cartId=${vo.cartId }">		
												
						<!--
						class vs id 차이
						여러가지 스타일링을 한꺼번에 적용해야 할 때는 클래스(class)를 사용하고, 한가지만 적용하고 싶다면 아이디(id)를 사용하면 된다.
						
						formaction -> formaction 속성을 사용하면 <form>태그의 action 속성은 선언하지 않아도 된다. 
						단지 여러개의 submit 버튼에 formaction 속성을 설정해 url을 넣어주는 것만으로도 각각의 주소로 요청을 보낼수 있다.
						get, post 방식 모두에서 잘 작동함!											
						  -->						
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						장바구니 금액 합계:<fmt:formatNumber pattern="###,###,###" value="${map.sumMoney }"/><br>
							
					</td>
				</tr>
			</table>
			<input type="hidden" name="count" value="${map.count }">
			<button type="submit" id="btnUpdate">수정</button>
		</form>
		</c:otherwise>
	</c:choose>
	<button type="submit" id="btn_list">상품목록</button>
	<button type="submit" id="btn_pay">구매하기</button>
	

	
</body>
</html>








