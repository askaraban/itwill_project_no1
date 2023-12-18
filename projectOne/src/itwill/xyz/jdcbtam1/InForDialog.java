package itwill.xyz.jdcbtam1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InForDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JoinDTO INFORdial;
	JComboBox comboBox;
	
	
	/**
	 * Launch the application.2
	 */
	public static void main(String[] args) {
		try {
			InForDialog dialog = new InForDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public InForDialog() {
		//joinDAOlmple 메소드 사용해서 DTO에 로그인 정보저장
		JoinDTO INFORdial = JoinDAOImpl.getDAO().selectClientByNo(LoginUI.id);
		
//		INOUTDAOEX1 accountINFOR = new INOUTDAOEX1();
//		accountINFOR.InforBtnTable(INFORdial);
		/*List<JoinDTOEX1> INFORdialAcNum = JoinDAOImplEX1.getDAO().InForMationClient(LoginUIEX1.id);
		for(JoinDTOEX1 INFORdial2 : INFORdialAcNum) {
			
			
		}*/
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblLabel = new JLabel("I       D   :");
				lblLabel.setFont(new Font("굴림", Font.BOLD, 20));
				panel.add(lblLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblValNewLabel = new JLabel(INFORdial.getID());
				lblValNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
				panel.add(lblValNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(10);
				panel.add(panel_1);
				{
					JLabel NameLabel = new JLabel(" 이     름   : ");
					NameLabel.setFont(new Font("굴림", Font.BOLD, 20));
					panel_1.add(NameLabel);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(10);
				panel.add(panel_1);
				{
					JLabel lblValLabel = new JLabel(INFORdial.getName());
					lblValLabel.setFont(new Font("굴림", Font.PLAIN, 20));
					panel_1.add(lblValLabel);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(10);
				panel.add(panel_1);
				{
					JLabel DateLabel = new JLabel("가입일자  :");
					DateLabel.setFont(new Font("굴림", Font.BOLD, 20));
					panel_1.add(DateLabel);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(10);
				panel.add(panel_1);
				{
					JLabel DateValLabel = new JLabel(INFORdial.getCal());
					DateValLabel.setFont(new Font("굴림", Font.PLAIN, 20));
					panel_1.add(DateValLabel);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(10);
				panel.add(panel_1);
				{
					JLabel AccountNumLabel = new JLabel("계좌 번호 ");
					AccountNumLabel.setFont(new Font("굴림", Font.BOLD, 20));
					panel_1.add(AccountNumLabel);
				}
			}
		}
		{	
			//콤보박스 패널 수정 후 계좌번호 넣기
			JPanel AcoountNumKind = new JPanel();
			getContentPane().add(AcoountNumKind);
			AcoountNumKind.setLayout(new GridLayout(1, 1, 0, 0));
			{
				comboBox = new JComboBox();
				
				List<JoinDTO> INFORdialAcNum = JoinDAOImpl.getDAO().InForMationClient(LoginUI.id);
				Vector<String> accountnumber = new Vector<>();
				 
				for(JoinDTO INFORdial2 : INFORdialAcNum) {
					accountnumber.add(INFORdial2.getAc_num());
				}
				
				comboBox.setModel(new DefaultComboBoxModel<String>(accountnumber));
				comboBox.setToolTipText("");
				AcoountNumKind.add(comboBox);
				
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel);
			{
				JPanel buttonPane = new JPanel();
				panel.add(buttonPane);
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton okButton = new JButton("확인");
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					
					//OK버튼 기능
					okButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							//jcombo.getSelectedItem().toString()
							//jcombo.getItemAt(jcombo.getSelectedIndex()).toString()
							
							String acuntNum = comboBox.getSelectedItem().toString();
							INFORdial.setAc_num(acuntNum);
							
							dispose();
							
						}
					});
				}
			}
		}
	}

}
