package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame {

	private LoginFrame() {}
	private static LoginFrame instance=new LoginFrame();
	public static LoginFrame getInstance() {
		return instance;
	}
	DbConnect db=new DbConnect();
	
	public int findByIdPw(String id,String pw)
	{
		Connection conn=db.getOracle();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from mainlogin where id=? and pw=?";
	try {
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			return 1;
		}
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		db.dbClose(rs, pstmt, conn);
	} return -1;
}
	/*
	public static void main(String[] args) {

	}
	*/
}