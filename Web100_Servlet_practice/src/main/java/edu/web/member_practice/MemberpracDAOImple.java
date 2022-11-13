package edu.web.member_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import oracle.jdbc.OracleDriver;

public class MemberpracDAOImple implements DBConnectionQuery, MemberpracDAO {
	
	private static MemberpracDAOImple instance=null;
	
	private MemberpracDAOImple() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("오라클 드라이버 로드 완료");
			//그동안은 밑에다가 매번썼지만 드라이버는 한번만 로드하면 되므로 위에다가 이렇게 작성해도 괜찮
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//end 
	
	public static MemberpracDAOImple getInstance() {
		if(instance==null) {
			instance= new MemberpracDAOImple();
		}
		return instance;
	}//end 싱글톤
	
	@Override
	public int insert(MemberpracVO vo) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 성공"); //이건 db랑 연결(url.user,pw가 드가니까!) 위에는 드라이버 불러오는거!
			
			pstmt=conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			// 배열로 등록되기 위해서는 vo에 새로운 매소드 만들어줘야하고 배열로 등록되게끔
			// 식을 작성!
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result=pstmt.executeUpdate();
			System.out.println(result+" 행이 삽입되었습니다.");
			
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

}//end DAOImple
