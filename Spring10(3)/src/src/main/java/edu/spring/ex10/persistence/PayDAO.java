package edu.spring.ex10.persistence;

import java.util.List;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;

public interface PayDAO {
	
	int insert(PayVO vo);
	
	List<PayVO>listPay(String userId);
	
	// 장바구니 목록 불러오기
	List<CartVO>listCart(String userId);
	
	// 상품 정보 불러오기
	ProductVO detailProduct(int productId);
	
	int sumMoney(String userId);
	
}
