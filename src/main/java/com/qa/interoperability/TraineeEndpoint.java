package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.TraineeService;



@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private TraineeService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String findAllTrainees()	{
		return service.findAllTrainees();
	}
	
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateTrainee(@PathParam("id") Long id, String traineeToUpdate){
			return service.updateTrainee(id, traineeToUpdate);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteTrainee(id);
	}
	public void setService(TraineeService service) {
		this.service = service;
	}
}
