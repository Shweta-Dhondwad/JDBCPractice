package com.jdbc;
import java.sql.*;
public class ReadTableClass {

	private static String driver_name="com.mysql.jdbc.Driver";
	private static String db_URL="jdbc:mysql://localhost/school";
	private static String db_userName="root";
	private static String db_password="Shweta123";
  public static void main(String[] args) {
	  
	  Connection con=null;
	  Statement stmt=null;
	  try{
		  Class.forName(driver_name);
		  con= DriverManager.getConnection(db_URL, db_userName, db_password);
		  stmt= con.createStatement();
		  String querry = "select * from Student";
		  ResultSet rs = stmt.executeQuery(querry);
		  System.out.println("Student details : "); 
		  while(rs.next()){
			  int stud_id= rs.getInt("id");
			  int stud_age= rs.getInt("age");
			  String first_name= rs.getString("first");
			  String last_name= rs.getString("last");
			  System.out.println(" ID : "+stud_id+",  Age : "+stud_age+",  First Name : "+first_name+",  Last Name : "+last_name);
			 
			 }
	  }catch(ClassNotFoundException | SQLException e){
		  e.printStackTrace();
	  }
	  finally{
		  try{
			  stmt.close();
		  }catch(Exception e){ System.out.println(e);}  
	  }
	}

}
