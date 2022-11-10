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

ul{
	list-style-type: none;
} /* 페이징 처리시 디자인  */

li{
	display: inline-block;
} /* 페이징 처리시 디자인  */
	
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>공지 페이지</title>
</head>
<body>
	<h1>공지 게시판</h1>
	
	<br>
	<a href="register"><input type="button" value="글작성"> </a>
	<!--버튼을 누르면 서버로가는 개념  -->
	<hr>
	<table>	
		<thead>
			<tr>
				<th style="width: 60px">번호</th>
				<th style="width: 700px">제목</th>
				<th style="width: 120px">작성자</th>
				<th style="width: 100px">작성일</th>
				<th style="width: 60px">댓글수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.boardId }</td>
					<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page }">${vo.boardTitle }</a></td>
					<!-- 눌렀을때 page값도 같이 넘기기 위해서!(가져온 페이지 값을 사용해 뒤로 갔을때 보던 페이지가 뜨게 하기 위해)  -->
					<td>${vo.memberId }</td>
					<fmt:formatDate value="${vo.boardDateCreated }"
					pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
					<td>${boardDateCreated }</td>
					<!--fmt 를 통해서 값이 들어가고 format에 맞춰서 boardDateCreated로 출력됨  -->
					
					<td>${vo.replyCnt }</td>
					<!--EL 부분 공부할 것! -> list 나 배열같은 집합객체 사용시 접근 방법을 제공 -->
										
				</tr>				
			</c:forEach>
		</tbody>		
	</table>
	
	<!-- 페이징 처리 밑에 태그 나오게~  -->
	<ul>
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


</body>
</html>








