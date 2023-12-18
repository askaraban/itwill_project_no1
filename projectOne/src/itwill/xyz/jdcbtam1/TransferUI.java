package itwill.xyz.jdcbtam1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class TransferUI extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField insertAccount;
	private JTextField insertMoney;
	Vector<String> myAcc = new Vector<>();
	JComboBox<String> myAccList = new JComboBox<String>(myAcc);
	private String showAccount = null;
	private JLabel balance = new JLabel();
	DecimalFormat decimalFormat = new DecimalFormat("###,###");
	
	
	public TransferUI(JFrame frame, String title) {
		super(frame, "계좌 이체", false);
		
		setTitle("*** 계좌 이체 ***");
		setResizable(false);
		setAlwaysOnTop(true);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel choiceAccount = new JLabel("어떤 계좌로 보낼까요?");
		choiceAccount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(choiceAccount);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		List<JoinDTO> jd = AccoutDAO.getAccountDAO().accountSearch(LoginUI.id);
		for (JoinDTO i : jd) {
			myAcc.add(i.getAc_num());
		}
		
		
		panel_7.add(myAccList);
		
		JLabel lblNewLabel_1 = new JLabel();
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel transAmount = new JLabel("보낼 수 있는 금액");
		panel_8.add(transAmount);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		panel_9.add(balance);
		
		myAccList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAccount = (String)myAccList.getSelectedItem();
				decimalFormat = new DecimalFormat("###,###");
				balance.setText(decimalFormat.format(displayMoney())+"원");
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel receiveAccount = new JLabel("누구에게 보낼까요?");
		panel_10.add(receiveAccount);
		receiveAccount.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		insertAccount = new JTextField();
		panel_11.add(insertAccount);
		insertAccount.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_1.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15);
		
		JLabel HowMany = new JLabel("얼마를 보낼까요?");
		panel_15.add(HowMany);
		HowMany.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16);
		
		insertMoney = new JTextField();
		panel_16.add(insertMoney);
		insertMoney.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		
		JButton sendMoneyBtn = new JButton("보내기");
		sendMoneyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inA = insertAccount.getText();
				String inM = insertMoney.getText();
				if(inA.equals("")) {
					JOptionPane.showMessageDialog(TransferUI.this, "계좌번호를 입력하세요.");
					insertAccount.requestFocus();
					return;
				}
				// 입력된 계좌번호가 존재하면 cnt에 +1를 더해서 0이면 존재하지 않는 계좌번호
				List<JoinDTO> allAccountList = AccoutDAO.getAccountDAO().allAccount();
				int cnt=0;
				for (JoinDTO j : allAccountList) {
					if (j.getAc_num().equals(inA)) {
						cnt++;
						break;
					}
				}
				if (cnt==0) {
//					JOptionPane.showMessageDialog(TransferUI.this, "없는 계좌번호입니다.");
					JOptionPane.showMessageDialog(TransferUI.this, "없는 계좌번호입니다.", "이체할 수 없는 계좌번호...!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String ExReg = "^[\\d]*$";
				if(!Pattern.matches(ExReg, inM)) {
					JOptionPane.showMessageDialog(TransferUI.this, "이체하실 금액은 숫자만 입력해주세요.", "사용할 수 없는 금액...!",
							JOptionPane.ERROR_MESSAGE);
					insertMoney.requestFocus();
					return;
				}
				if (AccoutDAO.getAccountDAO().getAccountBal(showAccount).getBalance()<Integer.parseInt(inM)) {
					JOptionPane.showMessageDialog(TransferUI.this, "현재 잔액에보다 큰 금액을 입력하셨습니다.", "에러...!",
							JOptionPane.ERROR_MESSAGE);
					insertMoney.requestFocus();
					return;
				}
				
				// ----------------- 입금과정--------------------
				// 1. 선택된 계좌에서 transferMoney() 메소드를 이용해 balance를 입금액만큼 더함
				// 2. 선택된 계좌의 잔액을 확인해서 매개변수에 담음 getAccountBal()
				// 3. 선택된 계좌의 히스토리를 transferHistoryInsert (account_number, widthrow_money, memo, hbalance)를 사용해서 업데이트
				// ----------------- 출금과정--------------------
				// 1. 선택된 내 계좌에서 transferMoney() 메소드를 이용해 -balance를 출금액만큼 더함
				// 2. 선택된 내 계좌의 잔액을 확인해서 매개변수에 담음 getAccountBal()
				// 3. 선택된 내 계좌의 히스토리를 transferHistoryInsert (account_number, widthrow_money, memo, hbalance)를 사용해서 업데이트
				AccoutDAO.getAccountDAO().transferMoney(inA, Long.parseLong(insertMoney.getText()));
				int updateBal = AccoutDAO.getAccountDAO().getAccountBal(inA).getBalance();
				AccoutDAO.getAccountDAO().receiveHistoryInsert(inA, Long.parseLong(insertMoney.getText()), "계좌이체", updateBal);
				
				AccoutDAO.getAccountDAO().transferMoney(showAccount, -Long.parseLong(insertMoney.getText()));
				int updateBal2 = AccoutDAO.getAccountDAO().getAccountBal(showAccount).getBalance();
				AccoutDAO.getAccountDAO().transferHistoryInsert(showAccount, Long.parseLong(insertMoney.getText()), "계좌이체", updateBal2);
				JOptionPane.showMessageDialog(TransferUI.this, decimalFormat.format(Long.parseLong(inM))+"원 이체하였습니다.");
			}
		});
		panel_12.add(sendMoneyBtn);
		
		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		
		JButton cancelBtn = new JButton("취 소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_13.add(cancelBtn);
		
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
	
	}
	
	// 선택된 계좌의 잔액을 보여주는 메소드
	public int displayMoney() {
		
		
		return AccoutDAO.getAccountDAO().getAccountBal(showAccount).getBalance();
		
	}
	
	
}
