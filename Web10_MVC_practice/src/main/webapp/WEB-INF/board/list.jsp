<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>    
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

<meta charset="UTF-8">
<title>게시판 메인 페이지</title>

</head>
<body>

	<h1>게시판 메인</h1>
	
	<br>
	<c:if test="${empty sessionScope.memberId }">
		<a href= "login.go">로그인</a>
		<a href= "register.go">회원가입</a>	
	</c:if>
	
	<c:if test="${not empty sessionScope.memberId }">
		<p>${sessionScope.memberId }님, 환영합니다.</p>
		<a href= "logout.go">로그아웃</a>		
		<form action="delete.go" method="POST">
			<input type="hidden" name="memberId" value= "${sessionScope.memberId }">
			<input type="submit" value="회원탈퇴" >
		</form>	
	</c:if>
	<br>
	<br>
	<a href= "register.do"><input type="button" value ="글작성"> </a>
	
	<table>
		<thead>
		<tr>
			<th style="width: 60px">번호</th>
			<th style="width: 700px">제목</th>
			<th style="width: 120px">작성자</th>
			<th style="width: 100px">작성일</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.boardId }</td>
				<td><a href="detail.do?boardId=${vo.boardId }">${vo.boardTitle }</a> </td>
				<td>${vo.memberId }</td>
				<td>${vo.boardDateCreated }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<ul>
	<c:if test="${pageMaker.hasPrev }">
	<li><a href="list.do?page=${pageMaker.startPageNo-1 }">이전</a></li>
	</c:if>
	
	
	<c:forEach var= "num" begin="${pageMaker.startPageNo}" end="${pageMaker.endPageNo}">
	<li><a href="list.do?page=${num }">${num }</a> </li>
	
	</c:forEach>
	
	<c:if test="${pageMaker.hasNext }">
	<li><a href="list.do?page=${pageMaker.endPageNo+1 }">다음</a></li>
	</c:if>
	</ul>
	
</body>
</html>










