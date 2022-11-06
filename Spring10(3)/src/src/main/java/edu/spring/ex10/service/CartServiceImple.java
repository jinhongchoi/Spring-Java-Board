package edu.spring.ex10.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.persistence.CartDAO;

@Service
public class CartServiceImple implements CartService {
	
	private static final Logger logger=
			LoggerFactory.getLogger(CartServiceImple.class);
	
	@Autowired
	private CartDAO dao;

	@Override
	// 장바구니 추가
	public int create(CartVO vo) { 
		logger.info("---------create()호출 : vo= "+vo.toString()+"---------");
		return dao.insert(vo);
	}

	@Override
	// 장바구니 목록
	public List<CartVO> readCart(String userId) {
		logger.info("---------readCart()호출 ---------");
		return dao.listCart(userId);
	}

	@Override
	// 장바구니 삭제
	public int delete(int cartId) {
		logger.info("---------delete()호출 ---------");
		return dao.delete(cartId);
	}

	@Override
	// 장바구니 수정
	public int update(CartVO vo) {
		logger.info("---------update()호출 ---------");
		return dao.update(vo);
	}

	@Override
	// 장바구니 금액 합계
	public int sumMoney(String userId) {
		logger.info("---------sumMoney()호출 ---------");
		return dao.sumMoney(userId);
	}

	@Override
	// 장바구니 상품 확인
	public int countCart(int productId, String userId) {
		logger.info("---------countCart()호출 ---------");
		return dao.countCart(productId, userId);
	}

	@Override
	// 장바구니 상품 수량 변경
	public int updateCart(CartVO vo) {
		logger.info("---------updateCart()호출 ---------");
		return dao.updateCart(vo);
	}

}








