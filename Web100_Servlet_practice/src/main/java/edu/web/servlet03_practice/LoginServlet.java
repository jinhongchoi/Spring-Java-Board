package edu.web.servlet03_practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = LoginServlet.class.getName();
	
       

    public LoginServlet() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + "doGet()호출");
		String ip = request.getRemoteAddr();
		System.out.println("["+ip+"]");
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		System.out.println("아이디: "+userid);
		System.out.println("비밀번호: "+password);
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + "doPost()호출");
	
	}//end doPost

}//end LoginServlet
