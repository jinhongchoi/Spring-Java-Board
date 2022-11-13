package edu.web.homework;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import oracle.jdbc.OracleDriver;

public class ContactDAOImple implements OracleQuery_contact_practice, ContactDAO {
	
	private static ContactDAOImple instance= null;
	
	private ContactDAOImple() {}
	
	public static ContactDAOImple getinstance() {
		if(instance ==null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}
	
	@Override
	public int insert(ContactVO vo) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt = null;
		int result =0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 완료");
			
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("db연결 완료");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			//set 할때는 vo.getName 로
			//list 에서 뽑을 땨ㅐ는 list.get(i).getName()
			
			result= pstmt.executeUpdate();
			System.out.println(result +"행이 삽입되었습니다.");
			
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
	}//end result

}
