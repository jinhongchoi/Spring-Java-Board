<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록 페이지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
.file-drop{
	width: 100;
	height: 100px;
	border: 1px solid grey;
}
</style>
</head>
<body>
	<h2>상품등록 페이지</h2>
	<form action="productregister" method="POST" enctype="multipart/form-data">
	<!--  form action = "controller의 보낼 주소" -->
		<div>
			<p>상품 카테고리</p>
			<input type="radio" name="productCate" value="팝콘">팝콘
			<input type="radio" name="productCate" value="음료">음료
			<input type="radio" name="productCate" value="스낵">스낵
		</div>
		<div>
			<p>상품명: </p>
			<input type= "text" name="productName" placeholder= "상품명 입력" required>
		</div>
		<div>
			<p>상품 가격: </p>
			<input type="number" name="productPrice" placeholder= "상품 가격 입력" required>
		</div>
		
		<div>
			<p>상품 내용: </p>
			<textarea rows="20" cols="120" name="productDesc" placeholder="상품 내용 입력" required></textarea>			
		</div>
	
		<h2>상품 이미지 파일 업로드</h2>
		
		<!--enctype="multipart/form-data" // 파일 넣을시 encording 타입을 의미함! 이게 있어야 업로드가 가능!  -->
		<input type="file" name ="files">
		<br>
	
		<br>
		<hr>
		<div>	
			<input type="submit" value="등록">		
		</div>
		
	</form>
	
	
</body>
</html>





<!-- 

<h1>Ajax를 이용한 파일 업로드</h1>
	파일을 넣으면 입려이 되는 동시에 불러와지면서 화면에 뜨게 만들게 한다  
	
	<div class ="file-drop"></div>
	<div class ="upload-list"></div>
	
	<script type="text/javascript">
		$(document).ready(function () {
			// 파일을 끌어다 놓을 때(drag&drop)
			// 브라우저가 파일을 자동으로 열어주는 기능을 막음
			$('.file-drop').on('dragenter dragover', function (event) {
				event.preventDefault();
			}); //drop 만 막음
			
			$('.file-drop').on('drop', function (event) {
				event.preventDefault();
				console.log('drop 테스트');
				
				// Ajax를 이용하여 서버로 파일을 업로드
				// multipart/form-data 타입으로 파일을 업로드하는 객체
				var formData= new FormData();				
				//드래그한 파일 정보를 갖고 있는 객체
				var files =event.originalEvent.dataTransfer.files;
				var i =0;
				for(i=0; i<files.length; i++){
					console.log(files[i]);
					formData.append("files", files[i])
				} //이렇게 하면 append 가 있어서 배열로 넘어감
				
				$.ajax({
					type : 'post',
					url : '/ex10/product/upload-ajax',
					data : formData,
					processData : false,
					contentType : false,
					success : function (data) {
						console.log(data);
						
						var str ='';
						str += '<div>'
							+'<img src = "../display?fileName=' 
							//Failed to load resource: the server responded with a status of 404 ()
							//경로 설정이 잘못되었다는 뜻! 기존의 있던거를 복사했으므로 기존과 프로젝트가 다르다는 것을 인지하고  .. 붙여줘서 알아서 찾아가게 할 것!
							// 원하는 경로로 보내기 위해서는 상위 경로를 더 자세히 작성한다!
							+ data
							+'" />'
							+'</div>';
						$('.upload-list').html(str);
						
						str += "<span data-src="+data+">[삭제]</span></div>";
						$('.uploadedList').append(str);
						// 위의 삭제버튼은 따로 ajax를 만들어야함! -> 데이터에 입력하는 것부터 먼저하고 할 것!
					}
				}); // end ajax()
				
			});// drag 만 막음
			
		});//end document
	</script>
	 -->
	 