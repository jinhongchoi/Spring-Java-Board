package edu.spring.ex02;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class) // 이렇게 자동완성을 하게 하려면 builePath 에서 add library 드가서 jUnit선택 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardControllTest {
	private static final Logger logger=
			LoggerFactory.getLogger(BoardControllTest.class);
	
	@Autowired
	private WebApplicationContext wac; //웹 어플리케이션 객체
	
	// MVC 패턴의 앱을 테스트하는 mock-up 객체
	private MockMvc mock;
	
	@Before //junit으로 쓸 것!
	// JUnit 테스트를 실행하기 전에 초기화 작업을 수행하는 메소드
	public void beforeTest() {
		logger.info("----------beforeTest()호출----------");
		//컨트롤러 메소드에게 요청을 보낼 수 있는 mockup 객체 생성
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
		
	}//end before
	
	@Test
	public void test() {
		testList();
	}

	private void testList() {
		logger.info("testList()호출");
		
		MultiValueMap<String, String>params = new LinkedMultiValueMap<String, String>();
		//parameter는 String 형식이어서 위의 타입에 String으로 들어간다
		params.add("page", "1");
		params.add("numsPerPage", "2");
		
		RequestBuilder requestBuilder = get("/board/list").params(params);
		try {
			mock.perform(requestBuilder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end testList
		
}//end BoardControllerTest


















