package itwill.xyz.jdcbtam1;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class AccountCreateUI  extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;



	
	public AccountCreateUI(JFrame frame, String title) {
		
		super(frame, title, true);
		
		JPanel jPanel = new JPanel(new GridLayout(4, 1));
		setBounds(100, 100, 335, 397);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 아이디 :");
		lblNewLabel.setBounds(34, 23, 72, 15);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("계좌 번호 :");
		lblNewLabel_1.setBounds(33, 56, 72, 15);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("계좌번호 생성되는 곳");
		lblNewLabel_2.setBounds(117, 56, 151, 15);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("아이디 나타나는곳");
		lblNewLabel_4.setBounds(117, 23, 115, 15);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("계좌 비밀번호 :");
		lblNewLabel_3.setBounds(34, 29, 97, 15);
		panel_1.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 27, 111, 18);
		panel_1.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("생성");
		btnNewButton.setBounds(12, 30, 97, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(210, 30, 97, 23);
		panel_4.add(btnNewButton_1);
		
		
	} 
}
