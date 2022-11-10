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
input{
	margin-right: 10px;
}
.drink{
  display: inline-flex;
  justify-content: right;
  margin-left: 110px;
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
<title>상품 목록</title>

</head>
<body>

	<div class="Title">
	<h3>상품목록</h3>
	<h3><a href="../event/eventlist" class="event" style="color: black">EVENT LIST</a></h3>
	<br>
	<h3><a href="../pay/paylistDetail" class="event" style="color: black">결제 목록</a></h3>
	<br>
	<h3><a href="../board/list" class="event" style="color: black">공지 게시판</a></h3>		
		
	<a href="productregister"><input type="button" value="상품등록하기"></a>
	<a href="../cart/cartlist"><input type="button" value="장바구니로 가기"> </a>
	</div>
	<br>	
	<hr>
		<strong class="Title">
                  팝콘        
        </strong>
                
		<a href="productlistDetail?productCate=팝콘 "><input type="button" value="더보기"></a>		              
           
		<br>
		<div class="shop">
		
		<c:forEach var="vo" items="${listProduct }" begin="0" end="2">
		<c:if test="${vo.productCate eq '팝콘' }" >
		
			<ol class="drink">
				<li style="list-style-type: none" >  
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="120px" height="110px" align="top">
					</a>
			 		<br>
        			<strong>
        			등록번호: ${vo.productId }
        	 		</strong>
					<br>
					<strong>상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>
			 		</strong> 
        			<br>
					<Strong> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
					</Strong>
        			<br>
        			<Strong> 상품 종류: ${vo.productCate }</Strong>		
				</li> 
			</ol>	
		</c:if>
		
		</c:forEach>
	
		<br>
		</div>
		
		<strong class="Title">
        	음료        	
        </strong>
		<a href="productlistDetail?productCate=음료 "><input type="button" value="더보기"></a>
        <br>
		
			
		<div class="shop">
		
		<c:forEach var="vo" items="${listProduct2 }" begin="0" end="2">
		<c:if test="${vo.productCate eq '음료' }" >
     	
			<ol class="drink">
				<li style="list-style-type: none">  
				              
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="120px" height="110px" align="top">
					</a>
			 		<br>
        			<strong>
        			등록번호: ${vo.productId }
        	 		</strong>
					<br>
					<strong>상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>
			 		</strong> 
        			<br>
					<Strong> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
					</Strong>
        			<br>
        			<Strong> 상품 종류: ${vo.productCate }</Strong> 
        	      					
				</li> 
			</ol>
			
		</c:if>		
					
		</c:forEach>
		</div>
		<br>
		
		<strong class="Title">
        	스낵       
        </strong>        
        <a href="productlistDetail?productCate=스낵 "><input type="button" value="더보기"></a>
        <br>
        
		<div class="shop">
		<c:forEach var="vo" items="${listProduct3 }" begin="0" end="2">
		<c:if test="${vo.productCate eq '스낵' }" >
		
			<ol class="drink">
				<li style="list-style-type: none">  
				              
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="120px" height="110px" align="top">
					</a>
			 		<br>
        			<strong>
        			등록번호: ${vo.productId }
        	 		</strong>
					<br>
					<strong>상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>
			 		</strong> 
        			<br>
					<Strong> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
					</Strong>
        			<br>
        			<Strong> 상품 종류: ${vo.productCate }</Strong>         	      			
		
				</li> 
			</ol>
		</c:if>		
					
		</c:forEach>
		</div>
	
	
</body>
</html>

<!-- 
<input type="hidden" id ="deleteAlert" value="${delete_result}">
		
	<script type="text/javascript">
		var result = $('#deleteAlert').val();
		if(result=='success'){
			alert('글 삭제 성공!');
		}
	</script>

 -->



