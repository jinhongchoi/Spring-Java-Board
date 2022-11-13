<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String isSaveAgreed = request.getParameter("isSaveAgreed");
	// chechbox가 선택된 경우 agreed가 저장되어 있음

	// 파라미터 값으로 쿠키 생성

	Cookie idCookie = new Cookie("ID", id);
	Cookie pwCookie = new Cookie("PW", pw);
	Cookie isSaveAgreedCookie = new Cookie("isSave_Agreed", isSaveAgreed);

	response.addCookie(idCookie);
	response.addCookie(pwCookie);
	response.addCookie(isSaveAgreedCookie);

	//이 도메인(어플리케이션)과 관련있는 쿠키의 값들(배열) 가져오기
	Cookie[] cookies = request.getCookies(); //request.getCookies 의 리턴타입이 배열이다!(코드 설명 읽어볼것!)
	// 쿠키는 project에 있는 정보들을 가져오기 때문에 action으로 경로를 설정하지 않아도 가져올 수 있다.
	// 경로를 알 수 없기때문에 막 보내고 막 가져오면 안된다!

	Cookie cookie = null;
	if (isSaveAgreed != null) {
		if (cookies != null) { //쿠키가 존재하는 경우

			out.println("<h2>모든 쿠키의 이름과 값 찾기</h2>");

			for (int i = 0; i < cookies.length; i++) {
		cookie = cookies[i];
		out.println("name: " + cookie.getName() + "<br>"); //key -value 형식으로 가져온거!
		out.println("value: " + cookie.getValue() + "<br>");
			}
		} else { // 쿠키가 없는 경우
			out.println("<h2>쿠키를 찾지 못했습니다.</h2>");
			idCookie.setMaxAge(0);
			pwCookie.setMaxAge(0);
			isSaveAgreedCookie.setMaxAge(0);
		}
	} else {
		out.println("<h2>쿠키를 찾지 못했습니다.2</h2>");
		cookie = null;
	}
	%>

</body>
</html>








