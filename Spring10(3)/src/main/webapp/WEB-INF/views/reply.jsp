<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>  

<!--c 태그는 JSTL 이므로 사용하려면 taglib 라이브러리가 필요! 위에 코드 갖다 쓴다!-->
  
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
	
	 <div style="text-align: center;">
         <input type="text" id="memberId">
         <input type="text" id="replyContent">
         <button id="btn_add">작성</button>
     </div>
	
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
				var boardId = 27; // 게시판 번호 데이터 /boardId 변수는 위에  id = "boardId" 있는걸 보고 작성
				var memberId = $('#memberId').val(); // 작성자 데이터
				var replyContent = $('#replyContent').val();// 댓글 내용
				
				var obj = {
						'boardId' : boardId,
						'memberId' : memberId,
						'replyContent' : replyContent
				};				
				console.log(obj);
				
				// $.ajax로 송수신
				$.ajax({
					type: 'POST',
					url: 'replies',
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					data : JSON.stringify(obj), // JSON 으로 변환
					success : function (result, status) {
						console.log(result);
						console.log(status);
						if(result == 1){
							alert('댓글 입력 성공');
							getAllReplies();
						}
					}
				}); //end ajax
				
				
			});//end btn_add.click() 
			
			
			// 게시판 댓글 전체 가져오기
			function getAllReplies() {
				var boardId = 27;
				
				
				var url = 'replies/all/'+ boardId;
				//restApi -> requestparameter 안씀! -> json으로 사용/ 그래서 뒤에 쿼리 스트링으로 작성되지 않는다!
				
				
				////////여기서는 url만 바꿈!!!!!!!
				
				console.log(url);
				$.getJSON(
					url,
					function (data) {
						// data : 서버에서 온 list 데이터가 저장되어 있음.
						// getJSON()에서 json 데이터는 자동으로 parsing 됨.
						// header 는 보낼때만 필요(POST의 경우)
						console.log(data);
						
						
						var memberId = $('#memberId').val(); //memberId 값을 받은거 , 중괄호 소괄호 구분 할 것!('#memberId') 이부분
						var list =''; // 댓글 데이터를 HTML 에 표현할 문자열 변수	
											
					
						// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
						$(data).each(function(){
							// this : 컬렉션의 한 줄 데이터를 의미
		                     console.log(this);
							
						var replyDateCreated = new Date(this.replyDateCreated);
						
						var disabled ='';
						var readonly ='';
						
						if(memberId == this.memberId){
							disabled='';
							readonly='';
						}	 // 수정 삭제를 아이디가 맞아야 가능하게 함!					
						
							list += '<div class="reply_item">'
								+ '<pre>'
								+ '<input type="hidden" id="replyId" value="'+ this.replyId +'" />'
								+ '<input type="hidden" id="memberId" value="'+ this.memberId +'" />'
								+ this.memberId
								+ '&nbsp;&nbsp;' //공백
								+ '<input type="text" '+readonly+' id="replyContent" value="'+this.replyContent +'" />'
								+ '&nbsp;&nbsp;' //공백
								+ replyDateCreated
								+ '&nbsp;&nbsp;' //공백
								
								+ '<button class="btn_update" '+disabled+' >수정</button>'
								+ '<button class="btn_delete" '+disabled+' >삭제</button>'
															
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
					type:'PUT',
					url : 'replies/'+ replyId,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'PUT'
					},
					
					data:JSON.stringify({'replyContent' : replyContent}),
					// 여기서 변한 부분
					success : function (result) {
							console.log(result);
							if(result== 1){
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
				var boardId = 27;
				var replyId = $(this).prevAll('#replyId').val();
				console.log(replyId);
				
				// ajax 요청
				$.ajax({
					type:'DELETE',
					url : 'replies/'+ replyId,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'DELETE'
					},
					data : JSON.stringify({
						'boardId' : boardId
					}),
					// REST 방식 사용시 hearder 추가!					
					success : function (result) {
							console.log(result);
							if(result== 1){
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







