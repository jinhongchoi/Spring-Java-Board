package edu.spring.ex10.service;

import java.util.List;


import edu.spring.ex10.pageutil.PageCriteria;
import edu.spring.ex10.domain.ProductVO;


// CRUD(Create, Read, Update, Delete)
public interface ProductService {
		
	int create(ProductVO vo);
	
	List<ProductVO>read(PageCriteria criteria);
	List<ProductVO>listProduct(String productCate);
	
	ProductVO detailProduct(int productId);
	
	int update(ProductVO vo);
	
	int delete(int productId);
	
	int getTotalCount();
}
