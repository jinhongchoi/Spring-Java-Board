package my.practice.freeboard.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.practice.freeboard.domain.ReplyVO;
import my.practice.freeboard.persistence.BoardDAO;
import my.practice.freeboard.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO; // ���⼭�� �ʿ信 ���ؼ� ���� �� ���
	
	// @Transactional
	// - �� ���� �����ͺ��̽� ������ ���� ��,
	// ���� ������ ����Ǿ���, �Ʒ� ������ ������ �߻��ϸ�
	// ���� ������ rollback �Ǿ�� �Ѵ�.
	// �̷��� ����� ���ִ� �̳����̼�
	// -root-context.xml ���� ����
	
	@Transactional
	@Override
	public int create(ReplyVO vo) throws Exception{
		// ����� �����ϸ�
		// �Խ����� ��� ����(reply_cnt) �� ����Ǿ�� ��
		// test_reply ���̺� insert�� �����ϸ�
		// test_board ���̺� update�� �����Ѵ�.
		
		logger.info("-------create() ȣ�� : vo = "+ vo.toString()+"-------");
		replyDAO.insert(vo);
		logger.info("-------��� �Է� ����-------");
		boardDAO.updateReplyCnt(1, vo.getBoardId());
		//boardId �� vo�ȿ� �ֱ� ������ vo���� �������� ���� �Ű����� ���� ���ص���!
		logger.info("-------�Խ��� ��� ���� ������Ʈ ����-------");
		return 1; 
		//return���� �ΰ� ��� �ϴ� ��Ȳ���� 1�� �ϰ� ���� ���� �ΰ� ���ϰ��� �ۼ��Ѵ�!
		// -> service�ܿ��� dao�ΰ� ��� �ϴ� ��Ȳ�ϰ��!
	}//end create

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("-------read() ȣ�� : boardId = "+ boardId+"-------");
		return replyDAO.select(boardId);
	}//end list

	@Override
	public int update(ReplyVO vo) {
		logger.info("-------update() ȣ�� : vo = "+ vo.toString()+"-------");
		return replyDAO.update(vo);
	}//end update
	
	@Transactional
	@Override
	public int delete(int replyId, int boardId) throws Exception{
		logger.info("-------delete() ȣ�� : replyId = "+ replyId+"-------");
		replyDAO.delete(replyId);
		logger.info("-------��� ���� ����-------");
		boardDAO.updateReplyCnt(-1, boardId);
		logger.info("-------�Խ��� ��� ���� ������Ʈ ����-------");
		// service �ܿ��� �Ű������� ������ ����� controller �ܱ��� ������ �ޱ⶧���� ������ ����� �Ѵ�! 		
		return 1;
	}//end delete

}//end imple
