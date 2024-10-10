package projectpackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;

public class paymentekk extends JFrame{

	JFrame fr;
	 private JTextField memberIdField, paymentAmountField;
	    private JButton payButton;
	    private Connection connection;
	paymentekk()
	{
		fr = new JFrame();
		 System.out.println("Payment Class");
	    	setTitle("Payment of Fine");
	        setSize(300, 150);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JPanel panel = new JPanel();

	        JLabel memberIdLabel = new JLabel("Member ID:");
	        memberIdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	        memberIdLabel.setBounds(0, 34, 105, 36);
	        memberIdField = new JTextField();
	        memberIdField.setBounds(125, 33, 332, 43);

	        payButton = new JButton("Pay Fine");
	        payButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	        payButton.setBounds(125, 137, 221, 64);
	        payButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //payFine();
	            }
	        });
//	        panel.setLayout(null);
//	        panel.add(memberIdLabel);
//	        panel.add(memberIdField);
//	        panel.add(paymentAmountField);
//	        panel.add(payButton);
//
//	        fr.getContentPane().add(panel);
	}
}



/*package projectpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PAYMENT extends JFrame {
    private JTextField memberIdField, paymentAmountField;
    private JButton payButton;

    private Connection connection;
    private Statement statement;

    public PAYMENT() {
        System.out.println("Payment Class");
    	setTitle("Payment of Fine");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdField = new JTextField();

        payButton = new JButton("Pay Fine");
        /*payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //payFine();
            }
        });

        panel.add(memberIdLabel);
        panel.add(memberIdField);
        panel.add(paymentAmountField);
        panel.add(new JLabel());
        panel.add(payButton);

        add(panel);
        setVisible(true);
        }
*/
    /*private void payFine() {
        String memberId = memberIdField.getText();

        try {
        	Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","rooot");
			Statement ps=connection.createStatement();
            ResultSet resultSet = ps.executeQuery("SELECT reducedfine FROM fine WHERE stu_id = '" + memberId + "'");
            if (resultSet.next()) {
                double currentFine = resultSet.getDouble("reducedfine");
                if (currentFine<0) {
                    int rowsUpdated = statement.executeUpdate("UPDATE fines SET fine = 0 WHERE member_id = '" + memberId + "'");
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(this, "Fine paid successfully.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to update fine.");
                    }
                } 
            } else {
                JOptionPane.showMessageDialog(this, "No fine found for this member.");
            }
        } catch (NumberFormatException | SQLException e) {
            //JOptionPane.showMessageDialog(this, "Invalid payment amount.");
            e.printStackTrace();
        }
    }

  
}*/

