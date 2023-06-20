package Test;

import java.sql.Connection;
import java.sql.Date;



import Database.DBconnection;
import Model.Book;
import Model.Employees;
public class Test {

	public static void main(String[] args) {
		
	    Employees e = new Employees("009","NguyenHuuTrach","Hutrach","3456","A");
	    e.Remove("delete from Employees where IdEmPloyees = ? ",e.getId());
	  
        
      
        System.out.println("successfull");
	}

}
