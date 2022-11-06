package edu.spring.ex10.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;
import edu.spring.ex10.persistence.PayDAO;

@Service
public class PayServiceImple implements PayService {
	
	private static final Logger logger=
			LoggerFactory.getLogger(ProductServiceImple.class);
	
	@Autowired
	private PayDAO dao;

	@Override
	// 결제 등록
	public int create(PayVO vo) {
		logger.info("---------create()호출 ---------");
		return dao.insert(vo);
	}//end create

	@Override
	// 결제 목록
	public List<PayVO> listPay(String userId) {
		// logger.info("---------List()호출 ---------");
		return dao.listPay(userId);
	}//end list

	@Override
	// 상품 목록 불러오기
	public List<CartVO> readCart(String userId) {
		logger.info("---------readCart()호출 ---------");
		return dao.listCart(userId);
	}

	@Override
	public int sumMoney(String userId) {
		logger.info("---------sumMoney()호출 ---------");
		return dao.sumMoney(userId);
	}

	@Override
	public ProductVO detailProduct(int productId) {
		logger.info("---------detail()호출 ---------");
		return dao.detailProduct(productId);
	}//end detail

}
