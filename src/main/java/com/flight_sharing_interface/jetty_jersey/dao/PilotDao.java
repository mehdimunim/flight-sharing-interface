package com.flight_sharing_interface.jetty_jersey.dao;

import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public interface PilotDao {

	/**
	 * @param flight @ add a flight
	 */
	void putFlight(Flight flight);

	/**
	 * @ modify or update a flight information
	 * 
	 */
	void postFlightInformation(Flight flight);

	/**
	 * @param flight
	 * @delete a flight
	 */
	void deleteFlight(int flightId);

	/**
	 * @param reservation @ accept or cancel a reservation
	 */

	// boolean isAcceptedReservation(Reservation reservation);

	List<Flight> getPlannedFlights(int pilotId);

}
