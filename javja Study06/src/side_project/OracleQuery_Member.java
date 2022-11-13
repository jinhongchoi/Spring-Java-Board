package side_project;

public interface OracleQuery_Member{
	
	public static final String URL= 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER="SYSTEM";
	public static final String PASSWORD="1234"; //접속하기 위한 로그인 정보들
	
	
	public static final String TABLE_NAME= "EX_MEMBER_SIDE";    //테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_ID ="ID";
	public static final String COL_PW ="PW";
	public static final String COL_NAME ="NAME";
	public static final String COL_GENDER ="GENDER";
	public static final String COL_AGE ="AGE";
	
	public static final String SQL_INSERT=
			"INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?)";
	
	public static final String SQL_IDCHECK=
			"SELECT*FROM "+ TABLE_NAME + " WHERE " + COL_ID + " =?";
	
	public static final String SQL_ID_PWCHECK=
			"SELECT*FROM "+ TABLE_NAME + " WHERE " + COL_ID + " =?" + " AND " + COL_PW + " =?";		
			
		
}
