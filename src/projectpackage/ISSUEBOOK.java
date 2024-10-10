package projectpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

public class ISSUEBOOK extends JFrame {
	public ISSUEBOOK() {
	}
	public static boolean checkBook(String bookcallno){
		boolean status=false;
		try{
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
			PreparedStatement ps=connection.prepareStatement("select * from books where books_id=?");
			ps.setString(1,bookcallno);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int save(String bookcallno,int studentid,String studentname,String studentcontact){
		int status=0;
		try{
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
			
			status=updatebook(bookcallno);//updating quantity and issue
			
			if(status>0){
			PreparedStatement ps=connection.prepareStatement("insert into issuebooks(bookcallno,studentid,studentname,studentcontact) values(?,?,?,?)");
			ps.setString(1,bookcallno);
			ps.setInt(2,studentid);
			ps.setString(3,studentname);
			ps.setString(4,studentcontact);
			status=ps.executeUpdate();
			}
			
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int updatebook(String bookcallno){
		int status=0;
		int quantity=0,issued=0;
		try{
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
			
			PreparedStatement ps=connection.prepareStatement("select quantity,issued from books where books_id=?");
			ps.setString(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			
			if(quantity>0){
			PreparedStatement ps2=connection.prepareStatement("update books set quantity=?,issued=? where books_id=?");
			ps2.setInt(1,quantity-1);
			ps2.setInt(2,issued+1);
			ps2.setString(3,bookcallno);
			
			status=ps2.executeUpdate();
			}
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	}
