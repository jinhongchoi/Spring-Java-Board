package edu.spring.ex10.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.PayDetailVO;
import edu.spring.ex10.domain.PayProductVO;
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
	
	//장바구니 결제 등록
	@Override
	public int create2(PayDetailVO vo) {
		logger.info("---------create2()호출 ---------");
		return dao.insert2(vo);
	}//end create2

	@Override
	// 결제 목록
	public List<PayVO> listPay(String userId) {
		 logger.info("---------List()호출 ---------");
		return dao.listPay(userId);
	}//end list
	
	//장바구니 결제 목록
	@Override
	public List<PayDetailVO> listPayDetail(PayDetailVO vo) {
		 logger.info("---------listPayDetail()호출 ---------");
		return dao.listPayDetail(vo);
	}

	
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

	@Override
	public int sumMoney2(int productId) {
		logger.info("---------sumMoney2()호출 ---------");
		return dao.sumMoney2(productId);
	}

	@Override
	public int cartAllDelete(String userId) {
		logger.info("---------cartAllDelete()호출 ---------");
		return dao.delete(userId);
	}




}
