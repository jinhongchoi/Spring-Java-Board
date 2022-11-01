package edu.spring.ex10.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.spring.ex10.domain.ProductVO;
import edu.spring.ex10.pageutil.PageCriteria;
import edu.spring.ex10.persistence.ProductDAO;

@Service
public class ProductServiceImple implements ProductService {
	
	private static final Logger logger=
			LoggerFactory.getLogger(ProductServiceImple.class);
	
	@Autowired
	private ProductDAO dao;
	
	@Override
	public int create(ProductVO vo) {
		logger.info("---------create()호출 ---------");
		return dao.insert(vo);
	}//end create

	@Override
	public List<ProductVO>listProduct(String productCate) {
		logger.info("---------List()호출 ---------");
		return dao.listProduct(productCate);
	}//end listRead

	@Override
	public ProductVO detailProduct(int productId) {
		logger.info("---------detail()호출 ---------");
		return dao.detailProduct(productId);
	}//end detail

	@Override
	public int update(ProductVO vo) {
		logger.info("---------update()호출 : vo= "+vo.toString()+"---------");
		return dao.update(vo);
	}

	@Override
	public int delete(int productId) {
		logger.info("---------delete()호출 ---------");
		return dao.delete(productId);
	}

	@Override
	public List<ProductVO> read(PageCriteria criteria) {
		logger.info("---------read()호출 ---------");
		logger.info("start = "+criteria.getStart());
		logger.info("end = "+ criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public int getTotalCount() {
		logger.info("--------getTotalCounts()호출 --------");
		return dao.getTotalCount();
	}


}
