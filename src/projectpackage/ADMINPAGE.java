package projectpackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class ADMINPAGE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static ADMINPAGE frame;

    JFrame f;
    JPanel p1,p2,p3,p4;
   JLabel l1,l2,l3,l4;
   JTextField  t1,t2,t3;
   JTextArea ta;
   private JTable table;

	public ADMINPAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 882);
		contentPane = new JPanel();
		getContentPane().setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 1652, 982);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel remove = new JLabel("");
		remove.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\remove_book.png"));
		remove.setBounds(419, 540, 206, 209);
		panel.add(remove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(874, 226, 606, 215);
		panel.add(scrollPane);
		TableModel model = null;
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setForeground(new Color(255, 255, 0));
		table.setBackground(new Color(47, 79, 79));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(47,79,79,255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(351, 47, 206, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Books Table");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(1107, 171, 150, 45);
		panel.add(lblNewLabel_2);
		
		JButton back = new JButton("BACK");
		back.setForeground(new Color(255, 0, 0));
		back.setBounds(1442, 10, 91, 44);
		panel.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADMINPAGELOGIN.main(new String[]{});
				setVisible(false);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 18));
		DefaultTableModel model1 = new DefaultTableModel();
		
		JButton btnNewButton_1 = new JButton("REMOVE_BOOK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveBook.main(new String [] {});
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(417, 452, 186, 44);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(255, 0, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel backImagelabel = new JLabel("");
		backImagelabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
		backImagelabel.setBounds(340, 0, 1537, 835);
		panel.add(backImagelabel);
		
		JLabel lblNewLabel = new JLabel("      ADMIN ");
		lblNewLabel.setBounds(143, 50, 198, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(94,132,143,255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JButton add = new JButton("ADD_BOOK");
		add.setBounds(83, 452, 170, 44);
		panel.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  BOOKADDFORM.main(new String[]{});
				setVisible(false);
			}
		});
		add.setForeground(new Color(51, 255, 0));
		add.setFont(new Font("Tahoma", Font.BOLD, 15));
        //DefaultTableModel model = new DefaultTableModel();
		
		JLabel addimg = new JLabel("");
		addimg.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\add-book.png"));
		addimg.setBounds(68, 201, 206, 215);
		panel.add(addimg);

		 try {
 			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
 			Statement ps=connection.createStatement();
	            ResultSet rs = ps.executeQuery("SELECT * FROM BOOKS");

	            int columnCount = rs.getMetaData().getColumnCount();

	            for (int i = 1; i <= columnCount; i++) {
	                model1.addColumn(rs.getMetaData().getColumnName(i));
	            }
	            while (rs.next()) {
	                Object[] row = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    row[i - 1] = rs.getObject(i);
	                }
	                model1.addRow(row);
	            }

	            rs.close();
	            ps.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	
	   }      
	  
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ADMINPAGE frame = new ADMINPAGE();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}
