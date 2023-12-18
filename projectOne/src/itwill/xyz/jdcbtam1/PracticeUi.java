package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PracticeUi extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JButton InBtn;
	private InputMoney inin;
	


	/**
	 * Create the application.2
	 */ 
	public PracticeUi(String title) {
		initialize(title); 
	} 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String title) {
		
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setBounds(400,100,1000,800);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		InBtn = new JButton("입금");
		InBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(InBtn);
		
		JButton btnNewButton_3 = new JButton("출금");
		panel_3.add(btnNewButton_3);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("~");
		panel_3.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"입금", "출금"}));
		comboBox.setMaximumRowCount(2);
		panel_3.add(comboBox);
		
		JButton btnNewButton_4 = new JButton("조회");
		panel_3.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
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
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("로그인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginUI join = new LoginUI();
				join.setVisible(true);
				join.setLayout(null);
				join.setLocation(getWidth() / 2 + 700 + join.getLocation().x, 
						getHeight() / 2 + 200 + join.getLocation().y);
				
			}
		});
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JoinUI join = new JoinUI();
				join.setVisible(true);
				join.setLayout(null);
				join.setLocation(getWidth() / 2 + 700 + join.getLocation().x, 
						getHeight() / 2 + 200 + join.getLocation().y);
			}
		});
		panel_4.add(btnNewButton);
		
		JButton button = new JButton("로그아웃");
		panel_4.add(button);
		
		JButton btnNewButton_8 = new JButton("회원탈퇴");
		panel_4.add(btnNewButton_8);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_5 = new JButton("내 정보 보기");
		panel_5.add(btnNewButton_5);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("환영합니다");
		panel_7.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("아이티윌 은행입니다.");
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		
		inin = new InputMoney(this, "입금창");
		
	}
	
	public class InOutMoney implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object es = e.getSource();
			
			if(es == InBtn) {
				inin.setVisible(true);
			}
			
		}
		
		
		
	}
	
	public class InputMoney extends JDialog{
		private static final long serialVersionUID = 1L;
		
		JTextField inTF, psTF;
		JButton okBtn, cancelBtn;
		
		public InputMoney(JFrame frame, String title) {
			super(frame, title, true);
			
			setTitle(title);
			
			getContentPane().setLayout(new GridLayout(2, 1));
			
			JPanel panelOne = new JPanel(new GridLayout(2,2));
			
			panelOne.setBorder(new EmptyBorder(10,10,10,10));
			
			inTF = new JTextField();
			psTF = new JTextField();
			
			panelOne.add(new JLabel("입금액", JLabel.CENTER));
			panelOne.add(inTF);
			panelOne.add(new JLabel("비밀번호", JLabel.CENTER));
			panelOne.add(psTF);
			
			inTF.requestFocus();
			
			okBtn = new JButton("입금");
			cancelBtn = new JButton("취소");
			
			JPanel panel2 = new JPanel();
			panel2.add(okBtn);
			panel2.add(cancelBtn);
			
			getContentPane().add(panelOne);
			getContentPane().add(panel2);
			
			okBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String in = inTF.getText();
					String passwd = psTF.getText();
					
					Vector<String> vector = new Vector<String>();
					vector.add(in);
					vector.add(passwd);
					
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				
				tableModel.addRow(vector);

				inTF.setText("");
				psTF.setText("");
				setVisible(true);
				
				
				

				}
			});
			
				
			};
			
		}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticeUi window = new PracticeUi("계좌관리");
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	}
	
	
