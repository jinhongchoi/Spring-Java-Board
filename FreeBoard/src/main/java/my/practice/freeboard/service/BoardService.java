package my.practice.freeboard.service;

import java.util.List;

import my.practice.freeboard.domain.BoardVO;
import my.practice.freeboard.pageutill.PageCriteria;



// CRUD(Create, Read, Update, Delete)
public interface BoardService {
		
	int create(BoardVO vo);
	
	List<BoardVO>read(PageCriteria criteria);
	//List<BoardVO>read();
	
	List<BoardVO>selectBykeyword(String searchType, String keyword);
	
	BoardVO read(int boardId);
	
	int update(BoardVO vo);
	
	int delete(int boardId);
		
	int getTotalCount();
	
}
