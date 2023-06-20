package View;

import java.awt.BorderLayout;
import Controll.ControllerChangePanel;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.util.*;
import Model.DanhMuc;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDienChinh extends JDialog {
	public JPanel ViewPanel;
	public JLabel Muontralabel;
	public 	JPanel panel_6 ;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public GiaoDienChinh() {
		setBounds(100, 100, 1055, 642);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
	    ViewPanel = new JPanel();
		ViewPanel.setBackground(new Color(240, 230, 140));
		ViewPanel.setBounds(259, 0, 782, 595);
		panel.add(ViewPanel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(0, 0, 249, 595);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel Sachjpn = new JPanel();
		Sachjpn.setBackground(new Color(0, 255, 0));
		Sachjpn.setBounds(10, 23, 229, 66);
		panel_2.add(Sachjpn);
		Sachjpn.setLayout(null);
		
		JLabel sachjlb = new JLabel("Quản lý sách");
		sachjlb.setFont(new Font("Tahoma", Font.BOLD, 20));
		sachjlb.setHorizontalAlignment(SwingConstants.CENTER);
		sachjlb.setBounds(0, 0, 229, 66);
		Sachjpn.add(sachjlb);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 255, 0));
		panel_4.setBounds(10, 124, 229, 66);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel DocGiaLabel = new JLabel("Quản lý độc giả");
		DocGiaLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		DocGiaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DocGiaLabel.setBounds(0, 0, 229, 66);
		panel_4.add(DocGiaLabel);
		
	    panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 255, 0));
		panel_6.setBounds(10, 230, 229, 66);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
	    Muontralabel = new JLabel("Quản lý mượn trả");
		Muontralabel.setBackground(new Color(255, 255, 255));
		Muontralabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		Muontralabel.setHorizontalAlignment(SwingConstants.CENTER);
		Muontralabel.setBounds(0, 0, 229, 66);
		panel_6.add(Muontralabel);
		ControllerChangePanel cd = new ControllerChangePanel(ViewPanel,this);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 255, 0));
		panel_8.setBounds(10, 334, 229, 66);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    System.exit(0);
				   
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(0, 0, 229, 66);
		panel_8.add(btnNewButton);
		List<DanhMuc> list = new ArrayList<>();
		list.add(new DanhMuc("Quản lý sách",Sachjpn,sachjlb));
		list.add(new DanhMuc("Quản độc giả",panel_4,DocGiaLabel));
		list.add(new DanhMuc("Quản lý mượn trả",panel_6,Muontralabel));
		cd.setEvent(list);
		cd.setView(Sachjpn, sachjlb);
		setVisible(true);
	
	}
}
