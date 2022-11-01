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
		$('#btnList').click(function () {
			location.href="../product/productlist";
		});
	});
	
</script>

</head>
<body>
	<h1>장바구니 확인</h1>
	
	<c:choose>
		<c:when test="${map.count ==0 }">
			장바구니가 비었습니다.
		</c:when>
		<c:otherwise>
		<form name="form1" id="form1" method="post" action="cart/update">
			<table border="1">
				<tr>
					<th>상품명</th>
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
						<a>삭제</a>
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
	<button type="submit" id="btnList">상품목록</button>
</body>
</html>








