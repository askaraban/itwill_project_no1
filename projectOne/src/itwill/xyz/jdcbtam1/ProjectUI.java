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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;



 
public class ProjectUI {
	
	private JTextField 이후날짜;
	private JTable table;
	private JTextField 이전날짜;
	DateCalculator dc = new DateCalculator();
	private String firstDate = null;
	private String endDate = null;
	private String event = null;
	public String id;
	private InputMoneyDialog inin;
	private OutputMoneyDialog OuOu;
	Vector<String> accountnumber = new Vector<>();
	JComboBox<String> comboBox_1 = new JComboBox<String>(accountnumber);
	private String[] comboSearchList = {"전체", "입금", "출금" };
	private JFrame frame;
	public static String checkAccNumber;
	public static String accoutSelectNumber;
	JLabel lblNewLabel_1;
	JLabel balanceLabel;
	private JPasswordField pwTF;

	
	JButton btnNewButton,button,btnNewButton_8,btnNewButton_1,btnNewButton_6,btnNewButton_7,InforBtn,InBtn,OutBtn,btnNewButton_4;
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
					
					List<JoinDTO> INFORdialAcNum = JoinDAOImpl.getDAO().InForMationClient(LoginUI.id);
					
					for(JoinDTO INFORdial2 : INFORdialAcNum) {
						accountnumber.add(INFORdial2.getAc_num());
					}
					
					btnNewButton.setEnabled(false);//회원가입
					button.setEnabled(true);//로그아웃
					btnNewButton_8.setEnabled(true);//회원탈퇴
					btnNewButton_1.setEnabled(false);//로그인
					btnNewButton_6.setEnabled(true);//계좌생성
					btnNewButton_7.setEnabled(true);//계좌 삭제
					InforBtn.setEnabled(true);//내 정보
					InBtn.setEnabled(true);//입금
					OutBtn.setEnabled(true);//출금
					btnNewButton_4.setEnabled(true);//조회
				} else {
					btnNewButton.setEnabled(true);//회원가입
					button.setEnabled(false);//로그아웃
					btnNewButton_8.setEnabled(false);//회원탈퇴
					btnNewButton_1.setEnabled(true);//로그인
					btnNewButton_6.setEnabled(false);//계좌생성
					btnNewButton_7.setEnabled(false);//계좌 삭제
					InforBtn.setEnabled(false);//내 정보
					InBtn.setEnabled(false);//입금
					OutBtn.setEnabled(false);//출금
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

		InBtn = new JButton("입금");
		panel_3.add(InBtn);

		OutBtn = new JButton("출금");
		panel_3.add(OutBtn);

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

		JComboBox<String> comboBox = new JComboBox<String>(comboSearchList);

		comboBox.setMaximumRowCount(3);
		panel_3.add(comboBox);


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
				
				int r1 = (int)((Math.random()*100)%100);
				int r2 = (int)((Math.random()*1000)%1000);
				int r3 = (int)((Math.random()*100000)%100000);
				checkAccNumber = "1"+r1+"-"+r2+"-"+r3;
				JoinUI join = new JoinUI();
				
				
				
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
				//로그아웃 메시지와 함께 실행시 프로그램 종료
				JOptionPane.showMessageDialog(null, "이용해 주셔서 감사합니다.");
				System.exit(0);
				/*
				 * if(LoginUI.isLogin) { btnNewButton.setEnabled(true);//회원가입
				 * button.setEnabled(false);//로그아웃 btnNewButton_8.setEnabled(false);//회원탈퇴
				 * btnNewButton_1.setEnabled(true);//로그인 btnNewButton_6.setEnabled(false);//계좌생성
				 * btnNewButton_7.setEnabled(false);//계좌 삭제 btnNewButton_5.setEnabled(false);//내
				 * 정보 btnNewButton_2.setEnabled(false);//입금
				 * btnNewButton_3.setEnabled(false);//출금 btnNewButton_4.setEnabled(false);//조회 }
				 * else { btnNewButton.setEnabled(false);//회원가입 button.setEnabled(true);//로그아웃
				 * btnNewButton_8.setEnabled(true);//회원탈퇴 btnNewButton_1.setEnabled(false);//로그인
				 * btnNewButton_6.setEnabled(true);//계좌생성 btnNewButton_7.setEnabled(true);//계좌
				 * 삭제 btnNewButton_5.setEnabled(true);//내 정보
				 * btnNewButton_2.setEnabled(true);//입금 btnNewButton_3.setEnabled(true);//출금
				 * btnNewButton_4.setEnabled(true);//조회
				 * 
				 * }
				 */
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
		
		InforBtn = new JButton("내 정보 ");
		panel_10.add(InforBtn, BorderLayout.CENTER);

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
		panel_18.setLayout(null);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBounds(120, 0, 72, 55);
		panel_18.add(panel_24);
		panel_24.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ProjectUI.class.getResource("/image/4xn.png")));
		lblNewLabel_6.setBounds(0, 0, 72, 55);
		panel_24.add(lblNewLabel_6);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));
