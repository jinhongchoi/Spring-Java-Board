package ContactVer06practice;

public interface OracleQuery {
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER = "SYSTEM";
	public static final String PASSWORD = "1234"; // 접속하기 위한 로그인 정보들
	
	public static final String TABLE_NAME = "EX_CONTACT"; // 테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";
	
	public static final String SQL_INSERT = "INSERT INTO "/* into 다음에 공백주의!! */ + TABLE_NAME
			+ " VALUES(SEQUENCE1.nextval, ?, ?, ?)";// 뛰어쓰기 안하면 안들어감
	
	public static final String SQL_SELECT_ALL=
			"select * from "+TABLE_NAME+" order by "+COL_CONTACT_ID;
	
	public static final String SQL_SELECT_BY_INDEX=
			"select * from "+TABLE_NAME+" where "+COL_CONTACT_ID+" = ?";
	

	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME+ " SET "+
					COL_NAME + " = ?, "+
					COL_PHONE + " = ?, "+
					COL_EMAIL + " = ? "+
					"WHERE " + COL_CONTACT_ID+ " = ?";
	
	public static final String SQL_DELETE=
			"DELETE "+ TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = ?";

}
