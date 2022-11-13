package edu.web.Member;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, DBConnectionQuery{
	
	private static MemberDAOImple instance=null;
	
	private MemberDAOImple() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			// 드라이버 로드는 한번만 하면되기때문에 위에다 선언!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MemberDAOImple getInstance() {
		if(instance==null) {
			instance= new MemberDAOImple();
		}
		return instance;
	}// 싱글톤패턴 
		
	private ArrayList<MemberVO> list = new ArrayList<>();
	
	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt =null;
		
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			
			pstmt=conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin()); //배열의 경우 vo에 추가로 하나 더 getInterestJoin메소드를 만들어준다.
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result=pstmt.executeUpdate();
			System.out.println(result +" 행이 삽입되었습니다.");
						
			
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
	public int userCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		int result=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_USERCHECK);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			
			rs=pstmt.executeQuery();			
			System.out.println(result+"행 성공");
			
			if(rs.next()) {
				if(rs.getString("userid") != null &&rs.getString("userid").equals(vo.getUserid())) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
		}
		
		return result;
	}//end userCheck

	@Override
	public MemberVO select(String userid) {
		// TODO Auto-generated method stub
		MemberVO vo= null;
		Connection conn= null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_SELECT);
			
			System.out.println(userid);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			System.out.println(rs);
			
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
	public ArrayList<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberVO>list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_SELECT_ALL);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					 String userid=rs.getString(1);
					 String password=rs.getString(2);
					 String email=rs.getString(3);
					 String emailAgree=rs.getString(4);
					 String[] interest=rs.getString(5).split(",");
					 String phone=rs.getString(6);				 
					 String introduce=rs.getString(7);
					 
					 MemberVO vo= new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
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
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		int result=0;
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
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, vo.getUserid());
			
			result=pstmt.executeUpdate();
			
			System.out.println(result+" 수정되었습니다.");
						
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
		int result =0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt=conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result+"행이 삭제되었습니다.");
			
			
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
			
	
}//end MemberDAOImple












