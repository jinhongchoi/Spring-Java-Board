package edu.spring.ex02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) // 이렇게 자동완성을 하게 하려면 builePath 에서 add library 드가서 jUnit선택 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {
	private static final Logger logger=
			LoggerFactory.getLogger(DataSourceTest.class);
	
	// Spring Framework가 관리하는 DataSource 객체를 주입받음
	// - root-context.xml 에서 bean으로 선택된 DataSource 객체를 주입받음(밑에 과정이)
	
	@Autowired //이렇게 anotation 을 해놓으면 알아서 찾아감
	private DataSource ds; //DataSource- javax.sql로 import 할 것! -> rootContext 에 있는 ds를 가져온 과정
	
	@Test
	public void testDataSource() {
		Connection conn= null;
		
		try {
			conn= ds.getConnection();
			logger.info("DataSource 연결 성공");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("DataSource 연결 실패: "+e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
	}
	
}// end DatraSourceTest
