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
margin: 0;
font-family: NanumSquareNeo;
}

table{
	text-align: center;
	margin-left:auto; 
    margin-right:auto;	
}

th, td{

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

/*=========== 전체 설정==================  */
.total{
	text-align: center;
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

.UD:hover{
	background-color: #C24032;
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
<title>상품 상세정보</title>
</head>
<body>

	<%@ include file ="../header.jspf" %>
	
	<!--앞에서 setattribute 였으니 getattribute 가져오는 것도 생각!   -->
	<div class="Title">
	<h2>상품 상세정보</h2>
	</div>
	<hr width="45%" style="margin-left: 550px">
	
	
	<div class="total">
	<ul>
	<li>
	<a href="productupdate?productId=${vo.productId }" class="UD"><input type="button" value="상품 수정"></a>
	</li>
	<li>
	<form action="productdelete" method="POST" class="UD">
			<input type="hidden" name="productId" value= "${vo.productId }">
			<input type= "submit" value ="상품 삭제">
	</form>
	</li>
	</ul>	
	
	<br>
	<br>	
	
	<form name="form1" method="post" action="../cart/cartinsert">
	<table>
		<tr>
			<td>
				<img src="display?fileName=/${vo.productUrl }" width="340px" height="300px" style="margin-right: 50px;">
			</td>
			<td>
				<table style="height: 300px; width: 400px">
					<tr align="left">				
						<td>상품명</td>						
						<td>
						<input type="hidden" name ="productName" value="${vo.productName }">
						${vo.productName }
						</td>												
					</tr>					
					<tr align="left">
						<td>가격</td>
						<td><fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/></td>
					</tr>
					<tr align="left">
						<td>상품소개</td>
						<td>${vo.productDesc }</td>
					</tr>
					<tr align="left">
						<td colspan="2">						
								<input type="hidden" id ="money" value="${vo.productPrice}">		
								<input type="hidden" id ="productPrice" value="${vo.productPrice}">
						        <input type="hidden" id ="productName" value="${vo.productName }">				
								<input type="hidden" id ="productId" value="${vo.productId }">
								<select id  ="amount">
									<c:forEach begin="1" end="10" var="i" varStatus="status">
										console.log(status);
										console.log(status.count);
										console.log(2);
										<option value="${i }">${i }</option>
									</c:forEach>
								</select>&nbsp;개
								<input type="hidden" id ="amount" value="" >
								<button id="btn_cart" class="btn-3d red" value="장바구니에 담기" type="button" style="margin-left: 150px;">장바구니에 담기</button>																
								<!--type="button" 을 넣지 않으면  
								Request method 'POST' not supported
								이런 에러가 뜬다! -->						
						</td>
					</tr>
				</table>
			</td>
		
		</tr>
	</table>
		
	</form>
	<ul>
	<li>
	<a type="button" href="../cart/cartlist" class="btn-3d red">장바구니 목록</a>
	</li>
	<li>
	<a href="productlist" class="btn-3d red" style="margin-left: 50px;">상품목록</a>
	</li>
	</ul>
	
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
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@ include file ="../footer.jspf" %>	

</body>
</html>







