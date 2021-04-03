package com.example.jetty_jersey.ws_stub;

import java.time.LocalDateTime;
import java.time.Month;
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

import com.example.jetty_jersey.dao.Flight;

@Path("/FlightResource")
public class FlightResource {

	public static class flightsFromCriteria {
		public String departure_aerodrome;
		public LocalDateTime departureDateTime;
		public LocalDateTime arrivalDateTime;
	}

	// return information of a specific flight (from its ID)
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Flight getFlightInfo(@PathParam("id") int flightId) {

		// Flight flight = DAO.getFlight(flightId);
		// if (flight == null){ throw new NotFoundException(); }

		List<Flight> flightsList = new ArrayList<Flight>();

		Flight f1 = new Flight();
		f1.id = 1234;
		f1.departure_aerodrome = "London";
		flightsList.add(f1);

		Flight f2 = new Flight();
		f2.id = 123;
		f2.departure_aerodrome = "Marseille";
		flightsList.add(f2);

		Flight f3 = new Flight();
		f3.id = 12;
		f2.departure_aerodrome = "Paris";
		flightsList.add(f3);

		for (Flight flight : flightsList) {
			if (flightId == flight.id) {
				return flight;
			}
		}
		return null;
	}

	// returns flights based on specific criteria (departure aerodrome, desired
	// period)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search-flight/flights")
	public List<flightsFromCriteria> getFlighsFromCriteria() {
		List<flightsFromCriteria> flightsList = new ArrayList<flightsFromCriteria>();

		flightsFromCriteria f1 = new flightsFromCriteria();
		f1.departure_aerodrome = "London";
		f1.departureDateTime = LocalDateTime.of(2020, Month.MAY, 25, 19, 30);
		f1.arrivalDateTime = LocalDateTime.of(2020, Month.MAY, 25, 20, 30);
		flightsList.add(f1);

		flightsFromCriteria f2 = new flightsFromCriteria();
		f2.departure_aerodrome = "Marseille";
		f2.departureDateTime = LocalDateTime.of(2020, Month.JANUARY, 25, 14, 30);
		f2.arrivalDateTime = LocalDateTime.of(2020, Month.JANUARY, 25, 15, 30);
		flightsList.add(f2);

		return flightsList;
	}

	// edit information of a specific flight (from its ID)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void editFlight(@PathParam("id") int flightId) {
		// Flight flight = DAO.getFlight(flightId);
		// if (flight == null){ throw new NotFoundException();
		List<Flight> flightsList = new ArrayList<Flight>();

		Flight f1 = new Flight();
		f1.id = 1234;
		f1.departure_aerodrome = "London";
		flightsList.add(f1);

		Flight f2 = new Flight();
		f2.id = 123;
		f2.departure_aerodrome = "Marseille";
		flightsList.add(f2);

		for (Flight flight : flightsList) {
			if (flightId == flight.id) {
				System.out.println("flight information has been changed. Flight ID :  " + flightId
						+ " Departure Aerodrome : " + flight.departure_aerodrome);
			}
		}
	}

	// addition of a flight in the database by the pilot
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{pilotId}")
	public void addFlight(@PathParam("pilotId") int pilotId) {
		Flight flight = new Flight();
		flight.id = 124;
		flight.departure_aerodrome = "London";
		System.out.println("The flight has been added successfully !");

	}

	// Delete a specific flight (from its ID)
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void deleteFlight(@PathParam("id") int flightId) {

		// Flight flight = DAO.getFlight(flightId);
		// if (flight == null){ throw new NotFoundException(); }

		List<Flight> flightsList = new ArrayList<Flight>();

		Flight f1 = new Flight();
		f1.id = 1234;
		f1.departure_aerodrome = "London";
		flightsList.add(f1);

		Flight f2 = new Flight();
		f2.id = 123;
		f2.departure_aerodrome = "Marseille";
		flightsList.add(f2);

		Flight f3 = new Flight();
		f3.id = 12345;
		f2.departure_aerodrome = "Paris";
		flightsList.add(f3);

		for (Flight flight : flightsList) {
			if (flightId == flight.id) {
				flightsList.remove(flight);
				System.out.println("The flight " + flightId + " has been deleted");
			}
		}
	}
}