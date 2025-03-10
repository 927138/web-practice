package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

public class ConnectDB {
	
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public ConnectDB (ServletContext application) {
		
		try {
			String driver = application.getInitParameter("MysqlDriver");
			Class.forName(driver);
			
			String url = application.getInitParameter("MysqlURL");
			String user = application.getInitParameter("MysqlUSER");
			String pw = application.getInitParameter("MysqlPW");
			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("application init prams sucess");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("JDBC 자원 해제");
	}
	
}
