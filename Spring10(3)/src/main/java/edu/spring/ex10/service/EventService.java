package edu.spring.ex10.service;

import java.util.List;

import edu.spring.ex10.domain.EventVO;

import edu.spring.ex10.pageutil.PageCriteria;

public interface EventService {
	
	int create(EventVO vo);
	
	List<EventVO>read(PageCriteria criteria);
	List<EventVO>listEvent();
	
	EventVO detailEvent(int eventId);
	
	int update(EventVO vo);
	
	int delete(int eventId);
	
	int getTotalCount();
	
}
