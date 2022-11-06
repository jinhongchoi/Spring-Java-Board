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
  margin-left: 120px;
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

ul{
	list-style-type: none;
	text-align: center;
} /* 페이징 처리시 디자인  */

li{
	display: inline-block;
} /* 페이징 처리시 디자인  */

a {
  text-decoration: none;
  active-color { color:#000; }
}

.product{
	float: right;
	margin-right: 250px; 
}
	
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script><meta charset="UTF-8">
<script>
$("a").click(function() {
    toggleClass(".active-color");
});
</script>

<title>이벤트 페이지</title>
</head>


<body>

	<div class="Title">
	<h3>이벤트 목록</h3>	
	<h3><a href="../product/productlist" class="product" style="color: black">상품 목록</a></h3>
	
	<a href="eventregister"><input type="button" value="이벤트 등록하기"></a>
	
	</div>
	<br>	
	<hr>
		<strong class="Title">
                   이벤트      
        </strong>
                
		<!-- <a href="productlistDetail?productCate=팝콘 "><input type="button" value="더보기"></a>	 -->	              
           
		<br>
		<div class="shop">
		<c:forEach var="vo" items="${listEvent }" >
		
			<ol class="drink">
				<li style="list-style-type: none" >  
					<a href="eventDetail?eventId=${vo.eventId }&page=${pageMaker.criteria.page }">
						<img src="display?fileName=/${vo.eventUrl }" width="120px" height="110px" align="top">
					</a>
			 		<br>
        			<strong>
        			등록번호: ${vo.eventId }
        	 		</strong>
					<br>
					<strong>이벤트명: <a href="eventDetail?eventId=${vo.eventId }&page=${pageMaker.criteria.page }">${vo.eventName }</a>
			 		</strong> 
        			<br>
					<Strong> 할인 가격: <fmt:formatNumber value="${vo.eventPrice}" pattern="###,###,###"/>
					</Strong>
        			<br>        			  	      			
		
				</li> 
			</ol>
			
		</c:forEach>
		
		<br>
		</div>
		
			<!-- 페이징 처리 밑에 태그 나오게~  -->
	<ul>
		<c:if test="${pageMaker.hasPrev }">
		<li><a href="eventlist?page=${pageMaker.startPageNo-1 }">이전</a></li>		
		</c:if>
		
		<c:forEach var= "num" begin="${pageMaker.startPageNo}" end="${pageMaker.endPageNo}">			
		<li><a href="eventlist?page=${num }">${num }</a></li>
		<!-- c:forEach에서 var 는 꼭 필요한 속성! 변수명을 의미! 그리고 다른데다가 이걸 갖다 쓴다!  -->
		
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
		<li><a href="eventlist?page=${pageMaker.endPageNo+1 }">다음</a></li>		
		</c:if>
	</ul>

</body>
</html>










