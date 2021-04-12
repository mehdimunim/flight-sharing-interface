package com.flight_sharing_interface.jetty_jersey.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.flight_sharing_interface.jetty_jersey.dao.dn.AircraftDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.dn.FlightDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.dn.PassengerDaoImpl;
import com.flight_sharing_interface.jetty_jersey.dao.dn.PilotDaoImpl;

/**
 * 
 * @author Mehdi Singleton to generate the correct DAO (Flight, Passenger,
 *         Pilot, Aircraft)
 * 
 */
public class DAO {
	private static FlightDao flightDAO = null;
	private static PassengerDao passengerDAO = null;
	private static PilotDao pilotDAO = null;
	private static AircraftDao aircraftDAO = null;
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("flight-sharing-interface");

	public static FlightDao getFlightDao() {

		if (flightDAO == null) {
			flightDAO = new FlightDaoImpl(pmf);
		}
		return flightDAO;
	}

	public static PassengerDao getPassengerDao() {

		if (passengerDAO == null) {
			passengerDAO = new PassengerDaoImpl(pmf);
		}
		return passengerDAO;
	}

	public static PilotDao getPilotDao() {

		if (pilotDAO == null) {
			pilotDAO = new PilotDaoImpl(pmf);
		}
		return pilotDAO;
	}

	public static AircraftDao getAircraftDao() {

		if (aircraftDAO == null) {
			aircraftDAO = new AircraftDaoImpl(pmf);
		}
		return aircraftDAO;
	}
}