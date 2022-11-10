package edu.spring.ex10.controller;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.PayDetailVO;
import edu.spring.ex10.domain.PayProductVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;
import edu.spring.ex10.service.CartService;
import edu.spring.ex10.service.PayService;
import edu.spring.ex10.service.ProductService;
import edu.spring.ex10.util.MediaUtil;

@Controller
@RequestMapping(value="/pay")
public class PayController {
	
	@GetMapping("/pay")
	public void cart() {
		
	}
	
	private static final Logger logger =
			LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	private PayService payservice;
	
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@GetMapping("/payinsert")
	public void payinsertGET() {
		logger.info("-----------payinsertGET()호출-----------");
	}//end registerGET()
	
	@PostMapping("/payinsert")
	public String payinsertPOST(PayVO vo,PayDetailVO vo2, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - 새로운 경로 위치에 속성값을 전송하는 객체
		logger.info("-----------payinsertPOST()호출-----------");
		logger.info(vo.toString());
//		int result= payservice.create(vo);
		int result=payservice.create2(vo2);
		logger.info(result+ "행 삽입");
		
		return "redirect:../pay/paylistDetail";
				
	}//end registerPOST()
	
	@PostMapping("/payinsert2")
	public String payinsert2POST(PayVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - 새로운 경로 위치에 속성값을 전송하는 객체
		String userId="1";
		String userName="1";
		String userTell="1";
		logger.info("-----------payinsert2POST()호출-----------");
		logger.info(vo.toString());
		vo.setUserId(userId);
		vo.setUserTell(userTell);
		vo.setUserName(userName);
		// 위에 3개 jsp에서 받는거로 수정!
		
//		int result= payservice.create(vo);
		int result=payservice.create(vo);
		logger.info(result+ "행 삽입");
		
		return "redirect:../pay/paylistDetail";
				
	}//end registerPOST()
	
	
	@GetMapping("/paylist")
	// model 과 modelAndView 와 차이점은 리턴값을 어떻게 표기하냐의 차이가 있다!
	// 강의 시간의 배운 방식과 표기법은 model이므로 헷갈리지않게 model 사용!
	public void list(HttpSession session, Model model, Integer productId, Integer amount) {
		logger.info("-----------paylist()호출-----------");
//		String userId=(String)session.getAttribute("userId");
		String userId="1";
		Map<String, Object>map = new HashMap<String, Object>();
		List<CartVO>list = payservice.readCart(userId); //장바구니 정보
		int sumMoney = payservice.sumMoney(userId);
		
		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
				
		model.addAttribute("map", map);		
		
		
	}//end list
	
	// 장바구니 결제목록
	@GetMapping("/paylistDetail")
	// model 과 modelAndView 와 차이점은 리턴값을 어떻게 표기하냐의 차이가 있다!
	// 강의 시간의 배운 방식과 표기법은 model이므로 헷갈리지않게 model 사용!
	public void listPayDetail(HttpSession session, Model model, PayDetailVO vo, Integer amount) {
		logger.info("-----------paylist()호출-----------");
//		String userId=(String)session.getAttribute("userId");
		String userId="1";
//		Map<String, Object>map = new HashMap<String, Object>();
//		List<CartVO>list = payservice.readCart(userId); //장바구니 정보
		
		vo.setUserId(userId);
		
		List<PayDetailVO>listPayDetail=payservice.listPayDetail(vo);
		model.addAttribute("listPayDetail", listPayDetail);		
		
		payservice.cartAllDelete(userId);		
				
	}//end list
	
	
	
	
	//단일 결제페이지 불러오기
	@GetMapping("/paylist2")
	// model 과 modelAndView 와 차이점은 리턴값을 어떻게 표기하냐의 차이가 있다!
	// 강의 시간의 배운 방식과 표기법은 model이므로 헷갈리지않게 model 사용!
	public void list2(HttpSession session, Model model, Model model2, Integer productId, HttpServletRequest request) {
		logger.info("-----------paylist2()호출-----------");
//		String userId=(String)session.getAttribute("userId");
		String userId="1";
		
		ProductVO vo= payservice.detailProduct(productId);	
				
		model.addAttribute("vo", vo);
		
	}//end list
	
	
	
	@GetMapping("/display")
	public ResponseEntity<byte[]>display(String fileName)throws Exception{
		logger.info("=====display() 호출");
		ResponseEntity<byte[]>entity = null;
		InputStream in = null;
		
		String filePath = uploadPath + fileName; // uploadPath -> 저장했던 경로
		in= new FileInputStream(filePath);
		
		//파일 확장자
		String extension =
				filePath.substring(filePath.lastIndexOf(".")+1);
		logger.info(extension);
		
		// 응답 헤더(response header) 에 Content-Type 설정
		HttpHeaders httpHeaders = new HttpHeaders(); //org.springframework.http.HttpHeaders; 이거 임포트
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));
		
		// 데이터 전송
		entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in),// org.apache.commons.io.IOUtils; 이거 임포트
					httpHeaders,
					HttpStatus.OK
				);
		return entity;
		//http://localhost:8080/ex05/display?fileName=/unnamed.jpg 이거 검색해서 불러와서 있는지 확인
	}
	
}





