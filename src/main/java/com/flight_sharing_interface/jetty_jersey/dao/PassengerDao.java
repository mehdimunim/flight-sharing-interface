package com.flight_sharing_interface.jetty_jersey.dao;

import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;
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
	void bookFlights(List<Flight> flights);

	/**
	 * @ return a booked flight
	 */
	List<Flight> getBookedFlight();

	/**
	 * @param user @ registering a user
	 */
	void register(Passenger passenger);

	/**
	 * @param booking @ cancel
	 */
	void cancelABooking(Booking booking);

	/**
	 * @param passenger
	 */

	Passenger loging(int passengerId);

	List<Passenger> clearDB();

}