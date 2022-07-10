package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class LoginApp01 {
	public static void main(String args[])
	{
		Scanner sc=null;
		String uname=null,pwd=null;
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enetr Username");
				uname=sc.nextLine();
				System.out.println("Enetr Password");
				pwd=sc.nextLine();
			}
			uname="'"+uname+"'";
			pwd="'"+pwd+"'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
		if(con!=null)
		{
			st=con.createStatement();
			query="SELECT COUNT(*) FROM USERLIST WHERE UNAME="+uname+"AND PWD="+pwd;
				System.out.println(query);
				if(st!=null)
					rs=st.executeQuery(query);
				
				if(rs!=null)
					if(rs.next())

						count=rs.getInt(1);				
					System.out.println(count);
				}
				if(count==0)
					System.out.println("Invald creaditiial");
				else
					System.out.println("Valid creadintial");
				
		}//try
		
		catch(SQLException se) {// to handle known Exception
			
			se.printStackTrace();
			System.out.println("Record insertion failed");
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("Record Insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e) {
		System.out.println("Record insertion failed");
		e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(rs!=null)
					st.close();
			}
		 catch(SQLException se) {
			 se.printStackTrace();
		 }
			try
			{
				if(st!=null)
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

