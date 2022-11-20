<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->    
<!DOCTYPE html>
<html>
<head>



<style type="text/css">

body{
margin: 0;
font-family: NanumSquareNeo;
}

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





/* ==============이미지============= */
.image{
  font-size:40px;  
  margin-left: 550px;
  margin-right: 300px;	
  
}

/* ==============최상단 타이틀(event List , 결제목록 등등 페이지)============= */
.Title{  
 
  margin: 0;
  padding: 0;
  font-size:17px;  
  margin-left: 450px;
  margin-right: 350px;
  text-decoration: none;/*a href 밑줄 등 글자 꾸밈 없음*/
  
}


.Title a:after{
   display:block;/*a요소를 블록 요소라고 선언*/  
   content: '';/*content안은 밑줄 디자인을 위해 비워두세요.*/
   border-bottom: solid 2px gray;
   transform: scaleX(0);/*크기를 0으로 줌으로써 평상시엔 밑줄 없음*/
   transition: transform 250ms ease-in-out; /*변형 방식*/
}

.Title a:hover:after {
   transform: scaleX(1);/*a 속성에 hover시 after를 기존 크기로 변경*/  
   
}

.event{
	float: left;
	margin-left: 60px;	
}


/* ==============상품등록, 장바구니 버튼 효과============= */
input[type="button"]:hover {
  background: #FF88A7;  
}

/* ==============상품등록 밑으로 배경색============= 
	style 에다가 지정할땐 id가 아닌 class로 된부분을 적용해야 적용가능!
*/
.container{
	background-color: #F5F5F5;
}

/* ==============카테고리명 + 더보기 버튼 나열============= */
.Title2{
  font-size:25px;  
  margin-left: 508px;
  margin-right: 350px;
  font-weight: 580;
}

.plus {
  margin-left: 350px; 
  
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

/* ==============class=".btn-3d.red" 더보기 버튼 효과 ============== */
.btn-3d {
  position: relative;
  display: inline-block;
  font-size: 15px;
  padding: 5px 18px;
  color: white;
  margin: 10px 100px;
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

<script>
$("a").click(function() {
    toggleClass(".active-color");
});
</script>


<meta charset="UTF-8">
<title>상품 목록</title>

</head>
<body>
	<%@ include file ="header.jspf" %>
	
	<div class="image">
	<img alt="Image" src="http://img.cgv.co.kr/GiftStore/Display/PC/15468087168510.jpg" width="900" height="300"> 
	</div>
	<hr>
	
	<div class="Title">	
	<ul>
	<li>	
	<a href="../event/eventlist" class="event" style="color: gray;">EVENT LIST</a>
	</li>	
	<li>
	<a href="../pay/paylistDetail" class="event" style="color: gray">결제 목록</a>
	</li>	
	<li>
	<a href="../board/list" class="event" style="color: gray">공지 게시판</a>
	</li>		
	<li>
	<a href="productregister" class="event" style="color: gray">상품등록하기</a>
	</li>
	<li>
	<a href="../cart/cartlist"class="event" style="color: gray">장바구니로 가기</a>
	</li>
	</ul>
	</div>
		
	<hr style="margin: 0;">		
	<div class="container">
	<br>
	<br>
	<br>
	<div id="contents">
		<ul>
		<li>
		<a class="Title2">		
                  팝콘
        </a>        
        </li>
        <li>
        <div class="plus">        
		<a href="productlistDetail?productCate=팝콘 "><input type="button" class="btn-3d red" value="+"></a>		              
        </div>       
        </li>   
		</ul>
		
		<hr width="45%" style="margin-left: 550px">
				
		<div class="shop">		
		<c:forEach var="vo" items="${listProduct }" begin="0" end="2">
		<c:if test="${vo.productCate eq '팝콘' }" >		
			<ol class="drink">
				<li style="list-style-type: none" >  
					<div class="b">
					<a href="productDetail?productId=${vo.productId }">
					<img src="display?fileName=/${vo.productUrl }" width="170px" height="170px" align="top">
					</a>
					</div>
			 		<br>
        			<a style="font-weight: 550">
        			등록번호: ${vo.productId }
        	 		</a>
					<br>
					<br>			
					상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>			 		 
        			<br>
					<a style="font-weight: 550"> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
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
		<br>
		
		<ul>
		<li>
		<strong class="Title2">
        	음료        	
        </strong>
        </li>
        <li>
        <div class="plus">
		<a href="productlistDetail?productCate=음료 " class="btn_category_product"><input type="button" class="btn-3d red" value="+"></a>
		<!-- class="btn-3d.red" 위에는 이렇게 적었지만 실제로는 class="btn-3d red" 이렇게 적어야 적용된다! -->
		</div>
		</li>
      	</ul>		
      	
      	<hr width="45%" style="margin-left: 550px">
      	
		<div class="shop">		
		<c:forEach var="vo" items="${listProduct2 }" begin="0" end="2">
		<c:if test="${vo.productCate eq '음료' }" >
     	
			<ol class="drink">
				<li style="list-style-type: none">  
				    <div class="b">          
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="170px" height="170px" align="top">
					</a>
					</div>
			 		<br>
        			<a style="font-weight: 550">
        			등록번호: ${vo.productId }
        	 		</a>
					<br>
					<br>
					상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>			 		
        			<br>
					<a style="font-weight: 550"> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
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
		<br>
		
		<ul>
		<li>
		<strong class="Title2">
        	스낵       
        </strong>
        </li>
        <li>        
        <div class="plus">
        <a href="productlistDetail?productCate=스낵 " class="btn_category_product"><input type="button" class="btn-3d red" value="+"></a>
        </div>
        </li>       
        </ul>
        
        <hr width="45%" style="margin-left: 550px">
        
		<div class="shop">
		<c:forEach var="vo" items="${listProduct3 }" begin="0" end="2">
		<c:if test="${vo.productCate eq '스낵' }" >
		
			<ol class="drink">
				<li style="list-style-type: none">  
				    <div class="b">         
					<a href="productDetail?productId=${vo.productId }">
						<img src="display?fileName=/${vo.productUrl }" width="170px" height="170px" align="top">
					</a>
					</div>
			 		<br>
        			<a style="font-weight: 550">
        			등록번호: ${vo.productId }
        	 		</a>
					<br>
					<br>
					상품명: <a href="productDetail?productId=${vo.productId }">${vo.productName }</a>			 		 
        			<br>
					<a style="font-weight: 550"> 상품 가격: <fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/>
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
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
	
	
	<%@ include file ="footer.jspf" %>
	
</body>
</html>




