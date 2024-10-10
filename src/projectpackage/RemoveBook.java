package projectpackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveBook extends JFrame {
	private JTextField textField;
	private JPanel contentPane ;
    public RemoveBook() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ADMINPAGE.main(new String[] {});
        		setVisible(false);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setBounds(1431, 10, 97, 39);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\remove_book.png"));
        lblNewLabel_3.setBounds(91, 477, 225, 255);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("Book");
        lblNewLabel_2.setForeground(new Color(47,79,79,255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel_2.setBounds(350, 31, 127, 50);
        getContentPane().add(lblNewLabel_2);
        
        JLabel bookIdLabel_1 = new JLabel("Book ID:");
        bookIdLabel_1.setForeground(new Color(255, 255, 0));
        bookIdLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        bookIdLabel_1.setBounds(61, 227, 114, 50);
        getContentPane().add(bookIdLabel_1);
        
        textField = new JTextField();
        textField.setBounds(167, 237, 155, 39);
        getContentPane().add(textField);
        
        JButton removeButton = new JButton("Remove");
        removeButton.setForeground(new Color(128, 0, 0));
        removeButton.setBounds(130, 347, 225, 53);
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        removeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String bookId= textField.getText();
        	      
        	        try {
        	            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
        	            PreparedStatement ps=connection.prepareStatement("delete from books where books_id=?");
        				ps.setString(1,bookId);
        	            int rowsAffected = ps.executeUpdate();

        	            if (rowsAffected > 0) {
        	                JOptionPane.showMessageDialog(null, "Book removed successfully!");
        	            } else {
        	                JOptionPane.showMessageDialog(null, "No book found with the given ID.");
        	            }

        	            //statement.close();
        	            connection.close();
        	        } catch (SQLException ex) {
        	            JOptionPane.showMessageDialog(null, "Error removing book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        	        }
        	}
        });
        removeButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        removeButton.setForeground(new Color(255, 0, 0));
        removeButton.setBounds(146, 329, 176, 39);
        getContentPane().add(removeButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
        lblNewLabel.setBounds(340, 0, 1552, 850);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Remove");
        lblNewLabel_1.setForeground(new Color(94,132,143,255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel_1.setBounds(167, 25, 176, 63);
        getContentPane().add(lblNewLabel_1);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RemoveBook();
            }
        });
    }
}