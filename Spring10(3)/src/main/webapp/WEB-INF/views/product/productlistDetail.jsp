<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

/*===========기본 설정==================  */

body{
margin: 0;
font-family: NanumSquareNeo;
}

@font-face {
    font-family: 'NanumSquareNeo';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2') format('woff2');    
}

table, th, td{
	border-style: solid;
	border-width: 1px;
	text-align: center;
	
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

/*===========타이틀  설정==================  */

.Title{
  margin: 0;
  padding: 0;
  font-size:20px;  
  margin-left: 550px;
  margin-right: 350px;
  text-decoration: none;/*a href 밑줄 등 글자 꾸밈 없음*/
  padding-top: 50px; 
}

/* ============== 상품 나열 효과============= */

.shop{
  font-size:15px;    
  font-weight: 580;
  margin-left: 500px;
}

.drink{
  display: inline-flex;
  justify-content: right;  
  padding-top:60px;
  padding-bottom: 60px;
  margin-right: 180px;
   
}

/* ==============class="b" 상품 이미지 효과============= */
.b img {
  transition: all 0.2s linear;
}
.b:hover img {
  transform: scale(1.4);
}

.b {
  width: 154px;
  margin: 0px auto; 
  overflow: hidden;
  border-radius: 10px;
}

/*=========== 배경색상==================  */
.container{
	background-color: #F5F5F5;
}

	
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<meta charset="UTF-8">
<title>상품 목록</title>



</head>
<body>
	<%@ include file ="../header.jspf" %>
	
	<div class="Title">
	<h3>상품 목록</h3>		
	</div>
	<br>	
	
	<script type="text/javascript">
	var para = document.location.href.split("?");
	console.log(para);	
	</script>
	
	<hr style="margin: 0;">
		<div class="container">				
		<div class="shop">
		<c:forEach var="vo" items="${listProduct }" >
		<c:if test="${vo.productCate eq '팝콘' }" >
			<ol class="drink">
				<li style="list-style-type: none">
					<div class="b">  				              
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }"width="170px" height="170px" align="top">
					</a>
					</div>
			 		<br>
        			<a>
        			등록번호: ${vo.productId }
        	 		</a>
					<br>
					<br>
					상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>			 		
        			<br>
					<a> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
					</a>
        			<br>
        			<br>
        			<a> 상품 종류: ${vo.productCate }</a> 		
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
					<div class="b">			              
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="170px" height="170px" align="top">
					</a>
					</div>
			 		<br>
        			<a>
        			등록번호: ${vo.productId }
        	 		</a>
        	 		<br>
					<br>
					상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>			 		
        			<br>
					<a> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
					</a>
        			<br>
        			<br>
        			<a> 상품 종류: ${vo.productCate }</a>        	      					
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
					<div class="b"> 				              
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="170px" height="170px" align="top">
					</a>
					</div>
			 		<br>
        			<a>
        			등록번호: ${vo.productId }
        	 		</a>
        	 		<br>
					<br>
					상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>			 		 
        			<br>
					<a> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
					</a>
					<br>
        			<br>
        			<a> 상품 종류: ${vo.productCate }</a> 	
				</li> 
			</ol>
		</c:if>					
		</c:forEach>
		</div>
		</div>
	<%@ include file ="../footer.jspf" %>	
	
</body>
</html>




