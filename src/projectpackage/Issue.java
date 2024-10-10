package projectpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Issue extends JFrame {
    private JTextField memberIdField, bookField;
    private JButton issueButton;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static BOOKADDFORM frame;
    private Connection connection;
    private Statement statement;
    private JLabel bookNamel;

    public Issue() {
        setTitle("Book Issue");
        setBounds(100, 100, 1552, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(100, 100, 1552, 800);
        panel.setBackground(new Color(47, 79, 79));

        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setForeground(new Color(255, 215, 0));
        memberIdLabel.setBounds(160, 171, 129, 46);
        memberIdLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        memberIdField = new JTextField();
        memberIdField.setBounds(360, 174, 208, 46);
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setForeground(new Color(255, 215, 0));
        bookIdLabel.setBounds(193, 337, 92, 46);
        bookIdLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        bookField = new JTextField();
        bookField.setBounds(360, 342, 208, 46);
        
        JLabel lblNewLabel_1 = new JLabel("Book Issue");
        lblNewLabel_1.setForeground(new Color(255, 255, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 44));
        lblNewLabel_1.setBounds(222, 23, 328, 65);
        panel.add(lblNewLabel_1);
        
        JLabel nameLabel = new JLabel("");
        nameLabel.setForeground(new Color(255, 0, 0));
        nameLabel.setBackground(new Color(47, 79, 79));
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameLabel.setBounds(360, 253, 208, 46);
        panel.add(nameLabel);
        
        JButton btnNewButton_1 = new JButton("GetName");
        btnNewButton_1.setForeground(new Color(255, 215, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String stu_id = memberIdField.getText();
        		try{
       			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
       		
	        	 PreparedStatement st=connection.prepareStatement("SELECT stu_name FROM student2 WHERE stu_id=?");
       			
       			 st.setString(1,stu_id);
       			   
       			 ResultSet  rs = st.executeQuery();
                    if (rs.next()) {
                        String name = rs.getString("stu_name");
                        nameLabel.setText("Name :              "+name);
                    } else {
                        JOptionPane.showMessageDialog(null, "Student with ID " + stu_id + " not found");
                    }
       			 
       		}
       		catch(Exception ee){System.out.println(ee);}
        	}
        });
        btnNewButton_1.setBounds(160, 253, 149, 46);
        panel.add(btnNewButton_1);

        issueButton = new JButton("Issue Book");
        issueButton.setForeground(new Color(128, 0, 0));
        issueButton.setBounds(57, 515, 225, 53);
        issueButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        issueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		try{
        			 ResultSet rs = null;
        			String stu_id = memberIdField.getText();
                    String bookcallno = bookField.getText();
                    Date currentDate = new Date();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String issue_date = dateFormat.format(currentDate);
                    
                    String return_date = dateFormat.format(new Date(currentDate.getTime() + (1 * 24 * 60 * 60 * 1000)));

        			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
        			Statement ps=connection.createStatement();
        			PreparedStatement p=connection.prepareStatement("select * from student1 where userid=?");
        			  String query = "INSERT INTO issued (stu_id, bookcallno, issue_date, return_date) VALUES (?, ?, ?, ?)";
                      PreparedStatement preparedStatement = connection.prepareStatement(query);
                      preparedStatement.setString(1, stu_id);
                      preparedStatement.setString(2, bookcallno);
                      preparedStatement.setString(3, issue_date);
                      preparedStatement.setString(4, return_date);

                      int rowsInserted = preparedStatement.executeUpdate();
                      if (rowsInserted > 0) {
                          JOptionPane.showMessageDialog(null, "Book issued successfully!");
                      } else {
                          JOptionPane.showMessageDialog(null, "Failed to issue book.");
                      }
        			connection.close();
        		}
        		catch(Exception ee){System.out.println(ee);}
            }

        });
        panel.setLayout(null);

        panel.add(memberIdLabel);
        panel.add(memberIdField);
        panel.add(bookIdLabel);
        panel.add(bookField);
        panel.add(issueButton);

        getContentPane().add(panel);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setForeground(new Color(128, 0, 0));
        btnNewButton.setBounds(453, 515, 208, 53);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		STUDENTPAGE.main(new String [] {});
        		setVisible(false);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(btnNewButton);
        
        JButton lblBookname = new JButton("BookName");
        lblBookname.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String books_id = bookField.getText();
        		try{
       			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
       		//	Statement ps=connection.createStatement();
	        	 PreparedStatement st=connection.prepareStatement("SELECT book_Title FROM books WHERE books_id=?");
       			// String sql = "SELECT stu_name FROM student2 WHERE stu_id=?";
       			 st.setString(1,books_id);
       			//st = connection.prepareStatement(sql);    
       			 ResultSet  rs = st.executeQuery();
                    if (rs.next()) {
                        String name = rs.getString("book_Title");
                        bookNamel.setText("Book_Name :               "+name);
                    } else {
                        JOptionPane.showMessageDialog(null, "Student with ID " + books_id + " not found");
                    }
       			 
       		}
       		catch(Exception ee){System.out.println(ee);}
        	}
        });
        lblBookname.setForeground(new Color(255, 215, 0));
        lblBookname.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblBookname.setBounds(160, 413, 149, 53);
        panel.add(lblBookname);
        
        bookNamel = new JLabel();
        bookNamel.setForeground(new Color(255, 0, 0));
        bookNamel.setBounds(360, 413, 208, 46);
        panel.add(bookNamel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
        lblNewLabel.setBounds(340, 0, 1550, 800);
        panel.add(lblNewLabel);
 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Issue().setVisible(true);
            }
        });
    }
}
