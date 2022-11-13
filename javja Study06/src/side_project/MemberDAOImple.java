package side_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements OracleQuery_Member, MemberDAO {
	
	private static MemberDAOImple instance= null;
	
	public MemberDAOImple() {}
	
	public static MemberDAOImple getinstance() {
		if(instance==null) {
			instance=new MemberDAOImple();
		}
		return instance;
	}//end instance

	@Override
	public int userCheck(MemberVO vo) {//로그인 imple
		// TODO Auto-generated method stub
		int result =-1;
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());//oracle 드라이버를 로드 하는거 먼저!
			System.out.println("드라이버 로드 성공");
			
			conn= DriverManager.getConnection(URL, USER, PASSWORD);//getconnection이 있으니 여기가 db연결하는거
			System.out.println("DB연결 성공");
			
			pstmt=conn.prepareStatement(SQL_ID_PWCHECK);
			pstmt.setString(1, vo.getId());//위에 매개 변수를 선언했으니 저기서 가져와야함!
			pstmt.setString(2, vo.getPw());
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {// rs는 db에서 순서대로 값을 찾는 코드임! rs.next하면 db에서 지정한 값을 순서대로 찾는다.
				//if 로 식을 세우면 한번, while 로 식을 세우면 반복!
				if(rs.getString("pw")!=null&& rs.getString("pw").equals(vo.getPw())) {
					
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
				e2.toString();
			}
		}
		
		return result;
	}//end userCheck

}//end MemberDAOImple
