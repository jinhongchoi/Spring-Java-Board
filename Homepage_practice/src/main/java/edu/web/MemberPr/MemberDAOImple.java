package edu.web.MemberPr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, DBConnectionQuery {
	
	private static MemberDAOImple instance=null;
	
	private MemberDAOImple() {
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	public static MemberDAOImple getInstance() {
		if(instance==null) {
			instance=new MemberDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			
			conn=DriverManager.getConnection(URL, USER,PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin()); //배열의 경우 vo에 추가로 하나 더 getInterestJoin메소드를 만들어준다.
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());//담기만 하기 때문에 따로 vo소환할 필요 없다!		
			
			result=pstmt.executeUpdate();
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
	}//end insert

	@Override
	public int Login(String userid, String password) {
		int result=-1;
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
				
		try {
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_USERCHECK);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("userid") != null &&rs.getString("userid").equals(userid)) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
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
				
		return result;
	}//end userCheck

	@Override
	public MemberVO select(String userid) {
		// TODO Auto-generated method stub
		MemberVO vo=null;
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try {
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db 연결 완료");
			
			pstmt=conn.prepareStatement(SQL_SELECT);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				 userid=rs.getString(1);				 
				 String password=rs.getString(2);
				 String email=rs.getString(3);
				 String emailAgree=rs.getString(4);
				 String[] interest=rs.getString(5).split(",");
				 String phone=rs.getString(6);				 
				 String introduce=rs.getString(7);
				 
				 vo= new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
				 System.out.println(vo);
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
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		int result =0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_UPDATE);
						
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.getInterestJoin()); //배열의 경우 vo에 추가로 하나 더 getInterestJoin메소드를 만들어준다.
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());//담기만 하기 때문에 따로 vo소환할 필요 없다!	
			pstmt.setString(7, vo.getUserid());
			
			result=pstmt.executeUpdate();
			System.out.println(result +"행이 업데이트 되었습니다.");
			
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
	public int delete(String userid) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt= null;
		
		try {
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(1, userid);
			
			result=pstmt.executeUpdate();
			
			if(result==1) {
				System.out.println(result + "행이 삭제되었습니다.");
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
	}//end delete

}//end DAOImple












