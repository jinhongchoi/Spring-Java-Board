package edu.web.ajax01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajax_test.do")
public class ajax01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ajax01() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");		
		System.out.println(id);
		System.out.println(pw);
		
		PrintWriter out = response.getWriter();
		out.print(id+"<br>");
		out.print(pw);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
