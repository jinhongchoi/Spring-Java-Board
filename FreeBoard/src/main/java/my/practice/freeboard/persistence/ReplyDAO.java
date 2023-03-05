package my.practice.freeboard.persistence;

import java.util.List;

import my.practice.freeboard.domain.ReplyVO;

public interface ReplyDAO {
	
	int insert(ReplyVO vo);
	
	List<ReplyVO>select(int boardId);
	
	int update(ReplyVO vo);
	
	int delete(int replyId);

}
