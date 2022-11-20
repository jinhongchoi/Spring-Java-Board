package edu.spring.ex10.service;

import java.util.List;


import edu.spring.ex10.domain.ECartVO;

public interface ECartService {
	
	int create(ECartVO vo);
	
	List<ECartVO>readECart(String userId);
	
	int delete(int ecartId, String userId);
			
	int countECart(int eventId, String userId);

}
