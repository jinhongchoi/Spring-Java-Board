package edu.web.member_practice;

public interface DBConnectionQuery {
	//DB 접속에 필요한 상수 정의				
	public static final String URL= "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER="scott";
	public static final String PASSWORD="tiger"; //접속하기 위한 로그인 정보들
	
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
	
	

}//end DBConnectionQuery
