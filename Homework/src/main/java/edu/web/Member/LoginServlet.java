package edu.web.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// TODO :
/*
 * 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서
 * 데이터가 일치하면 - 로그인 성공(login-result.jsp)로 이동 및 로그인 세션 생성
 * (아이디 값에 대한 세션 생성) -세션 만료 시간 60초
 *  - 예시) session.setAttribute("userid", 아이디 값);
 *  데이터가 일치하지 않으면 login.jsp로 이동(alert 띄우기)
 * */
@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;
	
    public LoginServlet() {
    		dao=MemberDAOImple.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//url로 접근할 경우 경로 변경
		response.sendRedirect("login.jsp");
		
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		MemberVO vo= new MemberVO(userid, password, null, null, null, null, null);
		
		int result= dao.userCheck(vo);
		System.out.println(result +"행");
		
		if(result==1) {
			HttpSession session= request.getSession();
			session.setAttribute("vo", vo);
			
			Date createTime = new Date(session.getCreationTime());
			
			System.out.println(createTime);
			System.out.println("로그인 성공");
			session.setMaxInactiveInterval(3);
						
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 되었습니다.'); location.href='login-result.jsp';</script>");
			out.flush();
			
			//response.sendRedirect("login-result.jsp");
			return;
		}else {
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 실패하였습니다.'); location.href='login.jsp';</script>");
			out.flush();
			
		}
		
				
		
	}//end Post

}//end LoginServlet
