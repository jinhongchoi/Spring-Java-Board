package edu.spring.ex10.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex10.domain.ProductVO;
import edu.spring.ex10.pageutil.PageCriteria;


@Repository
public class ProductDAOImple implements ProductDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ProductDAOImple.class);
	private static final String NAMESPACE= 
			"edu.spring.ex10.ProductMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ProductVO vo) {
		logger.info("--------insert()호출--------");
		
		return sqlSession.insert(NAMESPACE+ ".registerProduct", vo);
		
	}//end insert

	@Override
	public List<ProductVO> listProduct(String productCate) {
		// TODO Auto-generated method stub
		
		logger.info("--------listProduct()호출--------");
		return sqlSession.selectList(NAMESPACE+ ".listProduct", productCate);
	}//end list

	@Override
	public ProductVO detailProduct(int productId) {
		logger.info("--------detailProduct()호출--------"); 
		logger.info(String.valueOf(productId));
		return sqlSession.selectOne(NAMESPACE + ".detailProduct", productId);
	}//end detail

	@Override
	public int update(ProductVO vo) {
		logger.info("--------update()호출--------");
		return sqlSession.update(NAMESPACE+ ".updateProduct", vo);
	}

	@Override
	public int delete(int productId) {
		logger.info("--------delete()호출--------");
		return sqlSession.delete(NAMESPACE+ ".deleteProduct", productId);
	}

	@Override
	public List<ProductVO> select(PageCriteria criteria) {
		logger.info("--------selectPage()호출--------");
		logger.info("start= "+criteria.getStart());
		logger.info("end= "+criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE+ ".paging", criteria);
	}

	@Override
	public int getTotalCount() {
		logger.info("--------getTotalCounts()--------");
		return sqlSession.selectOne(NAMESPACE+ ".total_count");
	}
	
	
	

}
