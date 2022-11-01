package edu.spring.ex10.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.service.CartService;

@Controller
//@RequestMapping(value="/cart")
public class CartController {
	@GetMapping("/cart")
	public void carts() {
		
	}
//	private static final Logger logger =
//			LoggerFactory.getLogger(ProductController.class);
//	
//	@Autowired
//	private CartService cartservice;
//	
//	@GetMapping("/cartinsert")
//	public void insertGET() {
//		logger.info("-----------insertGET()호출-----------");
//	}//end registerGET()
//	
//	@PostMapping("/cartinsert")
//	public String insertPOST(CartVO vo, HttpSession session) {
//		// RedirectAttributes
//		// - 새로운 경로 위치에 속성값을 전송하는 객체
//		logger.info("-----------insertPOST()호출-----------");
//		logger.info(vo.toString());
//		
//		String userId=(String)session.getAttribute("userId");
//		vo.setUserId(userId);
//		// 장바구니에 기존 상품이 있는지 검사
//		int count = cartservice.countCart(vo.getProductId(), userId)
//		==0 ? cartservice.updateCart(vo) : cartservice.create(vo);
//		
//		if(count ==0) {
//			// 없으면 insert
//			cartservice.create(vo);
//		}else {
//			// 있으면 update
//			cartservice.updateCart(vo);
//		}		
//		
//		return "redirect:/cart/list";
//		
//	}//end registerPOST()
//	
//	@GetMapping("/cartlist")
//	// model 과 modelAndView 와 차이점은 리턴값을 어떻게 표기하냐의 차이가 있다!
//	// 강의 시간의 배운 방식과 표기법은 model이므로 헷갈리지않게 model 사용!
//	public void list(HttpSession session, Model model) {
//		logger.info("-----------cartlist()호출-----------");
////		String userId=(String)session.getAttribute("userId");
//		String userId="1";
//		Map<String, Object>map = new HashMap<String, Object>();
//		List<CartVO>list = cartservice.readCart(userId); //장바구니 정보
//		int sumMoney = cartservice.sumMoney(userId);
//		
//		map.put("list", list);
//		map.put("count", list.size());
//		map.put("sumMoney", sumMoney);
//		
//		model.addAttribute("map", map);
//		
//		
//	}//end list
//	
//	@PostMapping("/delete")
//	public String delete(int cartId, RedirectAttributes reAttr) {
//		logger.info("-----------delete()호출: cartId = "+cartId+"-----------");
//		int result=cartservice.delete(cartId);
//		if(result==1) {
//			reAttr.addFlashAttribute("delete_result", "success"); 
//			
//			return "redirect:/cart/list";
//			// reAttr.addFlashAttribute("insert_result", "success");  alert띄우고 싶으면 insert 부분 참고!
//			// 설정된 값들의 경로가 list로 가기때문에 list.jsp에 관련 jquery를 작성한다  
//		}else {
//			return "redirect:/cart/list";
//		}
//	}//end delete
//	
//	@GetMapping("/update") // 일단 페이지가 필요해서 get으로 가져옴
//	public void updateGET() {
//		logger.info("-----------updateGET()호출----------");		
//		
//	}//end updateGET
//	
//	@PostMapping("/update")
//	public String updatePOST(int[]amount, int[]productId, HttpSession session) {
//		logger.info("-----------updatePOST()호출-----------");
//		String userId= (String) session.getAttribute("userId");
//		
//		CartVO vo= new CartVO(); //이걸 선언하고 for문으로 다시 담는다!
//		for(int i=0; i<productId.length; i++) {
//			vo.setUserId(userId);
//			vo.setAmount(amount[i]);
//			vo.setProductId(productId[i]);
//			cartservice.updateCart(vo);
//		}
//		
//		return "redirect:/cart/list";
//		
//	}//end updatePOST
	
	
}












