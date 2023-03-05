package my.practice.freeboard.persistence;

import java.util.List;

import my.practice.freeboard.domain.BoardVO;
import my.practice.freeboard.pageutill.PageCriteria;


public interface BoardDAO {
	
	int insert(BoardVO vo);
	
	//List<BoardVO>select();
	
	BoardVO select(int boardId);
	
	int update(BoardVO vo);
	
	int delete(int boardId);
	
	List<BoardVO>select(PageCriteria criteria);
	
	int getTotalCount();
	
	List<BoardVO> select(String memberId);
	
	List<BoardVO> selectBykeyword(String searchType, String keyword);
	
	int updateReplyCnt(int amount, int boardId);

	//List<BoardVO>selectSearchList(BoardVO boardVO);
	
}
