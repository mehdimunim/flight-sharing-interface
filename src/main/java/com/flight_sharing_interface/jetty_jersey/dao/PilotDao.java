package com.flight_sharing_interface.jetty_jersey.dao;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

public interface PilotDao {

	/**
	 * @param flight @ add a flight
	 */
	void putFlight(Flight flight);

	/**
	 * @ modify or update a information of flight
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

}
