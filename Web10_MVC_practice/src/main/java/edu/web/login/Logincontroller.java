package edu.web.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.board.domain.MemberVO;
import edu.web.board.persistence.MemberDAO;
import edu.web.board.persistence.MemberDAOImple;


@WebServlet("*.go")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao; 
       

    public Logincontroller() {
    	dao= MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlURI(request, response);
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controlURI(request, response);
	}//end doPost


	private void controlURI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI= request.getRequestURI();
		String requestMethod= request.getMethod();
		
		System.out.println("호출 경로: "+ requestURI);
		System.out.println("호출 메소드 : "+ requestMethod);
		
		if(requestURI.contains("login")) {
			System.out.println("----------login 호출----------");
			if(requestMethod.equals("GET")) {
				loginGET(request, response);
			}else if(requestMethod.equals("POST")) {
				loginPOST(request, response);
			}
		}else if(requestURI.contains("logout")) {
			System.out.println("----------logout 호출----------");
			logout(request, response);
		}else if(requestURI.contains("register")) {
			System.out.println("----------register 호출----------");
			if(requestMethod.equals("GET")) {
				registerGET(request, response);
			}else if(requestMethod.equals("POST")) {
				registerPOST(request, response);
			}
		}else if(requestURI.contains("delete")) {
			System.out.println("----------delete 호출----------");
			delete(request,response);
		}
		
	}//end cotrolURI



	private void loginGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------loginGET()호출-----------");
		System.out.println("loginGET()호출");
		request.getRequestDispatcher("WEB-INF/login/login.jsp").forward(request, response);		
		
		
	}//end loginGET


	private void loginPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------loginPOST()호출-----------");
		String memberId =request.getParameter("memberId");
		String password = request.getParameter("password");
		
		System.out.println("memberId: "+ memberId);
		System.out.println("password: "+ password);
		
		MemberVO vo = new MemberVO(memberId, password, null, null, null, null, null);
		
		int result = dao.userCheck(vo);
		
		if(result==1) {
			HttpSession session= request.getSession();
			session.setAttribute("memberId", memberId); //id에 대해서만 세션 생성
			session.setMaxInactiveInterval(600);
			
			String targetURL= (String)session.getAttribute("targetURL");
			System.out.println("targetURL : "+ targetURL);
			
			if(targetURL != null) { // targetURL 이 존재하는 경우(글 작성 버튼 -> 로그인 하는 경우)
				session.removeAttribute("targetURL"); //session 은 활용이 끝나면 없애주기!
				response.sendRedirect(targetURL);		
			}else { //targetURL 이 존재하지 않는 경우(일반적인 로그인하는 경우)			
				response.sendRedirect("index.jsp");
			}
			
		}else {
			response.sendRedirect("login.go");
		}
		
	}//end loginPOST
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------logout호출-----------");
		
		HttpSession session = request.getSession();
		session.removeAttribute("memberId");
		response.sendRedirect("index.jsp");
		
	}//end logout
	
	private void registerGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("----------registerGET()호출-----------");
		System.out.println("registerGET()호출");
		request.getRequestDispatcher("WEB-INF/login/register.jsp").forward(request, response);
		
		
	}//end registerGET


	private void registerPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------registerPOST()호출-----------");
		request.setCharacterEncoding("UTF-8"); //한글화 패치
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo= new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(vo); //출력 꼭해서 확인해보기!
		int result = dao.insert(vo);
		System.out.println(result);		
		
		if(result ==1) { // DB 저장에 성공하면 다른 페이지에 데이터 전송
		
		// 요청받은 request에 포워딩하는 방법(클라이언트에 다시 보내는 방법! -dispatcher까지)
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('회원가입 되었습니다.')</script>");
			out.print("<script>location.href='index.jsp';</script>");
			out.print("</head>"); 
			
		}else {
			result=dao.idCheck(userid);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('중복된 id가 있습니다.'); location.href='member-register.jsp';</script>");
			out.flush();
		}
		
	}//end registerPOST
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("----------delete()호출-----------");
		
		String memberId= request.getParameter("memberId");
		System.out.println(memberId);
		int result= dao.delete(memberId);
		System.out.println(result + "행이 삭제되었습니다.");
		
		if (result == 1) {
			HttpSession session = request.getSession();
			session.removeAttribute("memberId");
						
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('회원 탈퇴되었습니다.')</script>");
			out.print("<script>location.href='index.jsp';</script>");

		} 
		
	}//end delete

}











