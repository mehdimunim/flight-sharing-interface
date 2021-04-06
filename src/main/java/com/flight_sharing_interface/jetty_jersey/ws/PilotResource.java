package com.flight_sharing_interface.jetty_jersey.ws;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flight_sharing_interface.jetty_jersey.dao.PilotDao;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;
import com.flight_sharing_interface.jetty_jersey.ws_stub.flightResource.Aircraft;

@Path("/pilotResource")
public class PilotResource {

	List<Flight> plannedFlights = new ArrayList<Flight>();
	Pilot pilotStub = new Pilot("Munim", "Mehdi", "Aucune", "Aucune", 1999);

	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/plane/{planeId}/flight/flightId")
	public Response addFlight(
			@PathParam("pilotId") int pilotId,
			@PathParam("flightId") int flightId) {

		return Response.status(200).entity("added" + flightId).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking/{bookingId}/information")
	public Response modifyFlightInformation(
			@PathParam("pilotId") int pilotId,
			@PathParam("flightId") int flightId) {
		return Response.status(200).entity("modified" + flightId).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/plane/{planeId}/flight/flightId")
	public Response deleteFlight(
			@PathParam("pilotId") int pilotId,
			@PathParam("planeId") int planeId
			) {
		return Response.status(200).entity("deleted" + planeId).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight")
	public void getPlannedFlights(
			@PathParam("pilotId") int pilotId
			) {

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking")
	public void getAllBookings(
			@PathParam("pilotId") int pilotId,
			@PathParam("flightId") int flightId
			) {

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking")
	public Response addBooking(
			@PathParam("pilotId") int pilotId,
			@PathParam("flightId") int flightId
			) {
		return Response.status(200).entity("added" + flightId).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}/flight/{flightId}/booking/number-of-places")
	public Response modifyNumberOfPlaces(
			@PathParam("pilotId") int pilotId,
			@PathParam("flightId") int flightId
			) {
		return Response.status(200).entity("modified" + flightId).build();

	}

}