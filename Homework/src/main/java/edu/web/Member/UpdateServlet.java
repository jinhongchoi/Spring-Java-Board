package edu.web.Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : member-update.jsp에서 전송받은 데이터로 DB회원 정보 수정
//		  DB 회원 정보 수정 성공하면 member-result.jsp에 vo데이터 전송하여 보여주기
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       

    public UpdateServlet() {
    	dao=MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url로 접근할 경우 경로 변경
		
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
		
		int result = dao.update(vo);
		System.out.println(result);
		
		if(result==1) {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("member-result.jsp");
			
			request.setAttribute("vo", vo);//vo 를 request에 다시 담는 방법
			dispatcher.forward(request, response);
			
		}
		
	}//end doPost

}//end Update
