package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import Model.Readers;
public class AddReader extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField idtext;
	public JTextField nametext;
	public JTextField addresstext;
	public JTextField cccdtext;
	public JTextField phonetext;
	ViewQuanLyDocGia t;
	public 	JButton thembutton;
	
	/**
	 * Launch the application.
	 */
   

	/**
	 * Create the dialog.
	 */
	public AddReader( ViewQuanLyDocGia v) {
		t = (ViewQuanLyDocGia)v;
		setBounds(100, 100, 501, 401);
		getContentPane().setLayout(new BorderLayout());
		
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(255, 255, 204));
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel lblThmcGi = new JLabel("Thêm độc giả");
				lblThmcGi.setHorizontalAlignment(SwingConstants.CENTER);
				lblThmcGi.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblThmcGi.setBounds(193, 22, 104, 39);
				panel.add(lblThmcGi);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Id");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_1.setBounds(84, 86, 62, 23);
				panel.add(lblNewLabel_1);
			}
			{
				idtext = new JTextField();
				idtext.setFont(new Font("Tahoma", Font.BOLD, 10));
				idtext.setColumns(10);
				idtext.setBounds(173, 88, 165, 19);
				panel.add(idtext);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Name");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_2.setBounds(101, 147, 45, 13);
				panel.add(lblNewLabel_2);
			}
			{
				nametext = new JTextField();
				nametext.setFont(new Font("Tahoma", Font.BOLD, 10));
				nametext.setColumns(10);
				nametext.setBounds(173, 144, 165, 19);
				panel.add(nametext);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Address");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_3.setBounds(101, 200, 45, 13);
				panel.add(lblNewLabel_3);
			}
			{
				addresstext = new JTextField();
				addresstext.setToolTipText("KD:kinh doanh,CN:Công nghệ,GD:Giáo Dục,CT:Chính trị,VH:Văn học");
				addresstext.setFont(new Font("Tahoma", Font.BOLD, 10));
				addresstext.setColumns(10);
				addresstext.setBounds(173, 197, 165, 19);
				panel.add(addresstext);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("CCCD");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_4.setBounds(101, 253, 62, 13);
				panel.add(lblNewLabel_4);
			}
			{
				cccdtext = new JTextField();
				cccdtext.setFont(new Font("Tahoma", Font.BOLD, 10));
				cccdtext.setColumns(10);
				cccdtext.setBounds(173, 250, 165, 19);
				panel.add(cccdtext);
			}
			{
			    thembutton = new JButton("Thêm");
			    thembutton.setFont(new Font("Tahoma", Font.BOLD, 15));
			    thembutton.setBounds(211, 333, 85, 21);
			    
				thembutton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String id = idtext.getText();
						String name = nametext.getText();
						String address = addresstext.getText();
						String CCCD = cccdtext.getText();
						String Phone = phonetext.getText();
						Readers r = new Readers(id,name,address,CCCD,Phone);
						r.Add("insert into Reader values(?,?,?,?,?,null)");
						t.listReader = Readers.SelectAll();
						ViewQuanLyDocGia.Showdata(t.listReader,t.model);
						JOptionPane.showMessageDialog(rootPane,"Thêm thành công!");
						dispose();
						
					}
				});
				panel.add(thembutton);
			}
			{
				JLabel lblNewLabel_5_3 = new JLabel("Phone");
				lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_5_3.setBounds(101, 301, 62, 13);
				panel.add(lblNewLabel_5_3);
			}
			{
				phonetext = new JTextField();
				phonetext.setFont(new Font("Tahoma", Font.BOLD, 10));
				phonetext.setColumns(10);
				phonetext.setBounds(173, 298, 165, 19);
				panel.add(phonetext);
			}
		}
	}

}
