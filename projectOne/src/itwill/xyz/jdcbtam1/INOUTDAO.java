package itwill.xyz.jdcbtam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class INOUTDAO extends ProjectDbcpFactory{
	public INOUTDAO() {}
	
	
	
	//아이디찾기
	public void selectBal(JoinDTO dto2) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;

		// 자바 잔액 가져오기
		try {
			// 회원테이블에서 id와 잔액 가져오기
			String sql1 = "SELECT ID,PW,NAME,CAL,AC_NUM,BALANCE FROM CLIENT JOIN ACCOUNT ON CLIENT.ID = ACCOUNT.AC_ID WHERE ID = ? AND AC_NUM = ?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, LoginUI.id);
			pstmt.setString(2, ProjectUI.accoutSelectNumber);
			rs = pstmt.executeQuery();

			String Cidd = null;
			int AClastmoney = 0;
			
			// 오라클의 잔액을 가져와 자바에 잔액을 설정
			if (rs.next()) {
				int Obal = rs.getInt("balance");
				System.out.println(Obal);
				Cidd = rs.getString("id");
				dto2.setID(Cidd);
				
				// 잔액설정완료
				dto2.setBalance(Obal);
				
				
				dto2.setAc_num(rs.getString("AC_Num"));
			

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
	}
	
	
	//클라이언트 정보변경
	
	public void updateInfo(JoinDTO dto2) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		boolean sameValue = false;
		String id = null;
		int paswd = 0;

		// 자바 잔액 더하기 유아이 입금액
		try {
			int fanalmoney = dto2.getBalance() + dto2.getDeposit();
			dto2.setBalance(fanalmoney);
			System.out.println(dto2.getBalance());
			// 클라이언트 balance에 잔액 넣기
			String sql2 = "update account set balance=? where ac_num = ? ";
			pstmt = con.prepareStatement(sql2);
			pstmt.setLong(1, fanalmoney);
			pstmt.setString(2, dto2.getAc_num());
			
			
			pstmt.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block2
			e1.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
	}
	
	
	//입출금테이블 삽입d
	public void insertInfo(JoinDTO dto2) {
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		boolean sameValue = false;
		String id = null;
		int paswd = 0;
		
		try {
		
			String sql3= "insert into iocash values(seq10.nextval,?,?,?,?,?,sysdate,?) ";
		
		pstmt = con.prepareStatement(sql3);
		
		pstmt.setString(1, dto2.getAc_num());
		pstmt.setString(2, "입금");
		pstmt.setLong(3, dto2.getDeposit());
		pstmt.setString(4, "0");
		pstmt.setString(5, dto2.getMemo());
		
		int HB = dto2.getDeposit()+dto2.getBalance();
		dto2.setBalance(HB);
		
		pstmt.setInt(6, HB);
		
//		dto2.setBalance(HB);
		
		
		pstmt.executeUpdate();
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}	
		
	}
	
	
	//출금아이디찾기
		public void selecOutAccount(JoinDTO dto2) {
			Connection con = getConnection();
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			String Cidd = null;
			int AClastmoney = 0;

			// 자바 잔액 가져오기
			try {
				// 회원테이블에서 id와 잔액 가져오기
				String sql1 = "select balance,ID from client where id='TEST'";
				pstmt = con.prepareStatement(sql1);
				rs = pstmt.executeQuery();

				// 오라클의 잔액을 가져와 자바에 잔액을 설정
				if (rs.next()) {
					
					//회원테이블의 잔액을 가져와 DTO에 저장
					String Obal = rs.getString("balance");
					AClastmoney = Integer.parseInt(Obal);
					dto2.setBalance(AClastmoney);
					
					//회원테이블의 아이디를 가져와 DTO에 저장
					Cidd = rs.getString("id");
					dto2.setID(Cidd);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
		}
		
		
		//출금클라이언트 정보변경
		public void OutupdateInfo(JoinDTO dto2) {
			Connection con = getConnection();
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;

			// 자바 잔액 빼기 유아이 입금액
			try {
				int fanalmoney = dto2.getHbalance() - dto2.getWithdraw();
				dto2.setBalance(fanalmoney);

				// 클라이언트 balance에 잔액 넣기
				String sql2 = "update client set balance=? where id = 'TEST' ";
				pstmt = con.prepareStatement(sql2);
				pstmt.setLong(1, dto2.getHbalance());
				pstmt.executeUpdate();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
		}
		
		//출금테이블 삽입
		public void OutinsertInfo(JoinDTO dto2) {
			Connection con = getConnection();
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			
			try {
			String sql3= "insert into iocash values(seq10.nextval,?,?,?,?,?,sysdate,?)";
			
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = dateFormat.format(now);
			dto2.setCal(nowDate);
			
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, dto2.getID());
			pstmt.setString(2, "출금");
			pstmt.setString(3, "0");
			pstmt.setLong(4, dto2.getWithdraw());
			pstmt.setString(5, dto2.getMemo());
			
			long HB = dto2.getHbalance() - dto2.getWithdraw();
			pstmt.setLong(6, HB);
			
			pstmt.executeUpdate();
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
			
		}
		
		//계좌테이블에서 정보가져오기
		public void accountInfor(JoinDTO dto2) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	try {
		String sql4 = "select ac_id,ac_num,ac_pw from account where ac_id='TEST'";
		pstmt = con.prepareStatement(sql4);
		
		rs = pstmt.executeQuery();
		
		int ACpw = 0;
		if(rs.next()) {
			String ACid =rs.getString("ac_id");
			String ACnum=rs.getString("ac_num");
			ACpw =rs.getInt("ac_pw");
		}
		
		dto2.setAc_pw(ACpw);
//		dto2.setAc_num(ACnum);
//		dto2.getAc_pw() ;
		
		} catch (SQLException e) {
			e.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
		}
		
		
		
		//테이블에서 내정보에 넣을 정보 가져오기
		public void InforBtnTable2(JoinDTO dto2) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	try {
		String sql4 = "SELECT ID,NAME,CAL,AC_NUM FROM CLIENT LEFT JOIN  ACCOUNT ON CLIENT.ID = ACCOUNT.AC_ID  where ac_id='TEST'";
		pstmt = con.prepareStatement(sql4);
		
		rs = pstmt.executeQuery();
		
		int ACpw = 0;
		String ACnum = null;
		while(rs.next()) {
			ACnum=rs.getString("ac_num");
		}
		dto2.setAc_num(ACnum);
		System.out.println(dto2.getAc_num());
			
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
		}

		
		
		
		
		
		
		
		
		
		
		
	
}
