package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import oracle.jdbc.OracleDriver;

public class JDBCMain04 {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB경로
	public static final String USER = "system";
	public static final String PASSWORD = "1234"; // 접속하기 위한 로그인 정보들

	public static final String TABLE_NAME = "EX_CONTACT"; // 테이블의 이름이랑 같게한다!, 실수하면 안됨!
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static void main(String[] args) {
		System.out.println("JDBC 4 - select by index");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try { // 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Connection 객체를 사용하여 Statement 객체를 생성
			stmt = conn.createStatement();

			// 5. SQL 문장 작성(DB에서 만들고 검증 후 가져온거!)
			String sql_select_by_contact_id=
					"SELECT * FROM "+ TABLE_NAME+
					" WHERE "+COL_CONTACT_ID+" =2";
			System.out.println(sql_select_by_contact_id);
			

			// 6. SQL 문장 실행(DB서버로 SQL 전송)
			rs = stmt.executeQuery(sql_select_by_contact_id);

			// 7. DB서버가 보낸 결과 확인/처리
			// ResultSet.next():
			// ResultSet에서 다음 행(row, record)이 있으면
			// true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경

			// ArrayList<ContactVO>
			
			if (rs.next()) { // 레코드가 존재할 때까지
				int contactId = rs.getInt(1); // CONTACT_ID 컬럼 ->컬럼의 데이터 타입 신경써서 int 인지 String 인지 신경쓸것!
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4); // EMAIL 컬럼

				ContactVO vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
			}
			
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

}// end JDBCMain04
