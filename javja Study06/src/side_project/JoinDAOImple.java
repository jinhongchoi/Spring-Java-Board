package side_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleDriver;

public class JoinDAOImple implements OracleQuery_Member, JoinDAO {
	
	private static JoinDAOImple instance= null;
	
	public JoinDAOImple() {}
	
	public static JoinDAOImple getinstance() {
		if(instance==null) {
			instance= new JoinDAOImple();
		}
		return instance;
	}
	

	@Override
	public int insert(JoinVO vo) {
		// TODO Auto-generated method stub
		System.out.println("JDBC - 입력받은 데이터를 쿼리에 적용하여 insert");
		int result= 0;
		Connection conn= null;
		PreparedStatement pstmt= null;
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt= conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setInt(5, vo.getAge());
			
			result=pstmt.executeUpdate();
			System.out.println(result+ "행이 삽입되었습니다.");
			
			
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
	}//end insert

	@Override
	public int idcheck(JoinVO vo) {
		// TODO Auto-generated method stub
		int result =-1;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt=conn.prepareStatement(SQL_IDCHECK);
			pstmt.setString(1, vo.getId());
			
			rs=pstmt.executeQuery();
			//rs 는 데이터 베이스 안에서 지정한 컬럼에 찾는 과정임! 
			//그래서 원하는 값을 불러오는 과정을 할때는 rs를 통해서 db에서 찾는 과정을 거침
			
			if(rs.next()) {
				if(rs.getString("id")!=null && rs.getString("id").equals(vo.getId())) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생: "+e.toString());
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		return result;
	}//end idcheck

}//end JoinDAOImple
