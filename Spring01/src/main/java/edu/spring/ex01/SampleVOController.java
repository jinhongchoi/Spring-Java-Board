package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleVOController {
	private static final Logger logger =
			LoggerFactory.getLogger(SampleVOController.class);
	
	@GetMapping("/product1")
	public String product1(Model model, String name, int price) {
		logger.info("product1()호출");
		ProductVO vo= new ProductVO(name, price);
		model.addAttribute("vo", vo);
		
		return "product-result";
	}//end product1()
	
	@GetMapping("/product2")
	public String product2(@ModelAttribute(name="vo")ProductVO vo) { 
		//매개변수가 많을 경우 이런식으로 작성하면 알아서 매칭되어 같은값이 나옴
		// -> 이름을 똑같이 지어놨기 때문에 알아서 매칭이 가능함!
		logger.info("product2()호출");
		
		return "product-result";
	}
	
	
}//end SampleVOController








