package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int count=0;
		try {
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
			//create STatement object
			if(con!=null)
				st=con.createStatement();
			//send and execute SQL Query in Db s/w
			if(st!=null)
				count=st.executeUpdate("DROP TABLE TEMP");
			//process the Result obj
			System.out.println(count);
			 if(count==0)
				  System.out.println("db table is  dropped");
			 else
				 System.out.println("dbt table is not dropped");
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
			//close jdbc objs
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