package edu.web.MemberPr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;   

    public LoginServlet() {
    	dao=MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid= request.getParameter("userid");
		String password= request.getParameter("password");
		
		int result= dao.Login(userid, password);
		
		PrintWriter out = response.getWriter();
		
		if(result ==1) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('로그인 성공.');</script>");
			out.print("<script>location.href='login-result.jsp';</script>");
			out.print("</head>");
		}else {
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('로그인 실패. 아이디 비밀번호 확인');</script>");
			out.print("<script>location.href='login.jsp';</script>");
			out.print("</head>");
		}
		
	}//end doPost

}//end LoginServlet
