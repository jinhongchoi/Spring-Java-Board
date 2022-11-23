<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->    
<!DOCTYPE html>
<html>
<head>

<!--================================아임포트 결제 api ================================ -->
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>



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

<script type="text/javascript">
	$().ready(function(){
			
		$("#checkBoxBtn").click(function(){
			$("#selectForm").attr({
				"method" : "post",
				"action" : "../pay/paylist"
			});
			$("#selectForm").submit();
		});
	});
	
	
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

	<%@ include file ="../header.jspf" %>
	
	<div class="Title">
	<h1>결제목록 확인</h1>
	</div>
	
	<button type="submit" id="btn_list" class="btn-3d red" style="margin-left: 1100px;">상품목록</button>
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
						<input type="number" style="width: 40px" name="amount" value="${vo.amount}" min="1" disabled="disabled">
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
				<tr>				
					<td colspan="5" align="right">
					쿠폰 선택					
					<select name="beforeAuth" id="changeTest" onchange="selectBoxChange(this.value)">	
					<option id = "coupon" value="">쿠폰 선택</option>			
					<c:forEach items="${listcoupon}" var="listcoupon" >					
					<option id ="eventPrice" value="${listcoupon.eventPrice}" >${listcoupon.eventPrice}</option>																					
					</c:forEach>
					</select>				
					</td>						
				</tr>				
				<tr>
					<td id="totalPrice" colspan="5" align="right">	
					<!-- 스크립트 부분에서 계산후 값을 가져다 쓰고 싶으면 id를 지정할 것!
						그러면 계산된 값이 id에 맞게 들어간다! 
					 -->										
						결제 금액:<fmt:formatNumber pattern="###,###,###" value="${map.sumMoney }"/>																						
					</td>
				</tr>				
			</table>
			<input type="hidden" name="count" value="${map.count }">
			
			<script type="text/javascript">		
			
	
			</script>
						
		</c:otherwise>
	</c:choose>
	
 	<br>

	<br>
 	<!-- ========================================================================================= -->
<!-- 	<div class="orderOpen">
  		<button type="button" id="orderOpen_bnt" class="orderOpen_bnt">주문 정보 입력</button>  		
  		<script>
 			$(".orderOpen_bnt").click(function(){
  			$(".orderInfo").slideDown();
  			$(".orderOpen_bnt").slideUp();
 			});      
		</script>
 	</div> -->
 	<br>
 	<br>
	
	<div class="orderInfo" >
 		
    <c:forEach var="vo" items="${map.list }" begin="0" end="0">
  	<div class="inputArea" >
   		<label for="">수령인</label>
   		<input type="hidden" name ="userName" value="${vo.userName }">
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
	
	<!-- ================================아임포트 결제 api========================================= -->
	<script type="text/javascript">
	  var IMP = window.IMP; // 생략가능
	  IMP.init('imp17313560'); // <-- 본인 가맹점 식별코드 삽입
	</script>
	
	<button id="requestPay" onclick="requestPay()" class="btn-3d red" style="margin-left: 900px;">결제하기</button>

	<script>
	
	var selectBoxChange = function (value) {
	// console.log(value);
	var a = value;
	console.log(a);
	sum = ${map.sumMoney };
	$("#changeTest").val(value);
	var totalPrice = Number(sum - a);
	console.log(typeof totalPrice);
	console.log(totalPrice);
	$('#totalPrice').text(totalPrice);
	
	
	if(totalPrice >= 100){
		const target = document.getElementById('requestPay');
        target.disabled = false;
    }else{
        alert('결제 금액은 100원 이상이어야 합니다!');          
        const target = document.getElementById('requestPay');
        target.disabled = true;
        // 그냥 버튼에 활성화 /비활성화만 필요하기 때문에 따로 function 을 수행할 필요가 없다!
    }
	
	
	}
	
	function requestPay() {
  	IMP.init('imp17313560'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
  	IMP.request_pay({
    pg: "html5_inicis",
    pay_method: "card",
    merchant_uid : 'merchant_'+new Date().getTime(),
    name : '결제테스트',
    amount : $('#totalPrice').text(),
    buyer_email : 'iamport@siot.do',
    buyer_name : document.getElementById('userId').value,
    buyer_tel : document.getElementById('userTell').value,
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456'
  	}, function (rsp) { // callback
      if (rsp.success) { //결제 성공시
    	  //location.href = "../pay/paylistDetail"
          var msg = '결제가 완료되었습니다.';
      	  var productId = '${vo.productId }';
      	  var amount = '${vo.amount}';
      	  var userId = document.getElementById('userId').value;
      	  var userName =document.getElementById('userName').value;
      	  var productName = '${vo.productName }';
      	  var productUrl = '${vo.productUrl }';
      	  var productPrice = '${vo.productPrice}';
      	  var money = '${vo.money}';
      	  var obj= {
      			  'productId' : productId,
      			  'amount' : amount,
      			  'userId' : 1,
      			  'userName' : userName,
      			  'productName' : productName,
      			  'productUrl' : productUrl,
      			  'productPrice' : productPrice,
      			  'money' : money
      	  };
      	  console.log(obj);
         
    	  $.ajax({
    		  type: 'POST',
    		  url: '../pays',
				headers : {
					'Content-Type' : 'application/json',
					'X-HTTP-Method-Override' : 'POST'
				},
				data : JSON.stringify(obj), // JSON 으로 변환
				success : function (result, status) {
					console.log(result);
					console.log(status);
					if(result != 0){
						alert('결제 성공');	
						location.href = "../pay/paylistDetail"
					}
				}
    	  })
          
      } else {// 결제 실패시
          var msg = '결제에 실패하였습니다.';
          msg += '에러내용 : ' + rsp.error_msg;
          alert(msg);
      }
      alert(msg);
  	});
	}
</script>

	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@ include file ="../footer.jspf" %>
	
</body>
</html>








