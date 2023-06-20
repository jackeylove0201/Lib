package Controll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.Book;
import Model.Employees;
import Model.Infor;
import View.AddBook;
import View.UpdateBook;
import View.ViewQuanLySach;

public class controllerSach implements ActionListener{
	   ViewQuanLySach v;
	   UpdateBook b;
	  
	   private DefaultTableModel model;
	   private AddBook addbook;
	   
	   

	public controllerSach(ViewQuanLySach v) {
		super();
		this.v = v;
		
	}
	
	public controllerSach(AddBook addbook) {
		this.addbook = addbook;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String n = e.getActionCommand();
	
		int index = this.v.tblSach.getSelectedRow();
	   
		if(n.equals("Thông tin chi tiết")) {
			 Book b = this.v.listBook.get(index);
			 Infor i = Infor.CheckType(b.getIdtype());
			 Employees e1 = Employees.CheckId(b.getMaNV());
			 Infor j  = Infor.CheckNXb(b.getIdNXB());
			 
			 this.v.TextBookId.setText(b.getId());
			 this.v.TextBookName.setText(b.getName());
			 this.v.TextType.setText(i.getName());
			 if(b.getIdLanguage().equals("A")){
				 this.v.TextLanguage.setText("English");
			 }
			 else if(b.getIdLanguage().equals("V")) {
				 this.v.TextLanguage.setText("Vietnamese");
			 }
			 this.v.SoLuongMuon.setText(b.getSoluongmuon());
			 System.out.println(b.getSoluongmuon());
			 this.v.TextNguoNhap.setText(e1.getName());
			 this.v.TextSoLuong.setText(String.valueOf(b.getQuantity()));
			 this.v.TextNxb.setText(j.getName());
			 
			 
			 
			 
		}
		if(n.equals("Xoá sách")) {
			model = (DefaultTableModel) this.v.tblSach.getModel();
			Book b = this.v.listBook.get(index);
			b.Remove("update Book Set isDelete = '1' where BookId = ? ",b.getId());
			this.v.listBook = Book.SelectAll();
			ViewQuanLySach.Showdata(this.v.listBook, model);
			
			
			
			
		}
		else if(n.equals("Thêm sách")) {
			   new AddBook(this.v).setVisible(true);;
			   
			   
			  
			  
		}
		else if(n.equals("Sửa thông tin")) {
			    int i = this.v.tblSach.getSelectedRow();
			    if(i==-1) {
			    	  JOptionPane.showMessageDialog(this.v,"Vui lòng chọn sách muốn sửa");
			    }
			    else {
			    
			    this.b = new UpdateBook(this.v);
			    this.b.setVisible(true);
			    this.b.setLocationRelativeTo(null);
			    Book c = this.v.listBook.get(i);
			    this.b.BookIdupdate.setText(c.getId());
			    this.b.BookIdupdate.setEditable(false);
			    this.b.NameBookUpdate.setText(c.getName());
			    this.b.IdtypeUpdate.setText(c.getIdtype());
			    this.b.IdLanguageUpdate.setText(c.getIdLanguage());
			    this.b.NgayNhapUpdate.setText(String.valueOf(c.getImportDate()));
			    this.b.ManxbUpdate.setText(c.getIdNXB());
			    this.b.MaNvUpdate.setText(c.getMaNV());
			    this.b.QuantityUpdate.setText(String.valueOf(c.getQuantity()));
			    }
		}
		else if(n.equals("Tìm kiếm bằng Id")) {
			  String timKiem = this.v.TimKiem.getText();
			  Book b = new Book();
			  this.v.listBook = b.Search(timKiem);
			  ViewQuanLySach.Showdata(this.v.listBook, this.v.model);
			  
		}
		else if(n.equals("Refresh")) {
			
			 this.v.listBook = Book.SelectAll();
			 ViewQuanLySach.Showdata(this.v.listBook, this.v.model);
		}
		else if(n.equals("Tìm kiếm bằng tên")) {
			  String timKiem = this.v.TimKiem.getText();
			  Book b = new Book();
			  this.v.listBook = b.SearchByName(timKiem);
			  ViewQuanLySach.Showdata(this.v.listBook, this.v.model);
		
		}
		
		
	}
	
	
	   

}

