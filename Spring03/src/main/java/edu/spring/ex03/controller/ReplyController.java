package edu.spring.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
// ReplyRestcontroller���� 
public class ReplyController {
	@GetMapping("/reply")
	public void reply() {
		
	}//end reply
	
}//end replycontroller
