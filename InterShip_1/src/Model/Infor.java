package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import Database.DBconnection;

public class Infor {
	private String Id;
	private String Name;
	public Infor(String id, String name) {
		super();
		Id = id;
		Name = name;
	}
	public Infor() {
		super();
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Infor [Id=" + Id + ", Name=" + Name + "]";
	}
	public void Update(String h, String k) {
		// TODO Auto-generated method stub
		
	}
	public void Add(String url) {
		// TODO Auto-generated method stub
		
	}
	public void Remove(String url,String h) {
		   Connection c = DBconnection.getConnection();
		   int k; 
		   try {
			    PreparedStatement stc = c.prepareStatement(url);
			    stc.setString(1,h);
			    k = stc.executeUpdate();
			    c.close();
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
	}
	public <Book> List<Book> Search(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	public static Infor CheckType(String n) {
		String url = "select * from Type where IdType = ? ";
		Connection c = DBconnection.getConnection();
		String Id = "";
		String Name = "";
		ResultSet result;
		try {
			 PreparedStatement stc = c.prepareStatement(url);
			 stc.setString(1,n);
			 result = stc.executeQuery();
			 while(result.next()) {
				  Id = result.getString("IdType");
				  Name = result.getString("Name");
				
			 }
			 c.close();
			
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		 return new Infor(Id,Name);
	}
	public static Infor CheckNXb(String n) {
		String url = "select * from NXB where IdNXB = ? ";
		Connection c = DBconnection.getConnection();
		String Id = "";
		String Name = "";
		ResultSet result;
		try {
			 PreparedStatement stc = c.prepareStatement(url);
			 stc.setString(1,n);
			 result = stc.executeQuery();
			 while(result.next()) {
				  Id = result.getString("IDNXB");
				  Name = result.getString("Name");
				
			 }
			 c.close();
			
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		
		
	}	 return new Infor(Id,Name); 
	
	
	
	
    
}
}
