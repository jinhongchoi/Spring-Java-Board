package edu.web.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.util.PageCriteria;

public class BoardDAOImple implements BoardDAO, BoardQuery {

	public static BoardDAOImple instance=null;
	
	private BoardDAOImple() {
		
	}
	
	public static BoardDAOImple getinstance() {
		if(instance==null) {
			instance=new BoardDAOImple();
		}
		return instance;
	}
	
	@Override
	public int insert(BoardVO vo) {
		
		int result=0;
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn= ConnMgr.getConnection();
			pstmt= conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setString(3, vo.getMemberId());
			
			result=pstmt.executeUpdate();
			System.out.println(result + "행이 삽입되었습니다.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			ConnMgr.close(conn, pstmt);
		}
		
		return result;
	}//end insert

	@Override
	public List<BoardVO> select() {
		List<BoardVO>list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
				
		try {
			conn=ConnMgr.getConnection();
			pstmt=conn.prepareStatement(SQL_SELECT_ALL);
			
			rs= pstmt.executeQuery();
			
			int boardId;
			String boardTitle;
			String boardContent;
			String memberId;
			Date boardDateCreated;
			
			BoardVO vo= null; // 바로 while문에 넣지 않고 이렇게 선언을 하면 속도의 개선이 이뤄짐!
			
			while(rs.next()) {
				boardId=rs.getInt(COL_BOARD_ID);
				boardTitle=rs.getString(COL_BOARD_TITLE);
				boardContent=rs.getString(COL_BOARD_CONTENT);
				memberId=rs.getString(COL_MEMBER_ID);
				boardDateCreated=rs.getTimestamp(COL_BOARD_DATE_CREATE);
				
				vo= new BoardVO(boardId, boardTitle, boardContent, memberId, boardDateCreated);
				System.out.println(vo);
				
				list.add(vo);
			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnMgr.close(conn, pstmt, rs);
		}		
		
		return list;
	}//end  List<BoardVO> select()

	@Override
	public BoardVO select(int boardId) {
		BoardVO vo= null;
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String boardTitle;
		String boardContent;
		String memberId;
		Date boardDateCreated;
		
		try {
			
			conn=ConnMgr.getConnection();
			pstmt=conn.prepareStatement(SQL_SELECT_BY_BOARD_ID);
			pstmt.setInt(1, boardId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {			
				
				boardTitle=rs.getString(COL_BOARD_TITLE);
				boardContent=rs.getString(COL_BOARD_CONTENT);
				memberId=rs.getString(COL_MEMBER_ID);
				boardDateCreated=rs.getTimestamp(COL_BOARD_DATE_CREATE);
				
				vo=new BoardVO(boardId, boardTitle, boardContent, memberId, boardDateCreated);
				System.out.println(vo);
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnMgr.close(conn, pstmt, rs);
		}
		
		
		return vo;
	}//end select

	@Override
	public int update(BoardVO vo) {
		
		int result=0;
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn= ConnMgr.getConnection();
			pstmt= conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getBoardTitle());
			pstmt.setString(2, vo.getBoardContent());
			pstmt.setInt(3, vo.getBoardId());
			
			result=pstmt.executeUpdate();
			System.out.println(result + "행이 업데이트 되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			ConnMgr.close(conn, pstmt);
		}
		
		return result;
	}//end update

	@Override
	public int delete(int boardId) {
		
		int result =0;
		Connection conn= null;
		PreparedStatement pstmt= null;
		
		try {
			
			conn=ConnMgr.getConnection();
			pstmt= conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, boardId);
			
			result= pstmt.executeUpdate();
			System.out.println(result + "행이 삭제되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnMgr.close(conn, pstmt);
		}
		
		
		return result;
	}//end delete

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		List<BoardVO>list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
				
		try {
			conn=ConnMgr.getConnection();
			pstmt=conn.prepareStatement(SQL_SELECT_PAGESCOPE);
			pstmt.setInt(1, criteria.getStart());
			pstmt.setInt(2, criteria.getEnd());
			
			rs= pstmt.executeQuery();
			
			int boardId;
			String boardTitle;
			String boardContent;
			String memberId;
			Date boardDateCreated;
			
			BoardVO vo= null; // 바로 while문에 넣지 않고 이렇게 선언을 하면 속도의 개선이 이뤄짐!
			
			while(rs.next()) {
				boardId=rs.getInt(COL_BOARD_ID);
				boardTitle=rs.getString(COL_BOARD_TITLE);
				boardContent=rs.getString(COL_BOARD_CONTENT);
				memberId=rs.getString(COL_MEMBER_ID);
				boardDateCreated=rs.getTimestamp(COL_BOARD_DATE_CREATE);
				
				vo= new BoardVO(boardId, boardTitle, boardContent, memberId, boardDateCreated);
				System.out.println(vo);
				
				list.add(vo);
			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnMgr.close(conn, pstmt, rs);
		}		
		
		return list;
	}//end List<BoardVO> select(PageCriteria criteria)

	@Override
	public int getTotalCounts() {
		int count = 0;
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			conn= ConnMgr.getConnection();
			pstmt=conn.prepareStatement(SQL_TOTAL_CNT);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("total_cnt");
			}
			
		} catch (Exception e) {
			
		}finally {
			ConnMgr.close(conn, pstmt, rs);
		}
		
		
		return count;
	}//end getTotalCounts() 

	
	
}//end daoImple
