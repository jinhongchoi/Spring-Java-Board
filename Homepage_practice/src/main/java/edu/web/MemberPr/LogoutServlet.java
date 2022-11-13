package edu.web.MemberPr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Remove;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("userid");
		if(userid != null) {
			session.removeAttribute(userid);
			response.sendRedirect("/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
