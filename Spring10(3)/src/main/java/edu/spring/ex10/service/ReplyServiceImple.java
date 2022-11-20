package edu.spring.ex10.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex10.domain.ReplyVO;
import edu.spring.ex10.persistence.BoardDAO;
import edu.spring.ex10.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO; // 여기서는 필요에 의해서 갖다 쓴 경우
	
	// @Transactional
	// - 두 개의 데이터베이스 변경이 생길 때,
	// 위의 내용이 수행되었고, 아래 내용이 에러가 발생하면
	// 위의 내용은 rollback 되어야 한다.
	// 이러한 기능을 해주는 이노테이션
	// -root-context.xml 에서 설정
	
	@Transactional
	@Override
	public int create(ReplyVO vo) throws Exception{
		// 댓글이 증가하면
		// 게시판의 댓글 개수(reply_cnt) 가 변경되어야 함
		// test_reply 테이블에 insert를 수행하면
		// test_board 테이블에 update를 수행한다.
		
		logger.info("-------create() 호출 : vo = "+ vo.toString()+"-------");
		replyDAO.insert(vo);
		logger.info("-------댓글 입력 성공-------");
		boardDAO.updateReplyCnt(1, vo.getBoardId());
		//boardId 가 vo안에 있기 때문에 vo에서 가져오면 따로 매개변수 선언 안해도됨!
		logger.info("-------게시판 댓글 개수 업데이트 성공-------");
		return 1; 
		//return값을 두개 줘야 하는 상황에서 1로 하고 위와 같이 두개 리턴값을 작성한다!
		// -> service단에서 dao두개 줘야 하는 상황일경우!
	}//end create

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("-------read() 호출 : boardId = "+ boardId+"-------");
		return replyDAO.select(boardId);
	}//end list

	@Override
	public int update(ReplyVO vo) {
		logger.info("-------update() 호출 : vo = "+ vo.toString()+"-------");
		return replyDAO.update(vo);
	}//end update
	
	@Transactional
	@Override
	public int delete(int replyId, int boardId) throws Exception{
		logger.info("-------delete() 호출 : replyId = "+ replyId+"-------");
		replyDAO.delete(replyId);
		logger.info("-------댓글 삭제 성공-------");
		boardDAO.updateReplyCnt(-1, boardId);
		logger.info("-------게시판 댓글 개수 업데이트 성공-------");
		// service 단에서 매개변수의 변경이 생기면 controller 단까지 영향을 받기때문에 수정을 해줘야 한다! 		
		return 1;
	}//end delete

}//end imple
