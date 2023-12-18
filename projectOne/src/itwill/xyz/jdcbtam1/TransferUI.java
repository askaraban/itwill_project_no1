package itwill.xyz.jdcbtam1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TransferUI extends JDialog{
	private JTextField receiveAccountTF;
	private JTextField MoneyTF;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TransferUI(JFrame frame, String title) {
		super(frame, "계좌 이체", false);
		
		setTitle("*** 계좌 이체 ***");
		setResizable(false);
		setAlwaysOnTop(true);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel(ProjectUI.accoutSelectNumber);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(213, 2, 225, 75);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("누구에게 보낼까요?");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 75, 225, 75);
		panel.add(label_2);
		receiveAccountTF = new JTextField();
		receiveAccountTF.setBounds(225, 87, 193, 51);
		panel.add(receiveAccountTF);
		
		JLabel label = new JLabel("얼마를 보낼까요?");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 150, 225, 75);
		panel.add(label);
		MoneyTF = new JTextField();
		MoneyTF.setBounds(225, 162, 193, 51);
		panel.add(MoneyTF);
		
		
		
		
		
		// 전송 버튼
		JButton transferBtn = new JButton("이체");
		transferBtn.setBounds(54, 235, 134, 44);
		transferBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 원화로 입력하는 방법
				NumberFormat kr = NumberFormat.getNumberInstance(Locale.KOREA);
				// 입력된 값을 매개변수에 넣음
				String MoneyTextField = MoneyTF.getText();
				//입금액텍스트필드에 값을 넣지 않았을때2
				if(MoneyTextField.equals("")) {
					JOptionPane.showMessageDialog(null, "입금액을 입력해주세요");
					MoneyTF.requestFocus();
					return;
				}
				
				String inmoneyReg = "^[\\d]*$";
				if(!Pattern.matches(inmoneyReg, MoneyTextField)) {
					JOptionPane.showMessageDialog(null, "입금액은 숫자만 입력해주세요");
					MoneyTF.requestFocus();
					return;
				}
				
				BankBookDTO transferMoney = new BankBookDTO();
				transferMoney.setOutputMoney(Long.parseLong(MoneyTextField));
				// 보낼 계좌번호에 입력된 금액을 보냄
				AccoutDAO.getAccountDAO().transferMoney("보낼 계좌번호", transferMoney.getOutputMoney());
				
				// 내 계좌에서 보낸 금액만큼 차감
				AccoutDAO.getAccountDAO().transferMoney("내 계좌번호", -transferMoney.getOutputMoney());
				JOptionPane.showMessageDialog(null, "에게 " + kr.format(transferMoney.getOutputMoney()) +"원을 보냈습니다.");
			}
		});
		panel.add(transferBtn);
		
		JButton cancelTF = new JButton("취소");
		cancelTF.setBounds(225, 234, 134, 44);
		cancelTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		panel.add(cancelTF);
		
		JLabel lblNewLabel = new JLabel("내 계좌번호");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 2, 225, 75);
		panel.add(lblNewLabel);
		
		
		
		
		
		
		
		
	}
}
