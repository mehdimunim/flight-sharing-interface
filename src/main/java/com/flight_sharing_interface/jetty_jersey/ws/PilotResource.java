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
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

@Path("/pilotResource")
public class PilotResource {

	/**
	 * Add a pilot to DB
	 * 
	 * @param pilot
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add-pilot")
	public long addPilot(Pilot pilot) {

		if (pilot == null) {
			throw new BadRequestException("Missing payload");
		}
		if (DAO.getFlightDao() == null) {
			throw new BadRequestException("Missing actions in the container");
		}
		return DAO.getPilotDao().addPilot(pilot);
	}

	/**
	 * Fetch a pilot from DB
	 * 
	 * 
	 * @param pilotId
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pilot-info/{id}")
	public Pilot getPilot(@PathParam("id") long pilotId) {
		return DAO.getPilotDao().getPilot(pilotId);
	}

	/**
	 * Delete pilot from DB
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("delete-pilot/{id}")
	public void deletePilot(@PathParam("id") long pilotId) {
		DAO.getPilotDao().deletePilot(pilotId);
	}

}