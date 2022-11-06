package edu.spring.ex03;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class BoardDAOTest {
	private static final Logger logger=
			LoggerFactory.getLogger(BoardDAOTest.class);
	
	
		
}// end DatraSourceTest


















