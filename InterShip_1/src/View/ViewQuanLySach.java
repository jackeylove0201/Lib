package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import Controll.controllerSach;
import Model.Book;
public class ViewQuanLySach extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable tblSach;
	public JTextField TextBookId;
	public JTextField TextBookName;
	public JTextField TextType;
	public JTextField TextLanguage;
	public JTextField TextNguoNhap;
	public JTextField textField_5;
    public List<Book> listBook;
    public  DefaultTableModel model;
    public JTextField TextSoLuong;
    public AddBook addbook;
    public JTextField TimKiem;
    public JTextField TextNxb;
    public JTextField SoLuongMuon;
	
	/**
	 * Create the panel.
	 */
    
	public ViewQuanLySach() {
		listBook = new ArrayList<>();
		listBook = Book.SelectAll();
		
		setBackground(new Color(255, 250, 205));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(258, 10, 224, 68);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý sách");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 224, 68);
		panel.add(lblNewLabel);
		
		tblSach = new JTable();
		tblSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblSach.setForeground(new Color(0, 0, 0));
		tblSach.setBackground(new Color(255, 250, 240));
		tblSach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"BookId", "Name", "IdType", "IdLanguage", "Quantity", "ImportDate", "MaNv", "IdNXB"
			}
		));
		model = (DefaultTableModel) tblSach.getModel();
		Showdata(listBook,model);
		
		JScrollPane scrollPane = new JScrollPane(tblSach);
		scrollPane.setBounds(10, 347, 772, 238);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(10, 88, 388, 249);
		panel_1.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết"));
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BookId :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(43, 29, 45, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(43, 66, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		TextBookId = new JTextField();
		TextBookId.setEditable(false);
		TextBookId.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextBookId.setBackground(new Color(255, 239, 213));
		TextBookId.setBounds(88, 26, 160, 19);
		panel_1.add(TextBookId);
		TextBookId.setColumns(10);
		
		TextBookName = new JTextField();
		TextBookName.setEditable(false);
		TextBookName.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextBookName.setColumns(10);
		TextBookName.setBackground(new Color(255, 239, 213));
		TextBookName.setBounds(88, 63, 160, 19);
		panel_1.add(TextBookName);
		
		JLabel lblNewLabel_3 = new JLabel("Loại sách :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(30, 99, 58, 13);
		panel_1.add(lblNewLabel_3);
		
		TextType = new JTextField();
		TextType.setEditable(false);
		TextType.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextType.setColumns(10);
		TextType.setBackground(new Color(255, 239, 213));
		TextType.setBounds(88, 96, 160, 19);
		panel_1.add(TextType);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ngôn ngữ :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1.setBounds(30, 132, 58, 13);
		panel_1.add(lblNewLabel_3_1);
		
		TextLanguage = new JTextField();
		TextLanguage.setEditable(false);
		TextLanguage.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextLanguage.setColumns(10);
		TextLanguage.setBackground(new Color(255, 239, 213));
		TextLanguage.setBounds(88, 129, 160, 19);
		panel_1.add(TextLanguage);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Người nhập :");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1_1.setBounds(10, 165, 68, 13);
		panel_1.add(lblNewLabel_3_1_1);
		
		TextNguoNhap = new JTextField();
		TextNguoNhap.setEditable(false);
		TextNguoNhap.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextNguoNhap.setColumns(10);
		TextNguoNhap.setBackground(new Color(255, 239, 213));
		TextNguoNhap.setBounds(88, 162, 160, 19);
		panel_1.add(TextNguoNhap);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_1_1_1.setBounds(10, 194, 68, 13);
		panel_1.add(lblNewLabel_3_1_1_1);
		
		TextSoLuong = new JTextField();
		TextSoLuong.setEditable(false);
		TextSoLuong.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextSoLuong.setColumns(10);
		TextSoLuong.setBackground(new Color(255, 239, 213));
		TextSoLuong.setBounds(88, 191, 74, 19);
		panel_1.add(TextSoLuong);
		
		JLabel lblNewLabel_5 = new JLabel("Nhà xuất bản");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 226, 68, 13);
		panel_1.add(lblNewLabel_5);
		
		TextNxb = new JTextField();
		TextNxb.setFont(new Font("Tahoma", Font.BOLD, 10));
		TextNxb.setEditable(false);
		TextNxb.setColumns(10);
		TextNxb.setBackground(new Color(255, 239, 213));
		TextNxb.setBounds(88, 220, 160, 19);
		panel_1.add(TextNxb);
		
		JLabel lblNewLabel_6 = new JLabel("SoLuongMuon");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(249, 29, 74, 13);
		panel_1.add(lblNewLabel_6);
		
		SoLuongMuon = new JTextField();
		SoLuongMuon.setFont(new Font("Tahoma", Font.BOLD, 10));
		SoLuongMuon.setEditable(false);
		SoLuongMuon.setBackground(new Color(250, 235, 215));
		SoLuongMuon.setBounds(333, 26, 45, 19);
		panel_1.add(SoLuongMuon);
		SoLuongMuon.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(426, 88, 335, 202);
		add(panel_2);
		panel_2.setLayout(null);
		ActionListener action = new controllerSach(this);
		JButton btnNewButton = new JButton("Thêm sách");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(32, 20, 270, 21);
		btnNewButton.addActionListener(action);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa thông tin");
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(32, 61, 270, 21);
		btnNewButton_1.addActionListener(action);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xoá sách");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBounds(32, 102, 270, 21);
		btnNewButton_2.addActionListener(action);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm bằng Id");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBounds(32, 171, 125, 21);
		btnNewButton_3.addActionListener(action);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm bằng tên");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.setBounds(167, 171, 135, 21);
		btnNewButton_4.addActionListener(action);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Thông tin chi tiết");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.setBounds(32, 140, 270, 21);
		btnNewButton_5.addActionListener(action);
		panel_2.add(btnNewButton_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(546, 313, 215, 26);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Ampeross-Qetto-2-Search.24.png"));
		lblNewLabel_4.setBounds(0, 0, 27, 26);
		panel_3.add(lblNewLabel_4);
		
		TimKiem = new JTextField();
		TimKiem.setBounds(25, 0, 190, 26);
		panel_3.add(TimKiem);
		TimKiem.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5.setBounds(26, 0, 189, 26);
		
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Refresh");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_6.setBounds(426, 316, 85, 21);
		btnNewButton_6.addActionListener(action);
		add(btnNewButton_6);
		
		
	
		
		
	
	

	}
	public static void Showdata(List<Book> listBook,DefaultTableModel model) {
		   model.setRowCount(0);
		   for(Book b : listBook) {
			   if(b instanceof Book) {
				  model.addRow(new Object[] {b.getId(),b.getName(),b.getIdtype(),b.getIdLanguage(),b.getQuantity(),b.getImportDate(),b.getMaNV(),b.getIdNXB()});
			   }
		   }
		
	}
}
