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

table{
	text-align: center;
	margin: auto;	
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
  margin-left: 50%;
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
  margin-left: 40%;
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

/* ==============페이지 처리 효과============= */
.page{
	text-align: center;
}
	
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>공지 페이지</title>
</head>
<body>
	
	
	<div class="Title">
	<h1>공지 게시판</h1>
	</div>
	
	<br>
	
	<a href="register" class="btn-3d red" style="margin-left: 30%;">글 작성</a>
		
	<br>
	<br>
	
	<div class= "search" style="margin-left: 30%;">
		<select name = "searchType" id="searchType">
    	 <option value="n">-----</option>
     	 <option value="boardTitle">제목</option>
     	 <option value="boardContent">내용</option>
   	 	 <option value="memberId">작성자</option>
		</select>
	
		<input type="text" name="keyword" id="keyword" />
		
		<button id="searchBtn" type="button">검색</button>
		
		<script type="text/javascript">
		  document.getElementById("searchBtn").onclick = function () {
		  var searchType = $('#searchType').val();
		  //var searchType = document.getElementsByName("searchType").value;
		  //자바스크립트에서 선언하고 값을 가져올때는 id로 선언한 것을 가져오고 위와 같이 표현해서 값을 가져올 것!
		  var keyword =  $('#keyword').val();
		  
		  console.log(searchType)
		  console.log(keyword)
		  location.href = "../board/list?" + "searchType=" + searchType + "&keyword=" + keyword;
		  
		  
		 };  
		 
			  
		</script>
		
	</div>		
	
	
	<br>
	<br>
	<table border="1" style="border: 1px solid #aaaaaa;" > 	
		<thead>
			<tr>
				<th style="width: 60px">번호</th>
				<th style="width: 50px">제목</th>
				<th style="width: 500px">내용</th>
				<th style="width: 120px">작성자</th>
				<th style="width: 120px">작성일</th>
			</tr>
		</thead>
		<tbody id = tblresult>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.boardId }</td>
					<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page }">${vo.boardTitle }</a></td>
					<!-- 눌렀을때 page값도 같이 넘기기 위해서!(가져온 페이지 값을 사용해 뒤로 갔을때 보던 페이지가 뜨게 하기 위해)  -->
					<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page }">${vo.boardContent }</a></td>
					
					<td>${vo.memberId }</td>
					<fmt:formatDate value="${vo.boardDateCreated }"
					pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
					<td>${boardDateCreated }</td>
					<!--fmt 를 통해서 값이 들어가고 format에 맞춰서 boardDateCreated로 출력됨  -->							
				</tr>				
			</c:forEach>
		</tbody>		
	</table>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<!-- 페이징 처리 밑에 태그 나오게~  -->
 	<ul class="page">
		<c:if test="${pageMaker.hasPrev }">
		<li><a href="list?page=${pageMaker.startPageNo-1 }">이전</a></li>		
		</c:if>
		
		<c:forEach var= "num" begin="${pageMaker.startPageNo}" end="${pageMaker.endPageNo}">			
		<li><a href="list?page=${num }">${num }</a></li>
		<!-- c:forEach에서 var 는 꼭 필요한 속성! 변수명을 의미! 그리고 다른데다가 이걸 갖다 쓴다!  -->
		
		</c:forEach>
		<c:if test="${pageMaker.hasNext }">
		<li><a href="list?page=${pageMaker.endPageNo+1 }">다음</a></li>		
		</c:if>
	</ul>
	
	
	<!-- BoardController -> registerPOST() 에서 보낸 데이터 저장 --> 
	<input type="hidden" id ="insertAlert" value="${insert_result}">
	
	<script type="text/javascript">
		var result = $('#insertAlert').val();
		if(result=='success'){
			alert('새 글 작성 성공!');
		}
	</script>
	
	<input type="hidden" id ="deleteAlert" value="${delete_result}">
	
	<script type="text/javascript">
		var result = $('#deleteAlert').val();
		if(result=='success'){
			alert('글 삭제 성공!');
		}
	</script>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	


</body>
</html>








