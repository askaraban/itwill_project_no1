package itwill.xyz.jdcbtam1;

//회원가입 UI

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;


public class JoinUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinUI dialog = new JoinUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoinUI() {
		setBounds(100, 100, 333, 505);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 423, 317, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("< 회 원 가 입 >");
			lblNewLabel.setBounds(90, 10, 131, 33);
			getContentPane().add(lblNewLabel);
			lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 17));
		}
		{
			JLabel lblNewLabel_1 = new JLabel("아이디");
			lblNewLabel_1.setBounds(49, 66, 57, 15);
			lblNewLabel_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
			getContentPane().add(lblNewLabel_1);
		}
		
		textField = new JTextField();
		textField.setBounds(49, 86, 213, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(49, 134, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 154, 213, 21);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("이름");
		lblNewLabel_1_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(49, 202, 57, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(49, 222, 213, 21);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("가입일");
		lblNewLabel_1_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(49, 274, 57, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(49, 294, 213, 21);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("잔액");
		lblNewLabel_1_2_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(49, 346, 57, 15);
		getContentPane().add(lblNewLabel_1_2_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(49, 366, 213, 21);
		getContentPane().add(textField_5);
	}
}
