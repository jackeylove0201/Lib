package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnection;

public class PhieuMuon extends Infor implements  QueueSql{
	private int borrow;
	private Date ngayPhat;

	public PhieuMuon(String id, String name, int borrow) {
		super(id, name);
		this.borrow = borrow;
	}
	public PhieuMuon() {
		
	}

	public Date getNgayPhat() {
		return ngayPhat;
	}
	public void setNgayPhat(Date ngayPhat) {
		this.ngayPhat = ngayPhat;
	}
	public PhieuMuon(String id, String name, int borrow, Date ngayPhat) {
		super(id, name);
		this.borrow = borrow;
		this.ngayPhat = ngayPhat;
	}
	public PhieuMuon(String id, String name) {
		super(id, name);
	}

	public int getBorrow() {
		return borrow;
	}

	public void setBorrow(int borrow) {
		this.borrow = borrow;
	}

	@Override
	public String toString() {
		return "PhieuMuon [borrow=" + borrow + "]";
	}

	@Override
	public void Update(String url) {
		Connection c = DBconnection.getConnection();
        int k;
        try {
			   PreparedStatement stc = c.prepareStatement(url);
			  
			   stc.setString(1,this.getName());
			   stc.setInt(2,this.borrow);
			   stc.setString(3,this.getId());
			 
			  
			 
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
          e.printStackTrace();
		
		
	
		
	}
	}
	@Override
	public void Remove(String url) {
	}
		   public void delete(String url,String id) {
			   Connection c = DBconnection.getConnection();
			   int k; 
			   try {
				    PreparedStatement stc = c.prepareStatement(url);
				    stc.setString(1,id);
				    k = stc.executeUpdate();
				    c.close();
			} catch (Exception e) {
				  e.printStackTrace();
			
			
		}
		   }
	public void add(String url) {
		Connection c = DBconnection.getConnection();
        int k;
        try {
			   PreparedStatement stc = c.prepareStatement(url);
			   stc.setString(1,this.getId());
			   stc.setString(2,this.getName());
			   stc.setInt(3,this.borrow);
			 
			  
			 
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
          e.printStackTrace();
		
		
	}


	
	
	
	
	}
	public static List<PhieuMuon> SelectAll(){
		String url = "Select * from PhieuMuon where isdelete is null";
		Connection c = DBconnection.getConnection();
		List<PhieuMuon> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String id = result.getString("IdPhieu");
				    String Name = result.getString("IdReader");
				    int Address = result.getInt("QuantityBorrow");
				    
				 
				
				  
				    PhieuMuon b = new PhieuMuon(id, Name, Address);
				    list.add(b);
				    
			  }
			  c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		    
	}
	public List<ChiTietPhieuMuon> SelectAll(String IdPhieu){
		String url = "Select * from ChiTiet where IdPhieu = ? and isdelete is null";
		Connection c = DBconnection.getConnection();
		List<ChiTietPhieuMuon> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  stc.setString(1,IdPhieu);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String id = result.getString("IdPhieu");
				    String Name = result.getString("BookId");
				    Date Address = result.getDate("BorrowDate");
				    Date CCCD = result.getDate("BackDate");				 				 				  
				    ChiTietPhieuMuon b = new ChiTietPhieuMuon(id, Name, Address,CCCD);
				    list.add(b);
				    
			  }
			  c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		    
	}
	public List<PhieuMuon> Kiemtra(String IdPhieu){
		String url = "Select * from PhieuMuon where IdPhieu = ?";
		Connection c = DBconnection.getConnection();
		List<PhieuMuon> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  stc.setString(1,IdPhieu);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String id = result.getString("IdPhieu");
				    String Name = result.getString("IdReader");
				    int  Address = result.getInt("QuantityBorrow");
				    			 				 				  
				    PhieuMuon b = new PhieuMuon(id, Name, Address);
				    list.add(b);
				    
			  }
			  c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		    
	}
	public void updateChitiet(String url,String idphieu) {
		Connection c = DBconnection.getConnection();
		int k;
		try {
			 PreparedStatement stc = c.prepareStatement(url);
			 stc.setString(1, idphieu);;
			 k = stc.executeUpdate();
			 c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public List<PhieuMuon> LayNgay(String IdPhieu) {
		Connection c = DBconnection.getConnection();
		String url = "select * from PhieuMuon where IdPhieu = ? ";
		int k;
		List<PhieuMuon> list = new ArrayList<>();
				
		try {
			 PreparedStatement stc = c.prepareStatement(url);
			 stc.setString(1, IdPhieu);;
			 ResultSet result = stc.executeQuery();
		     while(result.next()) {
		    	  String id = result.getString("IdPhieu");
				    String Name = result.getString("IdReader");
				    int  Address = result.getInt("QuantityBorrow");
				    Date phat = result.getDate("ngayPhat");
				    PhieuMuon p  = new PhieuMuon(id,Name,Address,phat);
				    list.add(p);
		     }
			 c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}
}
