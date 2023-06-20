package Controll;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Readers;
import View.AddReader;
import View.GiaoDienChinh;
import View.UpdateReader;
import View.ViewMuonTra;
import View.ViewQuanLyDocGia;

public class ControllerReader  implements ActionListener{
    ViewQuanLyDocGia v;
    GiaoDienChinh gd;
    
	@Override
	public void actionPerformed(ActionEvent e) {
	      String n = e.getActionCommand();
	      int index  = this.v.tblReader.getSelectedRow();
	      
	      if(n.equals("Thông tin chi tiết")) {
	    	   Readers b = this.v.listReader.get(index);
	    	   this.v.Idreader.setText(b.getId());
	    	   this.v.NameReader.setText(b.getName());
	    	   this.v.Address.setText(b.getAddress());
	    	   this.v.CCCD.setText(b.getCCCD());
	    	   this.v.Phone.setText(b.getPhone());
	    	   
	    	   
	      }
	      else if(n.equals("Thêm")) {
	    	   this.v.r = new AddReader(this.v);
	    	   this.v.r.setVisible(true);
	    	   this.v.r.setLocationRelativeTo(null);
	    	
		
	}
	      else if (n.equals("Xoá")) {
	    	   Readers t = this.v.listReader.get(index);
	    	  
	    	   t.Remove("update Reader set isdelete = '1' where IdReader = ?",t.getId());
	    	   this.v.listReader = Readers.SelectAll();
	    	   ViewQuanLyDocGia.Showdata(this.v.listReader,this.v.model);
	    	   
	    	   
	      }
	      else if(n.equals("Sửa")) {
	    	  Readers t = this.v.listReader.get(index);
	    	   this.v.u = new UpdateReader(this.v);
	    	   this.v.u.setVisible(true);
	    	   this.v.u.setLocationRelativeTo(null);
	    	   this.v.u.id.setText(t.getId()); 
	    	   this.v.u.Name.setText(t.getName());
	    	   this.v.u.Address.setText(t.getAddress());
	    	   
	    	   this.v.u.CCCD.setText(t.getCCCD());
	    	   this.v.u.phone.setText(t.getPhone());
	    	   
	    			   
	      }
	      else if(n.equals("Refresh")) {
	    	    this.v.listReader = Readers.SelectAll();
	    	    ViewQuanLyDocGia.Showdata(this.v.listReader,this.v.model);
	    	    this.v.TenTimKiem.setText("");
	      }
	      else if(n.equals("Tìm kiếm")) {
	    	   String data =  this.v.TenTimKiem.getText();
	    	   Readers r = new Readers();
	    	   this.v.listReader = r.SearchByName(data);
	    	   ViewQuanLyDocGia.Showdata(this.v.listReader,this.v.model);
	    	   
	      }
	      else if(n.equals("Thêm phiếu mượn")) {
	    	     if(index == -1 ) {
	    	    	 JOptionPane.showMessageDialog(this.v,"Vui long chọn độc giả!");
	    	    	  
	    	     }
	    	     else {
	    	     this.gd = MyController.g;
	    	     ControllerChangePanel c =  new ControllerChangePanel(this.gd.ViewPanel,this.gd);	    	     
	    	     c.setViews(this.gd.panel_6,this.gd.Muontralabel);
	    	    
	    	     
	    	     }
	      }
	}
	public ControllerReader(ViewQuanLyDocGia v) {
		super();
		this.v = v;
	}
	public ControllerReader(GiaoDienChinh gd) {
		super();
		this.gd = gd;
	}
  
	 
	   

}
