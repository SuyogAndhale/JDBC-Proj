package com.nt.jdbc;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoRetriveMysql  {
	public static void main(String args[]) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
         ResultSet rs=null;
         InputStream is=null;
         OutputStream os=null;
         int no=0;
         byte[] buffer=null;
         int bytesRead=0;
         try{
        	 sc=new Scanner(System.in);
        	 if(sc!=null) {
        		System.out.println("Enter App No:");
        		 no=sc.nextInt();
        		// System.out.println("Enter App Name");
        		 //String name=sc.nextLine();
        		 //System.out.println("Enter App gender");
        		 //String gender=sc.nextLine();
        	 }
        	 //register the jdbc driver
        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 //estblish the connection
        	 con=DriverManager.getConnection("jdbc:mysql:///datbase1","root","root");
        	 if(con!=null) 
        		 ps=con.prepareStatement("SELECT * FROM METROMINI WHERE NO=?" );
        	 // set param values
        	 if(ps!=null) {
        		 ps.setInt(1, no);
        		 //execute the SQL query
        		 rs=ps.executeQuery();
        	 }
        	 //process the ResultSet(read blob values)
              if(rs.next());{
            	is=rs.getBinaryStream(4);
              }//if
         //create outpute Stream for Destination
              //os= new FileOutputStream("‪C:/Users/suyog/Desktop/Anushka.jpg");
              os=new FileOutputStream("com\\nt\\jdbc\\Anushka.jpg");
              buffer=new byte[4096];
              while((bytesRead=is.read(buffer))!=-1){
            	  os.write(buffer,0,bytesRead);
              }//while
              }
         catch(SQLException se) {
        	 se.printStackTrace();
        	 System.out.println("Record insertion Fialed");
         }
         catch(ClassNotFoundException cnf) {
        	 cnf.printStackTrace();
        	 
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }
         finally {//close jdbc objects
        	 try {
        		 if(rs!=null) 
        			 rs.close();
        		 }
        		 catch(SQLException se) {
        			 se.printStackTrace();
        			 
        		 }
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
        			 if(sc!=null)
        				 sc.close();
        		 }
        		 catch(Exception se) {
        			 se.printStackTrace();
        		 }
        		 try {
        			 if(is!=null)
        				 is.close();
        		 }
        		 catch(Exception se) {
        			 se.printStackTrace();
        		 }
        		 try {
        			 if(os!=null)
        				 os.close();
        		 }
        		 catch(Exception se) {
        			 se.printStackTrace();
        		 }
        		 
        		 }//finally
        	 
         }//main 
         }//class
        				 
        	 
        	 
         
      