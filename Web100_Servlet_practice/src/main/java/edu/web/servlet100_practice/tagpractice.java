package edu.web.servlet100_practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tagpractice")
public class tagpractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CLASSNAME = tagpractice.class.getName();   

    public tagpractice() {

    }//end 생성자


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + "doGet()호출");
		
		int inputMoney = Integer.parseInt(request.getParameter("money"));
		int period = Integer.parseInt(request.getParameter("period"));
		
		double interest = Double.parseDouble(request.getParameter("balance"));
		
		
		System.out.println("금액 : "+ inputMoney + ", 기간: "+ period + ", 이자: "+interest);
		
		ServletContext context =  getServletContext();
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/01_TagPractice1.jsp");
		
		dispatcher.forward(request, response);
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}//end doGet

}//end tagpractice
