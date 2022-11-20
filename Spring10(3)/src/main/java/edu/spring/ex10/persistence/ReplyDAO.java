package edu.spring.ex10.persistence;

import java.util.List;

import edu.spring.ex10.domain.ReplyVO;

public interface ReplyDAO {
	
	int insert(ReplyVO vo);
	
	List<ReplyVO>select(int boardId);
	
	int update(ReplyVO vo);
	
	int delete(int replyId);

}
