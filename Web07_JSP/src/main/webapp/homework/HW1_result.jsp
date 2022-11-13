<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HW1_result</title>
</head>
<body>
	
	<%
	
		int inputMoney = Integer.parseInt(request.getParameter("inputMoney"));
		// form 형식으로 보내면 값은 parameter에 저장된다!(servlet/jsp 상관x)
		// servlet 없어도 request로 패킹해서 parameter값을 주고받는 형식은 같다!
		// jsp에는 get방식과 post 방식이 들어가있다!
		// servlet 은 유지보수나 작성에 편하기 때문에 사용한다!
		int period = Integer.parseInt(request.getParameter("period"));
		double interest = Double.parseDouble(request.getParameter("interest"));
		
		int totalInputMoney =inputMoney*period;
		double totalInterest =totalInputMoney*interest/100;
		double totalReceiveMoney =totalInterest + totalInputMoney;
		
		DecimalFormat df = new DecimalFormat(" ￦###,###,###");
		//DecimalFormat -> import 필요!		
				
	%>
	
	<h1>적금 계산</h1>
	<h2>입력받은 정보</h2>
	<p>월 금액 : <%=df.format(inputMoney) %></p>
	<p>적금 기간: <%=period %></p>
	<p>년 이자: <%=interest %></p>
	<hr>
	<p>총 납입 금액 : <%=df.format(totalInputMoney) %></p>
	<p>발생 이자 : <%=df.format(totalInterest) %></p>
	<p>총 수령액: <%=df.format(totalReceiveMoney) %></p>
	
</body>
</html>