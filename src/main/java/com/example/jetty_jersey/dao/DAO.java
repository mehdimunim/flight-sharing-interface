package com.example.jetty_jersey.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.example.jetty_jersey.dao.dn.AircraftDaoImpl;
import com.example.jetty_jersey.dao.dn.FlightDaoImpl;
import com.example.jetty_jersey.dao.dn.PassengerDaoImpl;
import com.example.jetty_jersey.dao.dn.PilotDaoImpl;

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

	public static FlightDao getFlightDAO() {

		if (flightDAO == null) {
			flightDAO = new FlightDaoImpl(pmf);
		}
		return flightDAO;
	}

	public static PassengerDao getPassengerDAO() {

		if (passengerDAO == null) {
			passengerDAO = new PassengerDaoImpl(pmf);
		}
		return passengerDAO;
	}

	public static PilotDao getPilotDAO() {

		if (pilotDAO == null) {
			pilotDAO = new PilotDaoImpl(pmf);
		}
		return pilotDAO;
	}

	public static AircraftDao getAircraftDAO() {

		if (aircraftDAO == null) {
			aircraftDAO = new AircraftDaoImpl(pmf);
		}
		return aircraftDAO;
	}
}