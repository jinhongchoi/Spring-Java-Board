package my.practice.freeboard.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.practice.freeboard.domain.BoardVO;
import my.practice.freeboard.pageutill.PageCriteria;
import my.practice.freeboard.persistence.BoardDAO;



@Service // @Component
// * 서비스 계층(Service/Business Layer)
// - 표현계층(Presentation Layer- controller 단)과 영속 계층(Persistence Layer) 사이클 연결하여
//   두 계층이 직접적으로 통신하지 않도록 하는 역할
// - 트렌젝션(transaction) 관리 -> 이게 핵심
//   DB와 상관없이 데이터를 처리 가능
public class BoardServiceImple implements BoardService {
	
	private static final Logger logger=
		LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) {
		logger.info("---------create()호출 : vo= "+vo.toString()+"---------");
		return dao.insert(vo);
	}//end create

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		logger.info("---------read()호출 ---------");
		logger.info("start = "+criteria.getStart());
		logger.info("end = "+ criteria.getEnd());
		return dao.select(criteria);
	}//end readPage
	
	/*
	 * @Override public List<BoardVO> read() {
	 * logger.info("---------read()호출 ---------"); return dao.select(); }
	 */


	@Override
	public BoardVO read(int boardId) {
		logger.info("---------read()호출 : boardId= "+boardId+"---------");
		return dao.select(boardId);
	}//end read

	@Override
	public int update(BoardVO vo) {
		logger.info("---------update()호출 : vo= "+vo.toString()+"---------");
		return dao.update(vo);
	}//end update

	@Override
	public int delete(int boardId) {
		logger.info("---------delete()호출 : boardId= "+boardId+"---------");
		return dao.delete(boardId);
	}//end delete

	@Override
	public int getTotalCount() {
		logger.info("--------getTotalCounts()호출 --------");
		return dao.getTotalCount();
	}//end getTotalCount

	@Override
	public List<BoardVO> selectBykeyword(String searchType, String keyword) {
		// TODO Auto-generated method stub
		logger.info("--------selectBykeyword()호출 --------");
		return dao.selectBykeyword(searchType, keyword);
	}


}//end imple









