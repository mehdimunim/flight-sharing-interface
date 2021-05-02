package com.flight_sharing_interface.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;

@Path("/pilotResource")
public class PilotResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/plane/{planeId}/flight/flightId")
	public void postFlight(@PathParam("pilotId") int pilotId, @PathParam("flightId") int flightId) {

		DAO.getPilotDao().addPilot(pilot);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking/{bookingId}/information")
	public void modifyFlightInformation(@PathParam("pilotId") int pilotId, @PathParam("flightId") int flightId) {
		DAO.getPilotDao().postFlightInformation(null);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/plane/{planeId}/flight/flightId")
	public void deleteFlight(@PathParam("pilotId") int pilotId, @PathParam("planeId") int planeId) {
		DAO.getPilotDao().deleteFlight(planeId);
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight")
	public void getPlannedFlights(@PathParam("pilotId") int pilotId) {

		DAO.getFlightDao().getPlannedFlights(pilotId);

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking")
	public void getAllBookings(@PathParam("pilotId") int pilotId, @PathParam("flightId") int flightId) {

		DAO.getPilotDao().getPlannedFlights(pilotId);

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking")
	public void addBooking(@PathParam("pilotId") int pilotId, @PathParam("flightId") int flightId) {

		// ????

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking/number-of-places")
	public void modifyNumberOfPlaces(@PathParam("pilotId") int pilotId, @PathParam("flightId") int flightId) {

		// ???

	}

}