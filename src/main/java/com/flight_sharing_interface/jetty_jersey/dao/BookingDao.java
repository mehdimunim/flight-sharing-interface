package com.flight_sharing_interface.jetty_jersey.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Booking;

/**
 * Defines method to access and modify to Booking table
 * 
 * @author Mehdi
 *
 */
public interface BookingDao {

	/**
	 * Add a booking to DB
	 */
	void addBooking(Booking booking);

	/**
	 * Fetch a booking from DB
	 */
	Booking getBooking(long passengerId, long aircraftId, LocalDate departureDate, LocalTime departureTime);

	/**
	 * Fetch bookings done by the given passenger
	 */
	List<Booking> getBookings(long passengerId);

	/**
	 * Fetch recent bookings done by the given passenger
	 */

	List<Booking> getRecentBookings(long passengerId);

	/**
	 * Cancel a booking
	 */
	void cancelBooking(long passengerId, long aircraftId, LocalDate departureDate, LocalTime departureTime);
}
