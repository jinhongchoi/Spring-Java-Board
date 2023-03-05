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

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;


@RunWith(SpringJUnit4ClassRunner.class) // �̷��� �ڵ��ϼ��� �ϰ� �Ϸ��� builePath ���� add library �尡�� jUnit���� 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReplyDAOTest {
	private static final Logger logger=
			LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao; // -> �̰ǰ� ������
	
	@Test
	public void testDAO() {
//		testInsert();
//		testSelectAll();
//		testUpdate();
//		testDelete();
	}



	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, 3, "test", "���", null);
		int result = dao.insert(vo);
		logger.info("------------"+result+"�� ���� ------------");
		
	} //end testInsert
	
	private void testSelectAll() {
		List<ReplyVO>list = dao.select(3);
		logger.info("------------"+list.size()+""+"------------");
		for(ReplyVO vo : list) {
			logger.info(vo.toString());
		}
		
	}//end selectAll
	
	private void testUpdate() {
		ReplyVO vo = new ReplyVO(3, 0, null, "������", null);
		int result = dao.update(vo);
		logger.info("------------"+result+"�� ���� ------------");
		
	}//end update
	
	private void testDelete() {
		int result = dao.delete(3);
		logger.info("------------"+result+"�� �簡��------------");
		
	}
		
}// end DatraSourceTest


















