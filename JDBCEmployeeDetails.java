package com.jdbc;

import java.sql.*;

public class JDBCEmployeeDetails {
	private static final String driver_name="com.mysql.jdbc.Driver";
	private static final String dbUrl="jdbc:mysql://localhost/Company";
	private static final String dbuser="root";
	private static final String dbpass="Shweta123";
  public static void main(String[] args) {
	  Connection con=null;
	  Statement stmt=null;
	  try{
	  Class.forName(driver_name);
	  con=DriverManager.getConnection(dbUrl, dbuser, dbpass);
	  stmt=con.createStatement();
	  String myquerry="Select * from Employee";
	  ResultSet rs= stmt.executeQuery(myquerry);
	  System.out.println("EmployeeId"+"  "+"FirstName"+"   "+"LastName"+"     "+"Address");
	  while(rs.next()){
		  int id=rs.getInt("EmployeeId");
		  String first=rs.getString("FirstName");
		  String last=rs.getString("LastName");
		  String add=rs.getString("Address");
		  System.out.println("    "+id+"       "+ first+"      "+last+"       "+ add);

	  }}
	  catch(ClassNotFoundException | SQLException e){
		  System.out.println(e);
	  }
	  finally{
		  try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  }}