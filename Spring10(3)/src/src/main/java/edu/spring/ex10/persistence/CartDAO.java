package edu.spring.ex10.persistence;



import java.util.List;

import edu.spring.ex10.domain.CartVO;

public interface CartDAO {
	
	int insert(CartVO vo);
	
	List<CartVO>listCart(String userId);
	
	int delete(int cartId);
	
	int update(CartVO vo);
	
	int sumMoney(String userId);
	
	int countCart(int productId, String userId);
	
	int updateCart(CartVO vo);
	
}
