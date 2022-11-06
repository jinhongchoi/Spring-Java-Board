package edu.spring.ex10.service;

import java.util.List;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;

public interface PayService {
	
	int create(PayVO vo);
	
	List<PayVO>listPay(String userId);
	
	List<CartVO>readCart(String userId);
	
	// 상품 정보
	ProductVO detailProduct(int productId);
	
	int sumMoney(String userId);
	
}
