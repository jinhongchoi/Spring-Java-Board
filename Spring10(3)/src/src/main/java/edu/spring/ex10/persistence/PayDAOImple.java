package edu.spring.ex10.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;

@Repository
public class PayDAOImple implements PayDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(PayDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex10.PayMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(PayVO vo) {
		logger.info("----------insert()호출 : vo= "+vo.toString()+"----------");
		return sqlSession.insert(NAMESPACE+ ".insert", vo);
	}


	@Override
	public List<PayVO> listPay(String userId) {
		logger.info("----------listPay()호출 ----------");
		userId= "1";
		return sqlSession.selectList(NAMESPACE+ ".listPay", userId);		
	}

	@Override
	public int sumMoney(String userId) {
		logger.info("----------sumMoney()호출 ----------");
		
		return sqlSession.selectOne(NAMESPACE+ ".sumMoney", userId);
	}


	@Override
	public List<CartVO> listCart(String userId) {
		logger.info("----------listCart()호출 ----------");
		userId= "1";
		return sqlSession.selectList(NAMESPACE+ ".listCart", userId);		
	}


	@Override
	public ProductVO detailProduct(int productId) {
		logger.info("--------detailProduct()호출--------"); 
		logger.info(String.valueOf(productId));
		return sqlSession.selectOne(NAMESPACE + ".detailProduct", productId);
	}//end detail

}
