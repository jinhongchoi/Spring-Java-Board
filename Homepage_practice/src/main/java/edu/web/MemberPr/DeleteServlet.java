package edu.web.MemberPr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public DeleteServlet() {
    	dao=MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String userid= (String)session.getAttribute("userid");
			if(userid !=null) {
				
				int result= dao.delete(userid);
				if(result==1) {
					response.sendRedirect("/login.jsp");
				}
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
