package projectpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FINEMOUDULE extends JFrame {
    private JTextField memberIdField, fineAmountField;
    private JButton calculateButton;

    private Connection connection;
    private Statement statement;

    public FINEMOUDULE() {
        setTitle("Fine Calculator");
        setBounds(100, 100, 1552, 882);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(47, 79, 79));

        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setForeground(new Color(50, 205, 50));
        memberIdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        memberIdLabel.setBounds(22, 341, 130, 57);
        JLabel fineAmountLabel = new JLabel("Fine Amount:");
        fineAmountLabel.setForeground(new Color(50, 205, 50));
        fineAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        fineAmountLabel.setBounds(22, 505, 130, 57);
        panel.setLayout(null);
        
                calculateButton = new JButton("Calculate Fine");
                calculateButton.setForeground(Color.RED);
                calculateButton.setFont(new Font("Tahoma", Font.BOLD, 17));
                calculateButton.setBounds(159, 428, 171, 38);
                calculateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //calculateFine();
                       String memberId = memberIdField.getText();

                       try {
                			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
                			Statement ps=connection.createStatement();
                            StringBuilder stringBuilder = new StringBuilder();
                	            ResultSet resultSet = ps.executeQuery("SELECT issue_date, return_date FROM issued WHERE stu_id = '" + memberId + "'");
                	            if (resultSet.next()) {
                	                String issueDateString = resultSet.getString("issue_date");
                	                String returnDateString = resultSet.getString("return_date");

                	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                	                Date issueDate = dateFormat.parse(issueDateString);
                	                Date returnDate = dateFormat.parse(returnDateString);

                	                long diffInMillies = Math.abs(returnDate.getTime() - issueDate.getTime());
                	                long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
                	                int fineAmount = 0;

//                	                if (diffInDays > 7) {
//                	                    fineAmount = (int) (diffInDays - 7);
//                	                }
                	                
                	                if (diffInDays > 0) {
                	                    fineAmount = (int) (10*diffInDays);
                	                }

                	                fineAmountField.setText(String.valueOf(fineAmount));
                	                String query = "INSERT INTO fine(stu_id,fine)VALUES (?, ?)";
                	                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                    preparedStatement.setString(1, memberId);
                                    preparedStatement.setInt(2, fineAmount);
                                    int rowsInserted = preparedStatement.executeUpdate();
                                    if (rowsInserted > 0) {
                                        JOptionPane.showMessageDialog(null, "INSERTED SUCCESSFULLY!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "FAILED");
                                    }

                	            } else {
                	                fineAmountField.setText("No transaction found for this member.");
                	            }
                			connection.close();
                		}
                		catch(Exception ee){System.out.println(ee);}
                    }
                });
                
                JButton btnNewButton_1 = new JButton("Payment");
                btnNewButton_1.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		newpayment.main(new String[] {});
                		setVisible(false);
                	}
                });
                fineAmountField = new JTextField();
                fineAmountField.setBounds(159, 517, 230, 38);
                panel.add(fineAmountField);
                memberIdField = new JTextField();
                memberIdField.setBounds(159, 349, 230, 38);
                panel.add(memberIdField);
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nikun\\Downloads\\finecharac.png"));
                lblNewLabel_1.setBounds(381, 252, 305, 412);
                panel.add(lblNewLabel_1);
                
                JLabel lblNewLabel = new JLabel("Dues");
                lblNewLabel.setForeground(new Color(255, 255, 0));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 56));
                lblNewLabel.setBounds(103, 131, 321, 45);
                panel.add(lblNewLabel);
                btnNewButton_1.setForeground(new Color(255, 0, 0));
                btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
                btnNewButton_1.setBounds(83, 607, 157, 38);
                panel.add(btnNewButton_1);
                panel.add(calculateButton);

        panel.add(memberIdLabel);
        panel.add(fineAmountLabel);

        getContentPane().add(panel);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		STUDENTPAGE.main(new String[] {});
        		setVisible(false);
        	}
        });
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnNewButton.setBounds(1414, 10, 114, 38);
        panel.add(btnNewButton);
        
        JLabel backimg = new JLabel("");
        backimg.setIcon(new ImageIcon("C:\\Users\\nikun\\Downloads\\adminbackground.jpg"));
        backimg.setBounds(340, 0, 1552, 882);
        panel.add(backimg);

        //connectToDatabase();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FINEMOUDULE().setVisible(true);
            }
        });
    }
}
