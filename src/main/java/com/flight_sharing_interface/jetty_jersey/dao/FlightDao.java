package com.flight_sharing_interface.jetty_jersey.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public interface FlightDao {

	/**
	 * @param flightId
	 * @return information of a specific flight (from its ID)
	 */
	public Flight getFlightInfo(int flightId);

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
	public void editFlight(Flight newFlight);

	/**
	 * @param flightID //Addition of a flight in the database by the pilot
	 */
	public void addFlight(int pilotId);

	/**
	 * @param flightID //Delete a specific flight (from its ID
	 * @return
	 */
	public void deleteFlight(int flightId);

	void addFlight(Flight flight);

}
