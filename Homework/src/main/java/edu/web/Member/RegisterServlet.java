package edu.web.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//TODO : member-register.jsp에서 전송받은 데이터를 DB에 저장
//		 DB 저장 후에 login.jsp로 이동(alert 띄우기)
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       

    public RegisterServlet() {
        dao= MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url로 접근할 경우 경로 변경
		response.sendRedirect("member-register.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo= new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		int result = dao.insert(vo);
		System.out.println(result);		
		
		if(result ==1) { // DB 저장에 성공하면 다른 페이지에 데이터 전송
		
		// 요청받은 request에 포워딩하는 방법(클라이언트에 다시 보내는 방법! -dispatcher까지)
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('회원가입 되었습니다.'); location.href='login.jsp';</script>");
			out.flush();
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("login.jsp");
			
			request.setAttribute("vo", vo);//vo 를 request에 다시 담는 방법
			dispatcher.forward(request, response);
			
			
		// 세션으로 클라이언트에 특정 데이터 전송
			//HttpSession session= request.getSession(); 
			//servlet에서는 session을 마음대로 set할 수 없기때문에 위와 같은 걸 선언이후에 set한다!
			
//			response.sendRedirect("login.jsp");
			
		}
		
	}//end doPost

}//end RegisterServlet 
