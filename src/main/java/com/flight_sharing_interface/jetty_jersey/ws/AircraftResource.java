package com.flight_sharing_interface.jetty_jersey.ws;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;

@Path("/AircraftResource")
public class AircraftResource {

	// return information of a specific aircraft (from its ID)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft/{id}")
	public Aircraft getAircraftInfo(@PathParam("id") long id) {
		return DAO.getAircraftDao().getAircraft(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public long addAircraftInfo(Aircraft aircraft) {

		if (aircraft == null) {
			throw new BadRequestException("Missing payload");
		}
		if (DAO.getAircraftDao() == null) {
			throw new BadRequestException("Missing actions in the container");
		}
		return DAO.getAircraftDao().addAircraft(aircraft);
	}
}
