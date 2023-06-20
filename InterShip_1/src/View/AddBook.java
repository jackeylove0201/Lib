package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Book;
public class AddBook extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField IdbookAdd;
	public JTextField NameBookAdd;
	public JTextField Idtypeadd;
	public JTextField IdlanguageAdd;
	public JTextField soluongadd;
	public JTextField manvadd;
	public JTextField manxbadd;
	public JTextField Ngaynhapadd;
	ViewQuanLySach v;  // tạo thuoc tinh giao dien view quan lý sách

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public AddBook(ViewQuanLySach t) {
		getContentPane().setLayout(null);
		v = (ViewQuanLySach) t;    // put this.v bang view quản lý sách
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(10, 10, 697, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(269, 10, 104, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BookId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 86, 62, 23);
		panel.add(lblNewLabel_1);
		
		IdbookAdd = new JTextField();
		IdbookAdd.setFont(new Font("Tahoma", Font.BOLD, 10));
		IdbookAdd.setBounds(119, 88, 165, 19);
		panel.add(IdbookAdd);
		IdbookAdd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(52, 147, 45, 13);
		panel.add(lblNewLabel_2);
		
		NameBookAdd = new JTextField();
		NameBookAdd.setFont(new Font("Tahoma", Font.BOLD, 10));
		NameBookAdd.setBounds(119, 144, 165, 19);
		panel.add(NameBookAdd);
		NameBookAdd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("IdType");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(52, 200, 45, 13);
		panel.add(lblNewLabel_3);
		
		Idtypeadd = new JTextField();
		Idtypeadd.setFont(new Font("Tahoma", Font.BOLD, 10));
		Idtypeadd.setBounds(119, 197, 165, 19);
		Idtypeadd.setToolTipText("KD:kinh doanh,CN:Công nghệ,GD:Giáo Dục,CT:Chính trị,VH:Văn học");
		panel.add(Idtypeadd);
		Idtypeadd.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("IdLanguage");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(35, 253, 62, 13);
		panel.add(lblNewLabel_4);
		
		IdlanguageAdd = new JTextField();
		IdlanguageAdd.setFont(new Font("Tahoma", Font.BOLD, 10));
		IdlanguageAdd.setBounds(119, 250, 165, 19);
		panel.add(IdlanguageAdd);
		IdlanguageAdd.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(375, 147, 45, 13);
		panel.add(lblNewLabel_5);
		
		soluongadd = new JTextField();
		soluongadd.setFont(new Font("Tahoma", Font.BOLD, 10));
		soluongadd.setBounds(441, 144, 165, 19);
		panel.add(soluongadd);
		soluongadd.setColumns(10);
		
		manvadd = new JTextField();
		manvadd.setFont(new Font("Tahoma", Font.BOLD, 10));
		manvadd.setColumns(10);
		manvadd.setBounds(441, 197, 165, 19);
		panel.add(manvadd);
		
		JLabel lblNewLabel_5_1 = new JLabel("MaNV");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(375, 200, 45, 13);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("MaNXB");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_2.setBounds(375, 256, 45, 13);
		panel.add(lblNewLabel_5_2);
		
		manxbadd = new JTextField();
		manxbadd.setFont(new Font("Tahoma", Font.BOLD, 10));
		manxbadd.setColumns(10);
		manxbadd.setBounds(441, 250, 165, 19);
		panel.add(manxbadd);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(314, 327, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			      String BookId = IdbookAdd.getText();
			      String Bookname = NameBookAdd.getText();
			      String IdType = Idtypeadd.getText();
			      String IdLanguage = IdlanguageAdd.getText();
			      Date ngaynhap = Date.valueOf(Ngaynhapadd.getText());
			      int soluong  = Integer.parseInt(soluongadd.getText());
			      String Manv = manvadd.getText();
			      String manxb = manxbadd.getText();
				  Book b = new Book(BookId,Bookname,IdType,IdLanguage,soluong,ngaynhap, Manv,manxb);
				  b.Add("insert into Book values(?,?,?,?,?,?,?,?,null,0)");
				  v.listBook = Book.SelectAll();
				  ViewQuanLySach.Showdata(v.listBook, v.model);
				  JOptionPane.showMessageDialog(rootPane,"Thêm thành công");
				  dispose();
			}
		});
		panel.add(btnNewButton);
		
		
		JLabel lblNewLabel_5_3 = new JLabel("Ngày nhập");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_3.setBounds(370, 91, 62, 13);
		panel.add(lblNewLabel_5_3);
		
		Ngaynhapadd = new JTextField();
		Ngaynhapadd.setFont(new Font("Tahoma", Font.BOLD, 10));
		Ngaynhapadd.setColumns(10);
		Ngaynhapadd.setBounds(441, 88, 165, 19);
		panel.add(Ngaynhapadd);
	
		setSize(731,500);
		setTitle("Thêm sách");
		
	
	}

	
}
