package side_project;

public interface OracleQuery_TeamMate {
	
	public static final String URL= 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER="SYSTEM";
	public static final String PASSWORD="1234"; //접속하기 위한 로그인 정보들
	
	public static final String TABLE_NAME1= "EX_TEAMMATE";    //테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String TABLE_NAME2= "EX_TEAMINFO";
	public static final String COL_NAME ="NAME";
	public static final String COL_GENDER ="GENDER";
	public static final String COL_AGE ="AGE";
	public static final String COL_HEIGHT ="HEIGHT";
	public static final String COL_POSITION ="POSITION";
	public static final String COL_BACKNO ="BACKNO";
	public static final String COL_TEAMNAME ="TEAMNAME";
	public static final String COL_CID ="CID";
	
	public static final String SQL_INSERT = "INSERT INTO "/* into 다음에 공백주의!! */ + TABLE_NAME1
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, SEQUENCE2.nextval)";// 뛰어쓰기 안하면 안들어감
	
	public static final String SQL_SELECTA= 
			"SELECT * FROM "+ TABLE_NAME1 + " ORDER BY "+COL_NAME;
	
	public static final String SQL_SELECTB= 
			"SELECT * FROM "+ TABLE_NAME2 + " ORDER BY "+COL_NAME;
	
	public static final String SQL_DELETE=
			"DELETE "+ TABLE_NAME1+ " WHERE " + COL_CID + " = ?";

}
