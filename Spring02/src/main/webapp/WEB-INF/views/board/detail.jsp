<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>  

<!--c 태그는 JSTL 이므로 사용하려면 taglib 라이브러리가 필요! 위에 코드 갖다 쓴다!-->
  
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>${vo.boardTitle }</title>
</head>
<body>
	
	<!--앞에서 setattribute 였으니 getattribute 가져오는 것도 생각!   -->
	
	<h2>글 보기</h2>
		
		<div>
			<p>글 번호 : ${vo.boardId }</p>
		</div>
		
		<div>
			<p>제목 : ${vo.boardTitle }</p>
		</div>
		<div>
			<p>작성자 : ${vo.memberId }</p>
			<p>작성일 : ${vo.boardDateCreated }</p>
		</div>
		<div>
			<textarea rows="20" cols="120"readonly>${vo.boardContent }</textarea>			
		</div>
		<a href="list?page=${page }"><input type="button" value="글 목록"></a>
		<!-- 기존의 페이지로 돌아가게 하기 위해서 ${page }를 사용해준다 -->
		<a href="update?boardId=${vo.boardId }"><input type="button" value="글 수정"></a>
		<!-- "update.do?boardId=${vo.boardId }" 이런 형식으로 url을 작성하여 각 번호의 페이지로 이동할 수 있게 만든다!
			그럼 새로 페이지 만드는게 아닌 알아서 나눠지고 각 번호에 맞게 수정 가능할 수 있게 함!  -> 매개변수 개념이라고 생각!
			
			이런식으로 url작성 여러가지로 활용가능!!!
			 -->
		<form action="delete" method="POST">
			<input type="hidden" name="boardId" value= "${vo.boardId }">
			<input type= "submit" value ="글 삭제">
		</form>	
		

</body>
</html>







