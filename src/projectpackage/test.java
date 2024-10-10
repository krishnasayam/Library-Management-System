package projectpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class test extends JFrame {

private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField tf1;
private JTextField tf2;
private JTextField tf4;
private JTextField tf5;
private JTextField tf6;
private JTextField tf3;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
test frame = new test();
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
public test() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1010, 692);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
tabbedPane.setBounds(10, 21, 976, 624);
contentPane.add(tabbedPane);

JPanel rp2 = new JPanel();
tabbedPane.addTab("Add Rooms", null, rp2, null);

JLabel lblNewLabel_6 = new JLabel("ADD YOUR ROOM HERE  :");
lblNewLabel_6.setFont(new Font("Swis721 Cn BT", Font.BOLD, 18));
rp2.add(lblNewLabel_6);

JPanel rp3 = new JPanel();
tabbedPane.addTab("Updation", null, rp3, null);

JPanel rp1 = new JPanel();
rp1.setBackground(new Color(255, 228, 181));
tabbedPane.addTab("Registration ", null, rp1, null);
rp1.setToolTipText("");
rp1.setLayout(null);

JLabel lb1 = new JLabel("STUDENT REGISTRATION PANEL");
lb1.setFont(new Font("Wide Latin", Font.BOLD, 20));
lb1.setBounds(153, 42, 680, 90);
rp1.add(lb1);

JLabel lb2 = new JLabel("NAME :");
lb2.setFont(new Font("Swis721 Cn BT", Font.BOLD, 20));
lb2.setBounds(252, 161, 70, 49);
rp1.add(lb2);

tf1 = new JTextField();
tf1.setBounds(484, 172, 301, 36);
rp1.add(tf1);
tf1.setColumns(10);

JLabel lb3 = new JLabel("ENROLLMENT NUMBER :");
lb3.setFont(new Font("Swis721 Cn BT", Font.BOLD, 18));
lb3.setBounds(249, 220, 207, 58);
rp1.add(lb3);

tf2 = new JTextField();
tf2.setBounds(484, 231, 301, 43);
rp1.add(tf2);
tf2.setColumns(10);

JLabel lb4 = new JLabel("FATHER'S NAME :");
lb4.setFont(new Font("Swis721 Cn BT", Font.BOLD, 20));
lb4.setBounds(249, 370, 173, 36);
rp1.add(lb4);

tf4 = new JTextField();
tf4.setBounds(487, 375, 298, 36);
rp1.add(tf4);
tf4.setColumns(10);

JLabel lblNewLabel_3 = new JLabel("BRANCH :");
lblNewLabel_3.setFont(new Font("Swis721 Cn BT", Font.BOLD, 20));
lblNewLabel_3.setBounds(252, 416, 145, 33);
rp1.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("SEMESTER :");
lblNewLabel_4.setFont(new Font("Swis721 Cn BT", Font.BOLD, 20));
lblNewLabel_4.setBounds(252, 471, 130, 25);
rp1.add(lblNewLabel_4);

tf5 = new JTextField();
tf5.setBounds(484, 419, 301, 36);
rp1.add(tf5);
tf5.setColumns(10);

tf6 = new JTextField();
tf6.setBounds(487, 467, 298, 41);
rp1.add(tf6);
tf6.setColumns(10);

JLabel lblNewLabel_5 = new JLabel("GENDER :");
lblNewLabel_5.setFont(new Font("Swis721 Cn BT", Font.BOLD, 20));
lblNewLabel_5.setBounds(252, 314, 145, 25);
rp1.add(lblNewLabel_5);

JButton r1 = new JButton("REGISTER");
r1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(e.getSource()==r1) {
String name = tf1.getText();
String enroll = tf2.getText();
String gender= tf3.getText();
String FatherName=tf4.getText();
String branch =tf5.getText();
int sm = Integer.parseInt(tf6.getText());
try
{
Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","rooot");
PreparedStatement pstmt = con.prepareStatement("insert into profile(name,enroll,gender,FatherName,branch,sm) values(?, ?, ?, ?, ?, ?)");
pstmt.setString(1,name);
pstmt.setString(2,enroll);
pstmt.setString(3,gender);
pstmt.setString(4,FatherName);
pstmt.setString(5,branch);
pstmt.setInt(6, sm);
int i = pstmt.executeUpdate();
if(i != 0)
JOptionPane.showMessageDialog(test.this, "1 Record INSERTED successfully !!!!!");
else
JOptionPane.showMessageDialog(test.this, "ERROR #####");
con.close();
//tf1.setText("");
//tf2.setText("");
//tf3.setText("");
//tf4.setText("");
//tf5.setText("");
//tf6.setText("");
}
catch(Exception ew)
{ System.out.println(ew.getMessage()); }
}
}


});
r1.setBackground(SystemColor.controlShadow);
r1.setFont(new Font("Swis721 Cn BT", Font.BOLD, 17));
r1.setBounds(335, 536, 107, 41);
rp1.add(r1);

JButton btnNewButton_1 = new JButton("RESET");
btnNewButton_1.setFont(new Font("Swis721 Cn BT", Font.BOLD, 17));
btnNewButton_1.setBackground(SystemColor.controlShadow);
btnNewButton_1.setBounds(504, 536, 109, 41);
rp1.add(btnNewButton_1);

tf3 = new JTextField();
tf3.setBounds(484, 313, 301, 36);
rp1.add(tf3);
tf3.setColumns(10);
}
}