package edu.web.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : member-result.jsp의 button에서 전송받은 userid룰 이용하여
// 		 DB에서 회원 정보 삭제, 성공후에 login.jsp로 이동
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;   

    public DeleteServlet() {
    	dao=MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid= request.getParameter("userid");
		System.out.println(userid);
		
		int result= dao.delete(userid);
		
		System.out.println(result);
		
		if(result==1) {
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('회원탈퇴 되었습니다.'); location.href='login.jsp';</script>");
			out.flush();
						
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}//end doPost

}//end DeleteServlet
