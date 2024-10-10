package projectpackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class BOOKADDFORM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static BOOKADDFORM frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BOOKADDFORM frame = new BOOKADDFORM();
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
	public BOOKADDFORM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\add book cartoon.png"));
		lblNewLabel_2.setBounds(0, 205, 338, 507);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAddBooks = new JLabel("ADD");
		lblAddBooks.setBounds(235, 50, 95, 44);
		lblAddBooks.setForeground(new Color(94,132,143,255));
		lblAddBooks.setFont(new Font("Tahoma", Font.BOLD, 35));
		contentPane.add(lblAddBooks);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK");
		lblNewLabel_1.setForeground(new Color(47,79,79,255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(351, 47, 206, 50);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(339, 263, 488, 398);
		panel.setBackground(new Color(47, 79, 79));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCallNo = new JLabel("Call No:");
		lblCallNo.setForeground(new Color(255, 255, 0));
		lblCallNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCallNo.setBounds(118, 58, 111, 31);
		panel.add(lblCallNo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(255, 255, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(118, 99, 111, 31);
		panel.add(lblName);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setForeground(new Color(255, 255, 0));
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAuthor.setBounds(118, 140, 111, 31);
		panel.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setForeground(new Color(255, 255, 0));
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPublisher.setBounds(118, 200, 111, 31);
		panel.add(lblPublisher);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(new Color(255, 255, 0));
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(118, 241, 111, 31);
		panel.add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(239, 41, 215, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 90, 215, 39);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(239, 188, 215, 39);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(239, 139, 215, 39);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(239, 240, 215, 39);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.setForeground(new Color(34, 139, 34));
		btnAddBooks.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAddBooks.setBounds(198, 323, 197, 44);
		panel.add(btnAddBooks);
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String callno=textField.getText();
			String name=textField_1.getText();
			String author=textField_2.getText();
			String publisher=textField_3.getText();
			String squantity=textField_4.getText();
			int quantity=Integer.parseInt(squantity);
			int i=BOOKADD.save(callno, name, author, publisher,quantity);
			if(i>0){
				
				JOptionPane.showMessageDialog(BOOKADDFORM.this,"Books added successfully!");
				//LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(BOOKADDFORM.this,"Sorry, unable to save!");
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADMINPAGE.main(new String[]{});
				setVisible(false);
			}
		});
		btnBack.setBounds(1403, 10, 125, 44);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
		lblNewLabel.setBounds(340,0, 1552, 800);
		contentPane.add(lblNewLabel);
		
	}
}
