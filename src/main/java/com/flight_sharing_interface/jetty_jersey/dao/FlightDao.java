package com.example.jetty_jersey.dao;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightDAO {

	/**
	 * @param flightId
	 * @return information of a specific flight (from its ID)
	 */
	Flight getFlightInfo(int flightId);

	/**
	 * @param Flight
	 * @return returns flights based on specific criteria (departure aerodrome,
	 *         desired period)
	 */
	List<Flight> getFlightsFromCriteria(String departure_aerodrome, LocalDateTime departureDateTime,
			LocalDateTime arrivalDateTime);

	/**
	 * @param flightID edit information of a specific flight (from its ID)
	 */
	void editFlight(int flightId);

	/**
	 * @param flightID //Add a flight in the database by the pilot
	 */
	void addFlight(int pilotId);

	/**
	 * @param flightID //Delete a specific flight (from its ID)
	 * @return
	 */
	void deleteFlight(int flightId);

	// void addFlight(Flight flight);

}
