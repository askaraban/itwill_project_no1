package itwill.xyz.jdcbtam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class INOUTDAO extends ProjectDbcpFactory{
	public INOUTDAO() {
		
		BankBookDTO bankBook = new BankBookDTO();
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		boolean sameValue = false;
		String id = null;
		int paswd = 0;
		
		
//		String inmo = inTF.getText();
//		String inmemo = memoTF.getText();
//		long INmoney = Long.parseLong(inmo);
//		
//		bankBook.setInputMoney(INmoney);
//		bankBook.setMemo(inmemo);
		
		//자바 잔액 가져오기
		try {
			//회원테이블에서 id와 잔액 가져오기
			String sql1 = "select balance,ID from client where id='TEST'";
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			
			String Cidd = null;
			long AClastmoney = 0;
			//오라클의 잔액을 가져와 자바에 잔액을 설정
			if (rs.next()) {
				String Obal = rs.getString("balance");
				Cidd = rs.getString("id");
				
				AClastmoney = Long.parseLong(Obal);
				
				//잔액설정완료
				bankBook.setLastMoney(AClastmoney);
			}
			
			
			//자바 잔액 더하기 유아이 입금액
			long fanalmoney = bankBook.getLastMoney() + bankBook.getInputMoney();
			
			//클라이언트 balance에 잔액 넣기
			String sql2 = "update client set balance=? where id = 'TEST' ";
			pstmt = con.prepareStatement(sql2);
			pstmt.setLong(1, fanalmoney);
			pstmt.executeUpdate();
			
			
			bankBook.setLastMoney(fanalmoney);
			String Sfanalmoney = fanalmoney+"";
			
			String sql3= "insert into iocash values(?,?,?,?,?,?,?)";
			
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = dateFormat.format(now);
			bankBook.setDate(nowDate);
			
			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, "4000");
			pstmt.setString(2, Cidd);
			pstmt.setString(3, "입금");
			pstmt.setLong(4, bankBook.getInputMoney());
			pstmt.setString(5, "0");
			pstmt.setString(6, bankBook.getMemo());
			pstmt.setString(7, nowDate);
			
			pstmt.executeUpdate();

			
			
//		Vector<String> vector = new Vector<String>();
//		
//		vector.add(nowDate);
//		vector.add("입금");
//		vector.add(inmo);
//		vector.add(Sfanalmoney);
//		vector.add(inmemo);
//			
//			
//	DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
//	tableModel.addRow(vector);
//			
//			inTF.setText("");
//			memoTF.setText("");
//			setVisible(true);
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
	}
}
