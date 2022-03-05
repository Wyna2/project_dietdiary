package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {//����Ŭ�������� �ʿ�ø��� ȣ���� DBŬ����
	
	//url
	static final String ORACLE_LOCAL="jdbc:oracle:thin:@192.168.0.12:1521:XE";
	
	//Connection
	public Connection getOracle() {
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_LOCAL,"project1","1234");
		} catch (SQLException e) {
			System.out.println("����Ŭ���� ����: "+e.getMessage());
		}
		
		return conn;
	}
	
	//Close..select..�ϼ���sql(statement)
	public void dbClose(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Close..�ϼ���sql(statement)
	public void dbClose(Statement stmt,Connection conn) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Close..select..�̿ϼ���sql(PrepareStatement)
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Close..�ϼ���sql(PrepareStatement)
	public void dbClose(PreparedStatement pstmt,Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
