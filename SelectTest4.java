package com.nt.jdbc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SelectTest4
{
	public static void main(String args[])
	{
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String desg1=null;
		String desg2=null;
		String desg3=null;
		boolean flag=false;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null)
			{
				System.out.println("Enter Desg1");
				desg1=sc.next().toUpperCase();     //gives CLERK
				System.out.println("Enter Desg2");
				desg2=sc.next().toUpperCase();  //gives MANAGER
				System.out.println("Enter Desg3");
				desg3=sc.next().toUpperCase();   //gives SALESMAN
			}
			//Frame codiction ('CLERK','MANAGER','SALESMAN')

			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			
			//geves('CLERK','MANAGER','SALESMAN')
			//resgister the jdbc driver software
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
				//create statement object
			if(con!=null)
			st=con.createStatement();
			//frame the sql query
			//SELECT EMPNO,JOB,SAL FROM EMP WHERE JOB IN('CLERK','MANAGER','SALESMAN') ORDER BY JOB;
		String query="select empno,ename,job,sal from emp where job in"+cond+"order by job";
		System.out.println(query);

		//send and exicute  SQL Query in database software
		if(st!=null)
			rs=st.executeQuery(query);
    //process the ResultSet
		if (rs!=null)
		{
			while(rs.next()){
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}//while
			if(flag==false)
				System.out.println("No Records Found");
		}//if
		}//try
		catch(SQLException se){  //known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){ //known Exception
			cnf.printStackTrace();
		}
		catch(Exception e){//unkown exception
       e.printStackTrace();
		}
		finally{
			//close object
			try{

				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class
