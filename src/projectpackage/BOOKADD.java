package projectpackage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BOOKADD extends JFrame {
	public BOOKADD() {
	}

	public static int save(String books_id,String book_Title,String category,String author,int quantity){
		int status=0;
		try{
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
       	    PreparedStatement ps=connection.prepareStatement("insert into books(books_id,book_Title,category,author,quantity) values(?,?,?,?,?)");
			ps.setString(1,books_id);
			ps.setString(2,book_Title);
			ps.setString(3,category);
			ps.setString(4,author);
			ps.setInt(5,quantity);
			status=ps.executeUpdate();
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	}
