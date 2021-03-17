package com.example.jetty_jersey.dao;

import java.time.Duration;
import java.util.List;

/**
 * @author DANSO
 *
 */

public interface PassengerDAO {

	
	/**
	 *@param flight
	 *@ book a flight
	 */
	void bookFlights( List<Flight> flights);
	
	/**
	 *@ return a booked flight
	 */
	List<Flight> getBookedFlight();
	
	/**
	 *@param user
	 *@ registering a user
	 */
	void register(Passenger passenger);
	
	/**
	 *@param booking
	 *@ cancel
	 */
	void cancelABooking(Booking booking);
	

	/**
	 *@param passenger 
	 */
	
public void loging(Passenger passenger);
	
}