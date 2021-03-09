package com.example.jetty_jersey.ws;

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

import com.example.jetty_jersey.dao.Pilot;
import com.example.jetty_jersey.dao.PilotDAO;
import com.example.jetty_jersey.ws_stub.flightResource.Aircraft;
import com.example.jetty_jersey.dao.Flight;
import com.example.jetty_jersey.dao.Passenger;

@Path("/pilotResource")
public class PilotResource {

	List<Flight> plannedFlights = new ArrayList<Flight>();
	Pilot pilotStub = new Pilot("Munim", "Mehdi", "Aucune", "Aucune", 1999);

	/**
	 * @return a list of flights to serve as a stub
	 */
	public List<Flight> stubFlights() {
		// flight parameters
		LocalDateTime dur = null;
		int ap = 0;
		double pr = 0; // will be changed further in the code
		String mp = "";
		String dep_a = "";
		String dest_a = "";
		LocalDateTime dep_t = null;
		LocalDate ar_d = null;
		LocalDateTime ar_t = null;
		int id = 0;
		Pilot pilot = pilotStub;
		List<Passenger> passengers = null;
		LocalDate dep_d = null;

		List<Flight> stubListFlights = new ArrayList<Flight>();
		stubListFlights
				.add(new Flight(dur, ap, 10, mp, dep_a, dest_a, dep_t, ar_d, ar_t, id, pilot, passengers, dep_d));
		stubListFlights
				.add(new Flight(dur, ap, 100, mp, dep_a, dest_a, dep_t, ar_d, ar_t, id, pilot, passengers, dep_d));
		stubListFlights
				.add(new Flight(dur, ap, 1000, mp, dep_a, dest_a, dep_t, ar_d, ar_t, id, pilot, passengers, dep_d));
		return stubListFlights;
	}

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
	public List<Flight> getPlannedFlights(
			@PathParam("pilotId") int pilotId
			) {
		return stubFlights();

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