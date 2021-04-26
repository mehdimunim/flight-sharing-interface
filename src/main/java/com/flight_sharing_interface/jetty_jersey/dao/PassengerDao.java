package com.flight_sharing_interface.jetty_jersey.dao;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

/**
 * Defines methods to access to Passengers Table
 * 
 * @author Mehdi
 *
 */

public interface PassengerDao {

	/**
	 * Add passenger to DB
	 * 
	 * @param passenger
	 */
	void addPassenger(Passenger passenger);

	/**
	 * Fetch a passenger from DB
	 * 
	 * @param passengerId
	 * @return passenger
	 */
	Passenger getPassenger(long passengerId);

	/**
	 * Delete a passenger from DB
	 * 
	 */
	void deletePassenger(long passengerId);

}