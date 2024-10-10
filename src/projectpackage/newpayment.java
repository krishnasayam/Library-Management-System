package projectpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class newpayment extends JFrame {
    private JTextField memberIdField;
    private JButton payButton;

    private Connection connection=null;

    public newpayment() {
        setTitle("Payment of Fine");
        setBounds(100, 100, 1552, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(47, 79, 79));

        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setForeground(new Color(173, 255, 47));
        memberIdLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        memberIdLabel.setBounds(562, 237, 117, 45);
        memberIdField = new JTextField();
        memberIdField.setBounds(744, 240, 321, 45);
        panel.setLayout(null);
        
                payButton = new JButton("Pay Fine");
                payButton.setForeground(new Color(220, 20, 60));
                payButton.setFont(new Font("Tahoma", Font.BOLD, 18));
                payButton.setBounds(677, 356, 159, 45);
                payButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        payFine();
                        setVisible(false);
                    }
                });
                
                JButton btnNewButton = new JButton("Back");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		STUDENTPAGE.main(new String[] {});
                		setVisible(false);
                	}
                });
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
                btnNewButton.setBounds(1403, 24, 125, 39);
                panel.add(btnNewButton);
                
                JLabel lblNewLabel = new JLabel("Payment");
                lblNewLabel.setForeground(new Color(255, 0, 0));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
                lblNewLabel.setBounds(573, 10, 513, 65);
                panel.add(lblNewLabel);
                panel.add(payButton);

        panel.add(memberIdLabel);
        panel.add(memberIdField);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
        label.setBounds(0, 0, 1552, 800);
        panel.add(label);

        getContentPane().add(panel);
        }

   
    private void payFine() {
        String memberId = memberIdField.getText();
        try {
        	Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
			Statement ps=connection.createStatement();
            ResultSet resultSet = ps.executeQuery("SELECT * FROM fine WHERE stu_id = '" + memberId + "'");
            if (resultSet.next()) {
               // double currentFine = resultSet.getDouble("reducedfine");
                int rowsUpdated = ps.executeUpdate("UPDATE fine SET fine = " + 0 + ",reducedfine = " + 0+ " WHERE stu_id = '" + memberId + "'");
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Fine Paid successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Pay fine.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No fine found for this member.");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new newpayment().setVisible(true);
            }
        });
    }
}
