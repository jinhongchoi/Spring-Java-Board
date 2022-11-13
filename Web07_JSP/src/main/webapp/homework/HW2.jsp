<%@page import="edu.web.homework.ContactVO"%>
<%@page import="java.util.ArrayList"%>
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
<title>HW2 과제</title>
</head>
<body>
	<!--
	1. 이름, 연락처, 이메일을 변수로 갖는 ContactVO.java 를 생성
	(위치: src/edu.web.homework/ContactVO.java)
	2. HW2.jsp 파일
	- ArrayList<ContactVO>를 선언하고 객체 생성
	- 임의로 3~5개의 데이터를 생성하여 ArrayList에 모두 저장
	- ArrayList에 저장된 데이터를 반복문과 <table>태그를 이용하여 출력
	  -->

	<%
	ArrayList<ContactVO> list = new ArrayList<>();
	//기본형 으로 외워둔다! <들어갈 타입>변수명! = new ArrayList<>() 이렇게 비워준다!
	//항상 import 필요함! 
	ContactVO vo = new ContactVO("둘리", "010-1111-1111", "test@test.com");
	ContactVO vo1 = new ContactVO("둘리", "010-1111-1112", "test@test.com");
	ContactVO vo2 = new ContactVO("둘리", "010-1111-1113", "test@test.com");
		
	list.add(vo);//이렇게 해줘야 vo에 입력된게 list로 들어간다!!
	list.add(vo1);
	list.add(vo2);
	list.add(new ContactVO("둘리", "010-1111-1114", "test@test.com"));//이런식으로도 추가 가능!
	
	
	%>
	<table>
		<thead>
			<tr>
				<th>이름 </th>
				<th>전화번호</th>
				<th>아매알 </th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
			
				<td>1<%=list.get(i).getName()%></td>
				<td>2<%=list.get(i).getPhone()%></td>
				<td>3<%=list.get(i).getEmail()%></td>
				<!--
					vo.get 은 하나가져올때 사용! 
				    여러개 가져올땐 list.get(i).get~으로 사용!
				    list.get(i) 이 list에서 가져오는 기본형태!
				-->
				
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>