package com;

import model.Fund;

import java.sql.Date;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

@Path("/Fund")
public class FundManagement {
	Fund FundObj = new Fund();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFunds()
	 {
		return FundObj.readFunds(); 
	 } 
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFund(@FormParam("funderName") String name,
	 @FormParam("fundResearch") String research,
	 @FormParam("paymentType") String type,
	 @FormParam("fundAmount") String amount,
	 @FormParam("fundDesc") String  Desc)
	{
	 String output = FundObj.insertFund(name,research,type,amount,Desc);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFund(String fundData)
	{
	//Convert the input string to a JSON object
	 JsonObject fundObject = new JsonParser().parse(fundData).getAsJsonObject();
	//Read the values from the JSON object
	 String fundID = fundObject.get("fundID").getAsString();
	 String funderName = fundObject.get("funderName").getAsString();
	 String fundResearch = fundObject.get("fundResearch").getAsString();
	 String paymentType = fundObject.get("paymentType").getAsString();
	 String fundAmount = fundObject.get("fundAmount").getAsString();
	 String fundDesc = fundObject.get("fundDesc").getAsString();
	 String output = FundObj.updateFund( fundID, funderName, fundResearch, paymentType, fundAmount, fundDesc);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFund(String fundData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(fundData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String fundID = doc.select("fundID").text();
	 String output = FundObj.deleteItem(fundID);
	return output;
	}

	
}
