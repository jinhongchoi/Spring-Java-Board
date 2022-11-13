package side_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import oracle.jdbc.OracleDriver;

public class TeamMateDAOImple implements TeamMateDAO, OracleQuery_TeamMate {
	private static TeamMateDAOImple instance=null;
	private TeamMateDAOImple() {
		
	}
	
	public static TeamMateDAOImple getinstance() {
		if(instance==null) {
			instance=new TeamMateDAOImple();
		}
		return instance;
	}
	
	private ArrayList<TeamMateVO>list = new ArrayList<>();
	
	@Override
	public int insert(TeamMateVO vo) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn= null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt=conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getTeamName());
			pstmt.setString(2, vo.getGender());
			pstmt.setInt(3, vo.getAge());
			pstmt.setInt(4, vo.getHeight());
			pstmt.setString(5, vo.getPosition()	);
			pstmt.setInt(6, vo.getBackNo());
			pstmt.setString(7, vo.getTeamName());
//			pstmt.setInt(8, vo.getCid());
			
			result= pstmt.executeUpdate();
			
			if(result ==1) {
				System.out.println(result+ " 행이 삽입되었습니다.");
			}else {
				System.out.println("실패하였습니다.");
			}
			
			
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
	public ArrayList<TeamInfoVO> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<TeamInfoVO>list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db 로드 완료");
			
			pstmt=conn.prepareStatement(SQL_SELECTB);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				String teamname = rs.getString(1);
				String sport = rs.getString(2);
				String location = rs.getString(3);
				String information = rs.getString(4);
				String id = rs.getString(5);
				int contactID = rs.getInt(6);
				
				TeamInfoVO vo= new TeamInfoVO(teamname, sport, location, information, id, contactID);
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
		
		return null;
	}//end selectAllTeamInfo

	@Override
	public int delete(int cid) {
		
		// TODO Auto-generated method stub
		int result=0;
		Connection conn= null;
		PreparedStatement pstmt= null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db 연결 성공");
			
			pstmt=conn.prepareStatement(SQL_DELETE);
			
			pstmt.setInt(1, cid);
			
			result= pstmt.executeUpdate();
			System.out.println(result + " 삭제 되었습니다.");
			
			
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
