package edu.web.servlet04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forward")

// info.html -> /forward -> result.jsp
// => form 으로 정보를 받은걸 forward로 받고 result로 넘겨주는 구조!

public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = ForwardTestServlet.class.getName();

    public ForwardTestServlet() {

    }// 생성자

    // forward : URL 주소 유지 : request/response 객체 유지
    // - 같은 웹 서버 내에 있는 파일들로만 이동이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()호출");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email =request.getParameter("email");
		int money = Integer.parseInt(request.getParameter("money"));
		// 기본적으로 form에서 넘어올때는 String 타입으로 넘어옴! 
		// 다른 형태로 바꾸고 싶을때는 형변환 필요!
		
		System.out.println("이름 : "+ name + ", 나이: "+ age + ", 이메일: "+email+", 재산: "+money);
		
		/* 존재하는 JSP 페이지에 데이터를 보내는 방식 */
		// info.html ->ForwardTestServlet.java(/forward) -> result.jsp(jsp는 java 와 HTML 의 형식을 공존하게 할 수 있다.)
		// html은 데이터를 읽어오는 동적기능이 없기 때문에 jsp로 데이터를 받아와야 함
		
		// forward 방식에서 페이지를 이동할 때는
		// RequestDispatcher 인터페이스의 forward(request, response)메소드를 사용
		// URL이 변경되지 않고 이동함
		ServletContext context = getServletContext();
		//이미 있는 정보가 있기때문에  어디.getServlet 형태로 쓰여지지 않는다.
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
		// dispatcher에 jsp가 받는 주소를 입력!(이런 이유로 result에 따로 request를 선언할 필요가 없다!) 
		// - 의도하지 않는다면 forward-result 각 한개씩 연결 짓도록!
		
		// request 객체를 jsp로 전달
		dispatcher.forward(request, response);
		// result.jsp에 request 객체를 전달하고
		// 전달받은 request에서 parameter를 꺼내는 방식
		
	}//end doGet()

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}//end doPost()

}//end ForwardTestServlet
