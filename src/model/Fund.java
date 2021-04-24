package model;

import java.sql.*; 


public class Fund {

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
	 {
		 e.printStackTrace();
		 }
	 	return con;
	 } 

//------------------------------------------------Insert---------------------------------------------------------
	
	public String insertFund(String name, String research, String type, String amount,String desc,String date)
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
	 	String query = " insert into fund(`fundID`,`funderName`,`fundResearch`,`paymentType`,`fundAmount`,`fundDesc`,`fundDate`)"
	 			+ " values (?, ?, ?, ?, ?, ?, ?)";
	 	PreparedStatement preparedStmt = con.prepareStatement(query);
	 	// binding values
	 	preparedStmt.setInt(1, 0);
	 	preparedStmt.setString(2, name);
	 	preparedStmt.setString(3, research);
	 	preparedStmt.setString(4, type);
	 	preparedStmt.setDouble(5, Double.parseDouble(amount));
	 	preparedStmt.setString(6, desc);
	 	preparedStmt.setString(7, date);
	 	// execute the statement

	 	preparedStmt.execute();
	 	con.close();
	 	output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
		 output = "Error while inserting the Fund.";
		 System.err.println(e.getMessage());
	 }
	 	return output;
	 } 
	
//----------------------------------------------------Read------------------------------------------------	
	
	public String readFunds()
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
	 	output = "<table border='1'><tr><th>Funder Name</th><th>Reaserch</th>" +
	 			"<th>Payment Type</th>" +
	 			"<th>Amount</th>" +
	 			"<th>Description</th>" +
	 			"<th>Date</th>" +
	 			"<th>Update</th><th>Remove</th></tr>";

	 	String query = "select * from fund";
	 	Statement stmt = con.createStatement();
	 	ResultSet rs = stmt.executeQuery(query);
	 	// iterate through the rows in the result set
	 while (rs.next())
	 {
		 String fundID = Integer.toString(rs.getInt("fundID"));
		 String funderName = rs.getString("funderName");
		 String fundResearch = rs.getString("fundResearch");
		 String paymentType = rs.getString("paymentType");
		 String fundAmount = Double.toString(rs.getDouble("fundAmount"));
		 String fundDesc = rs.getString("fundDesc");
		 String fundDate = rs.getString("fundDate");
		 
		 // Add into the html table
		 output += "<tr><td>" + funderName + "</td>";
		 output += "<td>" + fundResearch + "</td>";
		 output += "<td>" + paymentType + "</td>";
		 output += "<td>" + fundAmount + "</td>";
		 output += "<td>" + fundDesc + "</td>";
		 output += "<td>" + fundDate + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 + "<td><form method='post' action=''>"
	 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 + "<input name='fundID' type='hidden' value='" + fundID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
		 output = "Error while reading the funds.";
		 System.err.println(e.getMessage());
	 }
	 	return output;
	 } 
	
//--------------------------------------Update------------------------------------------------------------
	
	public String updateFund(String ID,String name, String research, String type, String amount, String Desc, String date)
	
	 {
		String output = "";
	 try
	 {
		 Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for updating."; 
		 }
	 // create a prepared statement
	 String query = "UPDATE fund SET funderName=?,fundResearch=?,paymentType=?,fundAmount=?,fundDesc=?,fundDate=? WHERE fundID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values with database
	 
	 	preparedStmt.setString(1, name);
	 	preparedStmt.setString(2, research);
	 	preparedStmt.setString(3, type);
	 	preparedStmt.setDouble(4, Double.parseDouble(amount)); 
	 	preparedStmt.setString(5, Desc);
	 	preparedStmt.setString(6, date);
	 	preparedStmt.setInt(7, Integer.parseInt(ID)); 
	 	// execute the statement
	 	preparedStmt.execute();
	 	con.close();
	 	output = "Updated successfully";
	 	}
	 	catch (Exception e)
	 	{
	 		output = "Error while updating the fund.";
	 		System.err.println(e.getMessage());
	 	}
	 		return output;
	 } 
	
//----------------------------------------------Delete----------------------------------------------------------------------
	
	public String deleteItem(String fundID)
	 {
		String output = "";
	 try
	 {
		 Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for deleting."; 
		 }
	 
	 // create a prepared statement
	 	String query = "delete from fund where fundID=?";
	 	PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(fundID));
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
