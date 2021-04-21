package model;

import java.sql.*;

public class Research {
	
	//A common method to connect to the DB
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadgetdb", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	public String insertResearch( String name, String institute, String duration, String description)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 
	 // create a prepared statement
	
	 String query = " insert into researchmanagement(`researchId`,`researcheName`,`researchInstitute`,`researchDuration`,`researchDescription`)" + " values (?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 
	 // binding values
	 
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, name);
	 preparedStmt.setString(3, institute);
	 preparedStmt.setString(4, duration);
	 preparedStmt.setString(5, description);

	// execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the item.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String readResearch()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 
	 
	 // Prepare the html table to be displayed
	 
	 output = "<table border='1'><tr><th>Research Name</th>" +
	 "<th>Research Institute</th>" +
	 "<th>Research Duration</th>" +
	 "<th>Research Description</th>" +
	 "<th>Update</th><th>Remove</th></tr>";

	 String query = "select * from researchmanagement";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 
	 
	 // iterate through the rows in the result set
	 
	 while (rs.next())
	 {
	 String researchID = Integer.toString(rs.getInt("researchId"));
	 String researcheName = rs.getString("researcheName");
	 String researchInstitute = rs.getString("researchInstitute");
	 String researchDuration = rs.getString("researchDuration");
	 String researchDescription = rs.getString("researchDescription");
	 
	 
	 // Add into the html table
	 
	 output += "<tr><td>" + researcheName + "</td>";
	 output += "<td>" + researchInstitute + "</td>";
	 output += "<td>" + researchDuration + "</td>";
	 output += "<td>" + researchDescription + "</td>";
	 
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 + "<input name='researchID' type='hidden' value='" + researchID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 
	 
	 // Complete the html table
	 
	 
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String updateResearch(String ID, String name, String institute, String duration, String description)

	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 
	 
	 // create a prepared statement
	 
	 String query = "UPDATE researchmanagement SET researcheName=?,researchInstitute=?,researchDuration=?,researchDescription=?WHERE researchID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 // binding values
	 
	 preparedStmt.setString(1, name);
	 preparedStmt.setString(2, institute);
	 preparedStmt.setString(3, duration);
	 preparedStmt.setString(4, description);
	 preparedStmt.setInt(5, Integer.parseInt(ID));
	 
	 // execute the statement
	 
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the item.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	public String deleteResearch(String researchID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 
	 // create a prepared statement
	 
	 String query = "delete from researchmanagement where researchId=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 // binding values
	 
	 preparedStmt.setInt(1, Integer.parseInt(researchID));
	 
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
