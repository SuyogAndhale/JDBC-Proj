package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PstInsertTest {
  
	public static void main(String[] args) {
		Scanner sc=null;
		int count=0;
		Connection con=null;
		String query=null;
		PreparedStatement ps=null;
		int no=0;
		String name=null;
		String addrs=null;
		int result=0;
		try {
			//read input
			sc=new Scanner(System.in);
			System.out.println("enter student count:");
			if(sc!=null)
		count=sc.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
			//prepaire SQL query
			query="insert into student values(?,?,?)";
			if(con!=null)
				ps=con.prepareStatement(query);
			if(sc!=null) {
				for(int i=1;i<count;++i) {
					System.out.println("Enter student "+i+"Detail");
					System.out.println("Enter number:");
					no=sc.nextInt();
					System.out.println("Enter name:");
					name=sc.next();
					System.out.println("Enter the address:");
					addrs=sc.next();
					ps.setInt(1, no);
					ps.setString(2, name);
					ps.setString(3,addrs);
					//execute the Query
                    result=ps.executeUpdate();
                    if(result==0)
                    	System.out.print(i+"student are not inserted");
                    else
                    	System.out.println(i+"student detail are inserted");
				}//for
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se){
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
		}

		
			
							
				}
			}
			