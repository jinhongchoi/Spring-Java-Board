package edu.spring.ex10.service;

import java.util.List;

import edu.spring.ex10.domain.CartVO;
import edu.spring.ex10.domain.ECartVO;
import edu.spring.ex10.domain.PayDetailVO;
import edu.spring.ex10.domain.PayProductVO;
import edu.spring.ex10.domain.PayVO;
import edu.spring.ex10.domain.ProductVO;

public interface PayService {
	
	// 단일 결제 주문 넣기
	int create(PayVO vo);
	
	// 장바구니 주문 넣기
	int create2(PayDetailVO vo);
	
	List<PayVO>listPay(String userId);
	
	// 쿠폰목록	
	List<ECartVO>readECart(String userId);
	
	//장바구니 결제 목록 불러오기
	List<PayDetailVO>listPayDetail(PayDetailVO vo);
	
	List<CartVO>readCart(String userId);
	
	// 상품 정보
	ProductVO detailProduct(int productId);
	
	int sumMoney(String userId);
	
	int sumMoney2(int productId);
	
	int cartAllDelete(String userId);
	
}
