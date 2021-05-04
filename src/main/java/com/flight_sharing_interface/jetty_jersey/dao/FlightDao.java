package com.flight_sharing_interface.jetty_jersey.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Flight;

/**
 * Define methods to access to Flight Table
 * 
 * @author Mehdi
 */
public interface FlightDao {

	// METHOD TO FETCH FLIGHTS

	/**
	 * Fetch flight with its id
	 */

	Flight getFlight(long flightId);

	/**
	 * Fetch flight from DB with the aircraftId, departure date and time
	 */
	Flight getFlight(long aircraftId, Date departureDate, Time departureTime);

	/**
	 * Get all flights
	 */

	List<Flight> getAllFlights();

	/**
	 * Get flights leaving at a given departure place
	 */

	List<Flight> getFlightsWithDeparture(String departureAerodrome);

	/**
	 * Get flights leaving at a given date and time
	 */

	List<Flight> getFlightsWithDateTime(Date departureDate, Time departureTime);

	/**
	 * Get flights with the given meeting place
	 */

	List<Flight> getFlightsWithMeetingPlace(String meetingPlace);

	/**
	 * Get flights planned for the given pilot
	 */
	List<Flight> getPlannedFlights(long pilotId);

	// METHOD TO ADD FLIGHT
	/**
	 * Add flight to DB
	 * 
	 * @return
	 */
	long addFlight(Flight flight);

	// METHOD TO MODIFY FLIGHTS
	/**
	 * Edit the flight stored at flightId
	 * 
	 * newFlight as input to be coherent with the ws
	 */
	void editFlight(Flight newFlight);

	// METHODS TO DELETE FLIGHTS

	/**
	 * Delete specific flight
	 */
	void deleteFlight(long flightId);

	/**
	 * Delete all flights planned with the given aircraft
	 */
	void deleteFlightsWithAircraft(long aircraftId);

	// OTHER
	/**
	 * Get available places in the given flight
	 */

	int getAvailablePlaces(long flightId);

}
