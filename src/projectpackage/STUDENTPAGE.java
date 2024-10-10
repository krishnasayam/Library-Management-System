package projectpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class STUDENTPAGE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					STUDENTPAGE frame = new STUDENTPAGE();
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
	public STUDENTPAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 882);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 330, 845);
		panel.setBackground(new Color(47, 79, 79));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("BOOKS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.main(new String[] {});
				setVisible(false);
				
//				 JTable table = new JTable();
//				JScrollPane scrollPane = new JScrollPane(table);
//				scrollPane.setBounds(578, 117, 507, 299);
//				panel.add(scrollPane);
//				// DefaultTableModel model = new DefaultTableModel();
//				
//				 // JTable table = new JTable(model);
//					scrollPane.setViewportView(table);
//				 try {
//			 			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","rooot");
////			 			Statement ps=connection.createStatement();
////				            ResultSet rs = ps.executeQuery("SELECT * FROM BOOKS");
////
////				            int columnCount = rs.getMetaData().getColumnCount();
////
////				            for (int i = 1; i <= columnCount; i++) {
////				                model.addColumn(rs.getMetaData().getColumnName(i));
////				            }
////
////				            while (rs.next()) {
////				                Object[] row = new Object[columnCount];
////				                for (int i = 1; i <= columnCount; i++) {
////				                    row[i - 1] = rs.getObject(i);
////				                }
////				                model.addRow(row);
////				            }
////
////				            rs.close();
////				            ps.close();
////				            connection.close();
////				        } catch (SQLException ee) {
////				            ee.printStackTrace();
////				        }
//				 String query = "SELECT * FROM BOOKS";
//		            PreparedStatement statement = connection.prepareStatement(query);
//		            ResultSet resultSet = statement.executeQuery();
//
//		            // Populate JTable with data from ResultSet
//		            DefaultTableModel model = new DefaultTableModel();
//		            ResultSetMetaData metaData = resultSet.getMetaData();
//		            int columnCount = metaData.getColumnCount();
//
//		            // Add columns to the model
//		            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//		                model.addColumn(metaData.getColumnName(columnIndex));
//		            }
//
//		            // Add rows to the model
//		            while (resultSet.next()) {
//		                Object[] row = new Object[columnCount];
//		                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//		                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
//		                }
//		                model.addRow(row);
//		            }
//
//		            // Set the model to the table
//		            table.setModel(model);
//		        } catch (SQLException ex) {
//		            ex.printStackTrace();
//		            JOptionPane.showMessageDialog(null, "Error loading data from database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//		        }
//				 
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(70, 151, 109, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ISSUE_BOOK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issue.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBounds(70, 246, 109, 31);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RETURN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RETURNBOOKFORM.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(70, 338, 109, 31);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DUES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FINEMOUDULE.main(new String [] {});
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setForeground(new Color(128, 0, 0));
		btnNewButton_3.setBounds(70, 437, 109, 31);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("WAIVE OFF");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waiveoff.main(new String [] {});
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setForeground(new Color(128, 0, 0));
		btnNewButton_4.setBounds(70, 528, 109, 31);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("PAYMENT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newpayment.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setForeground(new Color(128, 0, 0));
		btnNewButton_5.setBounds(70, 618, 109, 31);
		panel.add(btnNewButton_5);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(313, 10, 17, 835);
		panel.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Student Section:");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(39, 37, 249, 49);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_6 = new JButton("LOGOUT");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STUDENTLOGINPAGE.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_6.setForeground(new Color(255, 0, 0));
		btnNewButton_6.setBounds(70, 705, 109, 36);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("ISSUE_BOOK");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issue.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_7.setBounds(383, 70, 260, 114);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\book-stack.jpg"));
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("RETURN");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RETURNBOOKFORM.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_7_1.setBounds(383, 231, 260, 114);
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\book-stack.jpg"));
		btnNewButton_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton_7_1);
		
		JButton btnNewButton_7_2 = new JButton("DUES     ");
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FINEMOUDULE.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_7_2.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\cash-flow (1).jpg"));
		btnNewButton_7_2.setBounds(383, 415, 260, 114);
		btnNewButton_7_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton_7_2);
		
		JButton btnNewButton_7_3 = new JButton("PAYMENT");
		btnNewButton_7_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newpayment.main(new String[]{});
				setVisible(false);
			}
		});
		btnNewButton_7_3.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\cash-payment (1).jpg"));
		btnNewButton_7_3.setBounds(383, 620, 260, 114);
		btnNewButton_7_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton_7_3);
		
		JLabel backimg = new JLabel("");
		backimg.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
		backimg.setBounds(340, 0, 1537, 835);
		contentPane.add(backimg);
	}
}