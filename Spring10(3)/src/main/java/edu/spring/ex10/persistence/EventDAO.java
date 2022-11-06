package edu.spring.ex10.persistence;

import java.util.List;

import edu.spring.ex10.domain.EventVO;
import edu.spring.ex10.pageutil.PageCriteria;

public interface EventDAO {
	
	int insert(EventVO vo);
	
	List<EventVO>listEvent();
	
	EventVO detailEvent(int eventId);
	
	int update(EventVO vo);
	
	int delete(int eventId);
	
	List<EventVO>select(PageCriteria criteria);
	
	int getTotalCount();
	
}
