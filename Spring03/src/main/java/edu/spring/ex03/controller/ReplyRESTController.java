package edu.spring.ex03.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

// * RESTful url과 의미
// /replies (POST) : 댓글추가(insert)
// /replies/all/숫자(GET) : 해당 글 번호(boardId)의 모든 댓글 검색(select)
// /replies/숫자(PUT) : 해당 댓글 번호(replyId)의 내용을 수정(update)
// /replies/숫자(DELETE) : 해당 댓글 번호 (replyId)의 댓글을 삭제(delete)

@RestController //json &ajax 형태를 주고 받을 경우 @RestController 이거 사용 
@RequestMapping(value="/replies")
public class ReplyRESTController {
	private static final Logger logger=
			LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping //POST : 댓글 입력
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO vo) {
		// @RequestBody
		// -클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
		logger.info("-----------createReply() 호출: vo=" + vo.toString()+"-----------");

		// ResponseEntity<T> : Rest 방식에서 데이터를 리턴할 때 쓰이는 객체
		// -데이터와 HttpStatus를 전송
		// - <T> : 보내고자 하는 데이터 타입
		
		int result =replyService.create(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	}//end createReply
	
	@GetMapping("/all/{boardId}") // GET: 댓글 선택(all)
	public ResponseEntity<List<ReplyVO>>readReplies(
			@PathVariable("boardId") int boardId){
		//@PathVariable("boardId") : /all/{boardId} 값을 설정된 변수에 저장
		
		
		List<ReplyVO>list = replyService.read(boardId);
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		
	}//end ResponseEntity
	
	@PutMapping("/{replyId}")
	public ResponseEntity<Integer> updateReply(
			@PathVariable("replyId") int replyId,
			@RequestBody ReplyVO vo){
		vo.setReplyId(replyId);
		int result = replyService.update(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/{replyId}") //그냥 delete 가 아니라 deletemapping 이 되어야 한다!
	public ResponseEntity<Integer>deleteReply(
			@PathVariable("replyId") int replyId){
		
		int result = replyService.delete(replyId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}//end delete
	
}//end ReplyRESTController














