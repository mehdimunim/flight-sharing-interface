package com.example.jetty_jersey.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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