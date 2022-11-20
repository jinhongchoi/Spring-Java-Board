package edu.spring.ex10.persistence;

import java.util.List;

import edu.spring.ex10.domain.BoardVO;
import edu.spring.ex10.pageutil.PageCriteria;


public interface BoardDAO {
	
	int insert(BoardVO vo);
	
	List<BoardVO>select();
	
	BoardVO select(int boardId);
	
	int update(BoardVO vo);
	
	int delete(int boardId);
	
	List<BoardVO>select(PageCriteria criteria);
	
	int getTotalCount();
	
	List<BoardVO> select(String memberId);
	
	List<BoardVO> selectByTitleOrContent(String keyword);
	
	int updateReplyCnt(int amount, int boardId);
	
}
