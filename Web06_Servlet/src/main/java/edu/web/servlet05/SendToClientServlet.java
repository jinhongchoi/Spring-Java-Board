package edu.web.servlet05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendToClientServlet
 */
@WebServlet("/send")
public class SendToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SendToClientServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 여기 아주 중요!!!!(여기서는 attribute 형식으로 보내는 방법!)
		// (웹페이지에서 입력을 받지 않고 servlet에서 바로 입력해서 result로 보내는 방법!)
		// * request.setAttribute /request.getAttribute
		// - 데이터를 key-value 형식으로 전송하는 방식
		// - 문자열 뿐만 아니라, 다양한 변수 및 객체를 전송할 수 있음
		// * attrubute와 parameter의 차이점
		// - parameter는 html form태그를 통해 데이터 전송
		// *************************(form 외의 위치에서 데이터 추가 불가능)
		// - parameter는 String 형태로 값을 전송
		// - attribute는 client/server 에서 생성하여 전송 가능
		// - attribute는 문자열 뿐만 아니라, 다양한 변수 타입 및 참조 타입 전송 가능
		
		request.setAttribute("name", "고길동");
		request.setAttribute("lived", "서울 쌍문동");
		request.setAttribute("age", 40); //object 형식이므로 int, String상관 없이 입력 가능
		
		infoVO vo = new infoVO("둘리", "쌍문동", 1000);
		request.setAttribute("vo", vo);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/my_info.jsp");
		
		dispatcher.forward(request, response);
		
	}//end doGet()


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}//end doPost

}
