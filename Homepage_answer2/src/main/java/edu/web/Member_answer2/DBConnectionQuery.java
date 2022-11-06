package edu.web.Member_answer2;

public interface DBConnectionQuery {
	//DB 접속에 필요한 상수 정의				
	public static final String URL= "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로 
	// 1521: 뒤에 버젼에 따라 xe일수 있고 다른거일수도 있으니 복붙할시 버젼생각! 
	public static final String USER="SYSTEM";
	public static final String PASSWORD="1234"; //접속하기 위한 로그인 정보들
	
	public static final String TABLE_NAME= "TEST_MEMBER";    //테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_USERID ="USERID";
	public static final String COL_PASSWORD ="PASSWORD";
	public static final String COL_EMAIL ="EMAIL";
	public static final String COL_EMAIL_AGREE ="EMAIL_AGREE";
	public static final String COL_INTEREST ="INTEREST";
	public static final String COL_PHONE ="PHONE";
	public static final String COL_INTRODUCE ="INTRODUCE";
	
	// insert into TEST_MEMBER values
	//(?, ?, ?, ?, ?, ?, ?);
	public static final String SQL_INSERT = "insert into "+ TABLE_NAME
			+ " values (?, ?, ?, ?, ?, ?, ?)"; //쿼리 검증시 ?(물음표) 부분은 작은따옴표로 해서 값넣어서 검증해볼것!
	
	public static final String SQL_USERCHECK =
			"select * from "+TABLE_NAME+" where "+COL_USERID+" = ? and "+COL_PASSWORD+" = ?" ;
	
	public static final String SQL_SELECT =
			"select * from "+TABLE_NAME+" where "+COL_USERID+" = ?" ;
	
	public static final String SQL_SELECT_ALL= 
			"SELECT * FROM "+ TABLE_NAME + " ORDER BY "+COL_USERID;
	
	public static final String SQL_UPDATE= 
			"UPDATE " + TABLE_NAME+ " SET "+
					COL_PASSWORD + " = ?, "+
					COL_EMAIL + " = ?, "+
					COL_EMAIL_AGREE + " = ?, "+
					COL_INTEREST + " = ?, "+
					COL_PHONE + " = ?, "+
					COL_INTRODUCE + " = ? "+					
					"WHERE " + COL_USERID+ " = ?";

	public static final String SQL_DELETE=
			"DELETE "+ TABLE_NAME + " WHERE " + COL_USERID + " = ?";
	
	public static final String SQL_IDCHECK =
			"select * from "+TABLE_NAME+" where "+COL_USERID+" = ?" ;
	

}//end DBConnectionQuery
