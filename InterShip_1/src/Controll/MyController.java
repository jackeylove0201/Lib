package Controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Employees;
import View.Login;
import View.AddBook;
import View.GiaoDienChinh;

public class MyController implements ActionListener{
    Login lg;
    public static GiaoDienChinh g;
    GiaoDienChinh gd;
    AddBook addbook;
    public MyController(Login lg) {
    	this.lg = lg;
    	
    	
    }
    public MyController(GiaoDienChinh gd) {
    	this.gd = gd;
    }
    
	public MyController(AddBook addBook) {
		this.addbook = addBook;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		      String n = e.getActionCommand();
		      
		      if(n.equals("Đăng nhập")) {
		    	    
		    
		    	    String username = Login.userText.getText();		    	    
					String password = String.valueOf(Login.passwordText.getPassword());
				    List<Employees> list = Employees.Login(username, password);
				    int i = list.size();
				    if(i==0) {
				    	JOptionPane.showMessageDialog(this.lg,"Sai tên đăng nhập hoặc mật khâu!!");
				    }
				    else {
				      gd = new GiaoDienChinh();
				      g = gd;
				      this.gd.setVisible(true);
				      this.gd.setLocationRelativeTo(null);
				      this.lg.dispose();
				     
				    	
				    	
				    	
				    
				    	
				    }
					
		    	    
		    	    
		      }
		
	}

}
