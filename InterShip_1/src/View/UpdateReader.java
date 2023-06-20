package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Readers;
public class UpdateReader extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField id;
	public JTextField Name;
	public JTextField Address;
	public JTextField CCCD;
	public JTextField phone;
	ViewQuanLyDocGia t;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public UpdateReader(ViewQuanLyDocGia v) {
		t = (ViewQuanLyDocGia) v;
		setBounds(100, 100, 490, 415);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(255, 255, 204));
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblSaThngTin = new JLabel("Sửa thông tin");
				lblSaThngTin.setHorizontalAlignment(SwingConstants.CENTER);
				lblSaThngTin.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblSaThngTin.setBounds(193, 22, 104, 39);
				panel.add(lblSaThngTin);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Id");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_1.setBounds(84, 86, 62, 23);
				panel.add(lblNewLabel_1);
			}
			{
				id = new JTextField();
				id.setFont(new Font("Tahoma", Font.BOLD, 10));
				id.setColumns(10);
				id.setBounds(173, 88, 165, 19);
				panel.add(id);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Name");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_2.setBounds(101, 147, 45, 13);
				panel.add(lblNewLabel_2);
			}
			{
				Name = new JTextField();
				Name.setFont(new Font("Tahoma", Font.BOLD, 10));
				Name.setColumns(10);
				Name.setBounds(173, 144, 165, 19);
				panel.add(Name);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Address");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_3.setBounds(101, 200, 45, 13);
				panel.add(lblNewLabel_3);
			}
			{
				Address = new JTextField();
				Address.setToolTipText("KD:kinh doanh,CN:Công nghệ,GD:Giáo Dục,CT:Chính trị,VH:Văn học");
				Address.setFont(new Font("Tahoma", Font.BOLD, 10));
				Address.setColumns(10);
				Address.setBounds(173, 197, 165, 19);
				panel.add(Address);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("CCCD");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_4.setBounds(101, 253, 62, 13);
				panel.add(lblNewLabel_4);
			}
			{
				CCCD = new JTextField();
				CCCD.setFont(new Font("Tahoma", Font.BOLD, 10));
				CCCD.setColumns(10);
				CCCD.setBounds(173, 250, 165, 19);
				panel.add(CCCD);
			}
			{
				JButton btnCpNht = new JButton("Cập nhật");
				btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnCpNht.setBounds(211, 333, 104, 21);
				btnCpNht.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String Id = id.getText();
						String name = Name.getText();
						String address = Address.getText();
						String cccd = CCCD.getText();
						String Phone = phone.getText();
						Readers  r = new Readers(Id,name,address,cccd,Phone);
						r.Update("Update Reader set Name = ?,Address = ?,CCCD = ?,Phone = ? where IdReader = ? ");
						t.listReader = Readers.SelectAll();
						ViewQuanLyDocGia.Showdata(t.listReader,t.model);
						t.Idreader.setText(r.getId());
						t.NameReader.setText(r.getName());
						t.Address.setText(r.getAddress());
						t.CCCD.setText(r.getCCCD());
						t.Phone.setText(r.getPhone());
						JOptionPane.showMessageDialog(rootPane,"Đã cập nhật thông tin!");
						dispose();
					}
				});
				panel.add(btnCpNht);
			}
			{
				JLabel lblNewLabel_5_3 = new JLabel("Phone");
				lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_5_3.setBounds(101, 301, 62, 13);
				panel.add(lblNewLabel_5_3);
			}
			{
				phone = new JTextField();
				phone.setFont(new Font("Tahoma", Font.BOLD, 10));
				phone.setColumns(10);
				phone.setBounds(173, 298, 165, 19);
				panel.add(phone);
			}
		}
	}

}
