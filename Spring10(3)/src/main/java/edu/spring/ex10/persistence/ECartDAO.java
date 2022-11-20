package edu.spring.ex10.persistence;

import java.util.List;

import edu.spring.ex10.domain.ECartVO;

public interface ECartDAO {
	
	int insert(ECartVO vo);
	
	List<ECartVO>listECart(String userId);
		
	int delete(int ecartId, String userId);
	
	int countECart(int eventId, String userId);
	
}
