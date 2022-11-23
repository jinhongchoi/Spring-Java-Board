<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->   
<!DOCTYPE html>
<html>
<head>


<style type="text/css">
/* ========기본 설정==============  */

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

/* ==============배경============= */
.container{
	background-color: #F5F5F5;
}


/* ==============카테고리명 + 더보기 버튼 나열============= */
.Title{
  font-size:25px;  
  margin-left: 540px;
  margin-right: 350px;
  font-weight: 580;
  
  
}

/* ==============class="b" 이벤트 이미지 효과============= */
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

/* ==============페이지 처리 효과============= */
.page{
	text-align: center;
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
	
	<%@ include file ="../header.jspf" %>
	
		
		<br>
		<br>
		<a class="Title">
                   이벤트      
        </a>        
        <a href="eventregister" class="event" style="color: gray; margin-left: 385px;"><input type="button" value="이벤트 등록하기" ></a>        
		<!-- <a href="productlistDetail?productCate=팝콘 "><input type="button" value="더보기"></a>	 -->	              
        <hr width="48%" style="margin-left: 550px; margin-bottom: 0; " >  
        <div class="container" style="margin: 0;"> 
		<br>
		<div class="shop">
		<c:forEach var="vo" items="${listEvent }" >
		
			<ol class="drink">
				<li style="list-style-type: none" >
				<div class="b">  
					<a href="eventDetail?eventId=${vo.eventId }&page=${pageMaker.criteria.page }">
						<img src="display?fileName=/${vo.eventUrl }" width="170px" height="170px" align="top" >
					</a>
				</div>	
			 		<br>
        			<a>
        			등록번호: ${vo.eventId }
        	 		</a>
					<br>
					<br>
					이벤트명: <a href="eventDetail?eventId=${vo.eventId }&page=${pageMaker.criteria.page }">${vo.eventName }</a>			 		 
        			<br>
					<a> 할인 가격: <fmt:formatNumber value="${vo.eventPrice}" pattern="###,###,###"/>
					</a>
        			<br>        			  	      			
		
				</li> 
			</ol>
			
		</c:forEach>
		<br>
		<br>
		<br>
		<br>
		<br>
		</div>
		
			<!-- 페이징 처리 밑에 태그 나오게~  -->
	<ul class="page">
		<c:if test="${pageMaker.hasPrev }">
		<li><a href="eventlist?page=${pageMaker.startPageNo-1 }">이전</a></li>		
		</c:if>
		
		<c:forEach var= "num" begin="${pageMaker.startPageNo}" end="${pageMaker.endPageNo}">			
		<li><a href="eventlist?page=${num }" style="padding-left: 10px;">${num }</a></li>
		<!-- c:forEach에서 var 는 꼭 필요한 속성! 변수명을 의미! 그리고 다른데다가 이걸 갖다 쓴다!  -->
		
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
		<li><a href="eventlist?page=${pageMaker.endPageNo+1 }">다음</a></li>		
		</c:if>
	</ul>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
	<%@ include file ="../footer.jspf" %>
		
	
</body>
</html>










