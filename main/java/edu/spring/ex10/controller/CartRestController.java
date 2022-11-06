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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		int result= 0; 
		try {
			
				int count = cartService.countCart(vo.getProductId(), "1");
				//String userId=(String)session.getAttribute("userId");
//				vo.setUserId(userId);
//				// 장바구니에 기존 상품이 있는지 검사
//				int count = cartservice.countCart(vo.getProductId(), userId)
//				원래는 session으로 userid를 받아와서 들어가야 userId 들어가야 할 자리! "1" 대신!				
				
				
				
//				==0 ? cartService.updateCart(vo) : cartService.create(vo);
				
				if(count ==0) {
					// 없으면 insert
					result =cartService.create(vo);
				}else {
					// 있으면 update
					result =cartService.updateCart(vo);
				}		
		
	
//			result = cartService.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 이렇게 하면 제대로 들어가면 1 아니면 0이 되어 나온다
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	}//end createCart



}










