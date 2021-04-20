package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Project {
	
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/gadgetbadgetdb", "root", ""); 
	 } 
	 catch (Exception e) 
	 {
		 e.printStackTrace();
		 
	 } 
	 return con; 
	 } 
	
	public String insertProject(String code, String name, String price, String desc) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {
		 return "Error while connecting to the database for inserting."; 
		 
	 } 
	 
	 // create a prepared statement
	 String query = " insert into project(`projectId`,`projectCode`,`projectName`,`projectPrice`,`projectDescription`)"+ " values (?, ?, ?, ?, ?)";
	 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, code); 
	 preparedStmt.setString(3, name); 
	 preparedStmt.setDouble(3, Double.parseDouble(price)); 
	 preparedStmt.setString(5, desc); 
	 
	 
	// execute the statement
	 
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	 
	 catch (Exception e) 
	 { 
	 output = "Error while inserting the project."; 
	 System.err.println(e.getMessage()); 
	 } 
	 
	 return output; 
	 
	 } 
	public String readProject() 
	 { 
		String output = ""; 
		
	 try
	 { 
		 Connection con = connect(); 
		 
	 if (con == null) 
	 {
		 return "Error while connecting to the database for reading."; 
		 
	 } 
	 
	 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Project Code</th>"+"<th>Project Name</th>" +
	 "<th>Project Price</th>" + 
	 "<th>Project Description</th>" +
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from project"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String projectId = Integer.toString(rs.getInt("projectId")); 
	 String projectCode = rs.getString("projectCode"); 
	 String projectName = rs.getString("projectName"); 
	 String projectPrice = Double.toString(rs.getDouble("projectPrice")); 
	 String projectDescription = rs.getString("projectDescription"); 
	 // Add into the html table
	 output += "<tr><td>" + projectCode + "</td>"; 
	 output += "<td>" + projectName + "</td>"; 
	 output += "<td>" + projectPrice + "</td>"; 
	 output += "<td>" + projectDescription + "</td>"; 
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='project.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='itemID' type='hidden' value='" + projectId 
	 + "'>" + "</form></td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the project."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	public String updateProject(String ID, String code, String name, String price, String desc)
	
	{ 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 
		 
		 // create a prepared statement
		 String query = "UPDATE project SET projectCode=?,projectName=?,projectPrice=?,projectDescription=? WHERE projectId=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		 
		 // binding values
		 preparedStmt.setString(1, code); 
		 preparedStmt.setString(2, name); 
		 preparedStmt.setDouble(3, Double.parseDouble(price)); 
		 preparedStmt.setString(4, desc); 
		 preparedStmt.setInt(5, Integer.parseInt(ID)); 
		 
		 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while updating the project."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		public String deleteItem(String projectId) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for deleting."; } 
		 
		 
		 // create a prepared statement
		 String query = "delete from project where projectId=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
		 
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(projectId)); 
		 
		 
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Deleted successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while deleting the item."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
		
	
}

