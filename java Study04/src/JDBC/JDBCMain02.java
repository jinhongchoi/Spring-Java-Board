package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JDBCMain02 {

	// 1. DB에 사용할 상수들
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger"; // 접속하기 위한 로그인 정보들

	public static final String TABLE_NAME = "EX_CONTACT"; // 테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static void main(String[] args) {

		System.out.println("JDBC 2 - Update");

		Connection conn = null;
		Statement stmt = null;

		try { // 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Connection 객체를 사용하여 Statement 객체를 생성
			stmt = conn.createStatement();

			// 5. SQL 문장 작성(DB에서 만들고 검증 후 가져온거!)
			// UPDATE EX_CONTACT
			// SET NAME='둘리',
			// PHONE = '010-2222-2222',
			// EMAIL = 'dooli@test.com'
			// WHERE CONTACT_ID=2;
			String sql_update=
					"UPDATE "+TABLE_NAME+
					" SET "+COL_NAME+"='둘리', "+
					COL_PHONE+ " = '010-2222-2222', "+
					COL_EMAIL+ " = 'dooli@test.com' "+
					"WHERE "+ COL_CONTACT_ID +" =2";
			

			// 6. SQL 문장 실행(DB서버로 SQL 전송)
			// executeUpdate(): INSERT, UPDATE, DELETE를 처리할 때 사용
			// executeQuery(): SELECT를 처리할 때 사용
			int result = stmt.executeUpdate(sql_update);

			// 7. DB서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 수정되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end main()

}// end JDBCMain02
