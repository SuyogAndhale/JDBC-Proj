package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectTest5 {
	public static void main(String[] args) {
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	boolean flag=false;
	try {
		//Register jdbc Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bca123");
		//create statement
		if(con!=null)
			st=con.createStatement();
		//send and exicute SQL query in database softaware
		if(st!=null)
			rs=st.executeQuery("SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)");
		//Propcess the resultset
		if(rs!=null) {
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
				flag=true;
			}//while
	  }  //if
	if(!flag) {
		System.out.println("Record Not Found");
	}//if
	}//try
	catch(SQLException se) {//known Exception
		se.printStackTrace();
	}
	catch(Exception e) { //anknown Exception
		e.printStackTrace();
	}
	finally{
		//close object
		
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
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
            catch(SQLException se) {
            	se.printStackTrace();	
            }
	}//finally
	
}//main
}//class
