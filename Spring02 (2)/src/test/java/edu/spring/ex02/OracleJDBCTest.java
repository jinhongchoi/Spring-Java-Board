package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class) // 이렇게 자동완성을 하게 하려면 builePath 에서 add library 드가서 jUnit선택 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class OracleJDBCTest {
	 private static final Logger logger=
			 LoggerFactory.getLogger(OracleJDBCTest.class);
	 
	 private static final String URL = 
			 "jdbc:oracle:thin:@localhost:1521:xe";
	 
	 private static final String USER ="scott";
	 private static final String PASSWORD ="tiger";
	 
	 @Test // 단위테스트 어노테이션
	 public void testOracleConnection() {
		 Connection conn= null;
		 try {
			DriverManager.registerDriver(new OracleDriver());
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("oracle 연결 성공");
			 
		} catch (Exception e) {
			logger.error("oracle 연결 실패: "+e.getMessage());
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
			 
	 
}
