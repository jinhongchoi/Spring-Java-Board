package edu.spring.ex10.persistence;

import java.util.List;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.ECartVO;
import edu.spring.ex10.domain.PayDetailVO;
import edu.spring.ex10.domain.PayProductVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;

public interface PayDAO {
	
	// 단일 주문
	int insert(PayVO vo);
	
	List<PayVO>listPay(String userId);
	
	// 장바구니 주문
	int insert2(PayDetailVO vo);
	
	// 장바구니 주문 불러오기
	List<PayDetailVO>listPayDetail(PayDetailVO vo);
	
	// 쿠폰목록 불러오기
	List<ECartVO>listECart(String userId);
	
	// 장바구니 목록 불러오기
	List<CartVO>listCart(String userId);
	
	// 상품 정보 불러오기
	ProductVO detailProduct(int productId);
	
	int sumMoney(String userId);
	
	int sumMoney2(int productId);
	
	int delete(String userId);
	
}
