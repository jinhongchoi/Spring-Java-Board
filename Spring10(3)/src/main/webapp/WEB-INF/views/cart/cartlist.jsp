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
/* ========기본 설정==============  */
body{

font-family: NanumSquareNeo;
}

table{
	text-align: center;
	margin-left:auto; 
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

/*===========수정 삭제 설정==================  */

.UD{
	text-align: center;
	margin-left: 550px;
}

/*=========== 이미지 포인트 효과 설정==================  */

.img1:hover { background-color: #dcdcdc; }

</style>



<body>

	<%@ include file ="../header.jspf" %>
	
	<div class="Title">
	<h1>장바구니 확인</h1>
	</div>
	
	<div style="text-align: center;">
		<div id ="carts"></div>	
	</div>
		
	
	<c:choose>
		
		<c:when test="${map.count ==0 }">
			장바구니가 비었습니다.
		</c:when>
		
		<c:otherwise>
		<form name="form1" id="form1" method="post" action="../cart/update">
			<table border="1" style="border: 1px solid #aaaaaa;">
				<tr>
					<th>상품명</th>
					<th>상품 이미지</th>
					<th>단가</th>
					<th>수량</th>
					<th>금액</th>
					<th>취소</th>
				</tr>
				
				<c:forEach var="vo" items="${map.list }" varStatus="i">
				<tr class="img1">
					<td>
						${vo.productName }
					</td>
					<td >
						<img src="display?fileName=/${vo.productUrl }" width="200px" height="150px" >
					</td>
					<td style="width: 80px" align="center">
						<fmt:formatNumber pattern="###,###,###" value="${vo.productPrice}"/>
					</td>
					<td>
						<input type="number" style="width: 40px" name="amount" value="${vo.amount}" min="1">
						<input type="hidden" name ="productId" value="${vo.productId }">
					</td>
					<td style="width: 100px" align="center">
						<fmt:formatNumber pattern="###,###,###" value="${vo.money}"/>
					</td>
					<td>						
						<input type="submit" value="삭제" formaction="../cart/delete?cartId=${vo.cartId }" class="btn-3d red" style="margin-left: 10px;">												
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
					<td colspan="5" align="center">
						장바구니 금액 합계:<fmt:formatNumber pattern="###,###,###" value="${map.sumMoney }"/><br>
							
					</td>
				</tr>
			</table>
			<br>
			<br>
			<div class="UD">
			<input type="hidden" name="count" value="${map.count }">
			<button type="submit" id="btnUpdate" class="btn-3d red" style="margin-right: 40px;">수정</button>
			</div>
		</form>
		</c:otherwise>
	</c:choose>
	
	<br>
	<br>
	
	<div class="UD">
	<button type="submit" id="btn_list" class="btn-3d red" style="margin-left: 100px;">상품목록</button>
	<button type="submit" id="btn_pay" class="btn-3d red" style="margin-left: 50px;">구매하기</button>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@ include file ="../footer.jspf" %>
	
</body>
</html>








