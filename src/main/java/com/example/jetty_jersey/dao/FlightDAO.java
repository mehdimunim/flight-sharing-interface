package com.example.jetty_jersey.dao;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightDAO {

	/**
	 * @param flightId
	 * @return information of a specific flight (from its ID)
	 */
	public List<Flight> getFlightInfo(int flightId);

	/**
	 * @param Flight
	 * @return returns flights based on specific criteria (departure aerodrome,
	 *         desired period)
	 */
	public List<Flight> getFlightsFromCriteria(String departure_aerodrome, LocalDateTime departureDateTime,
			LocalDateTime arrivalDateTime);

	/**
	 * @param flightID edit information of a specific flight (from its ID)
	 */
	public void editFlight(int flightId);

	/**
	 * @param flightID //Addition of a flight in the database by the pilot
	 */
	public void addFlight(int pilotId);

	/**
	 * @param flightID //Delete a specific flight (from its ID
	 * @return
	 */
	public List<Flight> deleteFlight(int flightId);

	void addFlight(Flight flight);

}
