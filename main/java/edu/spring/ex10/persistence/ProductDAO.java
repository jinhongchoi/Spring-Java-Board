package edu.spring.ex10.persistence;

import java.util.List;


import edu.spring.ex10.pageutil.PageCriteria;
import edu.spring.ex10.domain.ProductVO;


public interface ProductDAO {
	
	int insert(ProductVO vo);
	
	List<ProductVO>listProduct(String productCate);
	
	ProductVO detailProduct(int productId);
	
	int update(ProductVO vo);
	
	int delete(int productId);
	
	List<ProductVO>select(PageCriteria criteria);
	
	int getTotalCount();
	
}
