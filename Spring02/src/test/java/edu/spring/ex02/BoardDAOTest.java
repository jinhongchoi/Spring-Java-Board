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

@RunWith(SpringJUnit4ClassRunner.class) // �̷��� �ڵ��ϼ��� �ϰ� �Ϸ��� builePath ���� add library �尡�� jUnit���� 
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
		// .insert : mapper.xml�� id��
		if(result==1) {
			logger.info("insert ����");			
		}else {
			logger.info("insert ����");			
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
		// .insert : mapper.xml�� id��
		if(result==1) {
			logger.info("update ����");			
		}else {
			logger.info("update ����");			
		}
	}//end update
	
	private void testdelete() {
		int result = dao.delete(3);
		if(result==1) {
			logger.info("delete ����");			
		}else {
			logger.info("delete ����");			
		}
	}//end delete
	
		
}// end DatraSourceTest


