//------------------------------------------------
		JPanel panel_23 = new JPanel();
		panel_6.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
				comboBox_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						accoutSelectNumber=(String)comboBox_1.getSelectedItem();
						
						JoinDTO showAmount = AccoutDAO.getAccountDAO().getAccountBal(accoutSelectNumber);
						balanceLabel.setText(showAmount.getBalance()+" 원");
					}
				});
		
				
				panel_23.add(comboBox_1);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 4, 0, 0));
		
		//잔액라벨 추가로 패넬 추가 및 레이아웃 변경
				JPanel panel_15 = new JPanel();
				panel_8.add(panel_15);
				panel_15.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("  잔액 :");
		panel_15.add(lblNewLabel_5, BorderLayout.CENTER);
		
		balanceLabel = new JLabel(" ");
		panel_8.add(balanceLabel);

		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		
				JPanel panel_9 = new JPanel();
				panel_6.add(panel_9);
				panel_9.setLayout(new BorderLayout(0, 0));
		
		
		inin = new InputMoneyDialog(null, "입금창");
		
		InBtn.addActionListener(new InOutMoneyListener());
		
		
		OuOu = new OutputMoneyDialog(null, "출금창");
		
		OutBtn.addActionListener(new InOutMoneyListener());
		

		// -------------------------------------------------------------------------------------------------------------------//
