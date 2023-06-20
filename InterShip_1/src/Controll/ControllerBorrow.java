package Controll;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.management.StringValueExp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.ChiTietPhieuMuon;
import Model.PhieuMuon;
import Model.Readers;
import View.ChiTietPhieu;
import View.ViewMuonTra;
import Model.Book;
import java.sql.*;
public class ControllerBorrow implements ActionListener{
	public static int dex = 0;
	public static int in = 0;
	public static int  on =0;

	ViewMuonTra v;
	public ControllerBorrow(ViewMuonTra v) {
		this.v =v;
		 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		  String n = e.getActionCommand();
		  int index = this.v.tblPh.getSelectedRow();
		  this.v.buttonPhat.setEnabled(false);
	      this.v.phat.setEditable(false);
	      this.v.btnNewButton_9.setEnabled(false);
		  if(n.equals("Hiển thị")) {
			   PhieuMuon p = this.v.listPM.get(index);
			   Readers r = new Readers();
			   Readers a = r.SearchById(p.getName());
			   this.v.MPh.setText(p.getId());
			   this.v.Mdg.setText(p.getName());
			   this.v.slm.setText(String.valueOf(p.getBorrow()));
			   this.v.lbten.setText(a.getName());	
			   this.v.listCh = p.SelectAll(p.getId());
			   this.v.models = (DefaultTableModel) this.v.tblChitiet.getModel();
			   this.v.btnNewButton_11.setEnabled(true);
			   this.v.btnNewButton.setEnabled(true);
			   this.v.btnNewButton_1.setEnabled(true);
			   ViewMuonTra.Showdata(this.v.listCh,this.v.models);
			    
			   
		  }
		  if(n.equals("Thêm")) {
		
			   
			   if(this.v.MPh.getText().length()==0||this.v.Mdg.getText().length()==0) {JOptionPane.showMessageDialog(this.v,"Vui long nhap thông tin tạo phiếu");}
			  
			   else {
			   String idPh = this.v.MPh.getText();
			   String Mdg = this.v.Mdg.getText();
			   int q = Integer.parseInt(this.v.slm.getText());

			   PhieuMuon p = new PhieuMuon(idPh,Mdg, q);
			   List<PhieuMuon> list  = p.Kiemtra(p.getId());
			   if(!list.isEmpty()) {
				   JOptionPane.showMessageDialog(this.v,"Mã Phiếu này đã tồn tại");
				   
			   }
			   else {
			   p.add("insert into PhieuMuon values(?,?,?,null)");
			   this.v.listPM = PhieuMuon.SelectAll();
			   ViewMuonTra.Showdata(this.v.listPM,this.v.models);
			   JOptionPane.showMessageDialog(this.v,"Thêm thành công");
			   }
			   }
			  
		  }
		  else if(n.equals("Sửa")) {
			   String idPh = this.v.MPh.getText();
			   String Mdg = this.v.Mdg.getText();
			   int q = Integer.parseInt(this.v.slm.getText());
			   PhieuMuon p = new PhieuMuon(idPh, Mdg, q);
			   p.Update("Update PhieuMuon set IdReader = ?,QuantityBorrow = ? where IdPhieu = ? ");
			   this.v.listPM = PhieuMuon.SelectAll();
			   ViewMuonTra.Showdata(this.v.listPM,this.v.models);
			   JOptionPane.showMessageDialog(this.v,"Sửa thành công");
		           
			 
		  }
		  else if(n.equals("Xoá")) {
			  if(index ==-1)   { JOptionPane.showMessageDialog(this.v,"Vui lòng chọn phiếu muốn xoá");}
			  else {
			  PhieuMuon p = this.v.listPM.get(index);
			  this.v.Tensach.setText("");
			  this.v.NgayMuon.setText("");
			  this.v.NgayTra.setText("");
			  this.v.Tensach.setBackground(Color.WHITE);
			  this.v.NgayMuon.setBackground(Color.WHITE);
			  this.v.NgayTra.setBackground(Color.WHITE);
			  p.delete("Update PhieuMuon set isdelete ='1' where  IdPhieu = ?",p.getId());
			  this.v.listPM = PhieuMuon.SelectAll();
			  this.v.models = (DefaultTableModel) this.v.tblPh.getModel();
			  ViewMuonTra.Showdata(this.v.listPM,this.v.models);
			  this.v.listCh.clear();
			  this.v.models  = (DefaultTableModel) this.v.tblChitiet.getModel();
			  ViewMuonTra.Showdata(this.v.listCh,this.v.models);
			  List<ChiTietPhieuMuon> ch = p.SelectAll(p.getId());
			  while(on<ch.size()) {
				   ChiTietPhieuMuon t = ch.get(on);
				   Book b = new Book(t.getBookId(),t.getIdPhieu());
				   b.UpdateSoluong("update Book set soluongmuon = soluongmuon -" +1+" where BookId = ? ",b.getId());
				   on++;
			  }
			  on = 0;
			  
			  }
		
			 
			
		  }
		  else if(n.equals("Thêm chi tiết phiếu")) {
			 
			  
			  if(index==-1)  {  JOptionPane.showMessageDialog(this.v,"Vui lòng chọn phiếu muốn thêm chi tiết");}
			  
			  else {
				  if(this.v.listCh.size()==Integer.parseInt(this.v.slm.getText())) {
					  JOptionPane.showMessageDialog(this.v,"Phiếu này đã mượn đủ số lượng sách mượn");
				  }
				  else {
				  PhieuMuon p = this.v.listPM.get(index);
				  List<PhieuMuon> list = p.LayNgay(p.getId());
				  PhieuMuon i = list.get(0);
				  
				  Date d = new Date(System.currentTimeMillis());
                  if(i.getNgayPhat() ==null) {
                	  this.v.ch = new ChiTietPhieu();
    				  this.v.ch.DocGiachitiet.setText(this.v.lbten.getText());
    				  this.v.ch.MaPhieuChitiet.setText(this.v.MPh.getText());
    				  this.v.ch.SoLuongChiTiet.setText(this.v.slm.getText());
                  }
                  else {
				  if(d.getTime()<i.getNgayPhat().getTime()) {
					     long start = d.getTime();
				    	 long end = i.getNgayPhat().getTime();
				    	 long tmp = Math.abs(start-end);
				    	 long result = tmp/(24*60*60*1000);
					  JOptionPane.showMessageDialog(this.v,"Phiếu này đang trong thời gian phạt(còn " + result+" ngày)" );
				  }
				
				  else {
					  this.v.ch = new ChiTietPhieu();
					  this.v.ch.DocGiachitiet.setText(this.v.lbten.getText());
					  this.v.ch.MaPhieuChitiet.setText(this.v.MPh.getText());
					  this.v.ch.SoLuongChiTiet.setText(this.v.slm.getText());
				  }
				  
				  
				  
			  }
			  }
			  } 
		  }
		  else if(n.equals("Xem chi tiết phiếu")) {
			
			     PhieuMuon p = this.v.listPM.get(index);
			   
			     
			    
			     if(this.v.listCh.isEmpty()) {
			    	 ///tubo
			     }
			     else {
			     ChiTietPhieuMuon ch = this.v.listCh.get(dex);
			     Book b = new Book();
		
			     List<Book> list = b.Search(ch.getBookId());
			     b = list.get(0);
			     this.v.btnNewButton_9.setEnabled(true);
			     this.v.Tensach.setText(b.getName());
			     this.v.NgayMuon.setText(String.valueOf(ch.getNgayMuon()));
			     this.v.NgayTra.setText(String.valueOf(ch.getNgayTra()));
			     Date date = new Date(System.currentTimeMillis());
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			     String d = sdf.format(date);
			     Date t = Date.valueOf(d);
			     long start = t.getTime();
		    	 long end = ch.getNgayTra().getTime();
		    	 long tmp = Math.abs(start-end);
		    	 long result = tmp/(24*60*60*1000);
			     if(t.after(ch.getNgayTra())) {
			    	
			    	 this.v.tblChitiet.setBackground(Color.RED);
			    	 this.v.Tensach.setBackground(Color.RED);
			    	 this.v.NgayMuon.setBackground(Color.RED);
			    	 this.v.NgayTra.setBackground(Color.RED);
			    	 this.v.thongbao.setText("Mã Phiếu "+ p.getId()+" quá hạn trả " + result + " ngày");
			    	 this.v.buttonPhat.setEnabled(true);
			    	 this.v.phat.setEditable(true);
			     }
			     else if(t.before(ch.getNgayTra())){
                     if(result==1) {
			    	 this.v.tblChitiet.setBackground(Color.YELLOW);
			    	 this.v.Tensach.setBackground(Color.YELLOW);
			    	 this.v.NgayMuon.setBackground(Color.YELLOW);
			    	 this.v.NgayTra.setBackground(Color.YELLOW);
			    	 this.v.thongbao.setText("Mã Phiếu "+ p.getId()+" thời gian mượn sách còn " + result + " ngày");
			    	 this.v.buttonPhat.setEnabled(false);
			    	 this.v.phat.setEditable(false);
                     }
                     else {
                    	 this.v.tblChitiet.setBackground(Color.GREEN);
    			    	 this.v.Tensach.setBackground(Color.GREEN);
    			    	 this.v.NgayMuon.setBackground(Color.GREEN);
    			    	 this.v.NgayTra.setBackground(Color.GREEN);
    			    	 this.v.thongbao.setText("Mã Phiếu "+ p.getId()+" thời gian mượn sách còn " + result + " ngày");
    			    	 this.v.buttonPhat.setEnabled(false);
    			    	 this.v.phat.setEditable(false);
                     }
			     }
			     
			     
			     }
			  
			
		  }
		  else if(n.equals("-->")){
			     dex++;
                 if(dex<this.v.listCh.size()) {
			     ChiTietPhieuMuon ch = this.v.listCh.get(dex);
			     Book b = new Book();
			     List<Book> list = b.Search(ch.getBookId());
			     b = list.get(0);
			     this.v.Tensach.setText(b.getName());
			     this.v.NgayMuon.setText(String.valueOf(ch.getNgayMuon()));
			     this.v.NgayTra.setText(String.valueOf(ch.getNgayTra()));
			     in = dex;
			    
                 }
                
		  }
		  else if(n.equals("<--")){
			     in--;
			     if(in>=0) {

			     ChiTietPhieuMuon ch = this.v.listCh.get(in);
			     Book b = new Book();
			     List<Book> list = b.Search(ch.getBookId());
			     b = list.get(0);
			     this.v.Tensach.setText(b.getName());
			     this.v.NgayMuon.setText(String.valueOf(ch.getNgayMuon()));
			     this.v.NgayTra.setText(String.valueOf(ch.getNgayTra()));
			     dex=0;
			     if(in>=this.v.listCh.size())
			    	 in = this.v.listCh.size()-1;
			     }
			     
			     
		  }
		  else if(n.equals("Reset")) {
			    this.v.listCh.clear();
			    this.v.models  = (DefaultTableModel) this.v.tblChitiet.getModel();
			    ViewMuonTra.Showdata(this.v.listCh,this.v.models);
			    this.v.Tensach.setText("");
			    this.v.NgayMuon.setText("");
			    this.v.NgayTra.setText("");
			    this.v.tblChitiet.setBackground(Color.WHITE);
			    this.v.Tensach.setBackground(Color.WHITE);
			    this.v.NgayMuon.setBackground(Color.WHITE);
			    this.v.NgayTra.setBackground(Color.WHITE);
			    
			    this.v.Mdg.setText("");
			    this.v.MPh.setText("");            
			    this.v.slm.setText("");
				this.v.buttonPhat.setEnabled(false);
		    	this.v.phat.setEditable(false);
				this.v.btnNewButton_11.setEnabled(false);
				this.v.btnNewButton.setEnabled(false);
				this.v.btnNewButton_1.setEnabled(false);
				this.v.buttonPhat.setEnabled(false);
			    this.v.phat.setEditable(false);
			    this.v.btnNewButton_9.setEnabled(false);
			    this.v.thongbao.setText("");
			    
			    
		  }
		  else if(n.equals("Gia hạn")) {
			  String ngaytra =   this.v.NgayTra.getText();
			  String v = this.v.MPh.getText();
			  ChiTietPhieuMuon c  = new ChiTietPhieuMuon();
			  PhieuMuon p = this.v.listPM.get(index);
			  c.Updates("update ChiTiet set BackDate = ?",ngaytra);
			  this.v.listCh = p.SelectAll(v);
			  this.v.models = (DefaultTableModel) this.v.tblChitiet.getModel();
			  ViewMuonTra.Showdata(this.v.listCh,this.v.models);
			  ChiTietPhieuMuon ch = this.v.listCh.get(dex);
			  Date date = new Date(System.currentTimeMillis());
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			     String d = sdf.format(date);
			     Date t = Date.valueOf(d);
			     long start = t.getTime();
		    	 long end = ch.getNgayTra().getTime();
		    	 long tmp = Math.abs(start-end);
		    	 long result = tmp/(24*60*60*1000);
			     if(t.after(ch.getNgayTra())) {
			    	
			    	 this.v.tblChitiet.setBackground(Color.RED);
			    	 this.v.Tensach.setBackground(Color.RED);
			    	 this.v.NgayMuon.setBackground(Color.RED);
			    	 this.v.NgayTra.setBackground(Color.RED);
			    	 this.v.thongbao.setText("Mã Phiếu "+ p.getId()+" quá hạn trả " + result + " ngày");
			    	 this.v.buttonPhat.setEnabled(true);
			    	 this.v.phat.setEditable(true);
			    	
			     }
			     else if(t.before(ch.getNgayTra())){
                  if(result==1) {
			    	 this.v.tblChitiet.setBackground(Color.YELLOW);
			    	 this.v.Tensach.setBackground(Color.YELLOW);
			    	 this.v.NgayMuon.setBackground(Color.YELLOW);
			    	 this.v.NgayTra.setBackground(Color.YELLOW);
			    	 this.v.thongbao.setText("Mã Phiếu "+ p.getId()+" thời gian mượn sách còn " + result + " ngày");
			    	 this.v.buttonPhat.setEnabled(false);
			    	 this.v.phat.setEditable(false);
                  }
                  
                  else {
                 	 this.v.tblChitiet.setBackground(Color.GREEN);
 			    	 this.v.Tensach.setBackground(Color.GREEN);
 			    	 this.v.NgayMuon.setBackground(Color.GREEN);
 			    	 this.v.NgayTra.setBackground(Color.GREEN);
 			    	 this.v.thongbao.setText("Mã Phiếu "+ p.getId()+" thời gian mượn sách còn " + result + " ngày");
 			    	 this.v.buttonPhat.setEnabled(false);
			    	 this.v.phat.setEditable(false);
                  }
			     }
			  JOptionPane.showMessageDialog(this.v,"Gia hạn thành công"); 
		  }
		  else if(n.equals("Xác nhận trả")) {
			  int i =0;
			 
			  PhieuMuon p = this.v.listPM.get(index);

			  int x = JOptionPane.showConfirmDialog(this.v,"Bạn chắc chứ?");
		
			  if(x==JOptionPane.YES_OPTION) {
				  while(i<this.v.listCh.size()) {
					  ChiTietPhieuMuon c = this.v.listCh.get(i);
					  Book b = new Book();
					  b.resetSoluong("update Book set soluongmuon = soluongmuon - "+1+" where BookId = '"+c.getBookId()+"'");
					  i++;
					  
				  }
			  i=0;
			  p.updateChitiet("update ChiTiet set isdelete = '1' where IdPhieu = ?",p.getId());
			  this.v.listCh = p.SelectAll(p.getId());
			  this.v.models = (DefaultTableModel) this.v.tblChitiet.getModel();
			  ViewMuonTra.Showdata(this.v.listCh,this.v.models);
			  this.v.Tensach.setText("");
			  this.v.NgayMuon.setText("");
			  this.v.NgayTra.setText("");
			  this.v.tblChitiet.setBackground(Color.WHITE);
			  this.v.Tensach.setBackground(Color.WHITE);
			  this.v.NgayMuon.setBackground(Color.WHITE);
			  this.v.NgayTra.setBackground(Color.WHITE);
			
			  }
			 
		  }
		  else if(n.equals("Phạt")) {
			  try {
				  GregorianCalendar c = new GregorianCalendar();
				    int phat  = Integer.parseInt(this.v.phat.getText());
				    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				    c.add(Calendar.DAY_OF_MONTH, phat);
				    String d = f.format(c.getTime());
				    PhieuMuon p = this.v.listPM.get(index);
				    
				    p.updateChitiet("update PhieuMuon set ngayPhat = '"+d+"' where IdPhieu = ? ",p.getId());
				    System.out.println(p.getId());
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			  
		  }
		  
		
	}
	  

}
