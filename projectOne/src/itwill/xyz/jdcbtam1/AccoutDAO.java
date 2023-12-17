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
import java.util.ArrayList;
import java.util.List;

public class AccoutDAO extends ProjectDbcpFactory{
	private static AccoutDAO _acdao;
	String findAccount = null;
	private AccoutDAO() {
		
	}
	
	static {
		_acdao = new AccoutDAO();
	}
	
	public static AccoutDAO getAccountDAO () {
		return _acdao;
	}
	
	
	
//	*********************************** 계좌 생성 *************************************
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
	
	
//	*************************** 계좌 중복 확인 메소드 *****************************************
	public String checkAccNum(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		// 계좌 생성을 눌렀을 때 계좌번호가 생성되고 이를 가져다가 비교하여 중복이면 계속 반복문 진행하도록하자
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
		} close(con, pstmt, rs);
		return id;
				
	}
	
	// ****************** 계좌 삭제 메소드 **************************************
	// 1. 다이얼로그 띄워서 계좌를 선택
	// 2. 삭제하시겠습니까? 메세지 띄우기
	// 3. 잔액이 남아있다면, "잔액이 남아있습니다" 경고 띄우기
	// 4. "이체하실 계좌를 선택하세요" -> 로그인된 아이디의 나머지 계좌를 선택하게 다이얼로그 띄우고 이체하기/취소하기 클릭
	// 5. 계좌가 삭제되었습니다.
	public void accountDelete (String accountNumber) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "delete from account where ac_num=? ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, accountNumber);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[에러]accountDelete() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		
	}
	
	// ******************* 선택된 계좌의 잔액을 확인하는 메소드 *************************
	public JoinDTO getAccountBal() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JoinDTO deleteAccount = null;
		
		try {
			con = getConnection();
			
			String sql = "select balance from client join account on id=ac_id where ac_num=?";
	
			pstmt = con.prepareStatement(sql);
			for (String str : AccountDeleteUI.ac_List) {
				if (str.equals("너가 액션리스너한 것과 같다면")) {
					findAccount = "너가 액션리스너한 것을 여기에 넣음";
				}
			}
			
			pstmt.setString(1, findAccount);  // 액션리스너 한것을 여기 넣음
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				deleteAccount = new JoinDTO();
				deleteAccount.setBalance(rs.getInt("balance"));
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]getAccountBal() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}  return deleteAccount;
	}
	
	// ********************* 선택된 내 계좌 외 나머지 계좌를 찾는 메소드 ****************
	public List<JoinDTO> getDeleteSearch() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> delSearchList = new ArrayList<JoinDTO>();
		JoinDTO delSearch = null;
		
		try {
			con = getConnection();
			
			String sql = "select balance from client join account on id=ac_id where ac_num!=?";
	
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, findAccount);
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				delSearch = new JoinDTO();
				delSearch.setAc_num(rs.getString("ac_num"));
				delSearchList.add(delSearch);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]getAccountBal() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
			
		}  return delSearchList;
	}
	
	// ********************** 내 계좌에서 선택된 계좌에게 잔액을 이체하는 메소드 *********************
	public void delTrans () {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = getConnection();
			// 기존 계좌에서 선택된 계좌로 남은 돈을 잔액에 더함
			String sql = "update client set balance = balance + ? join account on id=ac_id "
					+ "where ac_num = (select balance from client join account on id=ac_id where ac_num=?)";
			pstmt = con.prepareStatement(sql);
			
			// 내 계좌의 잔액
			pstmt.setInt(1, getAccountBal().getBalance());
			pstmt.setString(2, "선택된 계좌를 넣기-이체받을 계좌번호");
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("[에러]delTrans() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
	}
	
	
	
	
	// ****************** 계좌를 찾는 메소드 **************************************
	// 계좌를 찾아서 JoinDTO 객체에 id에 맞는 계좌번호 리스트를 담음
	public List<JoinDTO> accountSearch(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<JoinDTO> accountSearchList  = new ArrayList<JoinDTO>();
		JoinDTO accountSearch=null;
		
		
		try {
			con = getConnection();
			// client의 id를 가져와서 account 테이블과 비교하여 모든 계좌번호를 가져오기
			String sql = "select ac_num from account join client on ac_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, LoginUI.id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				accountSearch = new JoinDTO();
				accountSearch.setAc_num(rs.getString("ac_num"));
				accountSearchList.add(accountSearch);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]accountSearch() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return accountSearchList;
	} 
	
	
	 

	
}
