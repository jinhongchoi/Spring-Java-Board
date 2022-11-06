package edu.spring.ex10.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
	public String payinsertPOST(PayVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - 새로운 경로 위치에 속성값을 전송하는 객체
		logger.info("-----------payinsertPOST()호출-----------");
		logger.info(vo.toString());
		int result= payservice.create(vo);
		logger.info(result+ "행 삽입");
		if(result==1) {
			reAttr.addFlashAttribute("insert_result", "success");  // 왜 안뜰까?
			// insert_result가 list.jsp로 가고 success라는 문구가 jsp에 전달되면 jsp에서 처리함
			return "redirect:../pay/paylistDetail"; // /pay/paylistDetail 경로로 이동. get 방식
		}else {
			return "redirect:/pay/payinsert";
		}
		
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
		
		
//		logger.info("-----------detail()호출: productId= " + productId +"-----------");
//		logger.info("-----------detail()호출: amount= " + amount +"-----------");
//		Map<String, Object>map2 = new HashMap<String, Object>();
//		ProductVO vo = payservice.detailProduct(productId);
//		map2.put("voId", vo.getProductId());
//		map2.put("voName", vo.getProductName());
//		map2.put("voUrl", vo.getProductUrl());
//		map2.put("voPrice", vo.getProductPrice());		
//		map2.put("amount", amount);
//		map2.put("voTotal", amount*vo.getProductPrice());
//		model.addAttribute("map2", map2);
		
		// model을 이용해 jsp로 보낸다!
		// 기존의 servlet 에서 request.setAttribute() 이거와 같음 -> request나 session과 같은 개념!
		
	}//end list
	
	
	@GetMapping("/paylistDetail")
	// model 과 modelAndView 와 차이점은 리턴값을 어떻게 표기하냐의 차이가 있다!
	// 강의 시간의 배운 방식과 표기법은 model이므로 헷갈리지않게 model 사용!
	public void listDetail(HttpSession session, Model model) {
		logger.info("-----------paylistDetail()호출-----------");
//		String userId=(String)session.getAttribute("userId");
		String userId="1";
		Map<String, Object>map = new HashMap<String, Object>();
		List<PayVO>listDetail = payservice.listPay(userId); //장바구니 정보
				
		map.put("listDetail", listDetail);
		map.put("count", listDetail.size());		
		
		model.addAttribute("map2", map);		
		
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





