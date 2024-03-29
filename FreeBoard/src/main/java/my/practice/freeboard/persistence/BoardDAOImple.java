package my.practice.freeboard.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.practice.freeboard.domain.BoardVO;
import my.practice.freeboard.pageutill.PageCriteria;



@Repository// @Component
// - 영속 계층(Persistence Layer)의 DB관련 기능을 담당
// - Spring Component bean으로 등록함
// - servlet-context.xml의 component-scan을 통해
//   설정된 Component를 찾아봐 bean으로 등록
// - <context:component-scan../>
public class BoardDAOImple implements BoardDAO{ //따로 Query를 상속받지 않는다
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE= 
			"my.practice.freeboard.BoardMapper";
	
	// MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardVO vo) {
		logger.info("--------insert()호출--------");
				
		return sqlSession.insert(NAMESPACE+ ".insert", vo);
		// + 다음에 띄어쓰기 주의할 것!
		// NAMESPACE가 동일한 mapper를 찾아가서 id="insert"인
		// insert 태그에 vo 데이터를 전송
		
		
	}//end insert

	/*
	 * @Override public List<BoardVO> select() {
	 * logger.info("--------select()호출--------");
	 * 
	 * return sqlSession.selectList(NAMESPACE+ ".select_all"); // 쿼리에 ? 가 없는 것들은
	 * 매개변수가 필요 없기 때문에 그냥 statement 가져온다 // mapping에 #이 없으면 ? 가 없는 것이라 생각! -> #이
	 * 매개변수! }//end select
	 */
	@Override
	public BoardVO select(int boardId) {
		logger.info("--------selectOne()호출--------"); 
		return sqlSession.selectOne(NAMESPACE + ".select_by_board_id", boardId);
	}//end select one

	@Override
	public int update(BoardVO vo) {
		logger.info("--------update()호출--------"); 
		
		return sqlSession.update(NAMESPACE + ".update", vo);
	}//end update

	@Override
	public int delete(int boardId) {
		logger.info("--------delete()호출--------");
		return sqlSession.delete(NAMESPACE + ".delete", boardId);
	}//end delete

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		logger.info("--------selectPage()호출--------");
		logger.info("start= "+criteria.getStart());
		logger.info("end= "+criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE+ ".paging", criteria);
	}//end select(PageCriteria criteria)

	@Override
	public int getTotalCount() {
		logger.info("--------getTotalCounts()--------");
		return sqlSession.selectOne(NAMESPACE+ ".total_count");
	}//end getTotalCount()

	@Override
	public List<BoardVO> select(String memberId) {
		logger.info("--------select() 호출: memberId"+ memberId+"--------");
		return sqlSession.selectList(NAMESPACE+ ".select_by_memberid", "%"+memberId+"%");
		// "%" 를 사용하면 검색이 가능하게 memberId가 포함된 글자들이 select된다.
	}//end select(String memberId)

	@Override
	public List<BoardVO> selectBykeyword(String searchType, String keyword) {
		
		 HashMap<String, Object> data = new HashMap<String, Object>();
		 		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		
		logger.info("--------select() 호출: searchType: "+ searchType+"--------");
		logger.info("--------select() 호출: keyword: "+ keyword+"--------");
		return sqlSession.selectList(NAMESPACE+ ".select_by_keyword", data);
	}//end selectByTitleOrContent(String keyword)

	@Override
	public int updateReplyCnt(int amount, int boardId) {
		logger.info("--------updateReplyCnt() 호출: boardId"+ boardId+"--------");
		Map<String, Integer>args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("boardId", boardId);
		
		return sqlSession.update(NAMESPACE+ ".update_reply_cnt", args);
	}//end updateReplyCnt
	
	
}//end daoimple














