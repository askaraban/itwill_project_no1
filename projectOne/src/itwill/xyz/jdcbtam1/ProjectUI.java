package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class ProjectUI {
	
	private JTextField 이후날짜;
	private JTable table;
	private JTextField 이전날짜;
	DateCalculator dc = new DateCalculator();
	private String firstDate = null;
	private String endDate = null;
	private String event = null;
	public static String idLogin=null;

	private JFrame frame;
	JLabel lblNewLabel_1;
	
	JButton btnNewButton,button,btnNewButton_8,btnNewButton_1,btnNewButton_6,btnNewButton_7,btnNewButton_5,btnNewButton_2,btnNewButton_3,btnNewButton_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectUI window = new ProjectUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public ProjectUI() throws IOException {

		initialize();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//로그인 전과 후 버튼 활성화,비활성화 설정
				if(LoginUI.isLogin) {
					lblNewLabel_1.setText(LoginUI.id);

					btnNewButton.setEnabled(false);//회원가입
					button.setEnabled(true);//로그아웃
					btnNewButton_8.setEnabled(true);//회원탈퇴
					btnNewButton_1.setEnabled(false);//로그인
					btnNewButton_6.setEnabled(true);//계좌생성
					btnNewButton_7.setEnabled(true);//계좌 삭제
					btnNewButton_5.setEnabled(true);//내 정보
					btnNewButton_2.setEnabled(true);//입금
					btnNewButton_3.setEnabled(true);//출금
					btnNewButton_4.setEnabled(true);//조회
				} else {
					btnNewButton.setEnabled(true);//회원가입
					button.setEnabled(false);//로그아웃
					btnNewButton_8.setEnabled(false);//회원탈퇴
					btnNewButton_1.setEnabled(true);//로그인
					btnNewButton_6.setEnabled(false);//계좌생성
					btnNewButton_7.setEnabled(false);//계좌 삭제
					btnNewButton_5.setEnabled(false);//내 정보
					btnNewButton_2.setEnabled(false);//입금
					btnNewButton_3.setEnabled(false);//출금
					btnNewButton_4.setEnabled(false);//조회
				}
			}		
		});
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		
		frame = new JFrame();
		frame.setBounds(800, 200, 800, 500);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnNewButton_2 = new JButton("입금");
		panel_3.add(btnNewButton_2);

		btnNewButton_3 = new JButton("출금");
		panel_3.add(btnNewButton_3);

		이전날짜 = new JTextField();

		이전날짜.setText("");

		panel_3.add(이전날짜);
		이전날짜.setColumns(10);

		JLabel lblNewLabel = new JLabel("~");
		panel_3.add(lblNewLabel);

		이후날짜 = new JTextField();
		이후날짜.setText("");

		panel_3.add(이후날짜);
		이후날짜.setColumns(10);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "전체", "입금", "출금" }));
		comboBox.setMaximumRowCount(3);
		panel_3.add(comboBox);

		System.out.println(comboBox.getSelectedItem());

	    btnNewButton_4 = new JButton("조회");
		// 조회버튼을 눌렀을 경우

		panel_3.add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uB0A0\uC9DC", "\uC785/\uCD9C\uAE08", "\uAE08\uC561", "\uC794\uC561", "\uBA54\uBAA8"
			}
		));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 4, 5, 5));

		Panel panel_1 = new Panel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 5, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 50));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 2, 5, 5));

		btnNewButton_1 = new JButton("로그인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginUI login = new LoginUI();
				
				login.setSize(256, 225);
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (screenSize.width - login.getWidth()) / 2;
				int y = (screenSize.height - login.getHeight()) / 2;
				login.setLocation(x, y);
				
				login.setVisible(true);
				login.getContentPane().setLayout(null);
				login.setResizable(false);
				
			}
		});
		panel_4.add(btnNewButton_1);

		btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JoinUI join = new JoinUI();
				
				join.setSize(332, 365);
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (screenSize.width - join.getWidth()) / 2;
				int y = (screenSize.height - join.getHeight()) / 2;
				join.setLocation(x, y);
				
				join.setVisible(true);
				join.getContentPane().setLayout(null);
				join.setResizable(false);
				
			}
		});
		panel_4.add(btnNewButton);

		button = new JButton("로그아웃");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginUI.isLogin) {
					btnNewButton.setEnabled(true);//회원가입
					button.setEnabled(false);//로그아웃
					btnNewButton_8.setEnabled(false);//회원탈퇴
					btnNewButton_1.setEnabled(true);//로그인
					btnNewButton_6.setEnabled(false);//계좌생성
					btnNewButton_7.setEnabled(false);//계좌 삭제
					btnNewButton_5.setEnabled(false);//내 정보
					btnNewButton_2.setEnabled(false);//입금
					btnNewButton_3.setEnabled(false);//출금
					btnNewButton_4.setEnabled(false);//조회
				} else {
					btnNewButton.setEnabled(false);//회원가입
					button.setEnabled(true);//로그아웃
					btnNewButton_8.setEnabled(true);//회원탈퇴
					btnNewButton_1.setEnabled(false);//로그인
					btnNewButton_6.setEnabled(true);//계좌생성
					btnNewButton_7.setEnabled(true);//계좌 삭제
					btnNewButton_5.setEnabled(true);//내 정보
					btnNewButton_2.setEnabled(true);//입금
					btnNewButton_3.setEnabled(true);//출금
					btnNewButton_4.setEnabled(true);//조회
				}
			}
			
		});
		panel_4.add(button);

		btnNewButton_8 = new JButton("회원탈퇴");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel_4.add(btnNewButton_8);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panel_16 = new JPanel();
		panel_11.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_6 = new JButton("계좌 생성");
		
		panel_16.add(btnNewButton_6);
		
		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_7 = new JButton("계좌 삭제");
		panel_12.add(btnNewButton_7);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(new BorderLayout(5, 5));
		
		btnNewButton_5 = new JButton("내 정보 ");
		panel_10.add(btnNewButton_5, BorderLayout.CENTER);

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17);
		panel_17.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panel_20 = new JPanel();
		panel_17.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_20.add(lblNewLabel_1);
		
		JPanel panel_21 = new JPanel();
		panel_17.add(panel_21);
		
		JLabel lblNewLabel_2 = new JLabel("님 환영합니다!!");
		panel_21.add(lblNewLabel_2);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("아이티윌");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_19.add(lblNewLabel_3);
		
		JPanel panel_22 = new JPanel();
		panel_17.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel(" 은행입니다.");
		panel_22.add(lblNewLabel_4);
		
		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 10, 50));
		
		JPanel panel_23 = new JPanel();
		panel_9.add(panel_23);
		panel_23.setLayout(new BorderLayout(5, 5));
		
		JPanel panel_24 = new JPanel();
		panel_9.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel_25 = new JPanel();
		panel_24.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton btnNewButton_9 = new JButton("계좌 선택");
		panel_25.add(btnNewButton_9);

		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("계좌번호 보여주는 라벨");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(lblNewLabel_6, BorderLayout.CENTER);

		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("      잔액 :");
		panel_15.add(lblNewLabel_5, BorderLayout.CENTER);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);

		// -------------------------------------------------------------------------------------------------------------------//
