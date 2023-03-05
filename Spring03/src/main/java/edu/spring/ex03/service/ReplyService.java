package edu.spring.ex03.service;

import java.util.List;

import edu.spring.ex03.domain.ReplyVO;

public interface ReplyService {
	
	int create(ReplyVO vo);
	
	List<ReplyVO> read(int boardId);
	
	int update(ReplyVO vo);
	
	int delete(int replyId);
	
}
