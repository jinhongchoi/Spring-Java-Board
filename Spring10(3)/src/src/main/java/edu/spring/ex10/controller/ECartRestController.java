package edu.spring.ex10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.ECartVO;
import edu.spring.ex10.service.ECartService;

@RestController
@RequestMapping(value="/ecarts")
public class ECartRestController {
	
	private static final Logger logger=
			LoggerFactory.getLogger(ECartRestController.class);
	
	@Autowired
	private ECartService ecartService;
	
	@PostMapping
	// 쿠폰 추가
	public ResponseEntity<Integer>createCart(@RequestBody ECartVO vo, Model model){
		// @RequestBody
		// -클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
		logger.info("-----------createCarts() 호출: vo=" + vo.toString()+"-----------");


		int result= 0; 
		try {
			
				int count = ecartService.countECart(vo.getEventId(), "1");
				//String userId=(String)session.getAttribute("userId");

				if(count ==0) {
					// 없으면 insert
					result =ecartService.create(vo);
				}else {
					model.addAttribute("msg", "이미 존재하는 쿠폰입니다.");
					
				}		
	
//			result = cartService.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 이렇게 하면 제대로 들어가면 1 아니면 0이 되어 나온다
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	}//end createECart

}
