package itwill.xyz.jdcbtam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public abstract class ProjectDbcpFactory {
	private static PoolDataSource pds;
	// Connection 객체가 저장된 DBCP 기능을 가진 객체를 생성하고 DBCP 기능을 가진 객체로부터 Connection 객체를 제공받아 반환하는 메소드와
	// JDBC 관련 객체를 매개변수로 전달받아 삭제하는 기능의 메소드 작성
	static {
		pds = PoolDataSourceFactory.getPoolDataSource(); // dbcp기능을 가진 객체를 생성하여 connection 객체로 제공받음
		try {
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			pds.setURL("jdbc:oracle:thin:@www.itwill.xyz:1521:xe");
			pds.setUser("jdbc_team1");
			pds.setPassword("jdbc_team1");
			pds.setInitialPoolSize(7); // 
			pds.setMaxPoolSize(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = pds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con) {
		try {
			if (con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if (con!=null) con.close();
			if (pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (con!=null) con.close();
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
