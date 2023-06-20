package Controll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.DanhMuc;
import View.GiaoDienChinh;

import View.ViewMuonTra;

import View.ViewQuanLyDocGia;
import View.ViewQuanLySach;

public class ControllerChangePanel {   // class ChangePanel
	 public JPanel root;              // giao dien mục view
	 private String kindLest ="";      // chuoi dc chon
	 private List<DanhMuc> list = null;  // danh sach cac muc
	 GiaoDienChinh gd;
	public ControllerChangePanel(JPanel root,GiaoDienChinh gd) {
		super();
		this.root = root;
		this.gd= gd;
	}
	 
     public void setView(JPanel jpl,JLabel jlb) {
    	  kindLest = "Quản lý sách";
    	  jpl.setBackground(new Color(51,46,171));
    	  jlb.setBackground(new Color(51,46,171));
    	  root.removeAll();
    	  root.setLayout(new BorderLayout());
    	  root.add(new ViewQuanLySach());
    	  root.validate();
    	  root.repaint();
    	  
    	   
     }
     public void setViews(JPanel jpl,JLabel jlb) {
   	  kindLest = "Quản lý mượn trả";
   	  
   	  jpl.setBackground(new Color(51,46,171));
   	  jlb.setBackground(new Color(51,46,171));
   	  root.removeAll();
   	  root.setLayout(new BorderLayout());
   	  root.add(new ViewMuonTra());
   	  root.validate();
   	  root.repaint();
   	  
   	   
    }
     public void setEvent(List<DanhMuc> list) {    // set xu lý sự kiến nháy chuột
    	  for (DanhMuc item : list) {             // duyệt các mục
    			
    		  item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpb() ,item.getJlb()));
			    /// thêm dự kiên với chuột cho các mục trong menu
		}
     }
     public class LabelEvent implements MouseListener {       // lớp xử lý sự kiên
    	 private String kind;                                 // chuoi trong khi duyệt
    	 private JPanel jplItem;                              // panel
    	 private JLabel jlbItem;                              // label
    	 private JPanel note;                                 // bien tham chiếu trỏ tới view can xem
    	 

		public LabelEvent(String kind, JPanel jplItem, JLabel jlbItem) {
			super();
			this.kind = kind;
			this.jplItem = jplItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {         // click de chuyen man hinh
			switch(kind) {
			case "Quản lý sách":
				note = new ViewQuanLySach();           
				break;
			
			
			case "Quản lý độc giả":
				note = new ViewQuanLyDocGia();
				break;
			
				
			case "Quản lý mượn trả":
				note = new ViewMuonTra();
				break;
			default:
				note = new ViewQuanLyDocGia();
				break;
				
			
				
			}
			root.removeAll();        // xoa tat cac thanh phan trong giao dien cu 
			root.setLayout(new BorderLayout());    //  setLayout
			root.add(note);                           // them thanh phan can xem vao panel view
			root.validate();
			root.repaint();
			jplItem.setBackground(new Color(51,46,171));    // set mau cho menu dc chon
			jlbItem.setBackground(new Color(51,46,171));
			
				
		}

		@Override
		public void mousePressed(MouseEvent e) {   //xu kien khi nhan nut vao chuot
			    kindLest = kind;
				jplItem.setBackground(new Color(0,255,0));
    			jlbItem.setBackground(new Color(0,255,0));
		   
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {          
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {         // sư kien khi di chuyen chuot tro toi mot thanh phan
			jplItem.setBackground(new Color(51,46,171));
			jlbItem.setBackground(new Color(51,46,171));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {    // su kien khi di chuyen chuot ra khoi 1 thanh phan
			   if(!kindLest.equalsIgnoreCase(kind)) {
					jplItem.setBackground(new Color(0,255,0));
        			jlbItem.setBackground(new Color(0,255,0));
			   }
			
		}
		public void setChangeBackground(String kind) {
			 for (DanhMuc item : list) {
                     if(item.getKind().equalsIgnoreCase(kind)) {
                    		item.getJlb().setBackground(new Color(51,46,171));
                			item.getJpb().setBackground(new Color(51,46,171));
                     }
                     else {
                    	 item.getJlb().setBackground(new Color(0,255,0));
                    	 item.getJpb().setBackground(new Color(0,255,0));
                    	 
                     }
			}
			
		}
    	 
     }
}