//		****************** 기능 삽입 ***************************************************

		// 날짜 입력 후 조회버튼 눌렀을 때 발생하는 이벤트
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstDate = 이전날짜.getText();
				endDate = 이후날짜.getText();
				
				
				
				if (event.equals("전체")) {
					try {

						result();
						System.out.println("둘다!!");

					} catch (Exception e1) {
						// 잘못된 날짜 입력시 에러메세지 출력
						JOptionPane.showMessageDialog(null, "잘못된 날짜를 입력하셨습니다..!!\n ex) 20231225", "에러!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} else if (event.equals("입금")) {
					try {

						depositResult();
						System.out.println("입금만!!");

					} catch (Exception e1) {
						// 잘못된 날짜 입력시 에러메세지 출력
						JOptionPane.showMessageDialog(null, "잘못된 날짜를 입력하셨습니다..!!\n ex) 20231225", "에러!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} else if (event.equals("출금")) {
					try {

						withResult();
						System.out.println("출금만!");

					} catch (Exception e1) {
						// 잘못된 날짜 입력시 에러메세지 출력
						JOptionPane.showMessageDialog(null, "잘못된 날짜를 입력하셨습니다..!!\n ex) 20231225", "에러!!",
								JOptionPane.ERROR_MESSAGE);

					}
				}

			}
		});
		// textField에 클릭했을 때 발생하는 이벤트
		이전날짜.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				이전날짜.setText("");
			}
		});
		// textField_1에 클릭했을 때 발생하는 이벤트
		이후날짜.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				이후날짜.setText("");
			}
		});

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				event = (String) comboBox.getSelectedItem();

			}
		});
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountCreateUI acUI = new AccountCreateUI(frame, "계좌 생성");
				
				acUI.setSize(332, 365);
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (screenSize.width - acUI.getWidth()) / 2;
				int y = (screenSize.height - acUI.getHeight()) / 2;
				acUI.setLocation(x, y);
				
				acUI.setVisible(true);
				acUI.getContentPane().setLayout(null);
				acUI.setResizable(false);
			}
		});
		
	}
		

	public void result() throws Exception {

		if (firstDate.isEmpty() && endDate.isEmpty()) {
			
			System.out.println("둘다 비어있는 RESULT()메소드");
//												****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().nowSearch("TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("입금")) {
					i.add(joinDTO.getDeposit());
				} else {
					i.add(joinDTO.getWithdraw());
				}
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}

