package edu.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * Json 라이브러리 다운로드 -> JSON 방식으로 풀어내기 위해서는 라이브러리 필요!
		// https://code.google.com/archive/p/json-simple/downloads
				
		String obj= request.getParameter("obj"); //넘어오는 형태 그대로 String 타입으로 저장
		System.out.println(obj);
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject= (JSONObject)parser.parse(obj);
			System.out.println(jsonObject);
			
			String userid= (String)jsonObject.get("userid");
			String password= (String)jsonObject.get("password");
			System.out.println(userid);
			System.out.println(password);
			
			if(userid.equals("test") && password.equals("1234")) {
				PrintWriter out = response.getWriter();
				out.append("success");
			}
			
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			// json 형식으로 바꿔서 key value 형식으로 값을 풀어서 꺼낸것! 콘솔보면 값만 나옴!
			// 이런식이 아니면 그냥 입력된 형태(html) 그대로 출력! 
	}//end doPost
	
}
