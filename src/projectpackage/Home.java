package projectpackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import projectpackage.ADMINPAGELOGIN;
import projectpackage.STUDENTLOGINPAGE;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 3500, 3500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back = new JButton("");
		back.setBounds(1443, 10, 85, 52);
		contentPane.add(back);
		back.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\back.png"));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		JLabel homeLabel = new JLabel("Welcome To Harda Library.");
		homeLabel.setBounds(10, 10, 976, 46);
		homeLabel.setBackground(new Color(255, 0, 0));
		homeLabel.setForeground(new Color(0, 100, 0));
		homeLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(homeLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 66, 1537, 2);
		separator.setBackground(new Color(139, 0, 0));
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 66, 1552, 793);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 10));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBounds(0, 0, 1552, 819);
		ImageIcon img=new ImageIcon("C:\\\\Users\\\\nikun\\\\Downloads\\\\WhatsApp Image 2024-04-10 at 11.55.30 PM.jpeg");
		Image img1=img.getImage();
		Image imgScale = img1.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon=new ImageIcon(imgScale);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\Designer (1).png"));
		lblNewLabel_2.setBounds(1078, 113, 384, 512);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("Home Page");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(699, 42, 240, 90);
		panel.add(lblNewLabel_1);
		
		JButton adminbutton = new JButton("ADMIN LOGIN");
		adminbutton.setFont(new Font("Tahoma", Font.BOLD, 30));
		adminbutton.setForeground(new Color(0, 0, 128));
		adminbutton.setBounds(103, 220, 444, 197);
		panel.add(adminbutton);
		adminbutton.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\adminlogo.png"));
		adminbutton.setContentAreaFilled(false);
		adminbutton.setBorderPainted(false);
		adminbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADMINPAGELOGIN.main(new String[]{});
				setVisible(false);
			}
		});
		
		JButton stuButton = new JButton("STUDENT LOGIN");
		stuButton.setForeground(new Color(0, 0, 128));
		stuButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		stuButton.setBounds(103, 487, 484, 197);
		panel.add(stuButton);
		stuButton.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\studentlogo.png"));
		stuButton.setContentAreaFilled(false);
		stuButton.setBorderPainted(false);
		stuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				STUDENTLOGINPAGE.main(new String[]{});
				setVisible(false);
			}
		});
		
		
		
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\big.jpg"));
		panel.add(lblNewLabel);
		
		
	
		 ImageIcon icon = new ImageIcon("C:\\\\Users\\\\nikun\\\\Downloads\\\\studentlogo.png");
		
		
		
		
		
		
	}
}
