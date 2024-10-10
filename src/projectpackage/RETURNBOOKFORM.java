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
import javax.swing.ImageIcon;

public class RETURNBOOKFORM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static RETURNBOOKFORM frame;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RETURNBOOKFORM frame = new RETURNBOOKFORM();
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
	public RETURNBOOKFORM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1528, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\add book cartoon.png"));
		lblNewLabel_2.setBounds(385, 145, 275, 446);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 338, 181, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(194, 264, 181, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Book");
		lblNewLabel_1.setForeground(new Color(47,79,79,255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(345, 36, 150, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		lblStudentId.setForeground(new Color(255, 255, 0));
		lblStudentId.setBounds(43, 328, 141, 41);
		panel.add(lblStudentId);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(1447, 10, 71, 29);
		panel.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(new Color(165, 42, 42));
		btnBack.setForeground(new Color(128, 0, 0));
		
		JLabel lblBookCallno = new JLabel("Book Callno:");
		lblBookCallno.setForeground(new Color(255, 255, 0));
		lblBookCallno.setBounds(43, 255, 141, 41);
		panel.add(lblBookCallno);
		lblBookCallno.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBounds(103, 462, 157, 34);
		panel.add(btnReturnBook);
		btnReturnBook.setForeground(Color.RED);
		btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
		lblNewLabel.setBounds(43, 651, 292, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		JLabel lblReturnBook = new JLabel("Return ");
		lblReturnBook.setBounds(193, 29, 150, 65);
		panel.add(lblReturnBook);
		lblReturnBook.setForeground(new Color(94,132,143,255));
		lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel backlabel = new JLabel("");
		backlabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminbackground.jpg"));
		backlabel.setBounds(340, 0, 1552, 800);
		panel.add(backlabel);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stu_id=textField.getText();
				String bookcallno=textField_1.getText();
				int i=RETURNBOOK.delete(stu_id, bookcallno);
				if(i>0){
					JOptionPane.showMessageDialog(RETURNBOOKFORM.this,"Book returned successfully!");
					//LibrarianSuccess.main(new String[]{});
					setVisible(false);
					
				}else{
					JOptionPane.showMessageDialog(RETURNBOOKFORM.this,"Sorry, unable to return book!");
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STUDENTPAGE.main(new String[]{});
				setVisible(false);
			}
		});
		contentPane.setLayout(gl_contentPane);
	}
}
