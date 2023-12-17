package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AccountDeleteUI extends JDialog {
	public static Vector<String> ac_List = new Vector<String>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public AccountDeleteUI(JFrame frame, String title) {
		
		super(frame, "계좌 삭제", false);
		setTitle("삭제하실 계좌를 선택하세요.");
		setResizable(false);
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setResizable(false);
		getContentPane().setForeground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		
		setBounds(100, 100, 250, 150);
		getContentPane().setLayout(new GridLayout(2, 3, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(101, 15, 0, 2);
		separator.setBackground(new Color(255, 255, 255));
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(106, 15, 0, 2);
		separator_1.setBackground(new Color(255, 255, 255));
		panel.add(separator_1);
		
		
		JComboBox comboBox = new JComboBox();
		List<JoinDTO> comboList = AccoutDAO.getAccountDAO().accountSearch(LoginUI.id);
		for (JoinDTO jd : comboList) {
			ac_List.add(jd.getAc_num());
		}
		comboBox.setModel(new DefaultComboBoxModel<String>(ac_List));
		comboBox.setBounds(28, 15, 177, 23);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(20);
		panel_1.add(panel_4);
		
		JButton btnNewButton = new JButton("삭제");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// 선택된 계좌에 계좌의 잔액이 0원이 아니라면
				if (AccoutDAO.getAccountDAO().getAccountBal().getBalance()!=0) {
					JOptionPane.showMessageDialog(null, "계좌에 잔액이 남아있습니다!", "에러", JOptionPane.ERROR_MESSAGE);	
					return;
				} else {
					int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "계좌 삭제", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if (result == JOptionPane.YES_OPTION) {
						AccoutDAO.getAccountDAO().accountDelete("combobox에 선택된 계좌번호를 여기에 넣으세요");
						JOptionPane.showMessageDialog(null, "계좌를 삭제하였습니다.");	
						
					} else {
						dispose();
					}
					
				}
			}
		});
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(20);
		panel_1.add(panel_5);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_5.add(btnNewButton_1);
	}
		
	
}

