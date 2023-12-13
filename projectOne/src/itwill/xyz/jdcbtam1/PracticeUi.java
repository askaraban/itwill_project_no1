package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PracticeUi {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticeUi window = new PracticeUi();
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
	public PracticeUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_2 = new JButton("입금");
		panel_3.add(btnNewButton_2);
		
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
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("회원가입");
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
	}
}
