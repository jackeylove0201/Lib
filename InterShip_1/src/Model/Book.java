package Model;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import Database.DBconnection;

public class Book extends Infor implements QueueSql{
	private String Idtype;
	private String IdLanguage;
	private int Quantity;
	private Date ImportDate;
	private String MaNV;
	private String IdNXB;
	private String soluongmuon;
	public Book(String id, String name, String idtype, String idLanguage, int quantity, Date importDate, String maNV,
			String idNXB, String soluongmuon) {
		super(id, name);
		Idtype = idtype;
		IdLanguage = idLanguage;
		Quantity = quantity;
		ImportDate = importDate;
		MaNV = maNV;
		IdNXB = idNXB;
		this.soluongmuon = soluongmuon;
	}
	public String getSoluongmuon() {
		return soluongmuon;
	}
	public void setSoluongmuon(String soluongmuon) {
		this.soluongmuon = soluongmuon;
	}
	public Book(String id, String name, String idtype, String idLanguage, int quantity, Date importDate, String maNV,
			String idNXB) {
		super(id, name);
		Idtype = idtype;
		IdLanguage = idLanguage;
		Quantity = quantity;
		ImportDate = importDate;
		MaNV = maNV;
		IdNXB = idNXB;
	}
	public Book(String id, String name) {
		super(id, name);
	}
	
	
	public Book() {
		super();
	}
	public String getIdtype() {
		return Idtype;
	}
	public void setIdtype(String idtype) {
		Idtype = idtype;
	}
	public String getIdLanguage() {
		return IdLanguage;
	}
	public void setIdLanguage(String idLanguage) {
		IdLanguage = idLanguage;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Date getImportDate() {
		return ImportDate;
	}
	public void setImportDate(Date importDate) {
		ImportDate = importDate;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getIdNXB() {
		return IdNXB;
	}
	public void setIdNXB(String idNXB) {
		IdNXB = idNXB;
	}
	
	public String toString() {
		return "Book [Book.Name = "+this.getName()+",Book.Id = "+this.getId()+",Idtype=" + Idtype + ", IdLanguage=" + IdLanguage + ", Quantity=" + Quantity + ", ImportDate="
				+ ImportDate + ", MaNV=" + MaNV + ", IdNXB=" + IdNXB + "";
	}
	public void Add(String url) {
         Connection c = DBconnection.getConnection();
         int k;
         try {
			   PreparedStatement stc = c.prepareStatement(url);
			   stc.setString(1,this.getId());
			   stc.setString(2,this.getName());
			   stc.setString(3,this.Idtype);
			   stc.setString(4,this.IdLanguage);
			   stc.setInt(5,this.Quantity);
			   stc.setDate(6,(java.sql.Date) this.ImportDate);
			   stc.setString(7,this.MaNV);
			   stc.setString(8,this.getIdNXB());
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
           e.printStackTrace();
		}
         
	}
	public void Update(String url) {
		   Connection c = DBconnection.getConnection();
		   int k;
		   try {
			    PreparedStatement stc = c.prepareStatement(url);
			    stc.setString(1,this.getName());
				   stc.setString(2,this.Idtype);
				   stc.setString(3,this.IdLanguage);
				   stc.setInt(4,this.Quantity);
				   stc.setDate(5,(java.sql.Date) this.ImportDate);
				   stc.setString(6,this.MaNV);
				   stc.setString(7,this.getIdNXB());
				   stc.setString(8,this.getId());
				   k = stc.executeUpdate();
				   c.close();
				   
			    
		} catch (Exception e) {
			  e.printStackTrace();
		}
		    
		    
		
	}
	public void Remove(String url) {
		
		
	}
	public static List<Book> SelectAll(){
		String url = "Select * from Book where isDelete is null";
		Connection c = DBconnection.getConnection();
		List<Book> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String id = result.getString("BookId");
				    String Name = result.getString("Name");
				    String Idtype = result.getString("IdType");
				    String IdLanguage = result.getString("IdLanguage");
				    int quantity = result.getInt("Quantity");
				    Date importdate = result.getDate("ImportDate");
				    String MaNV   = result.getString("MaNV");
				    String IdNxb = result.getString("IDNXB");
				    String soluongmuon = result.getString("soluongmuon");
				    Book b = new Book(id, Name, Idtype, IdLanguage, quantity, importdate, MaNV,IdNxb,soluongmuon);
				    list.add(b);
				    
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		    
	}
	public  List<Book> Search(String id){
		String url = "Select * from Book where BookId =? and isDelete is null ";
		Connection c = DBconnection.getConnection();
		List<Book> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  stc.setString(1,id);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String Id= result.getString("BookId");
				    String Name = result.getString("Name");
				    String Idtype = result.getString("IdType");
				    String IdLanguage = result.getString("IdLanguage");
				    int quantity = result.getInt("Quantity");
				    Date importdate = result.getDate("ImportDate");
				    String MaNV   = result.getString("MaNV");
				    String IdNxb = result.getString("IDNXB");
				    String soluongmuon = result.getString("soluongmuon");
				    Book b = new Book(id, Name, Idtype, IdLanguage, quantity, importdate, MaNV,IdNxb,soluongmuon);
				    list.add(b);
				    
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return list;
		    
	}
	public  List<Book> SearchByName(String id){
		String url = "Select * from Book where Name =? and isDelete is null";
		Connection c = DBconnection.getConnection();
		List<Book> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  stc.setString(1,id);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String Id= result.getString("BookId");
				    String Name = result.getString("Name");
				    String Idtype = result.getString("IdType");
				    String IdLanguage = result.getString("IdLanguage");
				    int quantity = result.getInt("Quantity");
				    Date importdate = result.getDate("ImportDate");
				    String MaNV   = result.getString("MaNV");
				    String IdNxb = result.getString("IDNXB");
				    String soluongmuon = result.getString("soluongmuon");
				    Book b = new Book(Id, Name, Idtype, IdLanguage, quantity, importdate, MaNV,IdNxb,soluongmuon);
				    list.add(b);
				    
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return list;
		    
	}
	public void UpdateSoluong(String url,String id) {
		   Connection c = DBconnection.getConnection();
		   int k;
		   try {
			    PreparedStatement stc = c.prepareStatement(url);
			       stc.setString(1, id);
				   k = stc.executeUpdate();
				   c.close();
				   
			    
		} catch (Exception e) {
			  e.printStackTrace();
		}
		    
		    
		
	}
	public void resetSoluong(String url) {
		   Connection c = DBconnection.getConnection();
		   int k;
		   try {
			    PreparedStatement stc = c.prepareStatement(url);
			      
				   k = stc.executeUpdate();
				   c.close();
				   
			    
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
	}
	
	

	

}
