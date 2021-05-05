package com.flight_sharing_interface.jetty_jersey.ws;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flight_sharing_interface.jetty_jersey.dao.DAO;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

@Path("/FlightResource")
public class FlightResource {

	/**
	 * return information of a specific flight (from its ID)
	 *
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight-info/{id}")
	public Flight getFlight(@PathParam("id") long flightId) {
		return DAO.getFlightDao().getFlight(flightId);
	}

	/**
	 * add flight to DB
	 * 
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add-flight")
	public long addFlight(Flight flight) {

		if (flight == null) {
			throw new BadRequestException("Missing payload");
		}
		if (DAO.getFlightDao() == null) {
			throw new BadRequestException("Missing actions in the container");
		}
		return DAO.getFlightDao().addFlight(flight);
	}

	/**
	 * Delete a specific flight (from its ID)
	 *
	 */

	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("delete-flight/{id}")
	public void deleteFlight(@PathParam("id") long flightId) {
		DAO.getFlightDao().deleteFlight(flightId);
	}

	/**
	 * Get flights planned for the given pilot
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flightPlanned/{id}")
	public List<Flight> getPlannedFlights(@PathParam("id") long pilotId) {
		return DAO.getFlightDao().getPlannedFlights(pilotId);
	}

	/**
	 * Get available places in the given flight
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/availablePlaces/{id}")
	public int getAvailablePlaces(@PathParam("id") long flightId) {
		return DAO.getFlightDao().getAvailablePlaces(flightId);
	}

	/**
	 * Get flights leaving at a given date and time
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search-flight/{departureDate}/{departureTime}")
	public List<Flight> getFlightsWithDateTime(@PathParam("departureDate") Date departureDate,
			@PathParam("departureTime") Time departureTime) {
		return DAO.getFlightDao().getFlightsWithDateTime(departureDate, departureTime);
	}

	/**
	 * Edit the flight stored at flightId
	 * 
	 * newFlight as input to be coherent with the ws
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modify-flight")
	public void editFlight(Flight newFlight) {
		DAO.getFlightDao().editFlight(newFlight);

	}

}
