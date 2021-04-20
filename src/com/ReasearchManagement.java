package com;

import javax.ws.rs.GET;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 

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
	
	

	

}
