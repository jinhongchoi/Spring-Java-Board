package edu.spring.ex10.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex10.domain.CartVO;

@Repository
public class CartDAOImple implements CartDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(CartDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex10.CartMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(CartVO vo) {
		logger.info("----------insert()호출 : vo= "+vo.toString()+"----------");
		return sqlSession.insert(NAMESPACE+ ".insert", vo);
	}

	@Override
	public List<CartVO> listCart(String userId) {
		logger.info("----------listCart()호출 ----------");
		userId= "1";
		return sqlSession.selectList(NAMESPACE+ ".listCart", userId);		
	}

	@Override
	public int delete(int cartId) {
		logger.info("----------delete()호출 ----------");
		return sqlSession.delete(NAMESPACE+ ".delete", cartId);
	}

	@Override
	public int update(CartVO vo) {
		logger.info("----------update()호출 ----------");
		return sqlSession.update(NAMESPACE+ ".update", vo);
	}

	@Override
	public int sumMoney(String userId) {
		logger.info("----------sumMoney()호출 ----------");
	
		return sqlSession.selectOne(NAMESPACE+ ".sumMoney", userId);
	}

	@Override
	public int countCart(int productId, String userId) {
		logger.info("----------countCart()호출 ----------");
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("productId", productId);
		map.put("userId", userId);
		return sqlSession.selectOne(NAMESPACE+ ".countCart", map);
	}

	@Override
	public int updateCart(CartVO vo) {
		logger.info("----------updateCart()호출 ----------");
		return sqlSession.update(NAMESPACE+ ".updateCart", vo);
	}

}
