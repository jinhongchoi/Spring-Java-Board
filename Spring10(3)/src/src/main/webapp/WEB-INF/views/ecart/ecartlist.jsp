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
<title>상품장바구니 목록</title>
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
  margin-left: 40px;
  margin-right: 40px;
  padding: 100px 100px 100px 100px; 
}
.shop{
  margin-left: 150px;
  margin-right: 150px;
}
.Title{
  font-size:40px;
  margin-left: 250px;
  margin-right: 150px;	
}

ul{
	list-style-type: none;
	text-align: center;
} /* 페이징 처리시 디자인  */

li{
	display: inline-block;
} /* 페이징 처리시 디자인  */
	
</style>

<body>
	<h1>쿠폰함 확인</h1>
	
	<div style="text-align: center;">
		<div id ="ecarts"></div>	
	</div>
	
	
	
	<c:choose>
		<c:when test="${map.count ==0 }">
			쿠폰함이 비었습니다.
		</c:when>
		<c:otherwise>
		<form name="form2" id="form2" method="post">
			<table border="1">
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
					<td style="width: 80px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${vo.eventPrice}"/>
					</td>					
					<td>						
						<input type="submit" value="삭제" id="remove" formaction="../ecart/delete?ecartId=${vo.ecartId }">							
					</td>
				</tr>
				</c:forEach>
			
			</table>
			<input type="hidden" name="count" value="${map.count }">
		</form>		
		</c:otherwise>
	</c:choose>
	<button type="submit" id="btn_elist">이벤트 목록</button>
	
	
</body>
	
	<!-- 삭제 알림 띄우기  -->

</html>








