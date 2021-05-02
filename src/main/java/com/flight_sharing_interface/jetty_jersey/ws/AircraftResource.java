package com.flight_sharing_interface.jetty_jersey.ws;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

	/**
	 * Fetch an aircraft from DB with its id
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft-info/{id}")
	public Aircraft getAircraft(@PathParam("id") long id) {
		return DAO.getAircraftDao().getAircraft(id);
	}

	/**
	 * Add a specific aircraft to DB
	 * 
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add-aircraft")
	public long addAircraft(Aircraft aircraft) {

		if (aircraft == null) {
			throw new BadRequestException("Missing payload");
		}
		if (DAO.getAircraftDao() == null) {
			throw new BadRequestException("Missing actions in the container");
		}
		return DAO.getAircraftDao().addAircraft(aircraft);
	}

	/**
	 * Delete a specific aircraft (from its ID)
	 *
	 */

	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("delete-aircraft/{id}")
	public void deleteAircraft(@PathParam("id") long aircraftId) {
		DAO.getAircraftDao().deleteAircraft(aircraftId);
	}

}
