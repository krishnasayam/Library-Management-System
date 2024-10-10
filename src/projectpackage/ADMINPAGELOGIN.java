package projectpackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ADMINPAGELOGIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMINPAGELOGIN frame = new ADMINPAGELOGIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ADMINPAGELOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 882);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 255));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel passicon = new JLabel("");
		passicon.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\passicon.png"));
		passicon.setBounds(147, 445, 56, 85);
		contentPane.add(passicon);
		
		JLabel usericon = new JLabel("");
		usericon.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\usericom.png"));
		usericon.setBounds(147, 321, 56, 73);
		contentPane.add(usericon);
		
		JLabel lblNewLabel_1 = new JLabel("USERID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(213, 293, 108, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(213, 434, 164, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ADMIN LOGIN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(255, 204, 51));
		lblNewLabel_3.setBounds(213, 160, 207, 68);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();       
		        String password = passwordField.getText();        
		         try {
		        	 Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
		        	 PreparedStatement st=connection.prepareStatement("Select userid,password from student1 where userid=? and password=?");
		        	 st.setString(1,user);
		        	 st.setString(2,password);
		        	 ResultSet rs=st.executeQuery();
		        	 if(rs.next()) {
		        		 ADMINPAGE.main(new String[]{}); 
							setVisible(false);

		        	        }  
		        	        else{  
		        	            //System.out.println("Please enter valid username and password");  
		                          JOptionPane.showMessageDialog(null, "Please enter valid username and password.");
		        	        }  
		               //  }
		         }
		        	 catch(SQLException sql) {
		        		 sql.printStackTrace();
		        	 }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(102, 204, 0));
		btnNewButton.setBounds(213, 596, 96, 30);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(216, 335, 219, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 465, 219, 48);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(new String[]{}); 
       		setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(350, 598, 85, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\pikaso_texttoimage_login-page-with-books-shelves.jpeg"));
		lblNewLabel.setBounds(514, 0, 1024, 855);
		contentPane.add(lblNewLabel);
	}
}
