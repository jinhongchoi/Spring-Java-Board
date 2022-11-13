<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!--$ 모양은 jquery 이기때문에 위와 같은 태그를 넣어줘야 한다!  -->
<meta charset="UTF-8">
<title>${vo.boardTitle }</title>
</head>
<body>
	<h2>글 보기</h2>
		<div>
			<p>글 번호: ${vo.boardId }</p>
		</div>
		<div>
			<p>제목: ${vo.boardTitle }</p>
		</div>
		<div>
			<p>작성자: ${vo.memberId }</p>
			<p>작성일: ${vo.boardDateCreated }</p>
		</div>
		<div>
			<textarea rows="20" cols="120" readonly>${vo.boardContent }</textarea>
		</div>
		
		<a href="index.jsp"><input type="button" value="글 목록" > </a>
		<a href="update.do?boardId=${vo.boardId }"><input type="button" value="글 수정" > </a>
	
		<form action="delete.do" method="POST">
			<input type="hidden" name="boardId" value= "${vo.boardId }">
			<input type="submit" value="글 삭제" >
		</form>
		
		<hr>
		<input type="hidden" id = "boardId" value="${vo.boardId }" readonly> 
		<div style="text-align: center">
			<input type="hidden" id="memberId" value="${sessionScope.memberId }">
			<input type="text" id="replyContent">
			<button id="btn_add">작성</button>
		</div>
		
		<hr>
		<div style="text-align: center;">
			<div id ="replies"></div>	
		</div>
		<div>
		<br><br><br><br><br><br><br><br><br>
		</div>
		
		
		<script type="text/javascript">
			$(document).ready(function () {
				getAllReplies();
				$('#btn_add').click(function () {
					var boardId=$('#boardId').val();
					var memberId =$('#memberId').val();
					var replyContent =$('#replyContent').val();
					
					var obj={
							'boardId' : boardId,
							'memberId' : memberId,
							'replyContent' : replyContent
					};
					console.log(obj);
					
					$.ajax({
						type:'POST',
						url: 'replies/add',
						data:{'obj': JSON.stringify(obj)},
						success : function (result) {
							if(result=='success'){
								alert('댓글 입력 성공');
								getAllReplies();
							}
						}
					})//end ajax
					
				});//end btn_add.click();
				
				
				function getAllReplies() {
					var boardId = $('#boardId').val(); // 특정 게시판의 글을 가져오기 위해 필요함
					
					var url = 'replies/all?boardId='+ boardId; //어차피 가져오는게 get방식이므로 url의 쿼리 스트링으로 작성한다
					
					$.getJSON(
						url,
						function (data) {
							// data : 서버에서 온 list 데이터가 저장되어 있음.
							// getJSON()에서 json 데이터는 자동으로 parsing 됨.
							console.log(data);
							var list =''; // 댓글 데이터를 HTML 에 표현할 문자열 변수	
							
							
						
							// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
							$(data).each(function(){
								// this : 컬렉션의 한 줄 데이터를 의미
			                     console.log(this);
								
							var replyDateCreated = new Date(this.replyDateCreated);
							
								list += '<div class="reply_item">'
									+ '<pre>'
									+ '<input type="hidden" id="replyId" value="'+ this.replyId +'" />'
									+ '<input type="hidden" id="memberId" value="'+ this.memberId +'" />'
									+ this.memberId
									+ '&nbsp;&nbsp;' //공백
									+ '<input type="text" id="replyContent" value="'+this.replyContent +'" />'
									+ '&nbsp;&nbsp;' //공백
									+ replyDateCreated
									+ '&nbsp;&nbsp;' //공백
									
									+ '<button class="btn_update">수정</button>'//수정 삭제 버튼은 이런식으로 만들어서 밑에 사용한다!
									+ '<button class="btn_delete">삭제</button>'
									//+'<c:if test="${not empty sessionScope.memberId }">'
									//+'</c:if>'						
																
									+ '</pre>'
									+ '</div>';
			                  }); //end each()
			                  
							$('#replies').html(list);
			                  
						}//end function()
					); //end getJSON -> 가져오기만 하기때문에 $getJSON 사용! (ajax도 사용 가능)
					
				}// end getAllReplies()
				
				// 수정 버튼을 클릭하면 선택된 댓글 수정
				$('#replies').on('click','.reply_item .btn_update', function () { //'.reply_item .btn_update' 중간에 띄어쓰기 꼭 있어야됨
					console.log(this); // 클릭한 것을 확인 할 수 있음! / this -> 자기 자신을 의미!
					
					// 선택된 댓글의 replyId, replyContent 값을 저장
					// prevAll() : 선택된 노드 이전에 있는 모든 형제노드(같은 레벨에 있는 코드)를 접근
					var replyId = $(this).prevAll('#replyId').val();
					var replyContent =$(this).prevAll('#replyContent').val();
					console.log("선택된 댓글 번호: " + replyId + ", 댓글 내용: "+ replyContent);
					
					// ajax 요청
					$.ajax({
						type:'POST',
						url : 'replies/update',
						data:{
							'replyId' : replyId,
							'replyContent' : replyContent
						},
						success : function (result) {
								console.log(result);
								if(result== 'success'){
									alert('댓글 수정 성공!');
									getAllReplies();
								}
						}
					});
					
				}); // end replies.on()
				
				// 삭제 버튼을 클릭하면 선택된 댓글 삭제
				$('#replies').on('click','.reply_item .btn_delete', function () { //'.reply_item .btn_update' 중간에 띄어쓰기 꼭 있어야됨
					console.log(this); // 클릭한 것을 확인 할 수 있음! / this -> 자기 자신을 의미!
					
					// 선택된 댓글의 replyId, replyContent 값을 저장
					// prevAll() : 선택된 노드 이전에 있는 모든 형제노드(같은 레벨에 있는 코드)를 접근
					var replyId = $(this).prevAll('#replyId').val();
									
					// ajax 요청
					$.ajax({
						type:'POST',
						url : 'replies/delete',
						data:{
							'replyId' : replyId						
						},
						success : function (result) {
								console.log(result);
								if(result== 'success'){
									alert('댓글 삭제 성공!');
									getAllReplies();
								}
						}
					});
					
				}); // end replies.on()
				
				
			});//end document
			
			
		</script>
	
</body>
</html>






