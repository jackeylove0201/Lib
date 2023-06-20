package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.ControllerBorrow;

import java.awt.Component;
import javax.swing.JTextField;

import Model.ChiTietPhieuMuon;
import Model.PhieuMuon;
import Model.Readers;
import javax.swing.ImageIcon;
public class ViewMuonTra extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable tblChitiet;
	public JTable tblPh;
	public JTextField Mdg;
	public JTextField MPh;
	public JTextField slm;
	public JTextField Tensach;
	public JTextField NgayMuon;
	public JTextField NgayTra;
	public List<PhieuMuon> listPM;
	public DefaultTableModel models;
    public JLabel lbten;
    public ChiTietPhieu ch;
    public List<ChiTietPhieuMuon> listCh;
    public JLabel lblNewLabel_4;
    public JLabel thongbao;
    public JButton btnNewButton_9;
    public JTextField phat;
    public JButton 	buttonPhat;
    public JButton btnNewButton_11;
    public JButton  btnNewButton;
    public JButton   btnNewButton_1 ;
	/**
	 * Create the panel.
	 */
	public ViewMuonTra() {
		listPM = new ArrayList<>();
		listPM  = PhieuMuon.SelectAll();
		
		
		setBackground(new Color(0, 255, 255));
		setLayout(null);
		
	
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(10, 250, 381, 259);
		panel.setBorder(BorderFactory.createTitledBorder("Chi tiết phiếu"));
		add(panel);
		panel.setLayout(null);
		
	    thongbao = new JLabel("Mã Phiêu");
		thongbao.setFont(new Font("Tahoma", Font.BOLD, 10));
		thongbao.setHorizontalAlignment(SwingConstants.CENTER);
		thongbao.setBounds(52, 10, 319, 25);
		panel.add(thongbao);
		tblChitiet = new JTable();
		tblChitiet.setBackground(new Color(255, 255, 255));
		tblChitiet.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y tr\u1EA3"
			}
		));
		JScrollPane scrollPane = new JScrollPane(tblChitiet);
		scrollPane.setBounds(10, 45, 361, 204);
		panel.add(scrollPane);
		
	
	    ActionListener action = new ControllerBorrow(this);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(20, 519, 336, 66);
		add(panel_1);
		panel_1.setLayout(null);
		
	    btnNewButton = new JButton("Thêm chi tiết phiếu");
	    btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(10, 10, 154, 21);
		btnNewButton.addActionListener(action);
		panel_1.add(btnNewButton);
		
	    btnNewButton_1 = new JButton("Xem chi tiết phiếu");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(174, 10, 146, 21);
		btnNewButton_1.addActionListener(action);
		panel_1.add(btnNewButton_1);
		
	    buttonPhat = new JButton("Phạt");
	    buttonPhat.setEnabled(false);
		
		buttonPhat.setFont(new Font("Tahoma", Font.BOLD, 10));
		buttonPhat.setBounds(10, 35, 85, 21);
		buttonPhat.addActionListener(action);
		panel_1.add(buttonPhat);
		
		btnNewButton_11 = new JButton("Xác nhận trả");
		btnNewButton_11.setEnabled(false);
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_11.setBounds(174, 41, 146, 21);
		btnNewButton_11.addActionListener(action);
		panel_1.add(btnNewButton_11);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(401, 250, 381, 259);
		add(panel_2);
		
	    lbten = new JLabel("Tên độc giả");
		lbten.setHorizontalAlignment(SwingConstants.CENTER);
		lbten.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbten.setBounds(121, 10, 136, 25);
		panel_2.add(lbten);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(10, 45, 361, 204);
		panel_2.add(scrollPane_1);
		
		tblPh = new JTable();
		tblPh.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" M\u00E3 \u0111\u1ED9c gi\u1EA3", "M\u00E3 Phi\u1EBFu", "S\u1ED1 l\u01B0\u1EE3ng s\u00E1ch m\u01B0\u1EE3n"
			}
		));
		models = (DefaultTableModel) tblPh.getModel();
	    Showdata(listPM, models);
		scrollPane_1.setViewportView(tblPh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(135, 206, 250));
		panel_3.setBounds(411, 519, 348, 35);
		add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Sửa");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBounds(10, 10, 143, 21);
		btnNewButton_2.addActionListener(action);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Xoá");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBounds(191, 10, 143, 21);
		btnNewButton_3.addActionListener(action);
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(175, 238, 238));
		panel_4.setBounds(283, 20, 217, 55);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin mượn trả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 217, 55);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(127, 255, 212));
		panel_5.setBounds(425, 85, 357, 155);
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(27, 23, 45, 13);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã độc giả");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(27, 23, 63, 13);
		panel_5.add(lblNewLabel_3);
		
		Mdg = new JTextField();
		Mdg.setBounds(115, 17, 136, 19);
		panel_5.add(Mdg);
		Mdg.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Mã phiếu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(27, 56, 63, 13);
		panel_5.add(lblNewLabel_4);
		
		MPh = new JTextField();
		MPh.setBounds(115, 53, 136, 19);
		panel_5.add(MPh);
		MPh.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Số lượng sách mượn");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 91, 104, 13);
		panel_5.add(lblNewLabel_5);
		
		slm = new JTextField();
		slm.setBounds(115, 88, 136, 19);
		panel_5.add(slm);
		slm.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Thêm");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setBounds(255, 87, 85, 21);
		btnNewButton_4.addActionListener(action);
		panel_5.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Hiển thị");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.setBounds(255, 52, 85, 21);
		btnNewButton_5.addActionListener(action);
		panel_5.add(btnNewButton_5);
		
		JButton btnNewButton_8 = new JButton("Reset");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_8.setBounds(255, 16, 85, 21);
		btnNewButton_8.addActionListener(action);
		panel_5.add(btnNewButton_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(127, 255, 212));
		panel_6.setBounds(10, 85, 381, 155);
		add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Tên sách");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(10, 10, 66, 13);
		panel_6.add(lblNewLabel_6);
		
		Tensach = new JTextField();
		Tensach.setBounds(86, 7, 194, 19);
		panel_6.add(Tensach);
		Tensach.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ngày mượn");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(10, 49, 66, 13);
		panel_6.add(lblNewLabel_7);
		
		NgayMuon = new JTextField();
		NgayMuon.setBounds(88, 46, 192, 19);
		panel_6.add(NgayMuon);
		NgayMuon.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày trả");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(10, 91, 45, 13);
		panel_6.add(lblNewLabel_8);
		
		NgayTra = new JTextField();
		NgayTra.setBackground(new Color(255, 255, 255));
		NgayTra.setBounds(86, 88, 194, 19);
		panel_6.add(NgayTra);
		NgayTra.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("-->");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnNewButton_6.setBounds(290, 6, 55, 31);
		btnNewButton_6.addActionListener(action);
		panel_6.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("<--");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_7.setBounds(290, 45, 55, 31);
		btnNewButton_7.addActionListener(action);
		panel_6.add(btnNewButton_7);
		
		btnNewButton_9 = new JButton("Gia hạn");
		btnNewButton_9.setEnabled(false);
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_9.setBounds(290, 87, 85, 21);
		btnNewButton_9.addActionListener(action);
		panel_6.add(btnNewButton_9);
		
		JLabel lblNewLabel = new JLabel("Ngày phạt");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(10, 132, 66, 13);
		panel_6.add(lblNewLabel);
		
		phat = new JTextField();
		phat.setFont(new Font("Tahoma", Font.BOLD, 10));
		phat.setBounds(86, 129, 96, 19);
		panel_6.add(phat);
		phat.setColumns(10);

	}
	public static void Showdata(List listPM,DefaultTableModel model) {
		   model.setRowCount(0);
		   for(Object b : listPM) {
			   if(b instanceof PhieuMuon) {
				  PhieuMuon p = (PhieuMuon) b;
				  model.addRow(new Object[] {p.getName(),p.getId(),p.getBorrow()});
			   }
			   else {
				   ChiTietPhieuMuon c  = (ChiTietPhieuMuon) b;
				   model.addRow(new Object[] {c.getIdPhieu(),c.getNgayMuon(),c.getNgayTra()});
				   
			   }
		   }
		
	}
}
