package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controll.MyController;
import Model.Employees;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public  static JTextField userText;
	public  static JPasswordField passwordText;
	public static  Employees Employ;
	
	public static JRadioButton EmployeeRadio;

	;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Employ = new Employees(getWarningString(), getName());
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 64, 0));
		panel.setBounds(10, 0, 678, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		ActionListener action = new MyController(this);
		JLabel lblNewLabel = new JLabel("Đăng nhập\r\n");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(230, 35, 199, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(109, 137, 121, 47);
		panel.add(lblNewLabel_1);
	
		userText = new JTextField();
		userText.setForeground(new Color(47, 79, 79));
		userText.setBackground(new Color(255, 255, 224));
		userText.setFont(new Font("Tahoma", Font.BOLD, 15));
		userText.setBounds(264, 137, 287, 38);
		panel.add(userText);
		userText.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(109, 226, 121, 47);
		panel.add(lblNewLabel_1_1);
		
		passwordText = new JPasswordField();
		passwordText.setForeground(new Color(47, 79, 79));
		passwordText.setBackground(new Color(255, 255, 224));
		passwordText.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordText.setBounds(262, 226, 287, 38);
		panel.add(passwordText);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(30, 144, 255));
		
		
		btnNewButton.setBounds(262, 386, 103, 38);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(action);
		
		
	
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(436, 386, 89, 38);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(action);
		
	}
}
