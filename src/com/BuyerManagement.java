package com;

import model.Buyer;

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

@Path("/Buyer")

public class BuyerManagement {

	Buyer buyerObj = new Buyer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String readBuyer() {
		return buyerObj.readBuyers();
	}

	// insert
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBuyers(@FormParam("buyerID") String buyerID, @FormParam("name") String name,
			@FormParam("address") String address, @FormParam("phone") int phone, @FormParam("email") String email,
			@FormParam("projectName") String projectName)

	{
		String output = buyerObj.insertBuyers(buyerID, name, address, phone, email, projectName);
		return output;
	}

	// update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBuyers(String buyerData) {
		// Convert the input string to a JSON object
		JsonObject buyerObject = new JsonParser().parse(buyerData).getAsJsonObject();
		// Read the values from the JSON object
		String bno = buyerObject.get("bno").getAsString();
		String buyerID = buyerObject.get("buyerID").getAsString();
		String name = buyerObject.get("name").getAsString();
		String address = buyerObject.get("address").getAsString();
		int phone = buyerObject.get("phone").getAsInt();
		String email = buyerObject.get("email").getAsString();
		String projectName = buyerObject.get("projectName").getAsString();

		String output = buyerObj.updateBuyers(bno, buyerID, name, address, phone, email, projectName);
		return output;
	}

	// delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBuyers(String buyerData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(buyerData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String bno = doc.select("bno").text();
		String output = buyerObj.deleteBuyers(bno);
		return output;
	}

}
