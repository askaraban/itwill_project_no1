package itwill.xyz.jdcbtam1;

/*
AC_ID   NOT NULL VARCHAR2(30) 
AC_NUM  NOT NULL VARCHAR2(30) 
AC_PW   NOT NULL NUMBER(4)    
AC_KIND NOT NULL VARCHAR2(40)
*/


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccoutDAO extends ProjectDbcpFactory{
	private static AccoutDAO _acdao;
	
	private AccoutDAO() {
		
	}
	
	static {
		_acdao = new AccoutDAO();
	}
	
	public static AccoutDAO getAccountDAO () {
		return _acdao;
	}
	
	
	
	// ID는 projectUI의 id 에서
	// ac_num 은 projectUI의 checkAccNumber에서
	// 비밀번호는 입력된 값에서
	// 계좌종류는 일반통장
	public int createAccount(JoinDTO createAccount) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows = 0;
		
		try {
			con = getConnection();
			String sql = "insert into account values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, createAccount.getID());
			pstmt.setString(2, createAccount.getAc_num());
			pstmt.setInt(3, createAccount.getAc_pw());
			pstmt.setString(4, createAccount.getAc_kind());
			
			rows= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[에러]createAccount() 메소드의 SQL 오류 = " + e.getMessage());
			
		}
		
		return rows;
		
	} 
	
	public String checkAccNum(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		// 계좌 생성을 눌렀을 때 계좌번호가 생성되고 이를 가져다가 비교하여 중복이면 false를 반환시키자
		try {
			con = getConnection();
			
			while(true) {
				String sql = "select ac_num from account join client on ac_id=id where id=?";
				pstmt=con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				
				rs= pstmt.executeQuery();
				
				if (!rs.next()) {
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("[에러]checkAccNum() 메소드의 SQL 오류 = " + e.getMessage());
		}
		return id;
				
	}
	
	
	 
//	출처: https://info-lab.tistory.com/292 [:: IT School :::티스토리]
	public static void main(String[] args) {
		
		System.out.println("0.0 ~ 1.0 사이의 난수 1개 발생 : " + Math.random());
        System.out.println("0 ~ 10 사이의 난수 1개 발생 : " + (int)((Math.random()*1000000)%1000000
        		));
        
        
        
	}
	
}
