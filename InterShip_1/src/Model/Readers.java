package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnection;

public class Readers extends Infor implements QueueSql{
	private String Address;
	private String CCCD;
	private String Phone;
 
	
	


	public Readers(String id, String name, String address, String cCCD, String phone) {
		super(id, name);
		Address = address;
		CCCD = cCCD;
		Phone = phone;
	}


	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "Readers [Address=" + Address + ", CCCD=" + CCCD + ", Phone=" + Phone + "]";
	}
   
	@Override
	public void Add(String url) {
		 Connection c = DBconnection.getConnection();
         int k;
         try {
			   PreparedStatement stc = c.prepareStatement(url);
			   stc.setString(1,this.getId());
			   stc.setString(2,this.getName());
			   stc.setString(3,this.Address);
			   stc.setString(4,this.CCCD);
			   stc.setString(5,this.Phone);
			 
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
           e.printStackTrace();
		}
		
	}
	@Override
	public void Update(String url) {
		 Connection c = DBconnection.getConnection();
         int k;
         try {
			   PreparedStatement stc = c.prepareStatement(url);
			 
			   stc.setString(1,this.getName());
			   stc.setString(2,this.Address);
			   stc.setString(3,this.CCCD);
			   stc.setString(4,this.Phone);
			   stc.setString(5,this.getId());
			 
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
           e.printStackTrace();
		}
		
	}
	@Override
	public void Remove(String url,String id) {
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
	public static List<Readers> SelectAll(){
		String url = "Select * from Reader where isdelete is null";
		Connection c = DBconnection.getConnection();
		List<Readers> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String id = result.getString("IdReader");
				    String Name = result.getString("Name");
				    String Address = result.getString("Address");
				    String CCCD = result.getString("CCCD");
				 
				    String Phone   = result.getString("Phone");
				  
				    Readers b = new Readers(id, Name, Address,CCCD,Phone);
				    list.add(b);
				    
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		    
	}

	@Override
	public void Remove(String url) {
		// TODO Auto-generated method stub
		
	}
	public  List<Readers> SearchByName(String name){
		String url = "Select * from Reader where Name =?";
		Connection c = DBconnection.getConnection();
		List<Readers> list = new ArrayList<>();
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  stc.setString(1,name);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				    String Id= result.getString("IdReader");
				    String Name = result.getString("Name");
				    String Address = result.getString("Address");
				    String CCCD = result.getString("CCCD");
				   
				    String Phone = result.getString("Phone");
				    Readers b = new Readers(Id, Name, Address, CCCD,Phone);
				    list.add(b);
				    
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return list;
		    
	}
	public  Readers SearchById(String id){
		String url = "Select * from Reader where IdReader =?";
		Connection c = DBconnection.getConnection();
		List<Readers> list = new ArrayList<>();
		String Id="";
		String Name ="";
		String Address ="";
		String CCCD ="";
		  
		String Phone ="";
		 
		try {
			  PreparedStatement stc = c.prepareStatement(url);
			  stc.setString(1,id);
			  ResultSet result = stc.executeQuery();
			  while(result.next()) {
				   Id= result.getString("IdReader");
				    Name = result.getString("Name");
				    Address = result.getString("Address");
				     CCCD = result.getString("CCCD");
				   
				    Phone = result.getString("Phone");
				    
				    
				    
			  }
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Readers(Id, Name, Address, CCCD,Phone);
		 
		
		    
	}

	

	public Readers() {
		super();
	}
	
	

}
