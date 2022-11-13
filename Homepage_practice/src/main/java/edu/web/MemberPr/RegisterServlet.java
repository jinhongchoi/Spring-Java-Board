package edu.web.MemberPr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;

    public RegisterServlet() {
    	dao=MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest=request.getParameterValues("interest");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo= new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		int result= dao.insert(vo);
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		if(result == 1) { // 회원가입 성공
			out.print("<head><meta charset='UTF-8'>");
			out.print("<script>alert('등록 성공! 로그인 해주세요.');</script>");
			out.print("<script>location.href='login.jsp';</script>");
			out.print("</head>");
		}
		
	}//end doPost

}
