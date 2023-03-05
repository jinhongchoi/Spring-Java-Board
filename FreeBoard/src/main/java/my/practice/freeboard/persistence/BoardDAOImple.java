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
// - ���� ����(Persistence Layer)�� DB���� ����� ���
// - Spring Component bean���� �����
// - servlet-context.xml�� component-scan�� ����
//   ������ Component�� ã�ƺ� bean���� ���
// - <context:component-scan../>
public class BoardDAOImple implements BoardDAO{ //���� Query�� ��ӹ��� �ʴ´�
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE= 
			"my.practice.freeboard.BoardMapper";
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardVO vo) {
		logger.info("--------insert()ȣ��--------");
				
		return sqlSession.insert(NAMESPACE+ ".insert", vo);
		// + ������ ���� ������ ��!
		// NAMESPACE�� ������ mapper�� ã�ư��� id="insert"��
		// insert �±׿� vo �����͸� ����
		
		
	}//end insert

	/*
	 * @Override public List<BoardVO> select() {
	 * logger.info("--------select()ȣ��--------");
	 * 
	 * return sqlSession.selectList(NAMESPACE+ ".select_all"); // ������ ? �� ���� �͵���
	 * �Ű������� �ʿ� ���� ������ �׳� statement �����´� // mapping�� #�� ������ ? �� ���� ���̶� ����! -> #��
	 * �Ű�����! }//end select
	 */
	@Override
	public BoardVO select(int boardId) {
		logger.info("--------selectOne()ȣ��--------"); 
		return sqlSession.selectOne(NAMESPACE + ".select_by_board_id", boardId);
	}//end select one

	@Override
	public int update(BoardVO vo) {
		logger.info("--------update()ȣ��--------"); 
		
		return sqlSession.update(NAMESPACE + ".update", vo);
	}//end update

	@Override
	public int delete(int boardId) {
		logger.info("--------delete()ȣ��--------");
		return sqlSession.delete(NAMESPACE + ".delete", boardId);
	}//end delete

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		logger.info("--------selectPage()ȣ��--------");
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
		logger.info("--------select() ȣ��: memberId"+ memberId+"--------");
		return sqlSession.selectList(NAMESPACE+ ".select_by_memberid", "%"+memberId+"%");
		// "%" �� ����ϸ� �˻��� �����ϰ� memberId�� ���Ե� ���ڵ��� select�ȴ�.
	}//end select(String memberId)

	@Override
	public List<BoardVO> selectBykeyword(String searchType, String keyword) {
		
		 HashMap<String, Object> data = new HashMap<String, Object>();
		 		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		
		logger.info("--------select() ȣ��: searchType: "+ searchType+"--------");
		logger.info("--------select() ȣ��: keyword: "+ keyword+"--------");
		return sqlSession.selectList(NAMESPACE+ ".select_by_keyword", data);
	}//end selectByTitleOrContent(String keyword)

	@Override
	public int updateReplyCnt(int amount, int boardId) {
		logger.info("--------updateReplyCnt() ȣ��: boardId"+ boardId+"--------");
		Map<String, Integer>args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("boardId", boardId);
		
		return sqlSession.update(NAMESPACE+ ".update_reply_cnt", args);
	}//end updateReplyCnt
	
	
}//end daoimple














