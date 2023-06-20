package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DBconnection;

public class Employees extends Infor implements QueueSql{
	  private String Account;
	  private String Password;
	  private String MaCaLam;
	public Employees(String id, String name, String account, String password, String maCaLam) {
		super(id, name);
		Account = account;
		Password = password;
		MaCaLam = maCaLam;
	}
	
	public Employees(String id, String name) {
		super(id, name);
	}

	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMaCaLam() {
		return MaCaLam;
	}
	public void setMaCaLam(String maCaLam) {
		MaCaLam = maCaLam;
	}
	@Override
	public String toString() {
		return "Employees [Account=" + Account + ", Password=" + Password + ", MaCaLam=" + MaCaLam + "]";
	}

    

	@Override
	public void Add(String url) {
		  Connection c = DBconnection.getConnection();
		  int k;
		  try {
			   PreparedStatement stc = c.prepareStatement(url);
			   stc.setString(1,this.getId());
			   stc.setString(2,this.getName());
			   stc.setString(3,this.getAccount());
			   stc.setString(4,this.getPassword());
			   stc.setString(5,this.getMaCaLam());
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
			   stc.setString(2,this.getAccount());
			   stc.setString(3,this.getPassword());
			   stc.setString(4,this.getMaCaLam());
			   stc.setString(5,this.getId());
			   k = stc.executeUpdate();
			   c.close();
			   
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
	}

	@Override
	public void Remove(String url) {
		 Connection c = DBconnection.getConnection();
		   int k; 
		   try {
			    PreparedStatement stc = c.prepareStatement(url);
			    stc.setString(1,this.getId());
			    k = stc.executeUpdate();
			    c.close();
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
	}
	public static List<Employees> Login(String TenDangNhap,String MatKhau){
	    List<Employees> list = new ArrayList<>();
	    String url = "Select * from Employees where Account = ? and Password = ? ";
	    Connection c = DBconnection.getConnection();
	    int k;
	    try {
	    	PreparedStatement stc = c.prepareStatement(url);
	    	stc.setString(1,TenDangNhap);
	    	stc.setString(2,MatKhau);
	    	ResultSet result = stc.executeQuery();
	    	while(result.next()) {
	    		String Id = result.getString("IdEmPloyees");
	    		String Name = result.getString("Name");
	    		String Account = result.getString("Account");
	    		String Password = result.getString("Password");
	    		String MaCaLam = result.getString("IdCaLam");
	    		Employees e = new Employees(Id, Name, Account, Password, MaCaLam);
	    		list.add(e);
	    	}
	    	c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	
		return list;
		    
	}
	public static Employees CheckId(String n ) {
		String id = "";
		String Name = "";
		String Account = "";
		String Password = "";
		String MaCaLam = "";
		ResultSet result;
		String url = "select * from Employees where IdEmPloyees = ? ";
		Connection c = DBconnection.getConnection();
		try {
			PreparedStatement stc = c.prepareStatement(url);
			stc.setString(1,n);
			result = stc.executeQuery();
			while(result.next()) {
				  id = result.getString("IdEmPloyees");
				  Name =  result.getString("Name");
				  Account =  result.getString("Account");
				  Password =  result.getString("Password");
				  MaCaLam =  result.getString("IdCaLam");
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return new Employees(id, Name,Account,Password,MaCaLam);
		
	}



}
    
    
	
	  


