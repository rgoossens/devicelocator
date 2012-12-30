package com.alten.restservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

@Path("/")
public class LocationService 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Location> getAllLocations()
	{
		return Repository.getInstance().getLocations();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLocation(JAXBElement<Location> location)
	{
		Repository.getInstance().updateLocation(location.getValue());
		
		return Response.ok().build();
	}

}
