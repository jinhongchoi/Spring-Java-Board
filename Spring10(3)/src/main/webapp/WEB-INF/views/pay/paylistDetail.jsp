<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
table, th, td{
	border-style: solid;
	border-width: 1px;
	text-align: center;
	
}
.addBtn{
	border-style: solid;
	border-width: 1px;
	text-align: center;
	display :inline-block;
	margin: auto;
}
input{
	margin-right: 10px;
}
.drink{
  display: inline-flex;
  justify-content: right;
  margin-left: 140px;
  margin-right: 40px;
  padding: 100px 100px 100px 100px; 
}
.shop{
  margin-left: 150px;
  margin-right: 150px;
}
.Title{
  font-size:40px;
  margin-left: 350px;
  margin-right: 150px;	
}
a {
  text-decoration: none;
  active-color { color:#000; }
}


ul{
	list-style-type: none;
	text-align: center;
} /* 페이징 처리시 디자인  */

li{
	display: inline-block;
} /* 페이징 처리시 디자인  */

.event{
	float: right;
	margin-right: 250px; 
}
	
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<script>
$("a").click(function() {
    toggleClass(".active-color");
});
</script>


<meta charset="UTF-8">
<title>결제 목록</title>

</head>
<body>

	<div class="Title">
	<h3>결제 목록</h3>
	<h3><a href="../product/productlist" class="event" style="color: black">상품 목록</a></h3>
	<br>
	<h3><a href="../event/eventlist" class="event" style="color: black">EVENT LIST</a></h3>		
		
	<a href="../product/productregister"><input type="button" value="상품등록하기"></a>
	<a href="../cart/cartlist"><input type="button" value="장바구니로 가기"> </a>
	</div>
	<br>	
	<hr>
	
	<table id="addList" border="1" style="margin-left: auto; margin-right: auto;">
		<tr>
			<th>주문번호</th>
			<th>상품명</th>
			<th>상품</th>
			<th>결제금액</th>
		</tr>
		<tbody id="listBody">
		<c:forEach items="${listPayDetail}" var="listPayDetail">
		
		<tr>
			<td>			
				${listPayDetail.payDetailNum }
			</td>
			<td>
				${listPayDetail.productName }
			</td>
			<td>
				<img src="display?fileName=/${listPayDetail.productUrl }" width="200px" height="150px">
			</td>
			<td>
				${listPayDetail.money }
			</td>
		</tr>		
		
		</c:forEach> 
        </tbody>
	</table>		
	
</body>


</html>





