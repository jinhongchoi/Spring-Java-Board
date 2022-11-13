package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import oracle.jdbc.driver.OracleDriver;

public class JoinDAOImple implements JoinDAO, LoginQuery  {
	
	private static JoinDAOImple instance=null;
	
	public JoinDAOImple() {}
	
	public static JoinDAOImple getInstance() {
		if(instance==null) {
			instance= new JoinDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(JoinVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("JDBC - 입력받은 데이터를 쿼리에 적용하여 insert");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt= conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getAge());
			
			result= pstmt.executeUpdate();
			
			System.out.println(result+"행이 삽입되었습니다.");
			
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return result;
	}

}
