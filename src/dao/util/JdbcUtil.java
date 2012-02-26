package dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	// DB����
	private static String _user = "root";
	private static String _password = "root";
	private static String _url = "jdbc:mysql://localhost:3306/3s_db";

	// Singleton
	private JdbcUtil() {
	}

	// ע������
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	// ��ȡ����
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(_url, _user, _password);
	}

	// �ͷ���Դ
	public static void dispose(ResultSet rs, Statement st, Connection conn) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.err.println("SQL error: rs.close() exception");
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("SQL error: st.close() exception");
				e.printStackTrace();
				throw new ExceptionInInitializerError(e);
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("SQL error: conn.close() exception");
					e.printStackTrace();
					throw new ExceptionInInitializerError(e);
				}
			}
		}
	}
}
