package edu.spring.ex01;

import org.slf4j.Logger;  // �̰ɷ� import �� �� !
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController2 {
	private static final Logger logger=
			LoggerFactory.getLogger(SampleController2.class);
	
	@GetMapping("/test1") //�̰� shortcut
	public String test1(Model model, String username) {
		//username : request.getParameter("username") �̶� ������!
		// get ����̱⶧���� ���� ��Ʈ������ �ۼ��ؼ� �ּ� ġ�� get������� ��������!
		// http://localhost:8080/ex01/test1?username=mok �̷� ��������
		
		logger.info("test1()ȣ�� : username ="+username );
		
		//Model : view�� �����͸� �����ϱ� ���� ��ü
		model.addAttribute("username", username);
		//�̷����ϸ� forwarding ����� �� �ʿ���� �ڵ尡 �پ���!
		return "param-test"; //return �κп� ���� �κ��� �ּҸ� �ۼ�!
	}
	
	@GetMapping("/test2") //�̰� shortcut -> ��� �ٸ��ſ� ��ġ�� �ȵȴ�!
	public String test2(Model model, String username, int age) {
		
		logger.info("test2()ȣ�� ");
		logger.info("username= "+username);
		logger.info("age= "+age);
		
		//Model : view�� �����͸� �����ϱ� ���� ��ü
		model.addAttribute("username", username);
		model.addAttribute("age", age);
		//�̷����ϸ� forwarding ����� �� �ʿ���� �ڵ尡 �پ���!
		return "param-test"; //return �κп� ���� �κ��� �ּҸ� �ۼ�!
	}
	
	
}//end SampleController2












