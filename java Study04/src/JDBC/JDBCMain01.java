package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

// JDBC: Java DataBase Connection
// 0. 데이터베이스 라이브러리를 프로젝트에 추가
//		1) 프로젝트에 lib 폴더를 생성
//		2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib (11g xe 기준)
//			폴더에 있는 ojdbc6.jar 파일을 프로젝트의 lib 폴더에 복사
//		3) 복사한 jar 파일(라이브러리)을 build path에 추가
//		(마우스 오른쪽 클릭 -> Build Path -> Add to Build Path)
// 1. DB와 연동하기 위해 필요한 상수들을 정의
// 2. JDBC 드라이버를 메모리에 로드
// 3. DB가 Connection(연결)을 맺음
// 4. Connection 객체를 사용하여 Statement 객체를 생성.
// 5. SQL 문장을 생성
// 6. Statement 객체를 사용하여 SQL 문장을 실행(DB 서버로 SQL 문장을 전송)
// 7. DB 서버가 보내준 결과를 확인/처리

public class JDBCMain01 {
	
	// 1. DB에 사용할 상수들
	public static final String URL= 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER="system";
	public static final String PASSWORD="1234"; //접속하기 위한 로그인 정보들
	// 위의 3개가 접속하기 위한 로그인 정보들
	
	
	//밑에 5개는 만들 테이블의 이름 및 컬럼 명들
	public static final String TABLE_NAME= "EX_CONTACT";    //테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_CONTACT_ID ="CONTACT_ID";
	public static final String COL_NAME ="NAME";
	public static final String COL_PHONE ="PHONE";
	public static final String COL_EMAIL ="EMAIL";
		

	public static void main(String[] args) {
		System.out.println("JDBC 1 - insert");
		
		//두개가 연결을 맺기위한 변수선언
		Connection conn=null;
		Statement stmt =null;
		
		
		//try-catch 구문으로 선언!
		try { // 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 3. DB와 Connection(연결)을 맺음
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 4. Connection 객체를 사용하여 Statement 객체를 생성
			stmt=conn.createStatement();
			
			// 5. SQL 문장 작성(DB에서 만들고 검증 후 가져온거!)
			//INSERT INTO EX_CONTACT
			//VALUES(CONTACT_SEQ.nextval, 'CHOI', '010-1111-1111', 'TEST@TEST.COM');
			String sql_insert="INSERT INTO "/*into 다음에 공백주의!!*/+ TABLE_NAME 
					+" VALUES(CONTACT_SEQ.nextval, 'CHOI', '010-1111-1111', 'TEST@TEST.COM')";//뛰어쓰기 안하면 안들어감
			System.out.println(sql_insert);
			
			// 6. SQL 문장 실행(DB서버로 SQL 전송)
			int result = stmt.executeUpdate(sql_insert);
			
			
			// 7. DB서버가 보낸 결과 확인/처리
			System.out.println(result+"행이 삽입되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}//end main()

}//end JDBCMain01
