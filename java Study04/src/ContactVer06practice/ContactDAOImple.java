package ContactVer06practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class ContactDAOImple implements ContactDAO, OracleQuery {

	private static ContactDAOImple instance = null;

	public ContactDAOImple() {
	}

	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	private ArrayList<ContactVO> list = new ArrayList<>();

	@Override
	public int insert(ContactVO vo) {

		System.out.println("JDBC - 입력받은 데이터를 쿼리에 적용하여 insert");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");

			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());

			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return result;
	}// end insert

	@Override
	public ArrayList<ContactVO> select() {
		// TODO Auto-generated method stub
		
		ArrayList<ContactVO>list=new ArrayList<ContactVO>(); 
		//이거 안넣으면 검색시 계속 늘어남 -원인 파악 할것!

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			String SQL_SELECT_ALL = "select * from " + TABLE_NAME + " order by " + COL_CONTACT_ID;
			System.out.println(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int contactId = rs.getInt(1);//COL_CONTACT_ID 이거 넣어도 같은 결과!
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String Email = rs.getString(4);

				ContactVO vo = new ContactVO(contactId, name, phone, Email);
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
	public ContactVO select(int index) {
		// TODO Auto-generated method stub
		ArrayList<ContactVO>list=new ArrayList<ContactVO>();
		
		ContactVO vo=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int contactId = 0;
		try {

			System.out.println("드라이버 로드 성공");
			DriverManager.registerDriver(new OracleDriver());

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_INDEX);
			pstmt.setInt(1, index); //실수 했었음!
			//번호 지정하는 것들은 set int를 한다!!
			rs = pstmt.executeQuery();

			if (rs.next()) {
				contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);

				vo = new ContactVO(contactId, name, phone, email);
//				System.out.println(vo); //이거 땜에 검색이 안됐음!
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
	}// end select

	@Override
	public int update(int index, ContactVO vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result=0;
		
		try {

			System.out.println("드라이버 로드 성공");
			DriverManager.registerDriver(new OracleDriver());

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_UPDATE);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getContactId());//번호 지정하는 것들은 setint를 한다!!
			
			result= pstmt.executeUpdate(); //이것도 빼먹었음!

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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

	@Override
	public int delete(int contactId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt=conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, contactId); //중요!! list.remove대신 사용!
			//번호 지정하는 것들은 setint를 한다!!
			
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
				e2.printStackTrace();
			}
		}
		
		
		return result;
	}//end delete


}
