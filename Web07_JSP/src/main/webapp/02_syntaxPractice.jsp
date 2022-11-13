<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: :
	10px
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>

<meta charset="UTF-8">
<title>JSP 구문 연습</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
		<%for(int i=0; i<2 ; i++){ %>
			<tr>
				<td>test<%=i+1 %></td>
				<td>010-1111-222<%=i+1 %></td>
				<td>test<%=i+1 %>@test.com</td>
			</tr>
		<%} %>
		</tbody>
	</table>

</body>
</html>