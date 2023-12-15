package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class ProjectUI {
	
	private JTextField 이후날짜;
	private JTable table;
	private JTextField 이전날짜;
	DateCalculator dc = new DateCalculator();
	private String firstDate = null;
	private String endDate = null;
	private String event = null;
	int dd;

	private JFrame frame;

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

		JButton btnNewButton_2 = new JButton("입금");
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("출금");
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

		JButton btnNewButton_4 = new JButton("조회");
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
		panel.setLayout(new GridLayout(2, 4, 0, 0));

		Panel panel_1 = new Panel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 50));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 2, 5, 5));

		JButton btnNewButton_1 = new JButton("로그인");
		panel_4.add(btnNewButton_1);

		JButton btnNewButton = new JButton("회원가입");
		panel_4.add(btnNewButton);

		JButton button = new JButton("로그아웃");
		panel_4.add(button);

		JButton btnNewButton_8 = new JButton("회원탈퇴");
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
		
		JButton btnNewButton_6 = new JButton("계좌 생성");
		panel_16.add(btnNewButton_6);
		
		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_7 = new JButton("계좌 삭제");
		panel_12.add(btnNewButton_7);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(new BorderLayout(5, 5));
		
		JButton btnNewButton_5 = new JButton("내 정보 ");
		panel_10.add(btnNewButton_5, BorderLayout.CENTER);

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17);
		panel_17.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panel_20 = new JPanel();
		panel_17.add(panel_20);
		
		JLabel lblNewLabel_1 = new JLabel("TEST");
		panel_20.add(lblNewLabel_1);
		
		JPanel panel_21 = new JPanel();
		panel_17.add(panel_21);
		
		JLabel lblNewLabel_2 = new JLabel("님 환영합니다!!");
		panel_21.add(lblNewLabel_2);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		
		JLabel lblNewLabel_3 = new JLabel("아이티윌");
		panel_19.add(lblNewLabel_3);
		
		JPanel panel_22 = new JPanel();
		panel_17.add(panel_22);
		
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
		panel_9.setLayout(new BorderLayout(0, 0));

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "----------------------" }));
		panel_9.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("잔액 :");
		panel_8.add(lblNewLabel_5);

		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);

		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));

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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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
				i.add(joinDTO.getLocal());
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