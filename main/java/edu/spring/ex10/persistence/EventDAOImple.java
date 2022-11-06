package edu.spring.ex10.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex10.domain.EventVO;
import edu.spring.ex10.pageutil.PageCriteria;

@Repository
public class EventDAOImple implements EventDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ProductDAOImple.class);
	private static final String NAMESPACE= 
			"edu.spring.ex10.EventMapper";
	
	@Autowired
	private SqlSession sqlSession;	

	@Override
	public int insert(EventVO vo) {
		logger.info("--------insert()호출--------");
		
		return sqlSession.insert(NAMESPACE+ ".registerEvent", vo);
		
	}//end insert

	@Override
	public List<EventVO> listEvent() {
		// TODO Auto-generated method stub
		logger.info("--------listProduct()호출--------");
		
		return sqlSession.selectList(NAMESPACE+ ".listEvent");
	}//end list

	@Override
	public EventVO detailEvent(int eventId) {
		logger.info("--------detailProduct()호출--------"); 
		logger.info(String.valueOf(eventId));
		return sqlSession.selectOne(NAMESPACE + ".detailEvent", eventId);
	}//end detail

	@Override
	public int update(EventVO vo) {
		logger.info("--------update()호출--------");
		return sqlSession.update(NAMESPACE+ ".updateEvent", vo);
	}

	@Override
	public int delete(int eventId) {
		logger.info("--------delete()호출--------");
		return sqlSession.delete(NAMESPACE+ ".deleteEvent", eventId);
	}


	@Override
	public List<EventVO> select(PageCriteria criteria) {
		logger.info("--------selectPage()호출--------");
		logger.info("start= "+criteria.getStart());
		logger.info("end= "+criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE+ ".paging", criteria);
	}

	@Override
	public int getTotalCount() {
		logger.info("--------getTotalCounts()--------");
		return sqlSession.selectOne(NAMESPACE+ ".total_count");
	}

}







