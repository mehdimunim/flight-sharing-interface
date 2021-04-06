package com.example.jetty_jersey.dao;

import com.example.jetty_jersey.dao.objects.Flight;

public interface PilotDao {

	/**
	 * @param flight
	 @ add a  flight
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
	void deleteFlight(Flight flight);
	
	
	/**
	 * @param reservation
	 * @  accept or cancel a reservation
	 */
	
	// boolean isAcceptedReservation(Reservation reservation);
	

}


