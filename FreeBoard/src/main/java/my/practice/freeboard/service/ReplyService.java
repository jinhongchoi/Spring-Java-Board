package my.practice.freeboard.service;

import java.util.List;

import my.practice.freeboard.domain.ReplyVO;

public interface ReplyService {
	
	int create(ReplyVO vo) throws Exception;
	
	List<ReplyVO> read(int boardId);
	
	int update(ReplyVO vo);
	
	int delete(int replyId, int boardId) throws Exception;
	// service �ܿ��� �Ű������� ������ ����� controller �ܱ��� ������ �ޱ⶧���� ������ ����� �Ѵ�! 
}
