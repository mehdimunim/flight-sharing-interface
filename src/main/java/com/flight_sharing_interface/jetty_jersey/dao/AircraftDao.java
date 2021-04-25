package com.flight_sharing_interface.jetty_jersey.dao;

import java.util.List;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;

public interface AircraftDao {

	/**
	 * Add a nes action to the database
	 * 
	 * @param action
	 */
	void addAircraft(Aircraft aircraft);

	/**
	 * @param username
	 * @return the list of actions assigned to a specific user.
	 */
	List<Aircraft> getAircrafts(String username);

	/**
	 * @param aircraftId
	 * @return information of a specific aircraft (from its ID)
	 */
	Aircraft getAircraftInfo(long aircraftId);

	/**
	 * @param aircraft Add a flight in the database
	 */
	long addAircraftInfo(Aircraft aircraft);

}