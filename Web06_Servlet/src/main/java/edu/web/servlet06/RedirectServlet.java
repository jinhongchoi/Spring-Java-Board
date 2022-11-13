package edu.web.servlet06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectServlet() {

    }
    
    // redirect : URL 주소 바뀜. request/response 객체 소멸
    // - 같은 서버/ 다른 서버에 있는 페이지로 이동이 가능
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirect를 이용한 데이터 전송 방법(GET방식만 가능)
		String path = request.getContextPath(); // Web06_Servlet
		String pageName = "/result.jsp";
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String money = request.getParameter("money");
		String location = path + pageName +
						  "?name=" +name +
						  "&age=" +age +
						  "&email=" +email +
						  "&money=" +money;
		//url 경로로 위의 location이 들어가기 때문에  "=" 과 공백이 있으면 에러가뜸!!!!!!
		//url 을 보면서 에러 확인할 것!(붙일때 안붙일때 다름!)
		
		System.out.println(location);
		response.sendRedirect(location);
		
	}//end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}//end doPost

}//end main
