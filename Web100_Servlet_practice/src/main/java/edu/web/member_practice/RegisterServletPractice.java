package edu.web.member_practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 자바로 만들었던 frame 라이브러리에 method 부분이 기능적으로 실행되므로
// 그런걸 servlet에 적는다고 생각하고 service부분에 기능적인 코드들을 작성!
// 대체적으로 순서는 VO-Query-DAO-DAOImple-servlet순으로 작성!
@WebServlet("/RegisterServletPractice.do")
public class RegisterServletPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberpracDAO dao;
       

    public RegisterServletPractice() {
    	dao= MemberpracDAOImple.getInstance();
          //싱글톤 패턴을 가져와서사용할 수 있게끔! 기본생성자 있는데다가 작성!
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url로 접근할 경우 경로 변경
		response.sendRedirect("Web100_Servlet_practice/18_db_connection_practice.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식이므로 여기다가 작성!
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberpracVO vo= new MemberpracVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo);
		int result= dao.insert(vo);
		System.out.println(result);
		
	}

}
