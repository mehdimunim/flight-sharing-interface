package com.flight_sharing_interface.jetty_jersey.dao;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Aircraft;

public interface AircraftDao {

	/**
	 * Add a specific aircraft in DB
	 */
	void addAircraft(Aircraft aircraft);

	/**
	 * Fetch an aircraft from DB with its id
	 */
	Aircraft getAircraft(long aircraftId);

	/**
	 * Delete an aircraft
	 */
	void deleteAircraft(long aircraftId);

}