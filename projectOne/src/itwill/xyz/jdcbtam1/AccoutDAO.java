package itwill.xyz.jdcbtam1;

/*
AC_ID   NOT NULL VARCHAR2(30) 
AC_NUM  NOT NULL VARCHAR2(30) 
AC_PW   NOT NULL NUMBER(4)    
BALANCE NOT NULL VARCHAR2(40)
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
			String sql = "insert into account(AC_ID,AC_NUM,AC_PW) values (?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, createAccount.getID());
			pstmt.setString(2, createAccount.getAc_num());
			pstmt.setInt(3, createAccount.getAc_pw());
			
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
	// 1. 잔액이 남아있으면 경고 메세지 띄우기 -> 계좌이체하기
	// 2. 삭제하시겠습니까? 메세지 띄우기
	// 3. 삭제하기 -> 계좌가 삭제되었습니다 메세지 띄우기
	
	// ****************** 계좌 이체 메소드 **************************************
	// 1. 계좌 번호 입력하기
	// 2. 입금액 입력하기
	// 3. 입금 버튼 입력 시 계좌 번호 올바르게 입력했다면 ok 아니면 "없는 계좌번호 입니다" 메세지 출력
	// 4. 받는 계좌( 잔액 + 입금액) / 보낸 계좌 ( 잔액 - 입금액 )

	// ******************* 계좌를 삭제하는 메소드 ********************************
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
	public JoinDTO getAccountBal(String com) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JoinDTO searchBal = null;
		
		// 콤보창에서 액션 리스너한 것과 ac_List가 같다면 잔액을 확인하게 하자
		try {
			con = getConnection();
			
			String sql = "select balance from account where ac_num=?";
	
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, com);  // 액션리스너 한것을 여기 넣음
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				searchBal = new JoinDTO();
				searchBal.setBalance(rs.getInt("balance"));
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]getAccountBal() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}  return searchBal;
	}
	
	
	// ex) transferMoney(String "이체받을 계좌번호" , 입금액)
	// ex)  transferMoney(String "내 계좌번호" , - 입금액)
	
	// ********************** 내 계좌에서 선택된 계좌에게 돈을 이체하는 메소드 *********************
	public void transferMoney (String account_number, Long deposit_money) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = getConnection();
			// 기존 계좌에서 선택된 계좌로 돈을 잔액에 더함
			// 회원테이블의 아이디가 전달받은 아이디(?)와 같고 / 계좌번호가 
			
			String sql = "update account set balance = balance + ? where ac_num=?";
			pstmt = con.prepareStatement(sql);
			
			// 내 계좌의 잔액
			pstmt.setLong(1, deposit_money);
			pstmt.setString(2, account_number);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("[에러]transferMoney() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
	}
	
	// ********************** 내 계좌에서 선택된 계좌에게 돈을 이체하는 메소드2 - 출금히스토리 업데이트 *********************
		public void transferHistoryInsert (String account_number, Long widthrow_money, String memo, int hbalance) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			try {
				con = getConnection();
				
				String sql = "insert into iocash values(seq10.nextval,?,?,?,?,?,sysdate,?) ";
				pstmt = con.prepareStatement(sql);
				// 내 계좌의 잔액
				pstmt.setString(1, account_number);
				pstmt.setString(2, "출금");
				pstmt.setString(3, "0");
				pstmt.setLong(4, widthrow_money);
				pstmt.setString(5, memo);
				pstmt.setInt(6, hbalance);
				
				
				pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				System.out.println("[에러]transferHistoryInsert() 메소드의 SQL 오류 = " + e.getMessage());
			} finally {
				close(con, pstmt);
			}
		}
		
		// ********************** 내 계좌에서 선택된 계좌에게 돈을 이체하는 메소드3 - 이체된 계좌 입금히스토리 업데이트 *********************
				public void receiveHistoryInsert (String account_number, Long deposit_money, String memo, int hbalance) {
					Connection con = null;
					PreparedStatement pstmt = null;
					
					
					try {
						con = getConnection();
						
						String sql = "insert into iocash values(seq10.nextval,?,?,?,?,?,sysdate,?) ";
						pstmt = con.prepareStatement(sql);
						// 내 계좌의 잔액
						pstmt.setString(1, account_number);
						pstmt.setString(2, "입금");
						pstmt.setLong(3, deposit_money);
						pstmt.setString(4, "0");
						pstmt.setString(5, memo);
						pstmt.setInt(6, hbalance);
						
						
						pstmt.executeUpdate();
						
						
					} catch (SQLException e) {
						System.out.println("[에러]transferHistoryInsert() 메소드의 SQL 오류 = " + e.getMessage());
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
			String sql = "select ac_num from account where ac_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				accountSearch = new JoinDTO();
				accountSearch.setAc_num(rs.getString("ac_num"));
				accountSearchList.add(accountSearch);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]accountSearch() 메소드의 SQL 오류 = " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return accountSearchList;
		
	} 
	
	// ****************** 계좌를 찾는 메소드 **************************************
		// 계좌를 찾아서 JoinDTO 객체에 id에 맞는 계좌번호 리스트를 담음
		public List<JoinDTO> allAccount() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<JoinDTO> allAccountList  = new ArrayList<JoinDTO>();
			JoinDTO accountSearch=null;
			
			
			try {
				con = getConnection();
				// client의 id를 가져와서 account 테이블과 비교하여 모든 계좌번호를 가져오기
				String sql = "select ac_num from account";
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					accountSearch = new JoinDTO();
					accountSearch.setAc_num(rs.getString("ac_num"));
					allAccountList.add(accountSearch);
				}
				
			} catch (SQLException e) {
				System.out.println("[에러]allAccount() 메소드의 SQL 오류 = " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(con, pstmt, rs);
			}
			
			return allAccountList;
			
		} 
	
	
	/*
	// ********************* 선택된 내 계좌 외 나머지 계좌를 찾는 메소드 ****************2
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
	 */

	
}
