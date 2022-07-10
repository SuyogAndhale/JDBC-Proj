package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DeleteTest {
	public static void main(String[] args) {
   Scanner sc=null;
   Connection con=null;
   Statement st= null;
   int no=0;
   int result=0;
   try {
	   //read inputs
	   sc=new Scanner(System.in);
	   System.out.println("Enter Studente no to Delete");
	   no=sc.nextInt();
	   //Register jdbc Driver softare
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   //Establish the Connection
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bca123");
	   //create statement object
	   if(con!=null)
		   st=con.createStatement();
		   //send and execute sql queru in adatabase software
		   if(st!=null)
		    result=st.executeUpdate("delete from studente where sno="+no);
		   //process the result
		    if(result==0)
			 System.out.println("no record found of a deletion");
		        else
			   System.out.println(result+"no.of records found in deletion ");
   }//try
   catch(SQLException se) {//to handle known Exception
	se.printStackTrace();
   }
   catch(ClassNotFoundException cnf) {//to handle knon Exception
	   cnf.printStackTrace();
   }
   catch(Exception e) {//to handle  unkown Exception
	   e.printStackTrace();
   }
   finally {
    //closejdbc object
   try{
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
   try
   {
	   if(sc!=null)
		   sc.close();
   }
   catch(Exception se){
	   se.printStackTrace();
   }
 
  
   }//finaly
	   }//main
   
	}//class