package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		int no=0;
		String name=null,addrs=null;
		int result=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Eneter  the Student No:");
				no=sc.nextInt();//gives 101
				System.out.println("Eneter Name");
				name=sc.next();
				System.out.println("ENter the Address");
				addrs=sc.next();
				name="'"+name+"'";
				addrs="'"+addrs+"'";
			}//register jdbc driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//establish the connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
				//create statement object
				if(con!=null)
				st=con.createStatement();
				//prepare sql quiery
				
			//insert into student values(101,'raja','mumbai');
				String query="insert into studente values("+no+","+name+","+addrs+")";
				System.out.println(query);
				//send and execute sql quey and database software
				if(st!=null)
					result=st.executeUpdate(query);
				//process the result
				if(result==0) 
					System.out.println("Record insertion failed");
				else
					System.out.println("Record insertion Succeded");
			}//try
			catch(SQLException se) {// to handle known exception
			se.printStackTrace();
			System.out.println("Record insertion failed");
			}
		catch(ClassNotFoundException cnf) {//to handle unknown Exceptioin
			System.out.println("Record insertion failed");
			cnf.printStackTrace();
		}
		catch(Exception e) {//to handle unknown Exception
			System.out.println("Record insertion failed");
			e.printStackTrace();
		}
		finally
		{
			//close jdbc objects
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception se) {
				se.printStackTrace();
			}
			
			
		}
	//finally
	}//main
}//class