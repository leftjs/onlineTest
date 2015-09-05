package com.iweb.dao.impl;

import java.sql.*;

public class BaseDAO {

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/onlinetest";
	
	static {
		try{
			Class.forName(DRIVER);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
//		try{
//			if(rs != null && !rs.isClosed()){
//				rs.close();
//			}
//			if(pstmt != null && !pstmt.isClosed()){
//				pstmt.close();
//			}
//			if(conn != null && !conn.isClosed()){
//				conn.close();
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
}
