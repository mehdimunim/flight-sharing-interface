package com.flight_sharing_interface.jetty_jersey.dao;

import com.flight_sharing_interface.jetty_jersey.dao.objects.Pilot;

/**
 * Defines methods to access and modify Pilot Table
 * 
 * @author Mehdi
 *
 */
public interface PilotDao {

	/**
	 * Add a pilot to DB
	 * 
	 * @param pilot
	 * @return
	 */
	long addPilot(Pilot pilot);

	/**
	 * Fetch a pilot from DB
	 * 
	 * 
	 * @param pilotId
	 * @return
	 */
	Pilot getPilot(long pilotId);

	/**
	 * Delete pilot from DB
	 */
	void deletePilot(long pilotId);

}
