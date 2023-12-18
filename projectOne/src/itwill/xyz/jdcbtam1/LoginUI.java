package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idTf2;
	private JTextField pwTf2;
	public static String id;
	public static String VisualBalance;

	public static boolean isLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginUI dialog = new LoginUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginUI() {
		setBounds(100, 100, 256, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(12, 42, 41, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			idTf2 = new JTextField();
			idTf2.setBounds(12, 58, 198, 21);
			contentPanel.add(idTf2);
			idTf2.setColumns(10);
		}
		{
			pwTf2 = new JTextField();
			pwTf2.setBounds(12, 106, 198, 21);
			pwTf2.setColumns(10);
			contentPanel.add(pwTf2);
		}
		{
			JLabel lblNewLabel = new JLabel("비밀번호");
			lblNewLabel.setBounds(12, 89, 61, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("<로그인>");
			lblNewLabel_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(79, 10, 70, 26);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//로그인 버튼을 눌렀을때
						id=idTf2.getText();
						String pw=pwTf2.getText();
						 JoinDTO login=JoinDAOImpl.getDAO().selectClientByNo(id);
						 
						 //===여기에 잔액띄우는 메소드 삽입===
//						  VisualBalance = login.getBalance()+""; 
						
				            if(login==null) {
				               JOptionPane.showMessageDialog(null, "아이디를 찾을 수 업습니다.");
				               return;
				            }
				            
				            if(!login.getPw().equals(pw)) {
				               JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 맞지 않습니다.");
				               return;
				            }
				            
				            isLogin=true;
				            
				            
				            dispose();

						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
