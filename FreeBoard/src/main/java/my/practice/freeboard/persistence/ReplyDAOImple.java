package my.practice.freeboard.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.practice.freeboard.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE =
			"my.practice.freeboard.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(ReplyVO vo) {
		logger.info("----------insert()호출 : vo= "+vo.toString()+"----------");
		
		return sqlSession.insert(NAMESPACE+ ".insert2", vo);
	}//end insert

	@Override
	public List<ReplyVO> select(int boardId) {
		logger.info("----------select()호출 : boardId= "+boardId+"----------");
		
		return sqlSession.selectList(NAMESPACE+ ".select_all_by_board_id", boardId);
	}//end list

	@Override
	public int update(ReplyVO vo) {
		logger.info("----------update()호출 : vo= "+vo.toString()+"----------");
		
		return sqlSession.update(NAMESPACE+ ".update2", vo);
	}//end update

	@Override
	public int delete(int replyId) {
		logger.info("----------delete()호출 : replyId= "+replyId+"----------");
		
		return sqlSession.delete(NAMESPACE+ ".delete2", replyId);
	}//end delete

}//end daoimple







