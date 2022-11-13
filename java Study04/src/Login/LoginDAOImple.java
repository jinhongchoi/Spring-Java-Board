package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleDriver;

public class LoginDAOImple implements LoginQuery, LoginDAO {

	private static LoginDAOImple instance = null;

	public LoginDAOImple() {

	}

	public static LoginDAOImple getinstance() {
		if (instance == null) {
			instance = new LoginDAOImple();
		}
		return instance;
	}

	
	@Override
	public int userCheck(LoginVO vo2) {
		// TODO Auto-generated method stub

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_CHECK);
			pstmt.setString(1, vo2.getId());
			pstmt.setString(2, vo2.getPw());


			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("pw") != null && rs.getString("pw").equals(vo2.getPw())) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}

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

}// end class
