package edu.web.MemberPr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
	       
    public SelectServlet() {
    	dao=MemberDAOImple .getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid = request.getParameter("userid");
		MemberVO vo= dao.select(userid);
		System.out.println(vo);
		
		request.setAttribute("vo", vo);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/member-result.jsp");
		// getRequestDispatcher 자체가 forwarding하는 역할이기때문에 위에 context를 사용하는 것과 안하는 것이 차이가 없다!
		// context를 사용할 시 조금 더 넓은 범위(scope)에서 사용가능!
		
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}//end doPost

}