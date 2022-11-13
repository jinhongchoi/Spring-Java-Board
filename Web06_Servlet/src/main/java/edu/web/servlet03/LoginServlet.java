package edu.web.servlet03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginTest")
// 다른데랑 url을 똑같이 하면 안된다!
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = LoginServlet.class.getName();
       

    public LoginServlet() {

    }

    //doGet() : form method = "GET" 방식으로 전송할 경우 doGET()으로 수신
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//'request' 에서 받은 정보를 담고 뜯는 작업을 한다! -> 저장되어 있다!
		System.out.println(CLASSNAME + "doGet()호출");//웹상에서 일어나기 때문에 확인하기 어려워서 로그를 꼬박꼬박 찍어준다!
		/* 브라우저에서 받은 데이터를 꺼내는 방식 */
		String ip = request.getRemoteAddr(); //요청한 HTTP 의 IP주소를 얻어옴
		System.out.println("["+ip+"]");
		//[0:0:0:0:0:0:0:1] 자신이 직접 들어갔을때 이렇게 뜸
		
		// 요청 파라미터(request parameter)의 값을 읽어옴
		String userid = request.getParameter("userid");
		//getParameter("userid") 여기에 있는 userid 는 form에 있는 name이랑 같아야 한다!
		String password = request.getParameter("password");
		
		System.out.println("아이디: "+userid);
		System.out.println("비밀번호: "+password);
	}

    //doPost() : form method = "POST" 방식으로 전송할 경우 doPost()으로 수신
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + "doPost()호출");
	}

}
