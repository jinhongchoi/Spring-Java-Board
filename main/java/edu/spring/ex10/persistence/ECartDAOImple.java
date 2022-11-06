package edu.spring.ex10.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex10.domain.ECartVO;

@Repository
public class ECartDAOImple implements ECartDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ECartDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex10.ECartMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	// 쿠폰 추가
	public int insert(ECartVO vo) {
		logger.info("----------insert()호출 : vo= "+vo.toString()+"----------");
		return sqlSession.insert(NAMESPACE+ ".insert", vo);
	}

	@Override
	// 쿠폰 목록
	public List<ECartVO> listECart(String userId) {
		logger.info("----------listCart()호출 ----------");
		userId= "1";
		return sqlSession.selectList(NAMESPACE+ ".listECart", userId);		
	}

	@Override
	// 쿠폰 삭제
	public int delete(int ecartId) {
		logger.info("----------delete()호출 ----------");
		return sqlSession.delete(NAMESPACE+ ".delete", ecartId);
	}

	@Override
	// 쿠폰 수량 확인
	public int countECart(int eventId, String userId) {
		logger.info("----------countCart()호출 ----------");
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("eventId", eventId);
		map.put("userId", userId);
		return sqlSession.selectOne(NAMESPACE+ ".countECart", map);
	}

}
