package my.practice.freeboard.service;

import java.util.List;

import my.practice.freeboard.domain.ReplyVO;

public interface ReplyService {
	
	int create(ReplyVO vo) throws Exception;
	
	List<ReplyVO> read(int boardId);
	
	int update(ReplyVO vo);
	
	int delete(int replyId, int boardId) throws Exception;
	// service 단에서 매개변수의 변경이 생기면 controller 단까지 영향을 받기때문에 수정을 해줘야 한다! 
}
