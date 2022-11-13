package edu.web.board.persistence;

public interface BoardQuery {
	
	public static final String TABLE_NAME="BOARD";
	public static final String COL_BOARD_ID="BOARD_ID";
	public static final String COL_BOARD_TITLE="BOARD_TITLE";
	public static final String COL_BOARD_CONTENT="BOARD_CONTENT";
	public static final String COL_MEMBER_ID="MEMBER_ID";
	public static final String COL_BOARD_DATE_CREATE="BOARD_DATE_CREATE";
	
	public static final String SQL_INSERT =
			"insert into "+ TABLE_NAME +" values "
			+"(SEQ_BOARD.nextval, ?, ?, ?, sysdate)";
	public static final String SQL_SELECT_ALL =
			"select * from " + TABLE_NAME + " order by " + COL_BOARD_ID + " desc ";
	
	public static final String SQL_SELECT_BY_BOARD_ID =
			"select * from "+ TABLE_NAME + " where "+COL_BOARD_ID+" =?" ;	
	
	 // - 특정 게시글 수정
	// 쿼리 확인해보기!
	public static final String SQL_UPDATE =
			"update " + TABLE_NAME + " set "
			+ COL_BOARD_TITLE + " =?, "
			+ COL_BOARD_CONTENT + " =?, "
			+ COL_BOARD_DATE_CREATE + " = sysdate "
			+ "where " + COL_BOARD_ID+ " = ?";
	
	 // - 특정 게시글 삭제
	public static final String SQL_DELETE =
			"delete from " + TABLE_NAME + " where "+ COL_BOARD_ID + " =?";
	
	// 게시글 페이징 처리하여선택
	
	public static final String SQL_SELECT_PAGESCOPE =
			"select b."+COL_BOARD_ID+", b."+COL_BOARD_TITLE+", b."+COL_BOARD_CONTENT+", b."+COL_MEMBER_ID+", b."+COL_BOARD_DATE_CREATE+ " from("
			+ "select rownum rn, a.* from ("
					+"select * from "+ TABLE_NAME+" order by "+ COL_BOARD_ID+" desc"
				+ ")a"
				+ ")b where rn BETWEEN ? and ?";
	
	 // select count(*) total_cnt from board;
	public static final String SQL_TOTAL_CNT =
			"select count(*) total_cnt from "+ TABLE_NAME; //갯수 세는 쿼리 
	
	
	
}








