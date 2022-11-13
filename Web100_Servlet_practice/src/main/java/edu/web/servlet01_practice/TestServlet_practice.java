package edu.web.servlet01_practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet_practice")
public class TestServlet_practice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME =TestServlet_practice.class.getName();
       

    public TestServlet_practice() {

    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println(CLASSNAME + " : TestServlet init() 호출");    
    }
    //init 메소드 왜 생기는지 알기!

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
