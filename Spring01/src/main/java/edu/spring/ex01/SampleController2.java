package edu.spring.ex01;

import org.slf4j.Logger;  // 이걸로 import 할 것 !
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController2 {
	private static final Logger logger=
			LoggerFactory.getLogger(SampleController2.class);
	
	@GetMapping("/test1") //이게 shortcut
	public String test1(Model model, String username) {
		//username : request.getParameter("username") 이랑 같은거!
		// get 방식이기때문에 쿼리 스트링으로 작성해서 주소 치면 get방식으로 가져와짐!
		// http://localhost:8080/ex01/test1?username=mok 이런 느낌으로
		
		logger.info("test1()호출 : username ="+username );
		
		//Model : view에 데이터를 전송하기 위한 객체
		model.addAttribute("username", username);
		//이렇게하면 forwarding 방식을 쓸 필요없이 코드가 줄어든다!
		return "param-test"; //return 부분에 보낼 부분의 주소를 작성!
	}
	
	@GetMapping("/test2") //이게 shortcut -> 경로 다른거와 겹치면 안된다!
	public String test2(Model model, String username, int age) {
		
		logger.info("test2()호출 ");
		logger.info("username= "+username);
		logger.info("age= "+age);
		
		//Model : view에 데이터를 전송하기 위한 객체
		model.addAttribute("username", username);
		model.addAttribute("age", age);
		//이렇게하면 forwarding 방식을 쓸 필요없이 코드가 줄어든다!
		return "param-test"; //return 부분에 보낼 부분의 주소를 작성!
	}
	
	
}//end SampleController2












