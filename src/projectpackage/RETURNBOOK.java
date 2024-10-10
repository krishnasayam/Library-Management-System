package projectpackage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RETURNBOOK extends JFrame {
	public RETURNBOOK() {
	}
	public static int delete(String stu_id,String bookcallno){
		int status=0;
		try{
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");
			
			//status=updatebook(bookcallno);//updating quantity and issue
			PreparedStatement ps=connection.prepareStatement("delete from issued where stu_id=? and bookcallno=?");
			ps.setString(1,stu_id);
			ps.setString(2,bookcallno);
			status=ps.executeUpdate();
			
			
			connection.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
//	public static int updatebook(String bookcallno){
//		int status=0;
//		int quantity=0,issued=0;
//		try{
//			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","rooot");
//			
//			PreparedStatement ps=connection.prepareStatement("select quantity,issued from books where callno=?");
//			ps.setString(1,bookcallno);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()){
//				quantity=rs.getInt("quantity");
//				issued=rs.getInt("issued");
//			}
//			
//			if(issued>0){
//			PreparedStatement ps2=connection.prepareStatement("update books set quantity=?,issued=? where callno=?");
//			ps2.setInt(1,quantity+1);
//			ps2.setInt(2,issued-1);
//			ps2.setString(3,bookcallno);
//			
//			status=ps2.executeUpdate();
//			}
//			connection.close();
//		}catch(Exception e){System.out.println(e);}
//		return status;
	
}
