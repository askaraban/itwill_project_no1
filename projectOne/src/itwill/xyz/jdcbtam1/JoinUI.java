package itwill.xyz.jdcbtam1;

//회원가입 UI

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class JoinUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField idTf;
	private JTextField pwTf;
	private JTextField nameTf;
	private JTextField calTf;
	private JTextField textField_5;
	JButton okButton;
	protected JoinDTO join;
	protected Date cal;
	
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
		setBounds(100, 100, 333, 365);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 273, 317, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);
		
		JButton okButton = new JButton("Join");
				
				
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//회원가입 버튼을 누를 시 검증처리하는 코드
				
				//아이디
				String id=idTf.getText();
				
				
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.");
					idTf.requestFocus();
					return;
				}
				
				if(JoinDAOImpl.getDAO().selectClientByNo(id) != null) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디를 입력 하였습니다.");
					idTf.requestFocus();
					return;
				}
				
				//비밀번호
				String pw=pwTf.getText();
				
				if(pw.equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.");
					pwTf.requestFocus();
					return;
				}
				
				String pwReg = "^(?=.*[a-zA-Z])(?=.*\\d).{8,}$";

				if (!Pattern.matches(pwReg, pw)) {
				    JOptionPane.showMessageDialog(null, "비밀번호는 영어와 숫자가 섞여 8자 이상이어야 합니다.");
				    pwTf.requestFocus();
				    return;
				}
				
				//이름
				String name=nameTf.getText();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.");
					nameTf.requestFocus();
					return;
				}
				
				String nameReg="^[가-힣]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					JOptionPane.showMessageDialog(null, "이름은 2~5 범위의 한글로만 입력해 주세요.");
					nameTf.requestFocus();
					return;
				}
				
				join=new JoinDTO();
				join.setID(id);
				join.setPw(pw);
				join.setName(name);
				//join.setBalance(balance);
				
				JoinDAOImpl.getDAO().insertClient(join);
				
				idTf.setText("");
				pwTf.setText("");
				nameTf.setText("");
				//balanceTf.setText("");
				
				
				JOptionPane.showMessageDialog(null, "회원가입이 되었습니다.");
				
				setVisible(false);
				
			}
		});
				
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						setVisible(false);
				}
		});
			
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);


		JLabel lblNewLabel = new JLabel("< 회 원 가 입 >");
		lblNewLabel.setBounds(90, 10, 131, 33);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("나눔고딕코딩", Font.PLAIN, 17));

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(49, 66, 57, 15);
		lblNewLabel_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1);

			
		idTf = new JTextField();
		idTf.setBounds(49, 86, 213, 21);
		getContentPane().add(idTf);
		idTf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(49, 134, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		pwTf = new JTextField();
		pwTf.setColumns(10);
		pwTf.setBounds(49, 154, 213, 21);
		getContentPane().add(pwTf);
		
		JLabel lblNewLabel_1_1 = new JLabel("이름");
		lblNewLabel_1_1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(49, 202, 57, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		nameTf = new JTextField();
		nameTf.setColumns(10);
		nameTf.setBounds(49, 222, 213, 21);
		getContentPane().add(nameTf);
		
		setResizable(false);
	}
}
