package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AccountCreateUI  extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	

	
	public AccountCreateUI(JFrame frame, String title) {
		
		super(frame, "계좌 생성", false);
		setResizable(false);
		// 생성하기 버튼 눌렀을 때 계좌번호를 생성하여 매개변수에 담아 중복을 검증 ex) 123-134-123456
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("회원 아이디 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel(LoginUI.id);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("계좌 번호 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel(AccoutDAO.getAccountDAO().checkAccNum(ProjectUI.checkAccNumber));
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("계좌 비밀번호 :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		passwordField = new JPasswordField();
		panel_7.add(passwordField);
		passwordField.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("생성");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccount();
				setVisible(false);
				
				
			}
		});
		btnNewButton.setBounds(12, 30, 97, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(210, 30, 97, 23);
		panel_4.add(btnNewButton_1);
		
		
	} 
	// 계좌 생성
	public void addAccount() {
		String str = new String(passwordField.getPassword());
		String regEx = "^[0-9]{4}$";
		if (!Pattern.matches(regEx, str)) {
			JOptionPane.showMessageDialog(this, "4자리 숫자를 입력해 주세요.");
			textField.requestFocus();
			return;
		}
		
		JoinDTO jd = new JoinDTO();
		jd.setID(LoginUI.id);
		jd.setAc_num(ProjectUI.checkAccNumber);
		jd.setAc_pw(Integer.parseInt(str));
		jd.setAc_kind("일반통장");
		
		int rows = AccoutDAO.getAccountDAO().createAccount(jd);
		JOptionPane.showMessageDialog(this, rows+"개의 계좌를 생성하였습니다.");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
