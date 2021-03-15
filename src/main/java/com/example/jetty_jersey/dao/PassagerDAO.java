package com.example.jetty_jersey.dao;

public interface PassagerDAO {

	/**
	 * @param flight
	 * @ search a flight
	 */
	
	void searchFlight(Flight flight);
	
	/**
	 *@param flight
	 *@Access to information of a flight
	 */
	
	void putFlight ( Flight flight);
	
	/**
	 * @param reservation
	 * @ booking a flight
	 */
	
//	void putReservation(Reservation reservation);
	
	/**
	 * @param reservation
	 * @ cancel a reservation
	 */
//	void cancelReservation( Reservation reservation);
	
	
}