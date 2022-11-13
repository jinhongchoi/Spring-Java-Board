package side_project;

public interface OracleQuery_TeamInfo {
	
	public static final String URL= 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER="SYSTEM";
	public static final String PASSWORD="1234"; //접속하기 위한 로그인 정보들
	
	
	public static final String TABLE_NAME= "EX_TEAMINFO";    //테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_TEAMNAME ="TEAMNAME";
	public static final String COL_SPORT ="SPORT";
	public static final String COL_LOCATION ="LOCATION";
	public static final String COL_INFORMATION ="INFORMATION";
	public static final String COL_ID ="ID";
	public static final String COL_CONTACTID ="CONTACTID";
	
	public static final String SQL_INSERT = "INSERT INTO "/* into 다음에 공백주의!! */ + TABLE_NAME
			+ " VALUES(?, ?, ?, ?, ?, SEQUENCE1.nextval)";// 뛰어쓰기 안하면 안들어감
	
	public static final String SQL_SELECT =
			"SELECT * FROM "+ TABLE_NAME + " WHERE "+ COL_ID +" =?";
			
	
	public static final String SQL_SELECT_BY_TEAMNAME=
			"SELECT*FROM "+ TABLE_NAME
			+" WHERE "+ COL_CONTACTID +" =?" + " AND " + COL_ID + " = ?" ;
	
	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME+ " SET "+
					COL_TEAMNAME + " = ?, "+
					COL_SPORT + " = ?, "+
					COL_LOCATION + " = ?, "+
					COL_INFORMATION + " = ?, "+
					COL_ID + " = ? "+
//					COL_CONTACTID + " = ? "+
					"WHERE " + COL_CONTACTID + " = ?";
	
	public static final String SQL_DELETE=
			"DELETE "+ TABLE_NAME + " WHERE " + COL_TEAMNAME + " = ?" + " AND " + COL_ID + " = ?" ;
	
	
}
