package View;
import Model.Book;
import Model.ChiTietPhieuMuon;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import Model.ChiTietPhieuMuon;
public class ChiTietPhieu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField TenSachChitiet;
	public JTextField NgayMuonChiTiet;
	public JTextField NgayTraChiTiet;
	public JTextField DocGiachitiet;
	public JTextField MaPhieuChitiet;
	public JTextField SoLuongChiTiet;
	public JTextField SoLuongDaThem;
    static int borrow;
    public List<ChiTietPhieuMuon> listCh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChiTietPhieu dialog = new ChiTietPhieu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChiTietPhieu() {
		setBounds(100, 100, 781, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 250, 210));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBounds(264, 10, 182, 44);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi tiết phiếu");
		lblNewLabel.setBackground(new Color(65, 105, 225));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 182, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thêm");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String idphieu = MaPhieuChitiet.getText();
				  String Tensach = TenSachChitiet.getText();
				  Date  ngaymuon = Date.valueOf(NgayMuonChiTiet.getText());
				  Date  ngaytra  = Date.valueOf(NgayTraChiTiet.getText());
				  Book b = new Book();
				  List<Book> list = b.SearchByName(Tensach);
				  Book c = list.get(0);
				  ChiTietPhieuMuon p  = new ChiTietPhieuMuon(idphieu,c.getId(),ngaymuon,ngaytra);
				  listCh = p.searchById(idphieu,c.getId());
				  if(listCh.size()!=0) {
					    JOptionPane.showMessageDialog(rootPane,"Sách này đã được thêm vào phiếu này");
				  }
				  
				  else {
				  p.Add("insert into ChiTiet values(?,?,?,?,null)");
				  c.UpdateSoluong("update Book set soluongmuon = soluongmuon + " + 1 + ",isDelete = 2 where BookId = ? ",c.getId());
				  
				  JOptionPane.showMessageDialog(rootPane,"Đã thêm");
				  
			      SoLuongDaThem.setText(""+(++borrow));
			      if(Integer.parseInt(SoLuongDaThem.getText())==Integer.parseInt(SoLuongChiTiet.getText())) {
			    	 int x = JOptionPane.showConfirmDialog(rootPane,"Số lượng mượn đã đủ vui lòng xác nhận thao tác mượn");
			    	 if(x== JOptionPane.YES_OPTION) {
			    		   JOptionPane.showMessageDialog(rootPane,"Thêm chi tiết phiếu thành công");
			    		   c.resetSoluong("update Book set isDelete = null where isDelete = 2 ");
			    		  
			    		   SoLuongDaThem.setText("");
			    		   borrow=0;
			    		   dispose();
			    	 }
			    	 else if(x== JOptionPane.NO_OPTION) {
			    		 JOptionPane.showMessageDialog(rootPane,"Thao tác thêm đã bị huỷ");
			    		 p.delete("delete from ChiTiet where IdPhieu = ? ",p.getIdPhieu());
			    		 c.resetSoluong("update Book set isDelete = null,soluongmuon = soluongmuon -1 where isDelete = 2 ");
			    		 
			    	 }
			    	 
			      }
			     
				  } 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(315, 373, 115, 37);
		
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(178, 122, 54, 24);
		contentPanel.add(lblNewLabel_1);
		
		TenSachChitiet = new JTextField();
		TenSachChitiet.setFont(new Font("Tahoma", Font.BOLD, 10));
		TenSachChitiet.setBounds(254, 125, 203, 19);
		contentPanel.add(TenSachChitiet);
		TenSachChitiet.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày Mượn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(178, 201, 58, 13);
		contentPanel.add(lblNewLabel_2);
		
		NgayMuonChiTiet = new JTextField();
		NgayMuonChiTiet.setFont(new Font("Tahoma", Font.BOLD, 10));
		NgayMuonChiTiet.setBounds(254, 198, 203, 19);
		contentPanel.add(NgayMuonChiTiet);
		NgayMuonChiTiet.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày Trả");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(178, 277, 54, 13);
		contentPanel.add(lblNewLabel_3);
		
		NgayTraChiTiet = new JTextField();
		NgayTraChiTiet.setFont(new Font("Tahoma", Font.BOLD, 10));
		NgayTraChiTiet.setBounds(254, 274, 203, 19);
		contentPanel.add(NgayTraChiTiet);
		NgayTraChiTiet.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBounds(510, 103, 247, 243);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Độc giả");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 10, 51, 40);
		panel_1.add(lblNewLabel_4);
		
		DocGiachitiet = new JTextField();
		DocGiachitiet.setEditable(false);
		DocGiachitiet.setFont(new Font("Tahoma", Font.BOLD, 10));
		DocGiachitiet.setBounds(71, 21, 166, 19);
		panel_1.add(DocGiachitiet);
		DocGiachitiet.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã phiếu");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1.setBounds(10, 72, 51, 40);
		panel_1.add(lblNewLabel_4_1);
		
		MaPhieuChitiet = new JTextField();
		MaPhieuChitiet.setEditable(false);
		MaPhieuChitiet.setFont(new Font("Tahoma", Font.BOLD, 10));
		MaPhieuChitiet.setColumns(10);
		MaPhieuChitiet.setBounds(71, 83, 166, 19);
		panel_1.add(MaPhieuChitiet);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Số lượng");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_1.setBounds(10, 122, 51, 40);
		panel_1.add(lblNewLabel_4_1_1);
		
		SoLuongChiTiet = new JTextField();
		SoLuongChiTiet.setEditable(false);
		SoLuongChiTiet.setFont(new Font("Tahoma", Font.BOLD, 10));
		SoLuongChiTiet.setColumns(10);
		SoLuongChiTiet.setBounds(71, 133, 84, 19);
		panel_1.add(SoLuongChiTiet);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Số lượng đã thêm");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1_1_1.setBounds(10, 193, 115, 40);
		panel_1.add(lblNewLabel_4_1_1_1);
		
		SoLuongDaThem = new JTextField();
		SoLuongDaThem.setBounds(135, 204, 51, 19);
		panel_1.add(SoLuongDaThem);
		SoLuongDaThem.setColumns(10);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
