<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!--  fmt 는 포멧 형태 바꾸기 (날짜 같은거) -->    
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>쿠폰함 목록</title>
<script type="text/javascript">
	$(document).ready(function () {
		//리스트 페이지로 이동
		$('#btn_elist').click(function () {
			location.href="../event/eventlist";
		});// end btneList
			
	});//end document
	
</script>

</head>

<style type="text/css">
/* ========기본 설정==============  */
body{

font-family: NanumSquareNeo;
}

table{
	text-align: center;
	margin-left:auto; 
    margin-right:auto;	
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

/*===========타이틀 설정==================  */

.Title{
  margin: 0;
  padding: 0;
  font-size:20px;  
  margin-left: 550px;
  margin-right: 350px;
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

/*===========수정 삭제 설정==================  */

.UD{
	text-align: center;
	margin-left: 550px;
}

/*=========== 이미지 포인트 효과 설정==================  */

.img1:hover { background-color: #dcdcdc; }
	
</style>

<body>

	<%@ include file ="../header.jspf" %>
	
	<div class="Title">
	<h1>쿠폰함 확인</h1>
	</div>
	
	<div style="text-align: center;">
		<div id ="ecarts"></div>	
	</div>
	
	
	
	<c:choose>
		<c:when test="${map.count ==0 }">
			쿠폰함이 비었습니다.
		</c:when>
		<c:otherwise>
		<form name="form2" id="form2" method="post">
			<table border="1" style="border: 1px solid #aaaaaa; align: center;">
				<tr>
					<th>이벤트</th>
					<th>이벤트 이미지</th>
					<th>할인가</th>									
					<th>취소</th>
				</tr>
				<c:forEach var="vo" items="${map.list }" varStatus="i">
				<tr>
					<td>
						${vo.eventName }
					</td>
					<td>
						<img src="display?fileName=/${vo.eventUrl }" width="200px" height="150px">
					</td>
					<td style="width: 80px" align="center">
						<fmt:formatNumber pattern="###,###,###" value="${vo.eventPrice}"/>
					</td>					
					<td>						
						<input type="submit" value="삭제" style="text-align: center;" id="remove" formaction="../ecart/delete?ecartId=${vo.ecartId }" class="btn-3d red" >							
					</td>
				</tr>
				</c:forEach>
			
			</table>
			<input type="hidden" name="count" value="${map.count }">
		</form>		
		</c:otherwise>
	</c:choose>
	
	<br>
	<br>
	
	<div class="UD">
	<button type="submit" id="btn_elist" class="btn-3d red">이벤트 목록</button>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%@ include file ="../footer.jspf" %>
	
</body>
	
	<!-- 삭제 알림 띄우기  -->

</html>








