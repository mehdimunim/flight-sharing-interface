package com.flight_sharing_interface.jetty_jersey.dao;

import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;
import com.flight_sharing_interface.jetty_jersey.dao.objects.Passenger;

/**
 * @author DANSO
 *
 */

public interface PassengerDao {

	/**
	 * @param flight @ book a flight
	 */
	void bookFlights(int passengerId, List<Flight> flights);

	/**
	 * @ return a booked flight
	 */
	List<Flight> getBookedFlight(int passengerId);

	/**
	 * @param user @ registering a user
	 */
	void register(Passenger passenger);

	/**
	 * @param booking @ cancel
	 */
	void cancelABooking(int passengerId, Flight booking);

	/**
	 * @param passenger
	 */

	Passenger login(int passengerId);

	List<Passenger> clearDB();

}