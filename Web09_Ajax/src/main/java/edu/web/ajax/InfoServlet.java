package edu.web.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/Info.do")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InfoServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String userid ="test";
			String password ="1234";
			String email = "test@test.com";  // 들어간거!(parse 하기 전 상태를로 들어간 부분을 의미!)
			
			//JSON 객체 생성
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userid", userid);
			jsonObject.put("password", password);
			jsonObject.put("email", email);
			
			// JSON 객체 전송
			response.getWriter().append(jsonObject.toString());
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
