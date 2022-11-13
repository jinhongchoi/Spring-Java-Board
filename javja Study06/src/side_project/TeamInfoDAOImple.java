package side_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class TeamInfoDAOImple implements OracleQuery_TeamInfo, TeamInfoDAO {
	
	private static TeamInfoDAOImple instance= null;
	
	private TeamInfoDAOImple() {}
	
	public static TeamInfoDAOImple getinstance() {
		if(instance==null) {
			instance = new TeamInfoDAOImple();
		}
		return instance;
	}
	
	private ArrayList<TeamInfoVO>list = new ArrayList<>();
	

	@Override
	public int insert(TeamInfoVO vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt=conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getTeamName());
			pstmt.setString(2, vo.getSport());
			pstmt.setString(3, vo.getLocation());
			pstmt.setString(4, vo.getInformation());
			pstmt.setString(5, vo.getId());
			
			result= pstmt.executeUpdate();
			System.out.println(result + " 행이 삽입되었습니다.");
				
			
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
	} //end insert

	@Override
	public ArrayList<TeamInfoVO> select(String id) {
		// TODO Auto-generated method stub
		ArrayList<TeamInfoVO>list= new ArrayList<>();
		//이걸 넣고 안넣냐에 따라 재검색시 기존에 테이블 값이 남아 있냐 안남아있냐 차이가 생김!!
		//데이터list 의 초기화 하는 코드! list의 초기화 하는 코드!!
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT);
			pstmt.setString(1, id); 
			//매개변수가 필요하게 쿼리를 작성시 pstmt.setString 으로 필요한 값을 입력되게 한다! 
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
				String teamname= rs.getString(1);
				String sport= rs.getString(2);
				String location = rs.getString(3);
				String information = rs.getString(4);
				id= rs.getString(5);
				int contactId=rs.getInt(6);
				
				TeamInfoVO vo= new TeamInfoVO(teamname, sport, location, information, id, contactId);
				list.add(vo);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
		
		return list;
	}//end select
	
	public TeamInfoVO select(int contactId, String id) {
		TeamInfoVO vo=null;
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db 연결 성공");
			
			pstmt= conn.prepareStatement(SQL_SELECT_BY_TEAMNAME);
			pstmt.setInt(1, contactId);
			pstmt.setString(2, id);
			
			rs= pstmt.executeQuery();//rs로 값을 가져온다!
			
			if(rs.next()) {//값을 한개만 가져올땐 if(rs.next) /전체 가져올땐 while(rs.next)
				String teamName = rs.getString(1);
				String sport = rs.getString(2);
				String location = rs.getString(3);
				String information = rs.getString(4);
				id = rs.getString(5);
				int contactID = rs.getInt(6);
				
				vo= new TeamInfoVO(teamName, sport, location, information, id, contactID);
				list.add(vo);//rs에서 가져온 값을 list에 추가
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
				
		return vo;		
	}//end select

	@Override
	public int update(TeamInfoVO vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt=conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getTeamName());
			pstmt.setString(2, vo.getSport());
			pstmt.setString(3, vo.getLocation());
			pstmt.setString(4, vo.getInformation());
			pstmt.setString(5, vo.getId());
			pstmt.setInt(6, vo.getContactId());
			
			result=pstmt.executeUpdate();
			
			System.out.println(result + " 행이 수정되었습니다.");
					
			
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
	}//end update

	@Override
	public int delete(String teamName, String id) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt=conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(1, teamName);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result +" 삭제되었습니다.");
			
			
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
	}//end delete

}//end DAOImple
