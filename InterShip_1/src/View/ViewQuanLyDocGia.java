package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controll.ControllerReader;
import Model.Readers;
public class ViewQuanLyDocGia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField Idreader;
	public JTextField NameReader;
	public JTextField Address;
	public JTextField CCCD;
	public JTextField Phone;
	public JTable tblReader;
	public JTextField TenTimKiem;
	public List<Readers> listReader;
	public DefaultTableModel model;
	public AddReader r;
	public UpdateReader u;

	/**
	 * Create the panel.
	 */
	public ViewQuanLyDocGia() {
		listReader = Readers.SelectAll();
		setBackground(new Color(176, 224, 230));
		setLayout(null);
	    
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(256, 23, 224, 68);
		add(panel);
		
		JLabel lblcGi = new JLabel("Độc giả");
		lblcGi.setHorizontalAlignment(SwingConstants.CENTER);
		lblcGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblcGi.setBounds(0, 0, 224, 68);
		panel.add(lblcGi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(25, 123, 385, 209);
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(43, 29, 45, 13);
		panel_1.add(lblNewLabel_1);
		ActionListener action = new ControllerReader(this);
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(43, 66, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		Idreader = new JTextField();
		Idreader.setFont(new Font("Tahoma", Font.BOLD, 10));
		Idreader.setEditable(false);
		Idreader.setColumns(10);
		Idreader.setBackground(new Color(255, 239, 213));
		Idreader.setBounds(88, 26, 160, 19);
		panel_1.add(Idreader);
		
		NameReader = new JTextField();
		NameReader.setFont(new Font("Tahoma", Font.BOLD, 10));
		NameReader.setEditable(false);
		NameReader.setColumns(10);
		NameReader.setBackground(new Color(255, 239, 213));
		NameReader.setBounds(88, 63, 160, 19);
		panel_1.add(NameReader);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(30, 99, 58, 13);
		panel_1.add(lblNewLabel_3);
		
		Address = new JTextField();
		Address.setFont(new Font("Tahoma", Font.BOLD, 10));
		Address.setEditable(false);
		Address.setColumns(10);
		Address.setBackground(new Color(255, 239, 213));
		Address.setBounds(88, 96, 160, 19);
		panel_1.add(Address);
		
		JLabel lblNewLabel_3_1 = new JLabel("CCCD");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1.setBounds(30, 132, 58, 13);
		panel_1.add(lblNewLabel_3_1);
		
		CCCD = new JTextField();
		CCCD.setFont(new Font("Tahoma", Font.BOLD, 10));
		CCCD.setEditable(false);
		CCCD.setColumns(10);
		CCCD.setBackground(new Color(255, 239, 213));
		CCCD.setBounds(88, 129, 160, 19);
		panel_1.add(CCCD);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Phone");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1_1.setBounds(30, 165, 58, 13);
		panel_1.add(lblNewLabel_3_1_1);
		
		Phone = new JTextField();
		Phone.setFont(new Font("Tahoma", Font.BOLD, 10));
		Phone.setEditable(false);
		Phone.setColumns(10);
		Phone.setBackground(new Color(255, 239, 213));
		Phone.setBounds(88, 162, 160, 19);
		panel_1.add(Phone);
		
		JButton btnNewButton_1 = new JButton("Thông tin chi tiết");
		btnNewButton_1.setBackground(new Color(210, 180, 140));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(249, 128, 126, 21);
		btnNewButton_1.addActionListener(action);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thêm phiếu mượn");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(210, 180, 140));
		btnNewButton_2.setBounds(249, 158, 126, 21);
		btnNewButton_2.addActionListener(action);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(431, 101, 351, 239);
		add(panel_2);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Fatcow-Farm-Fresh-Insert-token.32.png"));
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(42, 25, 121, 59);
		btnNewButton.addActionListener(action);
		panel_2.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Etherbrian-Webuosities-Fix-it.32.png"));
		btnSa.setBackground(new Color(210, 180, 140));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSa.setBounds(196, 25, 106, 59);
		btnSa.addActionListener(action);
		panel_2.add(btnSa);
	
		JButton btnXo = new JButton("Xoá");
		btnXo.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Iconsmind-Outline-Close.32.png"));
		btnXo.setBackground(new Color(210, 180, 140));
		btnXo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXo.setBounds(42, 106, 121, 59);
		btnXo.addActionListener(action);
		panel_2.add(btnXo);
		
		JButton btnXo_1 = new JButton("Refresh");
		btnXo_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Custom-Icon-Design-Mono-General-4-Refresh.32.png"));
		btnXo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXo_1.setBackground(new Color(210, 180, 140));
		btnXo_1.setBounds(196, 106, 145, 59);
		btnXo_1.addActionListener(action);
		panel_2.add(btnXo_1);
		
		TenTimKiem = new JTextField();
		TenTimKiem.setBackground(new Color(210, 180, 140));
		TenTimKiem.setBounds(21, 187, 142, 29);
		panel_2.add(TenTimKiem);
		TenTimKiem.setColumns(10);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBounds(196, 170, 145, 59);
		btnTmKim.addActionListener(action);
		panel_2.add(btnTmKim);
		btnTmKim.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Gakuseisean-Ivista-2-Start-Menu-Search.32.png"));
		btnTmKim.setBackground(new Color(210, 180, 140));
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		tblReader = new JTable();
		tblReader.setFont(new Font("Tahoma", Font.BOLD, 10));
		tblReader.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Address", "CCCD", "Phone"
			}
		));
		model  = (DefaultTableModel) tblReader.getModel();
		Showdata(listReader, model);
	
		
		
		JScrollPane scrollPane = new JScrollPane((tblReader));
		scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		scrollPane.setBounds(10, 347, 772, 238);
		add(scrollPane);

	}
	public static void Showdata(List<Readers> listReader,DefaultTableModel model) {
		   model.setRowCount(0);
		   for(Readers b : listReader) {
			   if(b instanceof Readers) {
				  model.addRow(new Object[] {b.getId(),b.getName(),b.getAddress(),b.getCCCD(),b.getPhone()});
			   }
		   }
		
	}
}
