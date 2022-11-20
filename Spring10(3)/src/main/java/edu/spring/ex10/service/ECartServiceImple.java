package edu.spring.ex10.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex10.domain.ECartVO;
import edu.spring.ex10.persistence.ECartDAO;

@Service
public class ECartServiceImple implements ECartService {
	
	private static final Logger logger=
			LoggerFactory.getLogger(ECartServiceImple.class);
	
	@Autowired
	private ECartDAO dao;
	
	@Override
	// 쿠폰 추가
	public int create(ECartVO vo) {
		logger.info("---------create()호출 : vo= "+vo.toString()+"---------");
		return dao.insert(vo);
	}

	@Override
	// 쿠폰 목록
	public List<ECartVO> readECart(String userId) {
		logger.info("---------readECart()호출 ---------");
		return dao.listECart(userId);
	}

	@Override
	//쿠폰 삭제
	public int delete(int ecartId, String userId) {
		logger.info("---------delete()호출 ---------");
		return dao.delete(ecartId, userId);
	}

	@Override
	//쿠폰 수량 확인
	public int countECart(int eventId, String userId) {
		logger.info("---------countECart()호출 ---------");
		return dao.countECart(eventId, userId);
	}

}
