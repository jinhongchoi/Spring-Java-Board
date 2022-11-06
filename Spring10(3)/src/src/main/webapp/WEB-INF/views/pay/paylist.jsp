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


.orderInfo { border:5px solid #eee; padding:20px; display: none;}
.orderInfo .inputArea { margin:10px 0; }
.orderInfo .inputArea label { display:inline-block; width:120px; margin-right:10px; }
.orderInfo .inputArea input { font-size:14px; padding:5px; }
#userAddr2, #userAddr3 { width:250px; }

.orderInfo .inputArea:last-child { margin-top:30px; }
.orderInfo .inputArea button { font-size:20px; border:2px solid #ccc; padding:5px 10px; background:#fff; margin-right:20px;}

.orderOpen { float:left; width:45%; text-align:left; }
.orderOpen button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}

	
</style>



<body>
	<h1>결제목록 확인</h1>
	<button type="submit" id="btn_list">상품목록</button>
	<br>
	<br>
	
	<div style="text-align: center;">
		<div id ="carts"></div>	
	</div>
		
	
	<form name="form1" id="form1" method="post" action="../pay/payinsert" autocomplete="off"> <!-- autocomplete -> 자동완성기능 사용할지 여부  -->
	<c:choose>
		<c:when test="${map.count ==0 }">
			장바구니가 비었습니다.
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>상품명</th>
					<th>상품 이미지</th>
					<th>단가</th>
					<th>수량</th>
					<th>금액</th>
					
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
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						장바구니 금액 합계:<fmt:formatNumber pattern="###,###,###" value="${map.sumMoney }"/><br>
						<input type="hidden" name ="payPrice" value="${map.sumMoney }">	
					</td>
				</tr>
			</table>
			<input type="hidden" name="count" value="${map.count }">
			
		<%-- 	<table border="1">
				<tr>
					<th>상품명</th>
					<th>상품 이미지</th>
					<th>단가</th>
					<th>수량</th>
					<th>금액</th>
					
				</tr>
				
				<tr>
					<td>
						${map2.voName }
					</td>
					<td>
						<img src="display?fileName=/${map2.voUrl }" width="200px" height="150px">
					</td>
					<td style="width: 80px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${map2.voPrice}"/>
					</td>
					<td>
						<input type="number" style="width: 40px" name="amount" value="${map2.amount}" min="1">
						<input type="hidden" name ="productId" value="${map2.voId }">
					</td>
					<td style="width: 100px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${map2.voTotal}"/>
					</td>
				</tr>
				
				<tr>
					<td colspan="5" align="right">
						장바구니 금액 합계:<fmt:formatNumber pattern="###,###,###" value="${map.sumMoney }"/><br>
						<input type="hidden" name ="payPrice" value="${map.sumMoney }">	
					</td>
				</tr>
			</table> --%>
			
			
		</c:otherwise>
	</c:choose>
	
 	<br>
	<div class="orderOpen">
  		<button type="button" id="orderOpen_bnt" class="orderOpen_bnt">주문 정보 입력</button>  		
  		<script>
 			$(".orderOpen_bnt").click(function(){
  			$(".orderInfo").slideDown();
  			$(".orderOpen_bnt").slideUp();
 			});      
		</script>
 	</div>
 	<br>
 	<br>
	
	<div class="orderInfo" >
 		
    <c:forEach var="vo" items="${map.list }" begin="0" end="0">
  	<div class="inputArea" >
   		<label for="">수령인</label>
   		<input type="text" name="userName" id="userName" required="required"  value="${vo.userName}"/>
  	</div>
  
  	<div class="inputArea">
   		<label for="orderPhone">수령인 연락처</label>
   		<input type="text" name="userTell" id="userTell" required="required" />
  	</div>
  
  	<div class="inputArea">
   		<label for="userId">수령인 아이디</label>
   		<input type="text" name="userId" id="userId" readonly="readonly" value="${vo.userId}"/>
  	</div>  
  
  	<div class="inputArea">
   		<button type="submit" class="order_btn">주문</button>
   		<button type="button" class="cancel_btn">취소</button>    	
		
		<script>
			$(".cancel_btn").click(function(){
 			$(".orderInfo").slideUp();
 			$(".orderOpen_bnt").slideDown();
			});      
		</script>   		
  	</div>
  	</c:forEach>
	</div>
 	</form> 
	
	
	<!-- PayController -> registerPOST() 에서 보낸 데이터 저장  -> 아직 안되는중. --> 
	<input type="hidden" id ="insertAlert" value="${insert_result}">
	
	<script type="text/javascript">
		var result = $('#insertAlert').val();
		if(result=='success'){
			alert('결제 등록 성공!');
		}
	</script>
	
	
</body>
</html>








