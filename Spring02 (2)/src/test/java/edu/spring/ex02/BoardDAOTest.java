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
import edu.spring.ex02.pageutil.PageCriteria;
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
//		testSelectPageing();
//		testTotalCnt();
//		testSelectSearch();
//		testSelectTitleorContent();
	}


	private void testInsert() {
		BoardVO vo= new BoardVO(0, "test", "test", "gold", null, 0);
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
	
	private void testSelectPageing() {
		PageCriteria criteria = new PageCriteria(2, 3);
		List<BoardVO>list = dao.select(criteria);
		for(BoardVO vo : list) {
			logger.info(vo.toString());
			
		}
		
	}//end selectPageing
	

	private void testTotalCnt() {
		int totalCounts= dao.getTotalCount();
		logger.info("총 게시글 수 : "+ totalCounts);
		
	}//end testTotalCnt()
	
	private void testSelectSearch() {
		List<BoardVO>list = dao.select("ol");
		for(BoardVO vo : list) {
			logger.info(vo.toString());
			
		}
		
		/*
		 * log4j.xml에 
		 * 
		 * 	<!-- Application Loggers -->
			<logger name="edu.spring.ex02">
			<level value="debug" />
			</logger>
		 * 
		 * 이 부분에 log 를 debug로 바꾸게 되면 콘솔창에 쿼리 및 파라미터를 어떻게 작성했는지 알 수 있다!
		 *  log4j.xml는 src/test/resource에 있음 (main 에도 같은 경로에 있다)
		 * 
		 * */
		
	}//end testSelectSearch()
	
	private void testSelectTitleorContent() {
		List<BoardVO>list =dao.selectByTitleOrContent("sd");
		for(BoardVO vo : list) {
			logger.info(vo.toString());
			
		}
	}//end testSelectTitleorContent()
	
		
}// end DatraSourceTest


















