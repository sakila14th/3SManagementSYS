package dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBAccessUtil {
	/*
	 * Singleton模式的工具类
	 * 主要提供给TransactionLogic来调用
	 */
	private DBAccessUtil _instance = null;
	private DBAccessUtil(){
	}
	protected DBAccessUtil getInstance(){
		if(_instance==null){
			return new DBAccessUtil();
		}
		return _instance;
	}
	protected ResultSet select(Connection conn, String sql){
		try {
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL error: select()");
			throw new ExceptionInInitializerError(e);
		}
	}
	protected void delete(Connection conn, String sql){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL error: delete()");
			throw new ExceptionInInitializerError(e);
		}
	}
	protected void insert(Connection conn, String sql){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL error: insert()");
			throw new ExceptionInInitializerError(e);
		}
	}
	protected void update(Connection conn, String sql){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL error: update()");
			throw new ExceptionInInitializerError(e);
		}
	}
}
