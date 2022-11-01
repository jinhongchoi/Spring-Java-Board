package edu.spring.ex10.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.service.CartService;



@RestController
@RequestMapping(value="/carts")
public class CartRestController {
	
	private static final Logger logger=
			LoggerFactory.getLogger(CartRestController.class);
	
	@Autowired
	private CartService cartService;
	
	@PostMapping
	public ResponseEntity<Integer>createCart(@RequestBody CartVO vo){
		// @RequestBody
		// -클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
		logger.info("-----------createCarts() 호출: vo=" + vo.toString()+"-----------");

		// ResponseEntity<T> : Rest 방식에서 데이터를 리턴할 때 쓰이는 객체
		// -데이터와 HttpStatus를 전송
		// - <T> : 보내고자 하는 데이터 타입
		
		int result =cartService.create(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	}
	
	@GetMapping("/cartlist")
	// model 과 modelAndView 와 차이점은 리턴값을 어떻게 표기하냐의 차이가 있다!
	// 강의 시간의 배운 방식과 표기법은 model이므로 헷갈리지않게 model 사용!
	public void list(HttpSession session, Model model) {
		logger.info("-----------cartlist()호출-----------");
//		String userId=(String)session.getAttribute("userId");
		String userId="1";
		Map<String, Object>map = new HashMap<String, Object>();
		List<CartVO>list = cartService.readCart(userId); //장바구니 정보
		int sumMoney = cartService.sumMoney(userId);
		
		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
		
		model.addAttribute("map", map);
		
		
	}//end list

}










