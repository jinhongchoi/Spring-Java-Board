package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// POJO : Plain Old Java Object
@Controller
// servlet-context.xml 파일에서
// component-scanning의 대상으로 만들어주는 어노테이션
// @Component 어노테이션을 사용해도 됨
public class SampleController1 {
	// 스프링 프레임워크에서 로그를 사용하기 위한 객체
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController1.class); //로그 찍는 방법!
	
	@RequestMapping(value="/sample1", method =RequestMethod.GET)//get 방식으로 /value 경로로 오면 아래와 같이 호출 된다는 의미! 
	// @RequestMapping : 컨트롤러의 URL 매핑과 메소드(GET/POST/PUT/DELETE) 를 설정
	// value = URL 경로 
	// method = 요청방식 설정(GET, POST, PUT, DELETE)
	// method 속성을 생략하면 GET/POST 모두 처리 가능
	// short cut 기능 : @GetMapping, @PostMapping, ...
	
	public String sample1() {
		logger.info("sample1() 호출");
		return "sample1"; // jsp 경로 및 이름
		
		// WEB-INF/views/sample1.jsp로 찾아감(servlet-context,xml에 설정되어 있음)
		// * 컨트롤러 메소드 return 값의 의미
		// ViewResolver에서 실제 view를 결정하도록(찾도록)요청
		// return타입이 void인 경우는 URL 매핑을 통해서 view를 찾음
		
	}//end sample1()
	
	@RequestMapping(value="/sample2") //.jsp 가아니라 sample2 에서 끝낸다! 주소 검색시
	public void sample2() {
		// 리턴 문자열이 없으면 url 이름에 맞는 jsp를 찾아서 적용
		logger.info("sample2()호출");
		
	}//end sample2()
	
}//end SampleController1












