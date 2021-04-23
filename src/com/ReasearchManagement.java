package com;

import java.sql.Date;



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
import model.Research;
@Path("/research")



public class ReasearchManagement {

	

	Research researchObj = new Research();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readResearch()
	 {
		return researchObj.readResearch();
	 } 
	

	//---------INSERT----------
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertResearch(@FormParam("researcheName") String name,
	 @FormParam("researchInstitute") String institute,
	 @FormParam("researchDuration") String duration,
	 @FormParam("researchDescription") String description)
	{
	 String output = researchObj.insertResearch(name,institute , duration, description);
	return output;
	}
	
	//--------UPDATE---------
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateResearch(String researchData)
	{
	//Convert the input string to a JSON object
		
	 JsonObject researchObject = new JsonParser().parse(researchData).getAsJsonObject();
	 
	//Read the values from the JSON object
	 
	 String ID = researchObject.get("researchId").getAsString();
	 String name = researchObject.get("researcheName").getAsString();
	 String institute = researchObject.get("researchInstitute").getAsString();
	 String duration = researchObject.get("researchDuration").getAsString();
	 String description = researchObject.get("researchDescription").getAsString();
	 String output = researchObj.updateResearch (ID, name, institute, duration, description);
	return output;
	}
	
	//--------DELETE-------
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteResearch(String researchData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(researchData, "", Parser.xmlParser());



	//Read the value from the element <itemID>
	 String ID = doc.select("researchId").text();
	 String output = researchObj.deleteResearch(ID);
	return output;
	}

	
}
