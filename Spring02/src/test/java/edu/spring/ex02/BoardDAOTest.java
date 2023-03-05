package edu.spring.ex02;

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

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class) // 이렇게 자동완성을 하게 하려면 builePath 에서 add library 드가서 jUnit선택 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardDAOTest {
	private static final Logger logger=
			LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testDAO() {
		testInsert();
//		testSelectAll();
//		testSelectOne();
//		testupdate();
//		testdelete();
	}

	private void testInsert() {
		BoardVO vo= new BoardVO(1, "test", "test", "gold", null, 0);
		int result = dao.insert(vo);
		// .insert : mapper.xml의 id값
		if(result==1) {
			logger.info("insert 성공");			
		}else {
			logger.info("insert 실패");			
		}
		
	}//end insert
	
	private void testSelectAll() {
		List<BoardVO>list= dao.select();
		for(BoardVO vo : list) {
			logger.info(vo.toString());
		}
		
	}//end selectAll
	
	private void testSelectOne() {
		BoardVO vo= dao.select(1);
		logger.info(vo.toString());
		
	}//end selectOne
	
	private void testupdate() {
		BoardVO vo= new BoardVO(1, "test", "test", "silver", null, 0);
		int result = dao.update(vo);
		// .insert : mapper.xml의 id값
		if(result==1) {
			logger.info("update 성공");			
		}else {
			logger.info("update 실패");			
		}
	}//end update
	
	private void testdelete() {
		int result = dao.delete(3);
		if(result==1) {
			logger.info("delete 성공");			
		}else {
			logger.info("delete 실패");			
		}
	}//end delete
	
		
}// end DatraSourceTest


















