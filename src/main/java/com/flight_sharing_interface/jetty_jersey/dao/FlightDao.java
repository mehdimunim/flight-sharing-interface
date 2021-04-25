package com.flight_sharing_interface.jetty_jersey.dao;

import java.time.LocalDate;
import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.ws.FlightResource;

public interface FlightDao {

	/**
	 * @param flightId
	 * @return information of a specific flight (from its ID)
	 */
	Flight getFlightInfo(int flightId);

	/**
	 * @param Flight
	 * @return returns flights based on specific criteria (departure aerodrome,
	 *         destination_aerodrome, desired period (departure and arrival date))
	 */
	List<Flight> getFlightsFromCriteria(FlightResource.flightsFromCriteria flights);

	List<Flight> getFlightsFromCriteria(String departure_aerodrome_, LocalDate departureDateTime_,
			LocalDate arrivalDateTime_);

	/**
	 * replace by newFlight the flight stored with the id given in newFlight
	 */
	void editFlight(Flight newFlight);

	/**
	 * @param flightID //Add a flight in the database by the pilot
	 */
	// void addFlight(int pilotId);

	/**
	 * @param flightID //Delete a specific flight (from its ID)
	 * @return
	 */
	void deleteFlight(int flightId);

	int addFlight(Flight flight);

	List<Flight> clearDB();

}