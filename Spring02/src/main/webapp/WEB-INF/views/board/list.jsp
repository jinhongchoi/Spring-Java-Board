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
<title>게시판 메인 페이지</title>
</head>
<body>
		<div>
	
		<h1>자유게시판</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./freeBoardInsert.ino">글쓰기</a>
	</div>
	<hr style="width: 600px;">
	<div style="padding-bottom: 10px;">
		<table border="1">
			<thead>
				<tr>
					<td style="width: 55px; padding-left: 30px;" align="center">타입</td>
					<td style="width: 50px; padding-left: 10px;" align="center">글번호</td>
					<td style="width: 125px;" align="center">글제목</td>
					<td style="width: 48px; padding-left: 50px;" align="center">글쓴이</td>
					<td style="width: 100px; padding-left: 95px;" align="center">작성일시</td>
				</tr>
			</thead>
		</table>
	</div>
	<hr style="width: 600px;">

	<div>
		<table border="1">
			<tbody id="tb" name="tb">
					<c:forEach var="dto" items="${freeBoardList }">
						<tr>
							<td style="width: 55px; padding-left: 30px;" align="center">${dto.codeType }</td>
							<td style="width: 50px; padding-left: 10px;" align="center">${dto.num }</td>
							<td style="width: 125px; "" align="center"><a href="./freeBoardDetail.ino?num=${dto.num }">${dto.title }</a></td>
							<td style="width: 48px; padding-left: 50px;" align="center">${dto.name }</td>
							<td style="width: 100px; padding-left: 95px;" align="center">${dto.regdate }</td>
						<tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	
	<%-- <!-- 페이징 처리 밑에 태그 나오게~  -->
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
 --%>

</body>
</html>