//		****************** 기능 삽입 ***************************************************
		//내정보 버튼 클릭시 발생하는 이벤트
				InforBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						InForDialog infordial = new InForDialog();
						infordial.setVisible(true);
						
					}
				});
		
		
		
		
		// 날짜 입력 후 조회버튼 눌렀을 때 발생하는 이벤트
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstDate = 이전날짜.getText();
				endDate = 이후날짜.getText();
				
				
				
				if (comboSearchList[0].equals("전체")) {
					try {

						result();

					} catch (Exception e1) {
						// 잘못된 날짜 입력시 에러메세지 출력
						JOptionPane.showMessageDialog(null, "잘못된 날짜를 입력하셨습니다..!!\n ex) 20231225", "에러!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} else if (comboSearchList[1].equals("입금")) {
					try {

						depositResult();

					} catch (Exception e1) {
						// 잘못된 날짜 입력시 에러메세지 출력
						JOptionPane.showMessageDialog(null, "잘못된 날짜를 입력하셨습니다..!!\n ex) 20231225", "에러!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} else if (comboSearchList[2].equals("출금")) {
					try {

						withResult();

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
//		******************************* 계좌생성 UI **************************************
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AccountCreateUI acUI = new AccountCreateUI(frame, "계좌 생성");
				
				acUI.setSize(332, 365);
				
				acUI.setLocationRelativeTo(scrollPane);
				acUI.setVisible(true);
				acUI.getContentPane().setLayout(null);
				acUI.setResizable(false);
			}
		});
		
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountDeleteUI acDeleteUI = new AccountDeleteUI(frame, "계좌 삭제");
	
				acDeleteUI.setLocationRelativeTo(scrollPane);
				acDeleteUI.setVisible(true);
				acDeleteUI.getContentPane().setLayout(null);
				acDeleteUI.setResizable(false);
			}
		});
		
	}
	
	
	//=============================================================================
	//=============================================================================
	public class InOutMoneyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object es = e.getSource();
			
			if(es == InBtn) {
				inin.setVisible(true);
			}else if(es == OutBtn) {
				OuOu.setVisible(true);
			}
			
		}
		
		
		
	}
	
	//입금다이얼로그===========================================================
			public class InputMoneyDialog extends JDialog{
				private static final long serialVersionUID = 1L;
				
				JTextField inTF, memoTF;
				JButton okBtn, cancelBtn;
				
				public InputMoneyDialog(JFrame frame, String title) {
					super(frame, title, true);
					
					setTitle(title);
					
					getContentPane().setLayout(new GridLayout(2, 1));
					
					JPanel panelOne = new JPanel(new GridLayout(2,2));
					
					panelOne.setBorder(new EmptyBorder(10,10,10,10));
					
					inTF = new JTextField();
					memoTF = new JTextField();
					
					panelOne.add(new JLabel("입금액", JLabel.CENTER));
					panelOne.add(inTF);
					panelOne.add(new JLabel("메모", JLabel.CENTER));
					panelOne.add(memoTF);
					
					inTF.requestFocus();
					
					okBtn = new JButton("입금");
					cancelBtn = new JButton("취소");
					
					JPanel panel2 = new JPanel();
					panel2.add(okBtn);
					panel2.add(cancelBtn);
					
					getContentPane().add(panelOne);
					getContentPane().add(panel2);
//			=================================================================================
					
					
					
					//입금버튼 기능구현
					okBtn.addActionListener(new ActionListener() {
						 
						@Override
						public void actionPerformed(ActionEvent e) {
							JoinDTO dto2 = new JoinDTO();
							
							
							
							//북클래스에 입금액저장
							String ITF = inTF.getText();
							
							//입금액텍스트필드에 값을 넣지 않았을때
							if(ITF.equals("")) {
								JOptionPane.showMessageDialog(null, "입금액을 입력해주세요");
								inTF.requestFocus();
								return;
							}
							
							String inmoneyReg = "^[\\d]*$";
							if(!Pattern.matches(inmoneyReg, ITF)) {
								JOptionPane.showMessageDialog(null, "입금액은 숫자만 입력해주세요");
								inTF.requestFocus();
								return;
							}
							
							int Imoney= Integer.parseInt(ITF);
							dto2.setDeposit(Imoney); 
							
							
							
							//북클래스에 메모저장
							String Imemo = memoTF.getText();
							
							if(Imemo.equals("")){
								dto2.setMemo("");
							}else {
								dto2.setMemo(Imemo);
							}
							
							
							
							INOUTDAO inoutdto = new INOUTDAO();
							
							inoutdto.selectBal(dto2);
							System.out.println(dto2.getAc_num());
							
							inoutdto.updateInfo(dto2);
							inoutdto.insertInfo(dto2);
							
							
						
							
						Vector<String> vector = new Vector<String>();
						
						Date date = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String Cdate = dateFormat.format(date);
						dto2.setCal(Cdate);
						String Tdate = dto2.getCal()+"";
						
						
						vector.add(Tdate);
						vector.add("입금");
						
						
						String iom = dto2.getDeposit() + "";
						
						vector.add(iom);
						
						long GLmoney = dto2.getBalance();
						
						String glastmoney =  Long.toString(GLmoney) ;
						
						vector.add(glastmoney);
						vector.add(dto2.getMemo());
							
							
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					tableModel.addRow(vector);
							
					
							inTF.setText("");
							memoTF.setText("");
							setVisible(true);
							
						}
					});
					
					cancelBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
							
						}
					});
					
					setBounds(750, 200, 250, 200);
					setResizable(false);
					}
					
				}
			
			//출금다이얼로그
			public class OutputMoneyDialog extends JDialog{
				private static final long serialVersionUID = 1L;
				
				JTextField outTF, OmemoTF;
				JButton okBtn, cancelBtn;
				
				public OutputMoneyDialog(JFrame frame, String title) {
					super(frame, title, true);
					
					setTitle(title);
					
					getContentPane().setLayout(new GridLayout(2, 1));
					
					JPanel panelOne = new JPanel(new GridLayout(3,2));
					
					panelOne.setBorder(new EmptyBorder(10,10,10,10));
					
					outTF = new JTextField();
					pwTF = new JPasswordField();
					OmemoTF = new JTextField();
					
					panelOne.add(new JLabel("출금액", JLabel.CENTER));
					panelOne.add(outTF);
					panelOne.add(new JLabel("계좌 비밀번호", JLabel.CENTER));
					panelOne.add(pwTF);
					panelOne.add(new JLabel("메모", JLabel.CENTER));
					panelOne.add(OmemoTF);
					
					outTF.requestFocus();
					
					okBtn = new JButton("출금");
					cancelBtn = new JButton("취소");
					
					
					JPanel panel2 = new JPanel();
					panel2.add(okBtn);
					panel2.add(cancelBtn);
					
					getContentPane().add(panelOne);
					getContentPane().add(panel2);
//			=================================================================================
					
					
					
					//출금버튼 기능구현
					okBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							JoinDTO dto2 = new JoinDTO();
							INOUTDAO inoutdto = new INOUTDAO();
							
							//북클래스에 출금액저장
							String OTF = outTF.getText();
							
							//출금액텍스트필드에 값을 넣지 않았을때
							if(OTF.equals("")) {
								JOptionPane.showMessageDialog(null, "출금액을 입력해주세요");
								outTF.requestFocus();
								return;
							}
							//출금액텍스트필드에 숫자가 아닌 다른값을 넣었을때
							String outmoneyReg = "^[\\d]*$";
							if(!Pattern.matches(outmoneyReg, OTF)) {
								JOptionPane.showMessageDialog(null, "출금액은 숫자만 입력해주세요");
								outTF.requestFocus();
								return;
							}
							int Omoney= Integer.parseInt(OTF);
							dto2.setWithdraw(Omoney); 
							
							//북클래스에 계좌비번저장
							
							 String Opw = new String(pwTF.getPassword());
							 
							 
							 //계좌비밀번호 4자리를 넘거나 숫자가 아닌값을 넣었을때
							 String acpw = "^[0-9]{4}$";
							 
							 if(!Pattern.matches(acpw, Opw)) {
								 JOptionPane.showMessageDialog(null, "4자리 숫자만 입력해주세요");
								outTF.requestFocus();
								return;
							 }
							 
							 inoutdto.accountInfor(dto2);
							 
							 
							 int ACPW = Integer.parseInt(Opw);
//							 System.out.println(dto2.getAc_pw());
							 if(ACPW != dto2.getAc_pw()) {
								 JOptionPane.showMessageDialog(null, "계좌비밀번호가 다릅니다.");
								outTF.requestFocus();
								return;
							 }
							 
							 
							 while(dto2.getBalance() < dto2.getWithdraw()) {
								 JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
								 continue;
								 
							 }
							
							 
							 
							
							 int ACpw=Integer.parseInt(Opw);
							 dto2.setAc_pw(ACpw); 
							
							
							//북클래스에 메모저장
							String Dapmemo = OmemoTF.getText();
							if(Dapmemo.equals("")){
								dto2.setMemo("");
							}else {
								dto2.setMemo(Dapmemo);
							}
							
							inoutdto.selectBal(dto2);
							inoutdto.OutupdateInfo(dto2);
							inoutdto.OutinsertInfo(dto2);
							
						
							
						Vector<String> vector = new Vector<String>();
						
						Date date = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String Cdate = dateFormat.format(date);
						dto2.setCal(Cdate);
						
						
						vector.add(dto2.getCal());
						vector.add("출금");
						
						
						String iom = dto2.getWithdraw() + "";
						
						vector.add(iom);
						
						int GLmoney = dto2.getBalance();
						String glastmoney =  Integer.toString(GLmoney) ;
						
						vector.add(glastmoney);
						vector.add(dto2.getMemo());
							
							
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					tableModel.addRow(vector);
							
					outTF.setText("");
					pwTF.setText("");
							setVisible(true);

						}
					});
					
					cancelBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
						}
					});
					
					setBounds(750, 200, 300, 250);
					setResizable(false);
					}
					
				}
			
	
	//=============================================================================
	//=============================================================================

	
	
		
	
	
	
	
	
	
	
	
	

	public void result() throws Exception {

		if (firstDate.isEmpty() && endDate.isEmpty()) {
			
//												****** 아이디 넣는 곳 *********2
			List<JoinDTO> jd = ResultDAO.getDao().nowSearch(accoutSelectNumber);
			System.out.println(jd.size());
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
				i.add(joinDTO.getHbalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}

//			// 2. 이후 날짜만 있다면, 이후 날짜 이전꺼를 모두 조회
		} else if (firstDate.isEmpty() && !endDate.isEmpty()) {
//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().oneSearch(accoutSelectNumber,dc.getEndDate(endDate));
			
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
				i.add(joinDTO.getHbalance());
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
			List<JoinDTO> jd = ResultDAO.getDao().bothSearch(firstDate, dc.getEndDate(endDate), accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
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
			List<JoinDTO> jd = ResultDAO.getDao().depositNowSearch(accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}

//			// 2. 이후 날짜만 있다면, 이후 날짜 이전꺼를 모두 조회
		} else if (firstDate.isEmpty() && !endDate.isEmpty()) {
//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().depositOneSearch(dc.getEndDate(endDate), accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
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
			List<JoinDTO> jd = ResultDAO.getDao().depositSearch(firstDate, dc.getEndDate(endDate), accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
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
			List<JoinDTO> jd = ResultDAO.getDao().withNowSearch(accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}

//			// 2. 이후 날짜만 있다면, 이후 날짜 이전꺼를 모두 조회
		} else if (firstDate.isEmpty() && !endDate.isEmpty()) {
//																	****** 아이디 넣는 곳 *********
			List<JoinDTO> jd = ResultDAO.getDao().withOneSearch(dc.getEndDate(endDate), accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
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
			List<JoinDTO> jd = ResultDAO.getDao().withSearch(firstDate, dc.getEndDate(endDate), accoutSelectNumber);

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
				i.add(joinDTO.getHbalance());
				i.add(joinDTO.getMemo());

				tableModel.addRow(i);
			}
		} else {
			throw new Exception();
		}
	}
}