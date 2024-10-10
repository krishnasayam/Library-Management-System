package projectpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class STUDENTLOGINPAGE extends JFrame {

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
					STUDENTLOGINPAGE frame = new STUDENTLOGINPAGE();
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
	public STUDENTLOGINPAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 882);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel passicon = new JLabel("");
		passicon.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\passicon.png"));
		passicon.setBounds(105, 456, 56, 85);
		contentPane.add(passicon);
		
		JLabel usericon = new JLabel("");
		usericon.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\usericom.png"));
		usericon.setBounds(105, 335, 56, 73);
		contentPane.add(usericon);
		
		JLabel lblNewLabel_1 = new JLabel("USER_ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(171, 292, 130, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 51));
		lblNewLabel_2.setBackground(new Color(255, 255, 51));
		lblNewLabel_2.setBounds(172, 425, 154, 46);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("STUDENT LOGIN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setBounds(90, 112, 367, 55);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(171, 352, 245, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 481, 245, 41);
		contentPane.add(passwordField);
		
		JButton logBut = new JButton("LOGIN");
		logBut.addActionListener(new ActionListener() {
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
		        		 STUDENTPAGE.main(new String[]{}); 
		        		 setVisible(false);
		        	        }  
		        	        else{  
		        	           // System.out.println("Please enter valid username and password"); 
		                          JOptionPane.showMessageDialog(null, "Please enter valid username and password.");
		        	        }  
		               //  }
		         }
		        	 catch(SQLException sql) {
		        		 sql.printStackTrace();
		        	 }
				
			}
		});
		logBut.setFont(new Font("Tahoma", Font.BOLD, 17));
		logBut.setForeground(new Color(102, 204, 51));
		logBut.setBounds(171, 608, 105, 30);
		contentPane.add(logBut);
		
		JButton backBut = new JButton("BACK");
		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
       		 Home.main(new String[]{}); 
       		setVisible(false);
			}
		});
		backBut.setForeground(new Color(255, 0, 0));
		backBut.setFont(new Font("Tahoma", Font.BOLD, 12));
		backBut.setBounds(316, 610, 87, 30);
		contentPane.add(backBut);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(47, 79, 79));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
		lblNewLabel.setBounds(514, 0, 1024, 855);
		contentPane.add(lblNewLabel);
	}
}
