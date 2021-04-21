package com;

import model.Buyer;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//JSON
import com.google.gson.*;

//for XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Buyer")


public class BuyerManagement {

Buyer buyerObj = new Buyer();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String readBuyer()
	{
		return buyerObj.readBuyers();
	}
	
}
