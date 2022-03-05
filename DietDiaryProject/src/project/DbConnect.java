package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {//여러클래스에서 필요시마다 호출할 DB클래스
	
	//url
	static final String ORACLE_LOCAL="jdbc:oracle:thin:@192.168.0.12:1521:XE";
	
	//Connection
	public Connection getOracle() {
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_LOCAL,"project1","1234");
		} catch (SQLException e) {
			System.out.println("오라클연결 실패: "+e.getMessage());
		}
		
		return conn;
	}
	
	//Close..select..완성형sql(statement)
	public void dbClose(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Close..완성형sql(statement)
	public void dbClose(Statement stmt,Connection conn) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Close..select..미완성형sql(PrepareStatement)
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Close..완성형sql(PrepareStatement)
	public void dbClose(PreparedStatement pstmt,Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
