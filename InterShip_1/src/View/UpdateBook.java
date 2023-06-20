package View;

import java.awt.BorderLayout;
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
import Model.Employees;
import Model.Infor;;
public class UpdateBook extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField BookIdupdate;
	public JTextField NameBookUpdate;
	public JTextField IdtypeUpdate;
	public JTextField IdLanguageUpdate;
	public JTextField QuantityUpdate;
	public JTextField MaNvUpdate;
	public JTextField ManxbUpdate;
	public JTextField NgayNhapUpdate;
	ViewQuanLySach v;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public UpdateBook(ViewQuanLySach t) {
		v = (ViewQuanLySach) t;
		setBounds(100, 100, 716, 480);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(255, 255, 204));
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblSaThngTin = new JLabel("Sửa thông tin");
				lblSaThngTin.setHorizontalAlignment(SwingConstants.CENTER);
				lblSaThngTin.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblSaThngTin.setBounds(269, 10, 104, 39);
				panel.add(lblSaThngTin);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("BookId");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_1.setBounds(35, 86, 62, 23);
				panel.add(lblNewLabel_1);
			}
			{
				BookIdupdate = new JTextField();
				BookIdupdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				BookIdupdate.setColumns(10);
				BookIdupdate.setBounds(119, 88, 165, 19);
				panel.add(BookIdupdate);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Name");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_2.setBounds(52, 147, 45, 13);
				panel.add(lblNewLabel_2);
			}
			{
				NameBookUpdate = new JTextField();
				NameBookUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				NameBookUpdate.setColumns(10);
				NameBookUpdate.setBounds(119, 144, 165, 19);
				panel.add(NameBookUpdate);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("IdType");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_3.setBounds(52, 200, 45, 13);
				panel.add(lblNewLabel_3);
			}
			{
				IdtypeUpdate = new JTextField();
				
				IdtypeUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				IdtypeUpdate.setColumns(10);
				IdtypeUpdate.setBounds(119, 197, 165, 19);
				panel.add(IdtypeUpdate);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("IdLanguage");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_4.setBounds(35, 253, 62, 13);
				panel.add(lblNewLabel_4);
			}
			{
				IdLanguageUpdate = new JTextField();
				IdLanguageUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				IdLanguageUpdate.setColumns(10);
				IdLanguageUpdate.setBounds(119, 250, 165, 19);
				panel.add(IdLanguageUpdate);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Quantity");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_5.setBounds(375, 147, 45, 13);
				panel.add(lblNewLabel_5);
			}
			{
				QuantityUpdate = new JTextField();
				QuantityUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				QuantityUpdate.setColumns(10);
				QuantityUpdate.setBounds(441, 144, 165, 19);
				panel.add(QuantityUpdate);
			}
			{
				MaNvUpdate = new JTextField();
				MaNvUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				MaNvUpdate.setColumns(10);
				MaNvUpdate.setBounds(441, 197, 165, 19);
				panel.add(MaNvUpdate);
			}
			{
				JLabel lblNewLabel_5_1 = new JLabel("MaNV");
				lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_5_1.setBounds(375, 200, 45, 13);
				panel.add(lblNewLabel_5_1);
			}
			{
				JLabel lblNewLabel_5_2 = new JLabel("MaNXB");
				lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_5_2.setBounds(375, 256, 45, 13);
				panel.add(lblNewLabel_5_2);
			}
			{
				ManxbUpdate = new JTextField();
				ManxbUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				ManxbUpdate.setColumns(10);
				ManxbUpdate.setBounds(441, 250, 165, 19);
				panel.add(ManxbUpdate);
			}
			{
				JButton btnCpNht = new JButton("Cập nhật");
				btnCpNht.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						    String Id = BookIdupdate.getText();
						    String Name = NameBookUpdate.getText();
						    String Idtype = IdtypeUpdate.getText();
						    String IdLanguage = IdLanguageUpdate.getText();
						    int Quantity = Integer.parseInt(QuantityUpdate.getText());
						    String Manv = MaNvUpdate.getText();
						    String Manxb = ManxbUpdate.getText();
						    String ngaynhap  = NgayNhapUpdate.getText();
						    Book b = new Book(Id,Name,Idtype,IdLanguage,Quantity,Date.valueOf(ngaynhap),Manv,Manxb);
						    b.Update("update Book set Name =?,IdType = ?,IdLanguage = ?,Quantity = ?,ImportDate = ?,MaNV=?,IDNXB= ?"
						    		+ " where BookId = ? ");
						    v.listBook = Book.SelectAll();
						    ViewQuanLySach.Showdata(v.listBook,v.model);
						    
							 Infor i = Infor.CheckType(b.getIdtype());
							 Employees e1 = Employees.CheckId(b.getMaNV());
							 Infor j  = Infor.CheckNXb(b.getIdNXB());
							 
							 v.TextBookId.setText(b.getId());
							 v.TextBookName.setText(b.getName());
							 v.TextType.setText(i.getName());
							 if(b.getIdLanguage().equals("A")){
								 v.TextLanguage.setText("English");
							 }
							 else if(b.getIdLanguage().equals("V")) {
								v.TextLanguage.setText("Vietnamese");
							 }
							v.TextNguoNhap.setText(e1.getName());
							v.TextSoLuong.setText(String.valueOf(b.getQuantity()));
							v.TextNxb.setText(j.getName());
							JOptionPane.showMessageDialog(rootPane,"Sửa thành công");
							dispose();
						    
						    
					}
				});
				btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnCpNht.setBounds(314, 327, 106, 21);
				panel.add(btnCpNht);
			}
			{
				JLabel lblNewLabel_5_3 = new JLabel("Ngày nhập");
				lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_5_3.setBounds(370, 91, 62, 13);
				panel.add(lblNewLabel_5_3);
			}
			{
				NgayNhapUpdate = new JTextField();
				NgayNhapUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
				NgayNhapUpdate.setColumns(10);
				NgayNhapUpdate.setBounds(441, 88, 165, 19);
				panel.add(NgayNhapUpdate);
			}
		}
	}

}
