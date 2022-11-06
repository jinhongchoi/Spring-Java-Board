package edu.web.Member_answer2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




// TODO : userid 세션 제거, 세션 제거 후에 login.jsp로 이동(alert)
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session=request.getSession();
//		
//		String userid =(String)session.getAttribute("userid");
//		if(userid !=null) {
//			session.removeAttribute("userid");
//			response.sendRedirect("/Homepage/login.jsp");
//		} -> userid 세션 제거, 세션 제거 후에 login.jsp로 이동(alert) -> 이렇게 결과를 내기 위해선 위에처럼 작성할 것!
		
		
		request.getSession().invalidate();
					
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<script>alert('로그아웃 되었습니다.'); location.href='login.jsp';</script>");
		out.flush();
				
		//response.sendRedirect("login.jsp");
		
		
		
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}//end doPost

}//end logout