//			// 2. 이후 날짜만 있다면, 이후 날짜 이전꺼를 모두 조회
		} else if (firstDate.isEmpty() && !endDate.isEmpty()) {
			System.out.println("이후 날짜만 RESULT()메소드");
//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().oneSearch( "TEST",dc.getEndDate(endDate));
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("입금")) {
					i.add(joinDTO.getDeposit());
				} else {
					i.add(joinDTO.getWithdraw());
				}
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
			// 3. 이전 날짜와 이후 날짜 모두 있다면 해당 날짜 사이를 조회
		} else if (!firstDate.isEmpty() && !endDate.isEmpty()) {
			System.out.println("모든 날짜만만 RESULT()메소드");

			// 이후 날짜가 이전 날짜보다 작을경우 에러 출력
			if (Integer.valueOf(endDate) < Integer.valueOf(firstDate)) {
				throw new Exception();
			}

//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().bothSearch(firstDate, endDate, "TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("입금")) {
					i.add(joinDTO.getDeposit());
				} else {
					i.add(joinDTO.getWithdraw());
				}
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
		} else {
			throw new Exception();
		}
	}
	
	public void depositResult() throws Exception {

		if (firstDate.isEmpty() && endDate.isEmpty()) {
//												****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().depositNowSearch("TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("입금")) i.add(joinDTO.getDeposit()); 
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}

//			// 2. 이후 날짜만 있다면, 이후 날짜 이전꺼를 모두 조회
		} else if (firstDate.isEmpty() && !endDate.isEmpty()) {
//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().depositOneSearch(endDate, "TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("입금")) i.add(joinDTO.getDeposit());
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
			// 3. 이전 날짜와 이후 날짜 모두 있다면 해당 날짜 사이를 조회
		} else if (!firstDate.isEmpty() && !endDate.isEmpty()) {

			// 이후 날짜가 이전 날짜보다 작을경우 에러 출력
			if (Integer.valueOf(endDate) < Integer.valueOf(firstDate)) {
				throw new Exception();
			}

//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().depositSearch(firstDate, endDate, "TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("입금")) i.add(joinDTO.getDeposit());
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
		} else {
			throw new Exception();
		}
	}
	
	public void withResult() throws Exception {

		if (firstDate.isEmpty() && endDate.isEmpty()) {
			
//												****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().withNowSearch("TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("출금")) {
					i.add(joinDTO.getWithdraw());
				}
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}

//			// 2. 이후 날짜만 있다면, 이후 날짜 이전꺼를 모두 조회
		} else if (firstDate.isEmpty() && !endDate.isEmpty()) {
//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().withOneSearch(endDate, "TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("출금")) i.add(joinDTO.getWithdraw());
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
			// 3. 이전 날짜와 이후 날짜 모두 있다면 해당 날짜 사이를 조회
		} else if (!firstDate.isEmpty() && !endDate.isEmpty()) {

			// 이후 날짜가 이전 날짜보다 작을경우 에러 출력
			if (Integer.valueOf(endDate) < Integer.valueOf(firstDate)) {
				throw new Exception();
			}

//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().withSearch(firstDate, endDate, "TEST");

			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			for (int i = tableModel.getRowCount(); i > 0; i--) {
				tableModel.removeRow(0); // 0번째 행을 삭제를 반복하는 for문
			}

			for (JoinDTO joinDTO : jd) {
				Vector<Object> i = new Vector<Object>();
				String check = "";
				i.add(joinDTO.getIocal());
				i.add(joinDTO.getIotype());
				check = joinDTO.getIotype();
				if (check.equals("출금")) i.add(joinDTO.getWithdraw());
				i.add(joinDTO.getBalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
		} else {
			throw new Exception();
		}
	}

}