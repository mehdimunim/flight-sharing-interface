package com.example.jetty_jersey.ws;

import java.time.LocalDateTime;
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

import com.example.jetty_jersey.dao.DAO;
import com.example.jetty_jersey.dao.Flight;

@Path("/FlightResource")
public class FlightResource {

	public static class flightsFromCriteria {
		public String departure_aerodrome;
		public LocalDateTime departureDateTime;
		public LocalDateTime arrivalDateTime;
	}

	/**
	 * return information of a specific flight (from its ID)
	 *
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-info/{id}")
	public Flight getFlightInfo(@PathParam("id") int flightId) {
		return DAO.getFlightDao().getFlightInfo(flightId);
	}

	/**
	 * returns flights based on specific criteria (departure aerodrome, desired
	 * period)
	 *
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/search-flight/flights")
	public List<Flight> getFlighsFromCriteria(flightsFromCriteria flights) {
		return DAO.getFlightDao().getFlightsFromCriteria(null, null, null);
	}

	/**
	 * Edit information of a specific flight (from its ID)
	 *
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit-flight/{id}")
	public void editFlight(@PathParam("id") int flightId) {
		DAO.getFlightDao().editFlight(flightId);
	}

	/**
	 * Add flight in the database by the pilot (pilotId)
	 *
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add-flight/{pilotId}")
	public void addFlight(@PathParam("pilotId") int pilotId) {
		DAO.getFlightDao().addFlight(pilotId);
		System.out.println("The flight has been added successfully !");
	}

	/**
	 * Delete a specific flight (from its ID)
	 *
	 */

	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("delete-flight/{id}")
	public void deleteAFlight(@PathParam("id") int id) {
		DAO.getFlightDao().deleteFlight(id);
	}
}
