package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnection;

public class ChiTietPhieuMuon  implements QueueSql{
	private String IdPhieu;
	private String BookId;
	private Date NgayMuon;
	private Date NgayTra;
	public ChiTietPhieuMuon(String idPhieu, Date ngayMuon, Date ngayTra) {
		super();
		IdPhieu = idPhieu;
		NgayMuon = ngayMuon;
		NgayTra = ngayTra;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public ChiTietPhieuMuon(String idPhieu, String bookId, Date ngayMuon, Date ngayTra) {
		super();
		IdPhieu = idPhieu;
		BookId = bookId;
		NgayMuon = ngayMuon;
		NgayTra = ngayTra;
	}
	public ChiTietPhieuMuon() {
		super();
	}
	public String getIdPhieu() {
		return IdPhieu;
	}
	public void setIdPhieu(String idPhieu) {
		IdPhieu = idPhieu;
	}
	public Date getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public Date getNgayTra() {
		return NgayTra;
	}
	public void setNgayTra(Date ngayTra) {
		NgayTra = ngayTra;
	}
	@Override
	public void Add(String url) {
		Connection c = DBconnection.getConnection();
        int k;
        try {
			   PreparedStatement stc = c.prepareStatement(url);
			   stc.setString(1,this.IdPhieu);
			   stc.setString(2,this.BookId);
			   stc.setDate(3,this.NgayMuon);
			   stc.setDate(4, this.NgayTra);
			 
			  
			 
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
          e.printStackTrace();
		
		
	}
		
	}
	@Override
	public void Update(String url) {
			
	}
	@Override
	public void Remove(String url) {
		  
		
	}
	public void delete (String url,String id) {
		Connection c = DBconnection.getConnection();
        int k;
        try {
			   PreparedStatement stc = c.prepareStatement(url);
			   stc.setString(1,this.IdPhieu);
			 
			  
			 
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
          e.printStackTrace();
		
		
	}
       
		
	}
	 public void Updates(String url,String ngaytra) {
		    Date date = Date.valueOf(ngaytra);
			Connection c = DBconnection.getConnection();
	        int k;
	        try {
				   PreparedStatement stc = c.prepareStatement(url);
				   stc.setDate(1,date);
				 
				  
				 
				   k = stc.executeUpdate();
				   c.close();
				   
			} catch (Exception e) {
	          e.printStackTrace();
			
			}
		
     }
	public List<ChiTietPhieuMuon> searchById(String id,String BookId) {
		  String url = "Select * from ChiTiet where IdPhieu = ? and BookId = ?";
		  List<ChiTietPhieuMuon> list = new ArrayList<>();
		  Connection c = DBconnection.getConnection();
			try {
				  PreparedStatement stc = c.prepareStatement(url);
				  stc.setString(1,id);
				  stc.setString(2,BookId);
				  ResultSet result = stc.executeQuery();
				  while(result.next()) {
					    String Id= result.getString("IdPhieu");
					    String Name = result.getString("BookId");
					    Date Idtype = result.getDate("BorrowDate");
					    Date IdLanguage = result.getDate("BackDate");
					    ChiTietPhieuMuon p = new ChiTietPhieuMuon(Id,Name, Idtype, IdLanguage);
					    list.add(p);
					    
					   
				  }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		  
		  
		  
	}
	

	



	
    

    
}
