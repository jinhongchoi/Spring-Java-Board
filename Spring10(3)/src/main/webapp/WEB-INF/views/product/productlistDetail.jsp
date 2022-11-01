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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<meta charset="UTF-8">
<title>상품 목록</title>



</head>
<body>

	<div class="Title">
	<h3>상품 목록</h3>	
	
	</div>
	<br>	
	
	<script type="text/javascript">
	var para = document.location.href.split("?");
	console.log(para);	
	</script>
	
	<hr>
		

		<br>
		<div class="shop">
		<c:forEach var="vo" items="${listProduct }" >
		<c:if test="${vo.productCate eq '팝콘' }" >
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
		
		<br>
		</div>
		
		
        <br>
			
		<div class="shop">
		<c:forEach var="vo" items="${listProduct }" >
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
		

        <br>
		<div class="shop">
		<c:forEach var="vo" items="${listProduct }" >
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




