package edu.web.homework;

public interface OracleQuery_contact_practice {
	
	public static final String URL= 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER="SYSTEM";
	public static final String PASSWORD="1234"; //접속하기 위한 로그인 정보들
	
	public static final String TABLE_NAME= "EX_CONTACT_PRACTICE";    //테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_NAME ="NAME";
	public static final String COL_PHONE ="PHONE";
	public static final String COL_EMAIL ="EMAIL";
		
	public static final String SQL_INSERT=
			"INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?)";
	

}
