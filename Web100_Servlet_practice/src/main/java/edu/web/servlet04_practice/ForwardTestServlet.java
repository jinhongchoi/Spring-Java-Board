package edu.web.servlet04_practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardTestServlet")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = ForwardTestServlet.class.getName();
    
    public ForwardTestServlet() {

    }//end 생성자


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()호출");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		//form 에서 넘어오는 정보는 String 타입이므로 형변환 필요
		String email = request.getParameter("email");
		int money = Integer.parseInt(request.getParameter("money"));
		
		System.out.println("이름 : "+ name + ", 나이: "+ age + ", 이메일: "+email+", 재산: "+money);
		
		ServletContext context = getServletContext();
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result2.jsp");
		
		dispatcher.forward(request, response);
		
		
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}//end doPost

}//end ForwardTestServlet
