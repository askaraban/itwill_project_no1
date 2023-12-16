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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class AccountDeleteUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public AccountDeleteUI(JFrame frame, String title) {
		
		super(frame, "계좌 삭제", false);
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
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("삭제하시겠습니까?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		panel.add(separator, BorderLayout.SOUTH);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 255));
		panel.add(separator_1, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(20);
		panel_1.add(panel_4);
		
		JButton btnNewButton = new JButton("삭제");
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(20);
		panel_1.add(panel_5);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_5.add(btnNewButton_1);
	}
	
	
}
