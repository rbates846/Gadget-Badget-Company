package com;
import model.Project; 
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





@Path("/Project")

public class ProjectManagement {

	Project projectObj = new Project(); 
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readProject()
	 {
		return projectObj.readProject();
	 }
	
	
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertProject(@FormParam("projectCode") String projectCode,@FormParam("projectName") String projectName,@FormParam("projectPrice") String projectPrice, @FormParam("projectDescription") String projectDescription) 
	{ 
	 String output = projectObj.insertProject(projectCode, projectName, projectPrice, projectDescription); 
	return output; 
	}
	
	
	
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProject(String ProjectData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject projectObject = new JsonParser().parse(ProjectData).getAsJsonObject(); 
	 
	//Read the values from the JSON object
	 String projectId = projectObject.get("projectId").getAsString(); 
	 String projectCode = projectObject.get("projectCode").getAsString(); 
	 String projectName = projectObject.get("projectName").getAsString(); 
	 String projectPrice = projectObject.get("projectPrice").getAsString(); 
	 String projectDescription = projectObject.get("projectDescription").getAsString(); 
	 
	 String output = projectObj.updateProject(projectId, projectCode, projectName, projectPrice, projectDescription); 
	 
	
	 return output; 
	}
	
	
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteProject(String ProjectData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(ProjectData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <projectId>
	 String projectId = doc.select("projectId").text(); 
	 String output = projectObj.deleteProject(projectId); 
	return output; 
	}

	
}
