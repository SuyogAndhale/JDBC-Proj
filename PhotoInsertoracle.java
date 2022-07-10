package com.nt.jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoInsertoracle{

	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		String name=null,photopath=null;
		String gender=null;
		InputStream is=null;
		Connection con=null;
		File file=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				System.out.println("Enter no:");
				no=sc.nextInt();
				System.out.println("Enter Name:");
				name=sc.next();
				System.out.println("Enter gender:");
				gender=sc.next();
				System.out.println("Enter Photo Path");
				photopath=sc.next();//C:\\Users\\suyog\\Desktop\\Anushka.jpg
			
			}//if
			//create InputStream by locating file based on photopath
			file=new File(photopath);
			is=new FileInputStream(file);
		//Register the jdbc Driver
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
		//create prepaed statement object
		if(con!=null)
			ps=con.prepareStatement("insert into metromony_profile values(?,?,?,?)");
          	//set value of query param
		if(ps!=null)
		{
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setString(3,gender);
			ps.setBinaryStream(4, is,file.length());
		}
		if(ps!=null)
			result=ps.executeUpdate();
		if(result==0)
          System.out.println("Record is not inserted");
		else
			System.out.println("Record is inserted");
		}//try
		catch(SQLException se) {
		System.out.println("Record insertion failed");
		se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("Record insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Record insertion failed");
			e.printStackTrace();
		}
		finally {
			//close jdbc obj
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception se) {
				se.printStackTrace();
			}
		}//finally
			
	}//main
}//class
