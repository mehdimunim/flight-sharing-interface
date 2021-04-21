package com.flight_sharing_interface.jetty_jersey.dao;

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

	/**
	 * @param flightID edit information of a specific flight (from its ID)
	 */
	void editFlight(int flightId);

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
