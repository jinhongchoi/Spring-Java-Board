package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleJSONController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleJSONController.class);
	
	@GetMapping("/json1")
	public String json1() {
		logger.info("json1()호출");
		
		return "sample1"; // jsp 호출
	}//end json1()
	
	@GetMapping("/json2")
	@ResponseBody // 이걸 껴주면 json 으로 변한다! 이렇게 바뀌면서 페이지를 불러오는게 아니고 데이터 자체를 불러오게 된다!
	public String json2() {
		logger.info("json2()호출");
		
		return "Hello, Spring";
	}// end json2()
	
	
	@GetMapping("/json3")
	@ResponseBody
	public ProductVO json3() { // 리턴타입이 vo
		logger.info("json3()호출");
		
		return new ProductVO("야구공",1000);
		
	}//end json3()
	
}//end SampleJSONController









