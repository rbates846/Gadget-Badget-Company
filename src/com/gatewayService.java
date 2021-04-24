package com;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 @Path("/home")

public class gatewayService {

	//Read API
	@GET
	@Path("/research")
	@Produces(MediaType.TEXT_HTML)
	public String getDoctorDetails() throws IOException
	{
		URL obj = new URL("http://localhost:8080/GadgetBadgetCompany/ResearchService/research");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
					
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	//Read API
	@GET
	@Path("/Fund")
	@Produces(MediaType.TEXT_HTML)
	public String getPatientDetails() throws IOException
	{
		URL obj = new URL("http://localhost:8080/GadgetBadgetCompany/FundService/Fund");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
					
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	//Read API
	@GET
	@Path("/Buyer")
	@Produces(MediaType.TEXT_HTML)
	public String getAppointmentDetails() throws IOException
	{
		URL obj = new URL("http://localhost:8080/GadgetBadgetCompany/BuyerService/Buyer");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
					
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}
	
	//Read API
	@GET
	@Path("/Project")
	@Produces(MediaType.TEXT_HTML)
	public String getHospitalDetails() throws IOException
	{
		URL obj = new URL("http://localhost:8080/GadgetBadgetCompany/ProjectService/Project");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
					
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return "GET request not worked";
		}
	}

}
