package edu.spring.ex10.service;

import java.util.List;

import edu.spring.ex10.domain.CartVO;

public interface CartService {

	int create(CartVO vo);
	
	List<CartVO>readCart(String userId);
	
	int delete(int cartId);
	
	int update(CartVO vo);
	
	int sumMoney(String userId);
	
	int countCart(int productId, String userId);
	
	int updateCart(CartVO vo);
	
}
